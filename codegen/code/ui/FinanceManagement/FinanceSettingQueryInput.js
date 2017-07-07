var showInfo;
var turnPage = new turnPageClass();
window.onfocus=function (){
    if(showInfo!=null){
        try{
            showInfo.focus();
        }catch(ex){
            showInfo=null;
        }
    }
};
//提交后操作,服务器数据返回后执行的操作
function afterSubmit( FlagStr, content ){
    showInfo.close();
    if (FlagStr == "Fail" ){
        var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + content ;
        showModalDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:350px");
    }
    else{
        var urlStr="../common/jsp/MessagePage.jsp?picture=S&content=" + content ;
        showModalDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:350px");
    }
}
/********************* 表单：fm *********************/
var turnPageDataGird = new turnPageClass();
function easyQueryDataGird(){
    initDataGird();
    // 书写SQL语句
    var tReturn = getManageComLimitlike("managecom");
    var strSQL = "select 1 from dual "
        //+ tReturn
    ;
    var strSQLexcel= strSQL;
    fm.all("tSQL").value=strSQL;
    turnPageDataGird.strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);

    //判断是否查询成功
    if (!turnPageDataGird.strQueryResult) {
        alert("没有查询到符合条件的数据");
        return false;
    }
    turnPageDataGird.queryModal(strSQL,DataGird);
}//function easyQueryDataGird
//Query
function Query(){
    if(!confirm("该方法还没有实现，是否继续?")) return false;
    fm.hideOperate.value='Query';
    if(!verifyForm('fm')){
        return false;
    }
    //if (!beforeSubmitVerify(fm,"Query")){
    //    return false;
    //} 
    //TODO 这里一般会调用上边的easyQuery方法，请选择下边一个合适的方法
    //easyQueryDataGird();
    fm.hideOperate.value="";
    return true;
}
//OK
function Return(){
    if(!confirm("该方法还没有实现，是否继续?")) return false;
    var arrReturn = new Array();
    //TODO 选择一条记录后，从数据库查询出必要的信息并返回
    var tGird = DataGird;//注意这里可能需要修改这个MulLine
    var tTurnPage = turnPageDataGird;//注意这里可能需要将turnPageDataGird修改成该上边的MulLine使用的turnPage，这个turnPage在easyQuery方法上边。
    
    var tSel = tGird.getSelNo();
    if( !tTurnPage.strQueryResult ){
        alert( "请先查询！" );
    } else if(tSel == 0 || tSel == null){
          alert("请先选择一条记录，再点击返回按钮。");
    } else {
        try{
            arrReturn = tGird.getRowData(tSel-1);//如果这里的数据不够，可以使用下边的方法
            //arrReturn = getQueryResult();
            top.opener.afterQuery( arrReturn );
        }catch(ex){
            alert( "没有发现父窗口的afterQuery接口。" + ex );
        }
        top.close();
    }
}
//提交表单fm
function submitfm(){
    var i = 0;
    var showStr="正在保存数据，请您稍候并且不要修改屏幕上的值或链接其他页面";
    var urlStr="../common/jsp/MessagePage.jsp?picture=C&content=" + showStr;
    showInfo=window.showModelessDialog(urlStr,window,"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px");
    if (fm.hideOperate.value==""){
        alert("操作控制数据丢失！");
        return false;
    }
    DataGird.delBlankLine();
    fm.submit(); //提交
    fm.hideOperate.value="";
}
function afterQuery(arrQueryResult){
    if( arrQueryResult != null ){
        //TODO 赋值语句写到下边
        /*
         fm.all('FinanceCode').value = arrQueryResult[0][0];
         fm.all('FinanceName').value = arrQueryResult[0][1];
         fm.all('FinanceType').value = arrQueryResult[0][2];
         fm.all('DCType').value = arrQueryResult[0][3];
         fm.all('Status').value = arrQueryResult[0][4];
         fm.all('BranchType').value = arrQueryResult[0][5];
        */
        showCodeName();
        //查询MulLine
        easyQueryDataGird();
    }
    return true;
}
function getQueryResult(){
    var arrSelected = null;
    var rowNo = DataGird.getSelNo();
    if( rowNo == 0 || rowNo == null )
        return arrSelected;
    //var rowData = DataGird.getRowData(rowNo-1); //这是被选中的那行数据，返回这个数组应该会更方便       
    arrSelected = new Array();
    //TODO 把SQL写到这里
    var strSQL = "";
    var vResult = easyQueryVer3(strSQL, 1, 1, 1);

    //判断是否查询成功
    if (!vResult) {
        alert("没有符合条件的记录!");
        return false;
    }
    //查询成功则拆分字符串，返回二维数组
    arrSelected = decodeEasyQueryResult(vResult);
    return arrSelected;
}