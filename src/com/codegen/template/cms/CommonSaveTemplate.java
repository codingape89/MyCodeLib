// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CommonSaveTemplate.java

package com.codegen.template.cms;

import com.codegen.core.model.*;
import com.codegen.shell.Config;
import java.util.*;

public class CommonSaveTemplate
{

	protected static String nl;
	public final String NL;
	protected final String TEXT_1;
	protected final String TEXT_2 = "\" contentType=\"text/html;charset=";
	protected final String TEXT_3;
	protected final String TEXT_4;
	protected final String TEXT_5;
	protected final String TEXT_6 = "UI t";
	protected final String TEXT_7 = "UI = new ";
	protected final String TEXT_8;
	protected final String TEXT_9;
	protected final String TEXT_10 = " t";
	protected final String TEXT_11 = " = new ";
	protected final String TEXT_12 = "();";
	protected final String TEXT_13;
	protected final String TEXT_14 = "\",request.getParameter(\"";
	protected final String TEXT_15 = "\"));";
	protected final String TEXT_16;
	protected final String TEXT_17 = ".set";
	protected final String TEXT_18 = "(request.getParameter(\"";
	protected final String TEXT_19 = "\"));//";
	protected final String TEXT_20;
	protected final String TEXT_21 = "\",t";
	protected final String TEXT_22 = ");";
	protected final String TEXT_23;
	protected final String TEXT_24;
	protected final String TEXT_25 = "Chk\");//1:该行被选中；0:该行未被选中";
	protected final String TEXT_26;
	protected final String TEXT_27 = "Sel\");//1:该行被选中；0:该行未被选中";
	protected final String TEXT_28;
	protected final String TEXT_29 = "[] = request.getParameterValues(\"";
	protected final String TEXT_30 = "\");//";
	protected final String TEXT_31;
	protected final String TEXT_32;
	protected final String TEXT_33;
	protected final String TEXT_34 = "LineCount = request.getParameterValues(\"";
	protected final String TEXT_35;
	protected final String TEXT_36;
	protected final String TEXT_37 = "];";
	protected final String TEXT_38;
	protected final String TEXT_39;
	protected final String TEXT_40;
	protected final String TEXT_41;
	protected final String TEXT_42 = "] = t";
	protected final String TEXT_43 = "[m];";
	protected final String TEXT_44;
	protected final String TEXT_45;
	protected final String TEXT_46 = "\",mul";
	protected final String TEXT_47 = ");";
	protected final String TEXT_48;
	protected final String TEXT_49;
	protected final String TEXT_50;
	protected final String TEXT_51;
	protected final String TEXT_52;

