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
//AddSave
function AddSave(){
    //if(!confirm("该方法还没有实现，是否继续?")) return false;
    fm.hideOperate.value='AddSave';
    if(!verifyForm('fm')){
        return false;
    }
    //if (!beforeSubmitVerify(fm,"AddSave")){
    //    return false;
    //} 
    //TODO 处理逻辑放到这里
    submitfm();
    fm.hideOperate.value="";
    return true;
}
//UpdateSave
function UpdateSave(){
    //if(!confirm("该方法还没有实现，是否继续?")) return false;
    fm.hideOperate.value='UpdateSave';
    if(!verifyForm('fm')){
        return false;
    }
    //if (!beforeSubmitVerify(fm,"UpdateSave")){
    //    return false;
    //} 
    //TODO 处理逻辑放到这里
    submitfm();
    fm.hideOperate.value="";
    return true;
}
//QueryPage
function QueryPage(){
    //if(!confirm("该方法还没有实现，是否继续?")) return false;
    showInfo=window.open("./FinanceSettingQuery.jsp");
    return true;
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
    }
    return true;
}