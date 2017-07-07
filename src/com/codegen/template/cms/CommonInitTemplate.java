// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CommonInitTemplate.java

package com.codegen.template.cms;

import com.codegen.core.model.*;
import com.codegen.shell.Config;
import java.util.*;

public class CommonInitTemplate
{

	protected static String nl;
	public final String NL;
	protected final String TEXT_1 = "<%@page pageEncoding=\"";
	protected final String TEXT_2 = "\" contentType=\"text/html;charset=";
	protected final String TEXT_3;
	protected final String TEXT_4;
	protected final String TEXT_5 = "();";
	protected final String TEXT_6;
	protected final String TEXT_7;
	protected final String TEXT_8;
	protected final String TEXT_9;
	protected final String TEXT_10;
	protected final String TEXT_11 = "Init.jsp-->InitInpBox";
	protected final String TEXT_12;
	protected final String TEXT_13;
	protected final String TEXT_14;
	protected final String TEXT_15 = "();";
	protected final String TEXT_16;
	protected final String TEXT_17 = "();";
	protected final String TEXT_18;
	protected final String TEXT_19;
	protected final String TEXT_20;
	protected final String TEXT_21;
	protected final String TEXT_22;
	protected final String TEXT_23 = "\";";
	protected final String TEXT_24;
	protected final String TEXT_25 = "px\";";
	protected final String TEXT_26;
	protected final String TEXT_27;
	protected final String TEXT_28 = ";";
	protected final String TEXT_29;
	protected final String TEXT_30 = ";";
	protected final String TEXT_31;
	protected final String TEXT_32 = ";";
	protected final String TEXT_33;
	protected final String TEXT_34;
	protected final String TEXT_35 = " = new MulLineEnter( \"";
	protected final String TEXT_36 = "\" , \"";
	protected final String TEXT_37;
	protected final String TEXT_38;
	protected final String TEXT_39 = ".mulLineCount = ";
	protected final String TEXT_40 = ";";
	protected final String TEXT_41;
	protected final String TEXT_42 = ".displayTitle = ";
	protected final String TEXT_43 = ";";
	protected final String TEXT_44;
	protected final String TEXT_45 = ".hiddenPlus = ";
	protected final String TEXT_46 = ";";
	protected final String TEXT_47;
	protected final String TEXT_48 = ".hiddenSubtraction = ";
	protected final String TEXT_49 = ";";
	protected final String TEXT_50;
	protected final String TEXT_51 = ".canChk = ";
	protected final String TEXT_52 = ";";
	protected final String TEXT_53;
	protected final String TEXT_54 = ".canSel = ";
	protected final String TEXT_55 = ";";
	protected final String TEXT_56;
	protected final String TEXT_57;
	protected final String TEXT_58;
	protected final String TEXT_59;

