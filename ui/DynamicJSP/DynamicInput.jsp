<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <script src="./DynamicInput.js" charset="ISO-8859-1"></script>
<title>Dynamic JSP Test</title>
</head>
<body>
    <form action="./DynamicSave.jsp" method=post name=fm target="fraSubmit">
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div0);"></td>
                <td class=titleImg>Title1</td>
            </tr>
        </table>
        <div id='div0' style="display: ''">
            <table class=common name='table1' colNum='3'>
                <tr>
                    <td class=title>AlertName</td>
                    <td class=input><input name='Name' class='common'  /></td>
                    <td class=title>MetLifeAgentCode</td>
                    <td class=input><input name='MetLifeAgentCode' class='common'  /></td>
                    <td class=title>DivisionCode</td>
                    <td class=input><input name='DivisionCode' class='common'  /></td>
                </tr>
            </table>
        </div>
        <div id='div1' style='width:100%'>
            <div style="float:left;padding-right:10px;">
                <input class="cssButton" buttonname='ExportButton' value="Btn" type="button" onclick="return ExportButton();"/>
            </div>
        </div>
        <table>
            <tr class=common>
                <td class=common><img  src= "../common/images/butExpand.gif" style= "cursor:hand;" OnClick= "showPage(this,div2);"></td>
                <td class=titleImg>Text_SearchResult</td>
            </tr>
        </table>
        <div id='div2' style='width:100%'>
            <div id="divAlertListGird">
                <table class= common>
                    <tr class= common>
                        <td text-align: left colSpan=1>
                            <span id="spanAlertListGird" ></span>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <input type="hidden" name="hideOperate" />
        <input type="hidden" name="tSQL" />
        <input type="hidden" name="lang" />
    </form>
    <span id="spanCode"  style="display: none; position:absolute; slategray"></span>
    <iframe id='downloadframe' height=0,width=0 />
</body>
</html>