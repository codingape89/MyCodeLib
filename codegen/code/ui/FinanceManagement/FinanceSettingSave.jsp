<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.utility.*"%>
<%@page import="com.sinosoft.lis.pubfun.*"%>
<%@page import="com.sinosoft.lis.schema.*"%>
<%@page import="com.sinosoft.lis.vschema.*"%>
<%@page import="com.sinosoft.lis.db.*"%>
<%@page import="com.sinosoft.lis.FinanceManagement.*"%>
<%
    String FlagStr = "";
    String Content = "";
    CErrors tError = new CErrors();
    GlobalInput tG = (GlobalInput)session.getValue("GI");
    TransferData transferData = new TransferData();
    VData tVData = new VData();
    VData mResult = new VData();
    FinanceSettingUI tFinanceSettingUI = new FinanceSettingUI();

    String tOperate=request.getParameter("hideOperate");

    LDFinanceSchema tLDFinanceSchema = new LDFinanceSchema();
    tLDFinanceSchema.setFinanceCode(request.getParameter("FinanceCode"));//Finance Code
    tLDFinanceSchema.setFinanceName(request.getParameter("FinanceName"));//Finance Name
    tLDFinanceSchema.setFinanceType(request.getParameter("FinanceType"));//Finance Type
    tLDFinanceSchema.setDCType(request.getParameter("DCType"));//Debit/Credit
    tLDFinanceSchema.setStatus(request.getParameter("Status"));//Status
    tLDFinanceSchema.setBranchType(request.getParameter("BranchType"));//BranchType
    transferData.setNameAndValue("LDFinanceSchema",tLDFinanceSchema);
    //

    //开始提交
    tVData.add(tG);
    tVData.add(transferData);
    try {
        tFinanceSettingUI.submitData(tVData,tOperate);
    } catch(Exception ex) {
        Content = "保存失败，原因是:" + ex.toString();
        FlagStr = "Fail";
    }
    if (!FlagStr.equals("Fail")) {
        tError = tFinanceSettingUI.mErrors;
        if (!tError.needDealError()) {
            mResult = tFinanceSettingUI.getResult(); //获取返回值
            Content = " 保存成功! ";
            FlagStr = "Succ";
        } else {
            Content = " 保存失败，原因是:" + tError.getFirstError();
            FlagStr = "Fail";
        }
    }
%>
<html>
<script language="javascript">
    var mOperator='<%=tOperate%>';
    parent.fraInterface.afterSubmit("<%=FlagStr%>","<%=Content%>");
</script>
</html>