	public CommonInitTemplate()
	{
		NL = nl != null ? nl : System.getProperties().getProperty("line.separator");
		TEXT_3 = (new StringBuilder("\" %>")).append(NL).append("<%@page import=\"com.sinosoft.lis.pubfun.*\" %>").append(NL).append("<%").append(NL).append("    String gToday = PubFun.getCurrentDate();").append(NL).append("    GlobalInput tG=(GlobalInput)session.getValue(\"GI\");").append(NL).append("    //String tOperator = tG.Operator;").append(NL).append("    //String tManageCom = tG.ManageCom;").append(NL).append("%>").append(NL).append("<script type=\"text/javascript\">").append(NL).append("function initForms(){").append(NL).append("    try{").toString();
		TEXT_4 = (new StringBuilder(String.valueOf(NL))).append("        init").toString();
		TEXT_6 = (new StringBuilder(String.valueOf(NL))).append("    }catch(ex){").append(NL).append("        alert(\"在LAAgentInputInit.jsp-->initForm函数中发生异常:初始化界面错误!\");").append(NL).append("    }").append(NL).append("}//initForm()").toString();
		TEXT_7 = (new StringBuilder(String.valueOf(NL))).append("function initInpBox").toString();
		TEXT_8 = (new StringBuilder("(){")).append(NL).append("    try{").toString();
		TEXT_9 = (new StringBuilder(String.valueOf(NL))).append("        ").toString();
		TEXT_10 = (new StringBuilder(".reset();")).append(NL).append("        //TODO- 这里写初始化页面的代码").append(NL).append("    }catch(ex){").append(NL).append("        alert(\"在").toString();
		TEXT_12 = (new StringBuilder("函数中发生异常:初始化界面错误!\");")).append(NL).append("    }").append(NL).append("}").toString();
		TEXT_13 = (new StringBuilder(String.valueOf(NL))).append("function init").toString();
		TEXT_14 = (new StringBuilder("(){")).append(NL).append("    try{").append(NL).append("        initInpBox").toString();
		TEXT_16 = (new StringBuilder(String.valueOf(NL))).append("        init").toString();
		TEXT_18 = (new StringBuilder(String.valueOf(NL))).append("    }catch(re){").append(NL).append("        alert(\"LAAgentInputInit.jsp-->InitForm").toString();
		TEXT_19 = (new StringBuilder("函数中发生异常:初始化界面错误!\");")).append(NL).append("    }").append(NL).append("}").toString();
		TEXT_20 = (new StringBuilder(String.valueOf(NL))).append("function init").toString();
		TEXT_21 = (new StringBuilder("(){")).append(NL).append("    var iArray = new Array();").append(NL).append("    var i = 0;").append(NL).append("    try{").toString();
		TEXT_22 = (new StringBuilder(String.valueOf(NL))).append("        iArray[i]=new Array();").append(NL).append("        iArray[i][0]=\"").toString();
		TEXT_24 = (new StringBuilder(String.valueOf(NL))).append("        iArray[i][1]=\"").toString();
		TEXT_26 = (new StringBuilder(String.valueOf(NL))).append("        iArray[i][2]=100;").toString();
		TEXT_27 = (new StringBuilder(String.valueOf(NL))).append("        iArray[i][3]=").toString();
		TEXT_29 = (new StringBuilder(String.valueOf(NL))).append("        iArray[i][4]=").toString();
		TEXT_31 = (new StringBuilder(String.valueOf(NL))).append("        iArray[i][5]=i+\"|\"+").toString();
		TEXT_33 = (new StringBuilder(String.valueOf(NL))).append("        iArray[i][6]='0|1';").append(NL).append("        i++;").toString();
		TEXT_34 = (new StringBuilder(String.valueOf(NL))).append("        ").toString();
		TEXT_37 = (new StringBuilder("\" );")).append(NL).append("        //这些属性必须在loadMulLine前").toString();
		TEXT_38 = (new StringBuilder(String.valueOf(NL))).append("        ").toString();
		TEXT_41 = (new StringBuilder(String.valueOf(NL))).append("        ").toString();
		TEXT_44 = (new StringBuilder(String.valueOf(NL))).append("        ").toString();
		TEXT_47 = (new StringBuilder(String.valueOf(NL))).append("        ").toString();
		TEXT_50 = (new StringBuilder(String.valueOf(NL))).append("        ").toString();
		TEXT_53 = (new StringBuilder(String.valueOf(NL))).append("        ").toString();
		TEXT_56 = (new StringBuilder(String.valueOf(NL))).append("        ").toString();
		TEXT_57 = (new StringBuilder(".loadMulLine(iArray);")).append(NL).append("    }catch(ex){").append(NL).append("        alert(ex);").append(NL).append("    }").append(NL).append("}").toString();
		TEXT_58 = (new StringBuilder(String.valueOf(NL))).append(NL).append("</script>").toString();
		TEXT_59 = NL;
	}

	public static synchronized CommonInitTemplate create(String lineSeparator)
	{
		nl = lineSeparator;
		CommonInitTemplate result = new CommonInitTemplate();
		nl = null;
		return result;
	}