	public CommonSaveTemplate()
	{
		NL = nl != null ? nl : System.getProperties().getProperty("line.separator");
		TEXT_1 = (new StringBuilder("<%@include file=\"../common/jsp/UsrCheck.jsp\"%>")).append(NL).append("<%@page pageEncoding=\"").toString();
		TEXT_3 = (new StringBuilder("\" %>")).append(NL).append("<%@page import=\"java.util.*\"%>").append(NL).append("<%@page import=\"com.sinosoft.utility.*\"%>").append(NL).append("<%@page import=\"com.sinosoft.lis.pubfun.*\"%>").append(NL).append("<%@page import=\"com.sinosoft.lis.schema.*\"%>").append(NL).append("<%@page import=\"com.sinosoft.lis.vschema.*\"%>").append(NL).append("<%@page import=\"com.sinosoft.lis.db.*\"%>").append(NL).append("<%@page import=\"com.sinosoft.lis.").toString();
		TEXT_4 = (new StringBuilder(".*\"%>")).append(NL).append("<%").append(NL).append("    String FlagStr = \"\";").append(NL).append("    String Content = \"\";").append(NL).append("    CErrors tError = new CErrors();").append(NL).append("    GlobalInput tG = (GlobalInput)session.getValue(\"GI\");").append(NL).append("    TransferData transferData = new TransferData();").append(NL).append("    VData tVData = new VData();").append(NL).append("    VData mResult = new VData();").toString();
		TEXT_5 = (new StringBuilder(String.valueOf(NL))).append("    ").toString();
		TEXT_8 = (new StringBuilder("UI();")).append(NL).append(NL).append("    String tOperate=request.getParameter(\"hideOperate\");").append(NL).toString();
		TEXT_9 = (new StringBuilder(String.valueOf(NL))).append("    ").toString();
		TEXT_13 = (new StringBuilder(String.valueOf(NL))).append("    transferData.setNameAndValue(\"").toString();
		TEXT_16 = (new StringBuilder(String.valueOf(NL))).append("    t").toString();
		TEXT_20 = (new StringBuilder(String.valueOf(NL))).append("    transferData.setNameAndValue(\"").toString();
		TEXT_23 = (new StringBuilder(String.valueOf(NL))).append("    //").toString();
		TEXT_24 = (new StringBuilder("        ")).append(NL).append("    String tChk[] = request.getParameterValues(\"Inp").toString();
		TEXT_26 = (new StringBuilder("        ")).append(NL).append("    String tRadio[] = request.getParameterValues(\"Inp").toString();
		TEXT_28 = (new StringBuilder(String.valueOf(NL))).append("    String t").toString();
		TEXT_31 = (new StringBuilder(String.valueOf(NL))).append("    List mul").toString();
		TEXT_32 = (new StringBuilder(" = new ArrayList();")).append(NL).append("    if(request.getParameterValues(\"").toString();
		TEXT_33 = (new StringBuilder("No\") != null) {")).append(NL).append("        int ").toString();
		TEXT_35 = (new StringBuilder("No\").length;")).append(NL).append("        for(int m=0;m<").toString();
		TEXT_36 = (new StringBuilder("LineCount;m++){")).append(NL).append("            String[] aRow = new String[").toString();
		TEXT_38 = (new StringBuilder(String.valueOf(NL))).append("            aRow[0] = tChk[m];").toString();
		TEXT_39 = (new StringBuilder(String.valueOf(NL))).append("            aRow[0] = tRadio[m];").toString();
		TEXT_40 = (new StringBuilder(String.valueOf(NL))).append("            aRow[0] = \"-1\";").toString();
		TEXT_41 = (new StringBuilder(String.valueOf(NL))).append("            aRow[").toString();
		TEXT_44 = (new StringBuilder(String.valueOf(NL))).append("            mul").toString();
		TEXT_45 = (new StringBuilder(".add(aRow);")).append(NL).append("        }").append(NL).append("    }").append(NL).append("    transferData.setNameAndValue(\"mul").toString();
		TEXT_48 = (new StringBuilder(String.valueOf(NL))).append(NL).append("    //开始提交").append(NL).append("    tVData.add(tG);").append(NL).append("    tVData.add(transferData);").append(NL).append("    try {").append(NL).append("        t").toString();
		TEXT_49 = (new StringBuilder("UI.submitData(tVData,tOperate);")).append(NL).append("    } catch(Exception ex) {").append(NL).append("        Content = \"保存失败，原因是:\" + ex.toString();").append(NL).append("        FlagStr = \"Fail\";").append(NL).append("    }").append(NL).append("    if (!FlagStr.equals(\"Fail\")) {").append(NL).append("        tError = t").toString();
		TEXT_50 = (new StringBuilder("UI.mErrors;")).append(NL).append("        if (!tError.needDealError()) {").append(NL).append("            mResult = t").toString();
		TEXT_51 = (new StringBuilder("UI.getResult(); //获取返回值")).append(NL).append("            Content = \" 保存成功! \";").append(NL).append("            FlagStr = \"Succ\";").append(NL).append("        } else {").append(NL).append("            Content = \" 保存失败，原因是:\" + tError.getFirstError();").append(NL).append("            FlagStr = \"Fail\";").append(NL).append("        }").append(NL).append("    }").append(NL).append("%>").append(NL).append("<html>").append(NL).append("<script language=\"javascript\">").append(NL).append("    var mOperator='<%=tOperate%>';").append(NL).append("    parent.fraInterface.afterSubmit(\"<%=FlagStr%>\",\"<%=Content%>\");").append(NL).append("</script>").append(NL).append("</html>").toString();
		TEXT_52 = NL;
	}

