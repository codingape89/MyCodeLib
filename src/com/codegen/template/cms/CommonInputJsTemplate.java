// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CommonInputJsTemplate.java

package com.codegen.template.cms;

import com.codegen.core.model.*;
import com.codegen.shell.Config;
import java.util.*;

public class CommonInputJsTemplate
{

	protected static String nl;
	public final String NL;
	protected final String TEXT_1;
	protected final String TEXT_2;
	protected final String TEXT_3 = " *********************/";
	protected final String TEXT_4;
	protected final String TEXT_5;
	protected final String TEXT_6;
	protected final String TEXT_7;
	protected final String TEXT_8;
	protected final String TEXT_9;
	protected final String TEXT_10;
	protected final String TEXT_11 = "','";
	protected final String TEXT_12 = "','";
	protected final String TEXT_13 = "')";
	protected final String TEXT_14;
	protected final String TEXT_15 = "\"";
	protected final String TEXT_16;
	protected final String TEXT_17;
	protected final String TEXT_18;
	protected final String TEXT_19;
	protected final String TEXT_20;
	protected final String TEXT_21 = ".queryModal(strSQL,";
	protected final String TEXT_22;
	protected final String TEXT_23;
	protected final String TEXT_24;
	protected final String TEXT_25;
	protected final String TEXT_26;
	protected final String TEXT_27 = ".hideOperate.value='";
	protected final String TEXT_28;
	protected final String TEXT_29;
	protected final String TEXT_30;
	protected final String TEXT_31;
	protected final String TEXT_32;
	protected final String TEXT_33;
	protected final String TEXT_34;
	protected final String TEXT_35;
	protected final String TEXT_36 = "();";
	protected final String TEXT_37;
	protected final String TEXT_38;
	protected final String TEXT_39;
	protected final String TEXT_40;
	protected final String TEXT_41;
	protected final String TEXT_42;
	protected final String TEXT_43 = ".hideOperate.value='";
	protected final String TEXT_44;
	protected final String TEXT_45;
	protected final String TEXT_46;
	protected final String TEXT_47;
	protected final String TEXT_48;
	protected final String TEXT_49;
	protected final String TEXT_50;
	protected final String TEXT_51 = "();";
	protected final String TEXT_52;
	protected final String TEXT_53;
	protected final String TEXT_54;
	protected final String TEXT_55;
	protected final String TEXT_56;
	protected final String TEXT_57;
	protected final String TEXT_58;
	protected final String TEXT_59;
	protected final String TEXT_60;
	protected final String TEXT_61;
	protected final String TEXT_62;
	protected final String TEXT_63;
	protected final String TEXT_64;
	protected final String TEXT_65;
	protected final String TEXT_66 = ";//注意这里可能需要将turnPage";
	protected final String TEXT_67;
	protected final String TEXT_68;
	protected final String TEXT_69;
	protected final String TEXT_70;
	protected final String TEXT_71;
	protected final String TEXT_72;
	protected final String TEXT_73;
	protected final String TEXT_74;
	protected final String TEXT_75;
	protected final String TEXT_76 = ".delBlankLine();";
	protected final String TEXT_77;
	protected final String TEXT_78 = ".submit(); //提交";
	protected final String TEXT_79;
	protected final String TEXT_80;
	protected final String TEXT_81;
	protected final String TEXT_82;
	protected final String TEXT_83 = "').value = arrQueryResult[0][";
	protected final String TEXT_84 = "];";
	protected final String TEXT_85;
	protected final String TEXT_86;
	protected final String TEXT_87 = "();";
	protected final String TEXT_88;
	protected final String TEXT_89;
	protected final String TEXT_90;
	protected final String TEXT_91;