	public String generate(Object argument)
	{
		StringBuffer stringBuffer = new StringBuffer();
		Model model = (Model)argument;
		Object c = model.getParameter("config");
		Config config = null;
		if (c != null)
			config = (Config)c;
		else
			config = new Config();
		List forms = model.getForms();
		stringBuffer.append("<%@page pageEncoding=\"");
		stringBuffer.append(config.getPageEncoding());
		stringBuffer.append("\" contentType=\"text/html;charset=");
		stringBuffer.append(config.getCharset());
		stringBuffer.append(TEXT_3);
		for (int i = 0; i < forms.size(); i++)
		{
			Form form = (Form)forms.get(i);
			stringBuffer.append(TEXT_4);
			stringBuffer.append(form.getName());
			stringBuffer.append("();");
		}

		stringBuffer.append(TEXT_6);
		for (int i = 0; i < forms.size(); i++)
		{
			Form form = (Form)forms.get(i);
			stringBuffer.append(TEXT_7);
			stringBuffer.append(form.getName());
			stringBuffer.append(TEXT_8);
			stringBuffer.append(TEXT_9);
			stringBuffer.append(form.getName());
			stringBuffer.append(TEXT_10);
			stringBuffer.append(model.getFileName());
			stringBuffer.append("Init.jsp-->InitInpBox");
			stringBuffer.append(form.getName());
			stringBuffer.append(TEXT_12);
		}

		for (int i = 0; i < forms.size(); i++)
		{
			Form form = (Form)forms.get(i);
			Iterator mulLines = form.getMulLines().iterator();
			stringBuffer.append(TEXT_13);
			stringBuffer.append(form.getName());
			stringBuffer.append(TEXT_14);
			stringBuffer.append(form.getName());
			stringBuffer.append("();");
			for (; mulLines.hasNext(); stringBuffer.append("();"))
			{
				MulLine mulLine = (MulLine)mulLines.next();
				stringBuffer.append(TEXT_16);
				stringBuffer.append(mulLine.getId());
			}

			stringBuffer.append(TEXT_18);
			stringBuffer.append(form.getName());
			stringBuffer.append(TEXT_19);
		}

		for (int i = 0; i < forms.size(); i++)
		{
			Form form = (Form)forms.get(i);
			for (Iterator mulLines = form.getMulLines().iterator(); mulLines.hasNext(); stringBuffer.append(TEXT_57))
			{
				MulLine mulLine = (MulLine)mulLines.next();
				stringBuffer.append(TEXT_20);
				stringBuffer.append(mulLine.getId());
				stringBuffer.append(TEXT_21);
				Iterator colsIter = mulLine.getCols().iterator();
				int colNum = 0;
				for (; colsIter.hasNext(); stringBuffer.append(TEXT_33))
				{
					colNum++;
					MulLineCol col = (MulLineCol)colsIter.next();
					String selectCode = col.getSelectCode();
					if (selectCode != null)
						selectCode = (new StringBuilder("'")).append(selectCode).append("'").toString();
					int selectCodeNameIndex = col.getSelectCodeNameIndex();
					stringBuffer.append(TEXT_22);
					stringBuffer.append(col.getName());
					stringBuffer.append("\";");
					stringBuffer.append(colNum != 1 ? "" : " //列名");
					stringBuffer.append(TEXT_24);
					stringBuffer.append(col.getWidth());
					stringBuffer.append("px\";");
					stringBuffer.append(colNum != 1 ? "" : " //列宽");
					stringBuffer.append(TEXT_26);
					stringBuffer.append(colNum != 1 ? "" : " //列最大值");
					stringBuffer.append(TEXT_27);
					stringBuffer.append(col.getType());
					stringBuffer.append(";");
					stringBuffer.append(colNum != 1 ? "" : " //是否允许输入，0表示不允许，1表示允许，2表示代码选择，3表示隐藏");
					stringBuffer.append(TEXT_29);
					stringBuffer.append(selectCode);
					stringBuffer.append(";");
					stringBuffer.append(colNum != 1 ? "" : " //是否引用代码: null或者\" \"为不引用");
					stringBuffer.append(TEXT_31);
					stringBuffer.append(selectCodeNameIndex);
					stringBuffer.append(";");
					stringBuffer.append(colNum != 1 ? "" : " //上面的列中放置引用代码中第几位值");
				}

				stringBuffer.append(TEXT_34);
				stringBuffer.append(mulLine.getId());
				stringBuffer.append(" = new MulLineEnter( \"");
				stringBuffer.append(mulLine.getDiv().getForm().getName());
				stringBuffer.append("\" , \"");
				stringBuffer.append(mulLine.getId());
				stringBuffer.append(TEXT_37);
				stringBuffer.append(TEXT_38);
				stringBuffer.append(mulLine.getId());
				stringBuffer.append(".mulLineCount = ");
				stringBuffer.append(mulLine.getMulLineCount());
				stringBuffer.append(";");
				stringBuffer.append(TEXT_41);
				stringBuffer.append(mulLine.getId());
				stringBuffer.append(".displayTitle = ");
				stringBuffer.append(mulLine.isDisplayTitle() ? 1 : 0);
				stringBuffer.append(";");
				stringBuffer.append(TEXT_44);
				stringBuffer.append(mulLine.getId());
				stringBuffer.append(".hiddenPlus = ");
				stringBuffer.append(mulLine.isHiddenPlus() ? 1 : 0);
				stringBuffer.append(";");
				stringBuffer.append(TEXT_47);
				stringBuffer.append(mulLine.getId());
				stringBuffer.append(".hiddenSubtraction = ");
				stringBuffer.append(mulLine.isHiddenSubtraction() ? 1 : 0);
				stringBuffer.append(";");
				stringBuffer.append(TEXT_50);
				stringBuffer.append(mulLine.getId());
				stringBuffer.append(".canChk = ");
				stringBuffer.append(mulLine.isCanChk() ? 1 : 0);
				stringBuffer.append(";");
				stringBuffer.append(TEXT_53);
				stringBuffer.append(mulLine.getId());
				stringBuffer.append(".canSel = ");
				stringBuffer.append(mulLine.isCanSel() ? 1 : 0);
				stringBuffer.append(";");
				stringBuffer.append(TEXT_56);
				stringBuffer.append(mulLine.getId());
			}

		}

		stringBuffer.append(TEXT_58);
		stringBuffer.append(TEXT_59);
		return stringBuffer.toString();
	}
}
