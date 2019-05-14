package ding;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import common.PubFun;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.apache.http.HttpResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DingRecordSyncController {

  private static String accessTokenUrl = "https://oapi.dingtalk.com/gettoken";//通用
  private static String corpId = "你公司自己的corpId，在钉钉管理员账号设置里面能看到";
  private static String corpSecret = "你公司自己的corpId，在钉钉管理员账号设置里面能看到";

  public static String getAccessToken() {
    Map<String, Object> map = new HashMap<>();
    map.put("corpid", corpId);
    map.put("corpsecret", corpSecret);
    return httpGetStringResult(accessTokenUrl, map);//获取access_token
  }

  public static String httpGetStringResult(String url, Map<String, Object> param) {
    String content = null;
    CloseableHttpClient httpClient = HttpClients.createDefault();
    if (param != null && !param.isEmpty()) {
      StringBuffer strparams = new StringBuffer();
      for (Map.Entry<String, Object> map : param.entrySet()) {
        strparams.append(map.getKey()).append("=").append(map.getValue().toString()).append("&");
      }
      strparams = strparams.deleteCharAt(strparams.length() - 1);
      url = url + "?" + strparams;
    }
    HttpGet httpGet = new HttpGet(url);
    CloseableHttpResponse response = null;

    try {
      response = httpClient.execute(httpGet);
      HttpEntity entity = response.getEntity();
      content = EntityUtils.toString(entity, "UTF-8");
    } catch (ClientProtocolException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();

    } finally {
      try {
        if (null != response) {
          response.close();
        }
      } catch (IOException e) {

        e.printStackTrace();
      }
    }

    return content;
  }

  public static String doPost(String requestUrl, JSONObject json) {
    HttpClient client = new DefaultHttpClient();
    HttpPost post = new HttpPost(requestUrl);
    post.setHeader("Content-Type", "application/json");
    post.addHeader("Authorization", "Basic YWRtaW46");
    String result = "";
    try {
      StringEntity s = new StringEntity(json.toString(), "utf-8");
      s.setContentEncoding(new BasicHeader("contentType",
          "application/json"));
      post.setEntity(s);
      // 发送请求
      HttpResponse httpResponse = client.execute(post);
      // 获取响应输入流
      InputStream inStream = httpResponse.getEntity().getContent();
      BufferedReader reader = new BufferedReader(new InputStreamReader(inStream, "utf-8"));
      StringBuilder strber = new StringBuilder();
      String line = null;
      while ((line = reader.readLine()) != null) {
        strber.append(line + "\n");
      }
      inStream.close();
      result = strber.toString();
      System.out.println(result);
      if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
        System.out.println("请求服务器成功，做相应处理");
      } else {
        System.out.println("请求服务端失败");
      }
    } catch (Exception e) {
      System.out.println("请求异常");
      throw new RuntimeException(e);
    }
    return result;
  }

  public static List<AttendanceQvo> getAttendances(List<AttendanceQvo> users,
      List<String> userIDList, String workDateFrom,
      String workDateTo, String access_Token) {
    int listSize = userIDList.size();
    //员工在企业内的UserID列表，企业用来唯一标识用户的字段。最多不能超过50个
    int toIndex = 50;
    for (int i = 0; i < userIDList.size(); i += 50) {
      if (i + 50 > listSize) {        //作用为toIndex最后没有50条数据则剩余几条newList中就装几条
        toIndex = listSize - i;
      }
      List newList = userIDList.subList(i, i + toIndex);
      Boolean hasMore = true;
      int offset = 0;//为了分页
      do {
        Map<String, Object> mapParam = new HashMap<>();
        mapParam.put("workDateFrom", workDateFrom);
        mapParam.put("workDateTo", workDateTo);
        mapParam.put("userIdList", newList);
        mapParam.put("offset", offset * 50);
        mapParam.put("limit", 50);
        String attendanceStr = getAttendance(mapParam, access_Token);
        JSONObject firstJson = JSONObject.parseObject(attendanceStr);

        hasMore = firstJson.getBoolean("hasMore");
        JSONArray recordFirst = firstJson.getJSONArray("recordresult");//当前部门下的userList

        if(recordFirst!=null){
          for (int j = 0; j < recordFirst.size(); j++) {
            JSONObject record = recordFirst.getJSONObject(j);
            AttendanceQvo attendanceQvo = new AttendanceQvo();
            attendanceQvo.setCheckType(record.getString("checkType"));
            attendanceQvo.setUserId(record.getString("userId"));
            attendanceQvo.setWorkDate(record.getLong("workDate"));
            attendanceQvo.setUserCheckTime(record.getLong("userCheckTime"));
            users.add(attendanceQvo);
          }
        }
        if(hasMore == null){hasMore = false;}
        if (hasMore) {//有下一页偏移量加一
          offset++;
        }
      } while (hasMore);
    }
    return users;
  }

  public static List<AttendanceQvo> getPeriodAttendances(List<AttendanceQvo> users,
      List<String> userIDList, String workDateFrom, String workDateTo, String access_Token) {
    //查询考勤打卡记录的结束工作日。格式为“yyyy-MM-dd HH:mm:ss”，HH:mm:ss可以使用00:00:00，具体查询的时候不会起作用，最后将返回此日期从0点到24点的结果。注意，起始与结束工作日最多相隔7天
    //所以将startdate ~ enddate 7天循环
    String dFrom = workDateFrom;
    String dTo;
    while (dFrom.compareTo(workDateTo) <= 0) {
      dTo = PubFun.getPreDayOrAfterDay(dFrom, 6);
      if (dTo.compareTo(workDateTo) >= 0) {
        dTo = workDateTo;
      }
      System.out.println(dFrom + " ~ " + dTo);
      getAttendances(users, userIDList, dFrom + " 00:00:00", dTo + " 00:00:00",
          access_Token);
      dFrom = PubFun.getPreDayOrAfterDay(dTo, 1);
    }
    return users;
  }

  public static String getAttendance(Map<String, Object> map, String access_token_str) {
    String dingDingAttendance =
        "https://oapi.dingtalk.com/attendance/list?access_token=" + access_token_str;
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("workDateFrom", map.get("workDateFrom"));
    jsonObject.put("workDateTo", map.get("workDateTo"));
    jsonObject.put("limit", map.get("limit"));
    jsonObject.put("offset", map.get("offset"));
    jsonObject.put("userIdList", map.get("userIdList"));
    return doPost(dingDingAttendance, jsonObject);//获取考勤记录
  }

  public static void main(String[] args) {
    List<AttendanceQvo> users = new ArrayList<>();

    List userIDList = Arrays
        .asList("121212121212121212", "121212121212324345345", "。。。自己公司的员工钉钉ID");

    String workDateFrom = "2019-01-01";
    String workDateTo = "2019-01-31";

    String access_token_str = getAccessToken();//获取access_token
    JSONObject jsonStr = JSONObject.parseObject(access_token_str); //转json结构
    String access_Token = jsonStr.getString("access_token");//获取access_Token

    getPeriodAttendances(users, userIDList, workDateFrom, workDateTo, access_Token);//凌晨的

    System.out.println("dingding返回打卡记录：\n" + Arrays.asList(users));

  }
}