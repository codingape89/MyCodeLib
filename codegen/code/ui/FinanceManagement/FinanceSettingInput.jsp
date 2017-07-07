<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="../common/jsp/UsrCheck.jsp"%>
<%@include file="../common/jsp/ManageComLimit.jsp"%>
<head>
  <script src="../common/easyQueryVer3/EasyQueryCache.js" charset="UTF-8"></script>
  <script src="../common/easyQueryVer3/EasyQueryVer3.js" charset="UTF-8"></script>
  <script src="../common/javascript/jquery.js" charset="UTF-8"></script>
  <script src="../common/javascript/VerifyInput.js" charset="UTF-8"></script>
  <script src="../common/javascript/Common.js" charset="UTF-8"></script>
  <script src="../common/cvar/CCodeOperate.js" charset="UTF-8"></script>
  <script src="../common/Calendar/Calendar.js" charset="UTF-8"></script>
  <script src="../common/javascript/MulLine.js" charset="UTF-8"></script>
  <link href="../common/css/Project.css" rel=stylesheet type=text/css>
  <link href="../common/css/mulLine.css" rel=stylesheet type=text/css>  
  <script src="./FinanceSettingInput.js" charset="UTF-8"></script>
  <%@include file="./FinanceSettingInit.jsp"%>
</head>
<body  onload="initForms();initElementtype();">
    <form action="./FinanceSettingSave.jsp" method=post name=fm target="fraSubmit">
        <div id='div0' style='width:100%'>
            <div style="float:right;padding-right:10px;">
                <input class="cssButton" buttonname='AddSave' value="AddSave" type="button" onclick="return AddSave();" style='margin-right:20px;'/>
                <input class="cssButton" buttonname='UpdateSave' value="UpdateSave" type="button" onclick="return UpdateSave();" style='margin-right:20px;'/>
                <input class="cssButton" buttonname='QueryPage' value="QueryPage" type="button" onclick="return QueryPage();" style='margin-right:20px;'/>
            </div>
        </div>
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div1);"></td>
                <td class=titleImg>基本信息</td>
            </tr>
        </table>
        <div id='div1' style='width:100%'>
            <table class=common name='table1' colNum='2'>
                <tr>
                    <td class=title>Finance Code</td>
                    <td class=input><input name='FinanceCode' class='common' verify='Finance Code|notnull&10'  elementtype=nacessary/></td>
                    <td class=title>Finance Name</td>
                    <td class=input><input name='FinanceName' class='common' verify='Finance Name|notnull&100'  elementtype=nacessary/></td>
                </tr>
                <tr>
                    <td class=title>Finance Type</td>
                    <td class=input><input class='codeno' name='FinanceType' verify='Finance Type|notnull&code:FinanceType' ondblclick="return showCodeList('FinanceType',[this,FinanceTypeName],[0,1],null,null,null,1,null,1);" onkeyup="return showCodeListKey('FinanceType',[this,FinanceTypeName],[0,1],null,null,null,1,null,1)"/><input class=codename name='FinanceTypeName' elementtype=nacessary readonly/></td>
                    <td class=title>Debit/Credit</td>
                    <td class=input><input class='codeno' name='DCType' verify='Debit/Credit|notnull&code:DCType' ondblclick="return showCodeList('DCType',[this,DCTypeName],[0,1],null,null,null,1,null,1);" onkeyup="return showCodeListKey('DCType',[this,DCTypeName],[0,1],null,null,null,1,null,1)"/><input class=codename name='DCTypeName' elementtype=nacessary readonly/></td>
                </tr>
                <tr>
                    <td class=title>Status</td>
                    <td class=input><input class='codeno' name='Status' verify='Status|notnull&code:yesno' ondblclick="return showCodeList('yesno',[this,StatusName],[0,1],null,null,null,1,null,1);" onkeyup="return showCodeListKey('yesno',[this,StatusName],[0,1],null,null,null,1,null,1)"/><input class=codename name='StatusName' elementtype=nacessary readonly/></td>
                    <td class=title style='display:none;'>BranchType</td>
                    <td class=input style='display:none;'><input class='readonly' name='BranchType' value='1' type='hidden' readonly/></td>
                </tr>
            </table>
        </div>
        <input type="hidden" name="hideOperate" />
        <input type="hidden" name="tSQL" />
    </form>
    <span id="spanCode"  style="display: none; position:absolute; slategray"></span>
</body>
</html>