import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class FileEncodingTransform {
	
	public static void main(String[] args) {
        String fromPath = "F:\\EProject\\Lis65\\java_schema";
        String toPath1  = "F:\\EProject\\Lis65-NEW\\java_schema";
        //最后，将 toPath2覆盖toPath1，再将 toPath1覆盖fromPath
        String Encode1 = "UTF-8";
        String Encode2 = "GBK";
        FileEncodingTransform tFileEncodingTransform = new FileEncodingTransform();
        tFileEncodingTransform.transform1(fromPath, Encode2, toPath1, Encode1);
	}
	
	private String[] allowFileTypeList1 = {".jsp",".js",".java",".html",".css",".xsl",".xml"};//文件格式转码类型列表
	private String[] allowFileTypeList2 = {".jsp",".xsl",".xml",".html"};//文件内容修改类型列表
	private String[][] GBK2UTF8 = {
			{	 "page contentType=\"text/html;charset=GBK\""	,	 "page contentType=\"text/html;charset=UTF-8\""	},
			{	 "page contentType=\"text/html;charset=gbk\""	,	 "page contentType=\"text/html;charset=UTF-8\""	},
			{	 "meta http-equiv=\"Content-Type\" content=\"text/html; charset=GBK\""	,	 "meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\""	},
			{	 "meta http-equiv=\"Content-Type\" content=\"text/html; charset=gbk\""	,	 "meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\""	},
			{	 "meta http-equiv=\"Content-Type\" content=\"text/html;charset=GBK\""	,	 "meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\""	},
			{	 "meta http-equiv=\"Content-Type\" content=\"text/html;charset=gbk\""	,	 "meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\""	},
			{	 "page contentType=\"text/html;charset=GBK\""	,	 "page contentType=\"text/html;charset=UTF-8\""	},
			{	 "page contentType=\"text/html;charset=gbk\""	,	 "page contentType=\"text/html;charset=UTF-8\""	},
			{	 "page pageEncoding=\"GBK\" contentType=\"text/html;charset=GBK\""	,	 "page pageEncoding=\"UTF-8\" contentType=\"text/html;charset=UTF-8\""	},
			{	 "page pageEncoding=\"gbk\" contentType=\"text/html;charset=gbk\""	,	 "page pageEncoding=\"UTF-8\" contentType=\"text/html;charset=UTF-8\""	},
			{	 ".js\" charset=\"GBK\"></script>"	,	 ".js\" charset=\"UTF-8\"></script>"	},
			{	 ".js\" charset=\"gbk\"></script>"	,	 ".js\" charset=\"UTF-8\"></script>"	},
			{	 "charset=GBK"	,	 "charset=UTF-8"	},
			{	 "charset='GBK'"	,	 "charset='UTF-8'"	},
			{	 "charset=gbk"	,	 "charset=UTF-8"	},
			{	 "charset=\"GBK\""	,	 "charset=\"UTF-8\""	},
			{	 "charset=\"gbk\""	,	 "charset=\"UTF-8\""	},
			{	 "pageEncoding='GBK'"	,	 "pageEncoding='UTF-8'"	},
			{	 "pageEncoding=\"GBK\""	,	 "pageEncoding=\"UTF-8\""	},
			{	 "gb2312"	,	 "UTF-8"	},
			{	 "GB2312"	,	 "UTF-8"	}
	};
	private String[][] UTF82GBK = {
			{	 "page contentType=\"text/html;charset=UTF-8\""	,	 "page contentType=\"text/html;charset=GBK\""	},
			{	 "page contentType=\"text/html;charset=utf-8\""	,	 "page contentType=\"text/html;charset=GBK\""	},
			{	 "meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\""	,	 "meta http-equiv=\"Content-Type\" content=\"text/html; charset=GBK\""	},
			{	 "meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\""	,	 "meta http-equiv=\"Content-Type\" content=\"text/html; charset=GBK\""	},
			{	 "meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\""	,	 "meta http-equiv=\"Content-Type\" content=\"text/html;charset=GBK\""	},
			{	 "meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\""	,	 "meta http-equiv=\"Content-Type\" content=\"text/html;charset=GBK\""	},
			{	 "page contentType=\"text/html;charset=UTF-8\""	,	 "page contentType=\"text/html;charset=GBK\""	},
			{	 "page contentType=\"text/html;charset=utf-8\""	,	 "page contentType=\"text/html;charset=GBK\""	},
			{	 "page pageEncoding=\"UTF-8\" contentType=\"text/html;charset=UTF-8\""	,	 "page pageEncoding=\"GBK\" contentType=\"text/html;charset=GBK\""	},
			{	 "page pageEncoding=\"UTF-8\" contentType=\"text/html;charset=utf-8\""	,	 "page pageEncoding=\"gbk\" contentType=\"text/html;charset=GBK\""	},
			{	 ".js\" charset=\"UTF-8\"></script>"	,	 ".js\" charset=\"GBK\"></script>"	},
			{	 ".js\" charset=\"utf-8\"></script>"	,	 ".js\" charset=\"GBK\"></script>"	},
			{	 "charset=UTF-8"	,	 "charset=GBK"	},
			{	 "charset=utf-8"	,	 "charset=GBK"	},
			{	 "charset='UTF-8'"	,	 "charset='GBK'"	},
			{	 "charset='utf-8'"	,	 "charset='GBK'"	},
			{	 "charset=\"UTF-8\""	,	 "charset=\"GBK\""	},
			{	 "charset=\"utf-8\""	,	 "charset=\"GBK\""	},
			{	 "pageEncoding='UTF-8'"	,	 "pageEncoding='GBK'"	},
			{	 "pageEncoding='utf-8'"	,	 "pageEncoding='GBK'"	},
			{	 "pageEncoding=\"UTF-8\""	,	 "pageEncoding=\"GBK\""	},
			{	 "pageEncoding=\"utf-8\""	,	 "pageEncoding=\"GBK\""	}
	};
	
	public boolean transform1(String fromPath,String oldEncode,String toPath,String newEncode){  
    	String charSet="";
        File ftmp = new File(fromPath);  
        if (!ftmp.exists()) {  
            System.out.println("转换文件路径错误！");  
            return false;  
        }
        if (ftmp.isFile()) {
    		GetCharSet t=new GetCharSet();
    		charSet=t.getCharset(ftmp);
        	if(checkFileType1(fromPath)){
        		System.out.println("OLD FILE ("+fromPath+") IS ---------- "+charSet);
        		if(oldEncode.equals(charSet)){
                    byte[] value = fileToBytes(fromPath);  
                    String content = convEncoding(value, charSet, newEncode);
                    if(checkFileType2(fromPath)){
                    	if("GBK".equals(oldEncode) && "UTF-8".equals(newEncode)){
                        	content = transForm2(content,GBK2UTF8);
                    	}else if("UTF-8".equals(oldEncode) && "GBK".equals(newEncode)){
                        	content = transForm2(content,UTF82GBK);
                    	}
                    }
                    return saveFileNewEncode(toPath, content, newEncode); 
        		}
//        		else{
//                    byte[] value = fileToBytes(fromPath);  
//                    String content = convEncoding(value, charSet, charSet);
//                    if(checkFileType2(fromPath)){
//                    	if("GBK".equals(oldEncode) && "UTF-8".equals(newEncode)){
//                        	content = transForm2(content,GBK2UTF8);
//                    	}else if("UTF-8".equals(oldEncode) && "GBK".equals(newEncode)){
//                        	content = transForm2(content,UTF82GBK);
//                    	}
//                    }
//                    return saveFileNewEncode(toPath, content, charSet); 
//        		}
        	}
//        	else{
//                byte[] value = fileToBytes(fromPath);  
//                String content = convEncoding(value, charSet, charSet);
//                if(checkFileType2(fromPath)){
//                	if("GBK".equals(oldEncode) && "UTF-8".equals(newEncode)){
//                    	content = transForm2(content,GBK2UTF8);
//                	}else if("UTF-8".equals(oldEncode) && "GBK".equals(newEncode)){
//                    	content = transForm2(content,UTF82GBK);
//                	}
//                }
//                return saveFileNewEncode(toPath, content, charSet); 
//        	}
        } 
        else {  
            // 查找目录下面的所有文件与文件夹  
            File[] childFiles = ftmp.listFiles();  
            for (int i = 0, n = childFiles.length; i < n; i++) {  
                File child = childFiles[i];  
                String childFrom = fromPath + "/" + child.getName();  
                String childTo = toPath + "/" + child.getName();  
                transform1(childFrom, oldEncode, childTo, newEncode);  
            }  
        }
        return true;  
	}
	
	public String transForm2(String content,String[][] transformScriptList){
		String newcontent = content;
		for(int i=0;i<transformScriptList.length;i++){
			newcontent = newcontent.replaceAll(transformScriptList[i][0], transformScriptList[i][1]);
		}
		return newcontent;
	}
	
	public boolean checkFileType1(String filePath){
		for(int i=0;i<allowFileTypeList1.length;i++){
			if(filePath.endsWith(allowFileTypeList1[i])){
				return true;
			}
		}
		return false;
	}
	
	public boolean checkFileType2(String filePath){
		for(int i=0;i<allowFileTypeList2.length;i++){
			if(filePath.endsWith(allowFileTypeList2[i])){
				return true;
			}
		}
		return false;
	}

	public static byte[] fileToBytes(String fileName) {  
        FileInputStream ins = null;  
        ByteArrayOutputStream bos = null;  
        try {  
            ins = new FileInputStream(new File(fileName));
            bos = new ByteArrayOutputStream();  
            int len = 0;  
            byte[] buf = new byte[256];  
            while ((len = ins.read(buf, 0, 256)) > -1) {  
                bos.write(buf, 0, len);  
            }  
            return bos.toByteArray();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (ins != null) {ins.close();ins = null;}  
                if (bos != null) {bos.close();bos = null;}  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return null;  
    }
	
	public static String convEncoding(byte[] value, String oldCharset,  
            String newCharset) {  
        OutputStreamWriter outWriter = null;  
        ByteArrayInputStream byteIns = null;  
        ByteArrayOutputStream byteOuts = new ByteArrayOutputStream();  
        InputStreamReader inReader = null;  
        char cbuf[] = new char[1024];  
        int retVal = 0;  
        try {  
            byteIns = new ByteArrayInputStream(value);  
            inReader = new InputStreamReader(byteIns, oldCharset);  
            outWriter = new OutputStreamWriter(byteOuts, newCharset);  
            while ((retVal = inReader.read(cbuf)) != -1) {  
                outWriter.write(cbuf, 0, retVal);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (inReader != null)  inReader.close();  
                if (outWriter != null)  outWriter.close();  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        String temp = null;  
        try {  
            temp = new String(byteOuts.toByteArray(), newCharset);  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        return temp;  
    }
	
	public static boolean saveFileNewEncode(String fileName, String content, String newEncode) {  
        if (fileName == null || fileName.length() == 0)  
            return false;  
        if (content == null)  
            return false;  
        fileName = fileName.replace('\\', '/');
        createPath(fileName.substring(0, fileName.lastIndexOf('/')));  
        File file = null;  
        FileOutputStream out = null;  
        try {  
            file = new File(fileName); 
            if (file.exists()) {  
                file.delete();  
            } else {  
                file.createNewFile();  
            }  
            out = new FileOutputStream(file);   
            out.write(content.getBytes(newEncode));  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
            return false;  
        } catch (IOException e) {  
            e.printStackTrace();  
            return false;  
        } finally {  
            if (out != null) {  
                try {  out.flush();  out.close();  } catch (IOException e) {  e.printStackTrace();  return false;  }  
            }  
        }  
        return true;  
    }
	
	public static boolean createPath(String filePath) {  
        if (filePath == null || filePath.length() == 0)  
            return false;  
        // 路径中的\转换为/  
        filePath = filePath.replace('\\', '/');  
        // 处理文件路径  
        String[] paths = filePath.split("/");  
        // 处理文件名中没有的路径  
       /// StringBuilder sbpath = new StringBuilder();  
        StringBuffer sbpath = new StringBuffer();  
        for (int i = 0, n = paths.length; i < n; i++) {  
            sbpath.append(paths[i]);  
            // 检查文件路径如果没有则创建  
            File ftmp = new File(sbpath.toString());  
            if (!ftmp.exists()) {  
                ftmp.mkdir();  
            }  
            sbpath.append("/");  
        }  
        return true;  
    }  
	
}