	public CommonInputJsTemplate()
	{
		NL = nl != null ? nl : System.getProperties().getProperty("line.separator");
		TEXT_1 = (new StringBuilder("var showInfo;")).append(NL)
							.append("var turnPage = new turnPageClass();").append(NL)
							.append("window.onfocus=function (){").append(NL)
							.append("    if(showInfo!=null){").append(NL)
							.append("        try{").append(NL)
							.append("            showInfo.focus();").append(NL)
							.append("        }catch(ex){").append(NL)
							.append("            showInfo=null;").append(NL)
							.append("        }").append(NL)
							.append("    }").append(NL)
							.append("};").append(NL)
							.append("//提交后操作,服务器数据返回后执行的操作").append(NL)
							.append("function afterSubmit( FlagStr, content ){").append(NL)
							.append("    showInfo.close();").append(NL)
							.append("    if (FlagStr == \"Fail\" ){").append(NL)
							.append("        var urlStr=\"../common/jsp/MessagePage.jsp?picture=C&content=\" + content ;").append(NL)
							.append("        showModalDialog(urlStr,window,\"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:350px\");").append(NL)
							.append("    }").append(NL)
							.append("    else{").append(NL)
							.append("        var urlStr=\"../common/jsp/MessagePage.jsp?picture=S&content=\" + content ;").append(NL)
							.append("        showModalDialog(urlStr,window,\"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:350px\");").append(NL)
							.append("    }").append(NL).append("}")
							.toString();
		TEXT_2 = (new StringBuilder(String.valueOf(NL)))
							.append("/********************* 表单：")
							.toString();
		TEXT_4 = (new StringBuilder(String.valueOf(NL)))
							.append("var turnPage")
							.toString();
		TEXT_5 = (new StringBuilder(" = new turnPageClass();")).append(NL)
							.append("function easyQuery")
							.toString();
		TEXT_6 = (new StringBuilder("(){")).append(NL)
							.append("    init")
							.toString();
		TEXT_7 = (new StringBuilder("();")).append(NL)
							.append("    // 书写SQL语句").append(NL)
							.append("    var tReturn = getManageComLimitlike(\"")
							.toString();
		TEXT_8 = (new StringBuilder("\");")).append(NL)
							.append("    var strSQL = \"")
							.toString();
		TEXT_9 = (new StringBuilder(" \"")).append(NL)
							.append("        //+ tReturn")
							.toString();
		TEXT_10 = (new StringBuilder(String.valueOf(NL)))
							.append("        + getWherePart('")
							.toString();
		TEXT_14 = (new StringBuilder(String.valueOf(NL)))
							.append("        + \" ")
							.toString();
		TEXT_16 = (new StringBuilder(String.valueOf(NL)))
							.append("    ;").append(NL)
							.append("    var strSQLexcel= strSQL;")
							.toString();
		TEXT_17 = (new StringBuilder(String.valueOf(NL)))
							.append("    ")
							.toString();
		TEXT_18 = (new StringBuilder(".all(\"tSQL\").value=strSQL;")).append(NL)
							.append("    turnPage")
							.toString();
		TEXT_19 = (new StringBuilder(".strQueryResult  = easyQueryVer3(strSQL, 1, 0, 1);")).append(NL).append(NL)
							.append("    //判断是否查询成功").append(NL)
							.append("    if (!turnPage")
							.toString();
		TEXT_20 = (new StringBuilder(".strQueryResult) {")).append(NL)
							.append("        alert(\"没有查询到符合条件的数据\");").append(NL)
							.append("        return false;").append(NL)
							.append("    }").append(NL)
							.append("    turnPage").toString();
		TEXT_22 = (new StringBuilder(");")).append(NL)
							.append("}//function easyQuery")
							.toString();
		TEXT_23 = (new StringBuilder(String.valueOf(NL)))
							.append("//")
							.toString();
		TEXT_24 = (new StringBuilder(String.valueOf(NL)))
							.append("function ")
							.toString();
		TEXT_25 = (new StringBuilder("{")).append(NL)
							.append("    if(!confirm(\"该方法还没有实现，是否继续?\")) return false;")
							.toString();
		TEXT_26 = (new StringBuilder(String.valueOf(NL)))
							.append("    ")
							.toString();
		TEXT_28 = (new StringBuilder("';")).append(NL)
							.append("    if(!verifyForm('")
							.toString();
		TEXT_29 = (new StringBuilder("')){")).append(NL)
							.append("        return false;").append(NL)
							.append("    }")
							.toString();
		TEXT_30 = (new StringBuilder(String.valueOf(NL)))
							.append("    if (!beforeSubmitVerify(fm,\"")
							.toString();
		TEXT_31 = (new StringBuilder("\")){")).append(NL)
							.append("        return false;").append(NL)
							.append("    }")
							.toString();
		TEXT_32 = (new StringBuilder(String.valueOf(NL)))
							.append("    //if (!beforeSubmitVerify(fm,\"")
							.toString();
		TEXT_33 = (new StringBuilder("\")){")).append(NL)
							.append("    //    return false;").append(NL)
							.append("    //}")
							.toString();
		TEXT_34 = (new StringBuilder(" ")).append(NL)
							.append("    //TODO 这里一般会调用上边的easyQuery方法，请选择下边一个合适的方法")
							.toString();
		TEXT_35 = (new StringBuilder(String.valueOf(NL)))
							.append("    //easyQuery")
							.toString();
		TEXT_37 = (new StringBuilder(String.valueOf(NL)))
							.append("    ")
							.toString();
		TEXT_38 = (new StringBuilder(".hideOperate.value=\"\";")).append(NL)
							.append("    return true;").append(NL)
							.append("}")
							.toString();
		TEXT_39 = (new StringBuilder(String.valueOf(NL)))
							.append("//")
							.toString();
		TEXT_40 = (new StringBuilder(String.valueOf(NL)))
							.append("function ")
							.toString();
		TEXT_41 = (new StringBuilder("{")).append(NL)
							.append("    //if(!confirm(\"该方法还没有实现，是否继续?\")) return false;")
							.toString();
		TEXT_42 = (new StringBuilder(String.valueOf(NL)))
							.append("    ")
							.toString();
		TEXT_44 = (new StringBuilder("';")).append(NL)
							.append("    if(!verifyForm('")
							.toString();
		TEXT_45 = (new StringBuilder("')){")).append(NL)
							.append("        return false;").append(NL)
							.append("    }")
							.toString();
		TEXT_46 = (new StringBuilder(String.valueOf(NL)))
							.append("    if (!beforeSubmitVerify(fm,\"")
							.toString();
		TEXT_47 = (new StringBuilder("\")){")).append(NL)
							.append("        return false;").append(NL)
							.append("    }")
							.toString();
		TEXT_48 = (new StringBuilder(String.valueOf(NL)))
							.append("    //if (!beforeSubmitVerify(fm,\"")
							.toString();
		TEXT_49 = (new StringBuilder("\")){")).append(NL)
							.append("    //    return false;").append(NL)
							.append("    //}")
							.toString();
		TEXT_50 = (new StringBuilder(" ")).append(NL)
							.append("    //TODO 处理逻辑放到这里")
							.append(NL).append("    submit")
							.toString();
		TEXT_52 = (new StringBuilder(String.valueOf(NL)))
							.append("    ")
							.toString();
		TEXT_53 = (new StringBuilder(".hideOperate.value=\"\";")).append(NL)
							.append("    return true;").append(NL)
							.append("}")
							.toString();
		TEXT_54 = (new StringBuilder(String.valueOf(NL)))
							.append("//")
							.toString();
		TEXT_55 = (new StringBuilder(String.valueOf(NL)))
							.append("function ")
							.toString();
		TEXT_56 = (new StringBuilder("{")).append(NL)
							.append("    //if(!confirm(\"该方法还没有实现，是否继续?\")) return false;").append(NL)
							.append("    showInfo=window.open(\"")
							.toString();
		TEXT_57 = (new StringBuilder("\");")).append(NL)
							.append("    return true;").append(NL)
							.append("}")
							.toString();
		TEXT_58 = (new StringBuilder(String.valueOf(NL)))
							.append("//")
							.toString();
		TEXT_59 = (new StringBuilder(String.valueOf(NL)))
							.append("function ")
							.toString();
		TEXT_60 = (new StringBuilder("{")).append(NL)
							.append("    //if(!confirm(\"该方法还没有实现，是否继续?\")) return false;").append(NL)
							.append("    init")
							.toString();
		TEXT_61 = (new StringBuilder("();")).append(NL)
							.append("    return true;").append(NL)
							.append("}")
							.toString();
		TEXT_62 = (new StringBuilder(String.valueOf(NL)))
							.append("//")
							.toString();
		TEXT_63 = (new StringBuilder(String.valueOf(NL)))
							.append("function ")
							.toString();
		TEXT_64 = (new StringBuilder("{")).append(NL)
							.append("    if(!confirm(\"该方法还没有实现，是否继续?\")) return false;").append(NL)
							.append("    var arrReturn = new Array();").append(NL)
							.append("    //TODO 选择一条记录后，从数据库查询出必要的信息并返回").append(NL)
							.append("    var tGird = ")
							.toString();
		TEXT_65 = (new StringBuilder(";//注意这里可能需要修改这个MulLine")).append(NL)
							.append("    var tTurnPage = turnPage")
							.toString();
		TEXT_67 = (new StringBuilder("修改成该上边的MulLine使用的turnPage，这个turnPage在easyQuery方法上边。")).append(NL)
							.append("    ").append(NL)
							.append("    var tSel = tGird.getSelNo();").append(NL)
							.append("    if( !tTurnPage.strQueryResult ){").append(NL)
							.append("        alert( \"请先查询！\" );").append(NL)
							.append("    } else if(tSel == 0 || tSel == null){").append(NL)
							.append("          alert(\"请先选择一条记录，再点击返回按钮。\");").append(NL)
							.append("    } else {").append(NL)
							.append("        try{").append(NL)
							.append("            arrReturn = tGird.getRowData(tSel-1);//如果这里的数据不够，可以使用下边的方法").append(NL)
							.append("            //arrReturn = getQueryResult();").append(NL)
							.append("            top.opener.afterQuery( arrReturn );").append(NL)
							.append("        }catch(ex){").append(NL)
							.append("            alert( \"没有发现父窗口的afterQuery接口。\" + ex );").append(NL)
							.append("        }").append(NL)
							.append("        top.close();").append(NL)
							.append("    }").append(NL)
							.append("}")
							.toString();
		TEXT_68 = (new StringBuilder(String.valueOf(NL)))
							.append("//")
							.toString();
		TEXT_69 = (new StringBuilder(String.valueOf(NL)))
							.append("function ")
							.toString();
		TEXT_70 = (new StringBuilder("{")).append(NL)
							.append("    if(!confirm(\"该方法还没有实现，是否继续?\")) return false;").append(NL)
							.append("}")
							.toString();
		TEXT_71 = (new StringBuilder(String.valueOf(NL)))
							.append("//提交表单")
							.toString();
		TEXT_72 = (new StringBuilder(String.valueOf(NL)))
							.append("function submit")
							.toString();
		TEXT_73 = (new StringBuilder("(){")).append(NL)
							.append("    var i = 0;").append(NL)
							.append("    var showStr=\"正在保存数据，请您稍候并且不要修改屏幕上的值或链接其他页面\";").append(NL)
							.append("    var urlStr=\"../common/jsp/MessagePage.jsp?picture=C&content=\" + showStr;").append(NL)
							.append("    showInfo=window.showModelessDialog(urlStr,window,\"status:no;help:0;close:0;dialogWidth:550px;dialogHeight:250px\");").append(NL)
							.append("    if (")
							.toString();
		TEXT_74 = (new StringBuilder(".hideOperate.value==\"\"){")).append(NL)
							.append("        alert(\"操作控制数据丢失！\");").append(NL)
							.append("        return false;").append(NL)
							.append("    }")
							.toString();
		TEXT_75 = (new StringBuilder(String.valueOf(NL)))
							.append("    ")
							.toString();
		TEXT_77 = (new StringBuilder(String.valueOf(NL)))
							.append("    ")
							.toString();
		TEXT_79 = (new StringBuilder(String.valueOf(NL)))
							.append("    ")
							.toString();
		TEXT_80 = (new StringBuilder(".hideOperate.value=\"\";")).append(NL)
							.append("}")
							.toString();
		TEXT_81 = (new StringBuilder(String.valueOf(NL)))
							.append("function afterQuery(arrQueryResult){").append(NL)
							.append("    if( arrQueryResult != null ){").append(NL)
							.append("        //TODO 赋值语句写到下边").append(NL)
							.append("        /*")
							.toString();
		TEXT_82 = (new StringBuilder(String.valueOf(NL)))
							.append("         fm.all('")
							.toString();
		TEXT_85 = (new StringBuilder(String.valueOf(NL)))
							.append("        */").append(NL)
							.append("        showCodeName();").append(NL)
							.append("        //查询MulLine")
							.toString();
		TEXT_86 = (new StringBuilder(String.valueOf(NL)))
							.append("        easyQuery")
							.toString();
		TEXT_88 = (new StringBuilder(String.valueOf(NL)))
							.append("    }").append(NL)
							.append("    return true;").append(NL)
							.append("}")
							.toString();
		TEXT_89 = (new StringBuilder(String.valueOf(NL)))
							.append("function getQueryResult(){").append(NL)
							.append("    var arrSelected = null;").append(NL)
							.append("    var rowNo = ")
							.toString();
		TEXT_90 = (new StringBuilder(".getSelNo();")).append(NL)
							.append("    if( rowNo == 0 || rowNo == null )").append(NL)
							.append("        return arrSelected;").append(NL)
							.append("    //var rowData = ")
							.toString();
		TEXT_91 = (new StringBuilder(".getRowData(rowNo-1); //这是被选中的那行数据，返回这个数组应该会更方便       ")).append(NL)
							.append("    arrSelected = new Array();").append(NL)
							.append("    //TODO 把SQL写到这里").append(NL)
							.append("    var strSQL = \"\";").append(NL)
							.append("    var vResult = easyQueryVer3(strSQL, 1, 1, 1);").append(NL).append(NL)
							.append("    //判断是否查询成功").append(NL)
							.append("    if (!vResult) {").append(NL)
							.append("        alert(\"没有符合条件的记录!\");").append(NL)
							.append("        return false;").append(NL)
							.append("    }").append(NL)
							.append("    //查询成功则拆分字符串，返回二维数组").append(NL)
							.append("    arrSelected = decodeEasyQueryResult(vResult);").append(NL)
							.append("    return arrSelected;").append(NL)
							.append("}")
							.toString();
	}

