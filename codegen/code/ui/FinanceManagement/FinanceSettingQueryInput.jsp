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
  <script src="./FinanceSettingQueryInput.js" charset="UTF-8"></script>
  <%@include file="./FinanceSettingQueryInit.jsp"%>
</head>
<body  onload="initForms();initElementtype();">
    <form action="./FinanceSettingQuerySave.jsp" method=post name=fm target="fraSubmit">
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div0);"></td>
                <td class=titleImg>查询信息</td>
            </tr>
        </table>
        <div id='div0' style='width:100%'>
            <table class=common name='table1' colNum='2'>
                <tr>
                    <td class=title>Finance Code</td>
                    <td class=input><input name='FinanceCode' class='common' verify='Finance Code|10'  /></td>
                    <td class=title>Finance Name</td>
                    <td class=input><input name='FinanceName' class='common' verify='Finance Name|100'  /></td>
                </tr>
                <tr>
                    <td class=title>Finance Type</td>
                    <td class=input><input class='codeno' name='FinanceType' verify='Finance Type|code:FinanceType' ondblclick="return showCodeList('FinanceType',[this,FinanceTypeName],[0,1],null,null,null,1,null,1);" onkeyup="return showCodeListKey('FinanceType',[this,FinanceTypeName],[0,1],null,null,null,1,null,1)"/><input class=codename name='FinanceTypeName'  readonly/></td>
                    <td class=title>Debit/Credit</td>
                    <td class=input><input class='codeno' name='DCType' verify='Debit/Credit|code:DCType' ondblclick="return showCodeList('DCType',[this,DCTypeName],[0,1],null,null,null,1,null,1);" onkeyup="return showCodeListKey('DCType',[this,DCTypeName],[0,1],null,null,null,1,null,1)"/><input class=codename name='DCTypeName'  readonly/></td>
                </tr>
                <tr>
                    <td class=title>Status</td>
                    <td class=input><input class='codeno' name='Status' verify='Status|code:yesno' ondblclick="return showCodeList('yesno',[this,StatusName],[0,1],null,null,null,1,null,1);" onkeyup="return showCodeListKey('yesno',[this,StatusName],[0,1],null,null,null,1,null,1)"/><input class=codename name='StatusName'  readonly/></td>
                    <td class=title style='display:none;'>BranchType</td>
                    <td class=input style='display:none;'><input class='readonly' name='BranchType' value='1' type='hidden' readonly/></td>
                </tr>
            </table>
        </div>
        <div id='div1' style='width:100%'>
            <div style="float:left;padding-right:10px;">
                <input class="cssButton" buttonname='Query' value="Query" type="button" onclick="return Query();"/>
                <input class="cssButton" buttonname='Return' value="OK" type="button" onclick="return Return();"/>
            </div>
        </div>
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div2);"></td>
                <td class=titleImg>代理人信息</td>
            </tr>
        </table>
        <div id='div2' style='width:100%'>
            <div id="divDataGird">
                <table class= common>
                    <tr class= common>
                        <td text-align: left colSpan=1>
                            <span id="spanDataGird" ></span>
                        </td>
                    </tr>
                </table>
                <input value="首  页" type=button onclick="turnPageDataGird.firstPage();" class="cssButton"/>
                <input value="上一页" type=button onclick="turnPageDataGird.previousPage();" class="cssButton"/>
                <input value="下一页" type=button onclick="turnPageDataGird.nextPage();" class="cssButton"/>
                <input value="尾  页" type=button onclick="turnPageDataGird.lastPage();" class="cssButton"/>
                <input value="导出EXCEL" type=button class="cssbutton" onclick = "makeExcel(fm,DataGird)">
            </div>
        </div>
        <input type="hidden" name="hideOperate" />
        <input type="hidden" name="tSQL" />
    </form>
    <span id="spanCode"  style="display: none; position:absolute; slategray"></span>
</body>
</html>