	public static synchronized CommonSaveTemplate create(String lineSeparator)
	{
		nl = lineSeparator;
		CommonSaveTemplate result = new CommonSaveTemplate();
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
		stringBuffer.append(TEXT_1);
		stringBuffer.append(config.getPageEncoding());
		stringBuffer.append("\" contentType=\"text/html;charset=");
		stringBuffer.append(config.getCharset());
		stringBuffer.append(TEXT_3);
		stringBuffer.append(model.getContainer());
		stringBuffer.append(TEXT_4);
		stringBuffer.append(TEXT_5);
		stringBuffer.append(model.getFileName());
		stringBuffer.append("UI t");
		stringBuffer.append(model.getFileName());
		stringBuffer.append("UI = new ");
		stringBuffer.append(model.getFileName());
		stringBuffer.append(TEXT_8);
		List forms = model.getForms();
		for (int i = 0; i < forms.size(); i++)
		{
			Form form = (Form)forms.get(i);
			for (Iterator tableIter = form.getTables().iterator(); tableIter.hasNext();)
			{
				Table table = (Table)tableIter.next();
				Set schemaSet = new HashSet();
				List inputScheList = new ArrayList();
				List inputStrList = new ArrayList();
				for (Iterator inputIter = table.getInputs().iterator(); inputIter.hasNext();)
				{
					Input input = (Input)inputIter.next();
					if (input.getSchema() != null && !input.getSchema().trim().equals("") && input.getSchemaField() != null && !input.getSchemaField().trim().equals(""))
					{
						schemaSet.add(input.getSchema());
						inputScheList.add(input);
					} else
					{
						inputStrList.add(input);
					}
				}

				for (Iterator schemas = schemaSet.iterator(); schemas.hasNext(); stringBuffer.append("();"))
				{
					String s = (String)schemas.next();
					stringBuffer.append(TEXT_9);
					stringBuffer.append(s);
					stringBuffer.append(" t");
					stringBuffer.append(s);
					stringBuffer.append(" = new ");
					stringBuffer.append(s);
				}

				for (Iterator inputStrIter = inputStrList.iterator(); inputStrIter.hasNext(); stringBuffer.append("\"));"))
				{
					Input tInput = (Input)inputStrIter.next();
					stringBuffer.append(TEXT_13);
					stringBuffer.append(tInput.getCode());
					stringBuffer.append("\",request.getParameter(\"");
					stringBuffer.append(tInput.getCode());
				}

				Input tInput;
				for (Iterator inputScheIter = inputScheList.iterator(); inputScheIter.hasNext(); stringBuffer.append(tInput.getName()))
				{
					tInput = (Input)inputScheIter.next();
					stringBuffer.append(TEXT_16);
					stringBuffer.append(tInput.getSchema());
					stringBuffer.append(".set");
					stringBuffer.append(tInput.getSchemaField());
					stringBuffer.append("(request.getParameter(\"");
					stringBuffer.append(tInput.getCode());
					stringBuffer.append("\"));//");
				}

				for (Iterator schemas2 = schemaSet.iterator(); schemas2.hasNext(); stringBuffer.append(");"))
				{
					String s = (String)schemas2.next();
					stringBuffer.append(TEXT_20);
					stringBuffer.append(s);
					stringBuffer.append("\",t");
					stringBuffer.append(s);
				}

			}

			stringBuffer.append(TEXT_23);
			for (Iterator mulLineIter = form.getMulLines().iterator(); mulLineIter.hasNext(); stringBuffer.append(");"))
			{
				MulLine mulLine = (MulLine)mulLineIter.next();
				if (mulLine.isCanChk())
				{
					stringBuffer.append(TEXT_24);
					stringBuffer.append(mulLine.getId());
					stringBuffer.append("Chk\");//1:该行被选中；0:该行未被选中");
				} else
				if (mulLine.isCanSel())
				{
					stringBuffer.append(TEXT_26);
					stringBuffer.append(mulLine.getId());
					stringBuffer.append("Sel\");//1:该行被选中；0:该行未被选中");
				}
				List cols = mulLine.getCols();
				List colList = new ArrayList();
				for (int j = 1; j < cols.size(); j++)
				{
					MulLineCol col = (MulLineCol)cols.get(j);
					stringBuffer.append(TEXT_28);
					stringBuffer.append((new StringBuilder(String.valueOf(mulLine.getId()))).append(j).toString());
					stringBuffer.append("[] = request.getParameterValues(\"");
					stringBuffer.append((new StringBuilder(String.valueOf(mulLine.getId()))).append(j).toString());
					stringBuffer.append("\");//");
					stringBuffer.append(col.getName());
				}

				stringBuffer.append(TEXT_31);
				stringBuffer.append(mulLine.getId());
				stringBuffer.append(TEXT_32);
				stringBuffer.append(mulLine.getId());
				stringBuffer.append(TEXT_33);
				stringBuffer.append(mulLine.getId());
				stringBuffer.append("LineCount = request.getParameterValues(\"");
				stringBuffer.append(mulLine.getId());
				stringBuffer.append(TEXT_35);
				stringBuffer.append(mulLine.getId());
				stringBuffer.append(TEXT_36);
				stringBuffer.append(cols.size());
				stringBuffer.append("];");
				if (mulLine.isCanChk())
					stringBuffer.append(TEXT_38);
				else
				if (mulLine.isCanSel())
					stringBuffer.append(TEXT_39);
				else
					stringBuffer.append(TEXT_40);
				for (int j = 1; j < cols.size(); j++)
				{
					stringBuffer.append(TEXT_41);
					stringBuffer.append(j);
					stringBuffer.append("] = t");
					stringBuffer.append((new StringBuilder(String.valueOf(mulLine.getId()))).append(j).toString());
					stringBuffer.append("[m];");
				}

				stringBuffer.append(TEXT_44);
				stringBuffer.append(mulLine.getId());
				stringBuffer.append(TEXT_45);
				stringBuffer.append(mulLine.getId());
				stringBuffer.append("\",mul");
				stringBuffer.append(mulLine.getId());
			}

		}

		stringBuffer.append(TEXT_48);
		stringBuffer.append(model.getFileName());
		stringBuffer.append(TEXT_49);
		stringBuffer.append(model.getFileName());
		stringBuffer.append(TEXT_50);
		stringBuffer.append(model.getFileName());
		stringBuffer.append(TEXT_51);
		stringBuffer.append(TEXT_52);
		return stringBuffer.toString();
	}
}