	public static synchronized CommonInputJsTemplate create(String lineSeparator)
	{
		nl = lineSeparator;
		CommonInputJsTemplate result = new CommonInputJsTemplate();
		nl = null;
		return result;
	}

	public String generate(Object argument)
	{
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(TEXT_1);
		Model model = (Model)argument;
		Object c = model.getParameter("config");
		Config config = null;
		if (c != null)
			config = (Config)c;
		else
			config = new Config();
		List forms = model.getForms();
		String lastMulLineId = "";
		for (int i = 0; i < forms.size(); i++)
		{
			Form form = (Form)forms.get(i);
			stringBuffer.append(TEXT_2);
			stringBuffer.append(form.getName());
			stringBuffer.append(" *********************/");
			String mulLineId;
			for (Iterator iterator = form.getMulLines().iterator(); iterator.hasNext(); stringBuffer.append(mulLineId))
			{
				MulLine mulLine = (MulLine)iterator.next();
				mulLineId = mulLine.getId();
				if (mulLine.isCanSel())
					lastMulLineId = mulLineId;
				String sql = mulLine.getSql();
				if (sql == null)
					sql = "";
				String sqls[] = sql.split("\\?@\\?");
				String sql1 = "";
				String sql2 = "";
				sql1 = sqls[0].trim();
				if (sqls.length == 2)
					sql2 = sqls[1].trim();
				stringBuffer.append(TEXT_4);
				stringBuffer.append(mulLineId);
				stringBuffer.append(TEXT_5);
				stringBuffer.append(mulLineId);
				stringBuffer.append(TEXT_6);
				stringBuffer.append(mulLineId);
				stringBuffer.append(TEXT_7);
				stringBuffer.append(mulLine.getManageComLimit());
				stringBuffer.append(TEXT_8);
				stringBuffer.append(sql1);
				stringBuffer.append(TEXT_9);
				for (Iterator colIter = mulLine.getCols().iterator(); colIter.hasNext();)
				{
					MulLineCol col = (MulLineCol)colIter.next();
					if (col.getDbCode() != null && !col.getDbCode().trim().equals("") && col.getCode() != null && !col.getCode().trim().equals(""))
					{
						String oper = col.getOperation();
						if (oper == null || oper.trim().equals(""))
							oper = "=";
						stringBuffer.append(TEXT_10);
						stringBuffer.append(col.getDbCode());
						stringBuffer.append("','");
						stringBuffer.append(col.getCode());
						stringBuffer.append("','");
						stringBuffer.append(oper);
						stringBuffer.append("')");
					}
				}

				if (!sql2.equals(""))
				{
					stringBuffer.append(TEXT_14);
					stringBuffer.append(sql2);
					stringBuffer.append("\"");
				}
				stringBuffer.append(TEXT_16);
				stringBuffer.append(TEXT_17);
				stringBuffer.append(form.getName());
				stringBuffer.append(TEXT_18);
				stringBuffer.append(mulLineId);
				stringBuffer.append(TEXT_19);
				stringBuffer.append(mulLineId);
				stringBuffer.append(TEXT_20);
				stringBuffer.append(mulLineId);
				stringBuffer.append(".queryModal(strSQL,");
				stringBuffer.append(mulLineId);
				stringBuffer.append(TEXT_22);
			}

			for (Iterator operationIter = form.getOperations().iterator(); operationIter.hasNext();)
			{
				Operation operation = (Operation)operationIter.next();
				String method = operation.getMethod();
				String url = operation.getUrl();
				if (url.indexOf(".") == -1)
					url = (new StringBuilder("./")).append(url).append(".jsp").toString();
				if (operation.getType() == Operation.TYPE_QUERY)
				{
					stringBuffer.append(TEXT_23);
					stringBuffer.append(operation.getValue());
					stringBuffer.append(TEXT_24);
					stringBuffer.append(method);
					stringBuffer.append(TEXT_25);
					stringBuffer.append(TEXT_26);
					stringBuffer.append(form.getName());
					stringBuffer.append(".hideOperate.value='");
					stringBuffer.append(operation.getName());
					stringBuffer.append(TEXT_28);
					stringBuffer.append(form.getName());
					stringBuffer.append(TEXT_29);
					if (config.isGeneratConfig())
					{
						stringBuffer.append(TEXT_30);
						stringBuffer.append(operation.getName());
						stringBuffer.append(TEXT_31);
					} else
					{
						stringBuffer.append(TEXT_32);
						stringBuffer.append(operation.getName());
						stringBuffer.append(TEXT_33);
					}
					stringBuffer.append(TEXT_34);
					for (int f = 0; f < forms.size(); f++)
					{
						Form tForm = (Form)forms.get(f);
						for (Iterator tIterator = tForm.getMulLines().iterator(); tIterator.hasNext(); stringBuffer.append("();"))
						{
							MulLine mulLine = (MulLine)tIterator.next();
							mulLineId = mulLine.getId();
							stringBuffer.append(TEXT_35);
							stringBuffer.append(mulLine.getId());
						}

					}

					stringBuffer.append(TEXT_37);
					stringBuffer.append(form.getName());
					stringBuffer.append(TEXT_38);
				} else
				if (operation.getType() == Operation.TYPE_SUBMIT || operation.getType() == Operation.TYPE_REPORT)
				{
					stringBuffer.append(TEXT_39);
					stringBuffer.append(operation.getValue());
					stringBuffer.append(TEXT_40);
					stringBuffer.append(method);
					stringBuffer.append(TEXT_41);
					stringBuffer.append(TEXT_42);
					stringBuffer.append(form.getName());
					stringBuffer.append(".hideOperate.value='");
					stringBuffer.append(operation.getName());
					stringBuffer.append(TEXT_44);
					stringBuffer.append(form.getName());
					stringBuffer.append(TEXT_45);
					if (config.isGeneratConfig())
					{
						stringBuffer.append(TEXT_46);
						stringBuffer.append(operation.getName());
						stringBuffer.append(TEXT_47);
					} else
					{
						stringBuffer.append(TEXT_48);
						stringBuffer.append(operation.getName());
						stringBuffer.append(TEXT_49);
					}
					stringBuffer.append(TEXT_50);
					stringBuffer.append(form.getName());
					stringBuffer.append("();");
					stringBuffer.append(TEXT_52);
					stringBuffer.append(form.getName());
					stringBuffer.append(TEXT_53);
				} else
				if (operation.getType() == Operation.TYPE_OPEN)
				{
					stringBuffer.append(TEXT_54);
					stringBuffer.append(operation.getValue());
					stringBuffer.append(TEXT_55);
					stringBuffer.append(method);
					stringBuffer.append(TEXT_56);
					stringBuffer.append(url);
					stringBuffer.append(TEXT_57);
				} else
				if (operation.getType() == Operation.TYPE_RESET)
				{
					stringBuffer.append(TEXT_58);
					stringBuffer.append(operation.getValue());
					stringBuffer.append(TEXT_59);
					stringBuffer.append(method);
					stringBuffer.append(TEXT_60);
					stringBuffer.append(form.getName());
					stringBuffer.append(TEXT_61);
				} else
				if (operation.getType() == Operation.TYPE_RETURN)
				{
					stringBuffer.append(TEXT_62);
					stringBuffer.append(operation.getValue());
					stringBuffer.append(TEXT_63);
					stringBuffer.append(method);
					stringBuffer.append(TEXT_64);
					stringBuffer.append(lastMulLineId);
					stringBuffer.append(TEXT_65);
					stringBuffer.append(lastMulLineId);
					stringBuffer.append(";//注意这里可能需要将turnPage");
					stringBuffer.append(lastMulLineId);
					stringBuffer.append(TEXT_67);
				} else
				if (operation.getType() == Operation.TYPE_OTHER)
				{
					stringBuffer.append(TEXT_68);
					stringBuffer.append(operation.getValue());
					stringBuffer.append(TEXT_69);
					stringBuffer.append(method);
					stringBuffer.append(TEXT_70);
				}
			}

			stringBuffer.append(TEXT_71);
			stringBuffer.append(form.getName());
			stringBuffer.append(TEXT_72);
			stringBuffer.append(form.getName());
			stringBuffer.append(TEXT_73);
			stringBuffer.append(form.getName());
			stringBuffer.append(TEXT_74);
			for (Iterator mulLines = form.getMulLines().iterator(); mulLines.hasNext(); stringBuffer.append(".delBlankLine();"))
			{
				MulLine mul = (MulLine)mulLines.next();
				stringBuffer.append(TEXT_75);
				stringBuffer.append(mul.getId());
			}

			stringBuffer.append(TEXT_77);
			stringBuffer.append(form.getName());
			stringBuffer.append(".submit(); //提交");
			stringBuffer.append(TEXT_79);
			stringBuffer.append(form.getName());
			stringBuffer.append(TEXT_80);
		}

		stringBuffer.append(TEXT_81);
		List tForms = model.getForms();
		for (int i = 0; i < tForms.size(); i++)
		{
			Form tForm = (Form)tForms.get(i);
			List tables = tForm.getTables();
			for (int j = 0; j < tables.size(); j++)
			{
				Table table = (Table)tables.get(j);
				List inputs = table.getInputs();
				for (int m = 0; m < inputs.size(); m++)
				{
					Input input = (Input)inputs.get(m);
					stringBuffer.append(TEXT_82);
					stringBuffer.append(input.getCode());
					stringBuffer.append("').value = arrQueryResult[0][");
					stringBuffer.append(m);
					stringBuffer.append("];");
				}

			}

		}

		stringBuffer.append(TEXT_85);
		for (int i = 0; i < forms.size(); i++)
		{
			Form form = (Form)forms.get(i);
			for (Iterator iterator = form.getMulLines().iterator(); iterator.hasNext(); stringBuffer.append("();"))
			{
				MulLine mulLine = (MulLine)iterator.next();
				String mulLineId = mulLine.getId();
				stringBuffer.append(TEXT_86);
				stringBuffer.append(mulLine.getId());
			}

		}

		stringBuffer.append(TEXT_88);
		if (lastMulLineId != null && !lastMulLineId.trim().equals(""))
		{
			stringBuffer.append(TEXT_89);
			stringBuffer.append(lastMulLineId);
			stringBuffer.append(TEXT_90);
			stringBuffer.append(lastMulLineId);
			stringBuffer.append(TEXT_91);
		}
		return stringBuffer.toString();
	}
}
