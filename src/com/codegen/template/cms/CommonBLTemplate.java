// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CommonBLTemplate.java

package com.codegen.template.cms;

import com.codegen.core.model.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class CommonBLTemplate
{

	protected static String nl;
	public final String NL;
	protected final String TEXT_1;
	protected final String TEXT_2;
	protected final String TEXT_3;
	protected final String TEXT_4;
	protected final String TEXT_5;
	protected final String TEXT_6 = " m";
	protected final String TEXT_7 = " = new ";
	protected final String TEXT_8 = "();";
	protected final String TEXT_9;
	protected final String TEXT_10 = " = \"\";";
	protected final String TEXT_11;
	protected final String TEXT_12 = " = new ArrayList();//";
	protected final String TEXT_13;
	protected final String TEXT_14;
	protected final String TEXT_15;
	protected final String TEXT_16 = " = (";
	protected final String TEXT_17 = ")transferData.getValueByName(\"";
	protected final String TEXT_18 = "\");";
	protected final String TEXT_19;
	protected final String TEXT_20 = " = (String)transferData.getValueByName(\"";
	protected final String TEXT_21 = "\");";
	protected final String TEXT_22;
	protected final String TEXT_23 = " = (List)transferData.getValueByName(\"mul";
	protected final String TEXT_24 = "\");//";
	protected final String TEXT_25;
	protected final String TEXT_26;
	protected final String TEXT_27;
	protected final String TEXT_28;
	protected final String TEXT_29;
	protected final String TEXT_30;
	protected final String TEXT_31;
	protected final String TEXT_32;
	protected final String TEXT_33;
	protected final String TEXT_34;
	protected final String TEXT_35;

	public CommonBLTemplate()
	{
		NL = nl != null ? nl : System.getProperties().getProperty("line.separator");
		TEXT_1 = (new StringBuilder("/*")).append(NL)
							.append(" *************************************************************************").append(NL)
							.append(" * Copyright (C) 2010-")
							.toString();
		TEXT_2 = (new StringBuilder(", Sinosoft Corporation and others.             *")).append(NL)
							.append(" * All Rights Reserved.                                                  *").append(NL)
							.append(" *************************************************************************").append(NL)
							.append(" */").append(NL)
							.append("package com.sinosoft.lis.")
							.toString();
		TEXT_3 = (new StringBuilder(";")).append(NL).append(NL)
							.append("import java.util.*;").append(NL)
							.append("import com.sinosoft.lis.schema.*;").append(NL)
							.append("import com.sinosoft.lis.vschema.*;").append(NL)
							.append("import com.sinosoft.lis.db.*;").append(NL)
							.append("import com.sinosoft.lis.vdb.*;").append(NL)
							.append("import com.sinosoft.lis.pubfun.*;").append(NL)
							.append("import com.sinosoft.utility.*;").append(NL).append(NL)
							.append("public class ")
							.toString();
		TEXT_4 = (new StringBuilder("BL {")).append(NL)
							.append("    /** 错误处理类，每个需要错误处理的类中都放置该类 */").append(NL)
							.append("    public CErrors mErrors = new CErrors();").append(NL)
							.append("    private String mOperate;// 数据操作字符串").append(NL)
							.append("    private GlobalInput mGlobalInput = new GlobalInput();// 全局数据").append(NL)
							.append("    private MMap mMap = new MMap();").append(NL)
							.append("    private VData mResult = new VData();// 存放返回数据的容器").append(NL)
							.toString();
		TEXT_5 = (new StringBuilder(String.valueOf(NL)))
							.append("    ")
							.toString();
		TEXT_9 = (new StringBuilder(String.valueOf(NL)))
							.append("    private String m")
							.toString();
		TEXT_11 = (new StringBuilder(String.valueOf(NL)))
							.append("    List m")
							.toString();
		TEXT_13 = (new StringBuilder(String.valueOf(NL))).append(NL)
							.append("    private String currentDate = PubFun.getCurrentDate();").append(NL)
							.append("    private String currentTime = PubFun.getCurrentTime();").append(NL).append(NL)
							.append("    public ")
							.toString();
		TEXT_14 = (new StringBuilder("BL() {")).append(NL)
							.append("    }").append(NL).append(NL)
							.append("    /**").append(NL)
							.append("     * 传输数据的公共方法").append(NL)
							.append("     */").append(NL)
							.append("    public boolean check() {").append(NL)
							.append("        return true;").append(NL)
							.append("    }").append(NL).append(NL)
							.append("    public boolean submitData(VData cInputData, String cOperate) {").append(NL)
							.append("        // 将操作数据拷贝到本类中").append(NL)
							.append("        this.mOperate = cOperate;").append(NL)
							.append("        // 得到外部传入的数据,将数据备份到本类中").append(NL)
							.append("        if (!getInputData(cInputData)) {").append(NL)
							.append("            return false;").append(NL)
							.append("        }").append(NL)
							.append("        if (!check()) {").append(NL)
							.append("            return false;").append(NL)
							.append("        }").append(NL)
							.append("        // 进行业务处理").append(NL)
							.append("        if (!dealData()) {").append(NL)
							.append("            if(!mErrors.needDealError()) {").append(NL)
							.append("                CError.buildErr(this, \"后台处理失败！\");").append(NL)
							.append("            }").append(NL)
							.append("            return false;").append(NL)
							.append("        }").append(NL).append(NL)
							.append("        //开始提交").append(NL)
							.append("        VData tVData = new VData();").append(NL)
							.append("        tVData.add(mMap);").append(NL)
							.append("        PubSubmit tPubSubmit = new PubSubmit();").append(NL)
							.append("        if (!tPubSubmit.submitData(tVData, \"\")) {").append(NL)
							.append("            // @@错误处理").append(NL)
							.append("            CError.buildErr(this, \"数据提交失败!\");").append(NL)
							.append("            return false;").append(NL)
							.append("        }").append(NL)
							.append("        return true;").append(NL)
							.append("    }").append(NL).append(NL)
							.append("    /**").append(NL)
							.append("     * 从输入数据中得到所有对象").append(NL)
							.append("     * 输出：如果没有得到足够的业务数据对象，则返回false,否则返回true").append(NL)
							.append("     */").append(NL)
							.append("    public boolean getInputData(VData cInputData) {").append(NL)
							.append("        // 全局变量").append(NL)
							.append("        mGlobalInput = (GlobalInput) cInputData.get(0);").append(NL)
							.append("        TransferData transferData = (TransferData) cInputData.get(1);")
							.toString();
		TEXT_15 = (new StringBuilder(String.valueOf(NL)))
							.append("        m")
							.toString();
		TEXT_19 = (new StringBuilder(String.valueOf(NL)))
							.append("        m")
							.toString();
		TEXT_22 = (new StringBuilder(String.valueOf(NL)))
							.append("        m")
							.toString();
		TEXT_25 = (new StringBuilder(String.valueOf(NL))).append(NL)
							.append("        if (mGlobalInput == null) {").append(NL)
							.append("            CError.buildErr(this, \"没有得到足够的信息！\");").append(NL)
							.append("            return false;").append(NL)
							.append("        }").append(NL)
							.append("        return true;").append(NL)
							.append("    }").append(NL).append(NL)
							.append("    /**").append(NL)
							.append("     * 业务处理主函数").append(NL)
							.append("     *").append(NL)
							.append("     * @return boolean").append(NL)
							.append("     */").append(NL)
							.append("    public boolean dealData() {")
							.toString();
		TEXT_26 = (new StringBuilder(String.valueOf(NL)))
							.append("        if (mOperate.equals(\"")
							.toString();
		TEXT_27 = (new StringBuilder("\")) {")).append(NL)
							.append("            //TODO ")
							.toString();
		TEXT_28 = (new StringBuilder(String.valueOf(NL)))
							.append("            CError.buildErr(this, \"后台还没有实现这个方法：")
							.toString();
		TEXT_29 = (new StringBuilder("\");")).append(NL)
							.append("            return false;").append(NL)
							.append("        }")
							.toString();
		TEXT_30 = (new StringBuilder(""))
							.append("else if (mOperate.equals(\"")
							.toString();
		TEXT_31 = (new StringBuilder("\")) {")).append(NL)
							.append("            //TODO ")
							.toString();
		TEXT_32 = (new StringBuilder(String.valueOf(NL)))
							.append("            CError.buildErr(this, \"后台还没有实现这个方法：")
							.toString();
		TEXT_33 = (new StringBuilder("\");")).append(NL)
							.append("            return false;").append(NL)
							.append("        }")
							.toString();
		TEXT_34 = (new StringBuilder(String.valueOf(NL)))
							.append("        return true;").append(NL)
							.append("    }").append(NL).append(NL)
							.append("    /**").append(NL)
							.append("     * 这个方法返回的结果中存放程序执行后的结果").append(NL)
							.append("     * 如果程序需要返回数据，可以通过这个方法实现").append(NL)
							.append("     *").append(NL)
							.append("     * @return 返回一个VData容器").append(NL)
							.append("     */").append(NL)
							.append("    public VData getResult() {").append(NL)
							.append("        return mResult;").append(NL)
							.append("    }").append(NL).append(NL)
							.append("}")
							.toString();
		TEXT_35 = NL;
	}

	public static synchronized CommonBLTemplate create(String lineSeparator)
	{
		nl = lineSeparator;
		CommonBLTemplate result = new CommonBLTemplate();
		nl = null;
		return result;
	}

	public String generate(Object argument)
	{
		StringBuffer stringBuffer = new StringBuffer();
		Model model = (Model)argument;
		List forms = model.getForms();
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		String currYear = dateFormat.format(date);
		stringBuffer.append(TEXT_1);
		stringBuffer.append(currYear);
		stringBuffer.append(TEXT_2);
		stringBuffer.append(model.getContainer());
		stringBuffer.append(TEXT_3);
		stringBuffer.append(model.getFileName());
		stringBuffer.append(TEXT_4);
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
					stringBuffer.append(TEXT_5);
					stringBuffer.append(s);
					stringBuffer.append(" m");
					stringBuffer.append(s);
					stringBuffer.append(" = new ");
					stringBuffer.append(s);
				}

				for (Iterator inputStrIter = inputStrList.iterator(); inputStrIter.hasNext(); stringBuffer.append(" = \"\";"))
				{
					Input tInput = (Input)inputStrIter.next();
					stringBuffer.append(TEXT_9);
					stringBuffer.append(tInput.getCode());
				}

			}

			MulLine mulLine;
			for (Iterator mulLineIter = form.getMulLines().iterator(); mulLineIter.hasNext(); stringBuffer.append(mulLine.getDiv().getName()))
			{
				mulLine = (MulLine)mulLineIter.next();
				stringBuffer.append(TEXT_11);
				stringBuffer.append(mulLine.getId());
				stringBuffer.append(" = new ArrayList();//");
			}

		}

		stringBuffer.append(TEXT_13);
		stringBuffer.append(model.getFileName());
		stringBuffer.append(TEXT_14);
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

				for (Iterator schemas = schemaSet.iterator(); schemas.hasNext(); stringBuffer.append("\");"))
				{
					String s = (String)schemas.next();
					stringBuffer.append(TEXT_15);
					stringBuffer.append(s);
					stringBuffer.append(" = (");
					stringBuffer.append(s);
					stringBuffer.append(")transferData.getValueByName(\"");
					stringBuffer.append(s);
				}

				for (Iterator inputStrIter = inputStrList.iterator(); inputStrIter.hasNext(); stringBuffer.append("\");"))
				{
					Input tInput = (Input)inputStrIter.next();
					stringBuffer.append(TEXT_19);
					stringBuffer.append(tInput.getCode());
					stringBuffer.append(" = (String)transferData.getValueByName(\"");
					stringBuffer.append(tInput.getCode());
				}

			}

			MulLine mulLine;
			for (Iterator mulLineIter = form.getMulLines().iterator(); mulLineIter.hasNext(); stringBuffer.append(mulLine.getDiv().getName()))
			{
				mulLine = (MulLine)mulLineIter.next();
				stringBuffer.append(TEXT_22);
				stringBuffer.append(mulLine.getId());
				stringBuffer.append(" = (List)transferData.getValueByName(\"mul");
				stringBuffer.append(mulLine.getId());
				stringBuffer.append("\");//");
			}

		}

		stringBuffer.append(TEXT_25);
		List operationList = new ArrayList();
		for (int i = 0; i < forms.size(); i++)
		{
			Form form = (Form)forms.get(i);
			for (Iterator operations = form.getOperations().iterator(); operations.hasNext();)
			{
				Operation operation = (Operation)operations.next();
				if (operation.getType() == Operation.TYPE_SUBMIT)
					operationList.add(operation);
			}

		}

		for (int i = 0; i < operationList.size(); i++)
		{
			Operation oper = (Operation)operationList.get(i);
			if (i == 0)
			{
				stringBuffer.append(TEXT_26);
				stringBuffer.append(oper.getName());
				stringBuffer.append(TEXT_27);
				stringBuffer.append(oper.getValue());
				stringBuffer.append(TEXT_28);
				stringBuffer.append(oper.getValue());
				stringBuffer.append(TEXT_29);
			} else
			{
				stringBuffer.append(TEXT_30);
				stringBuffer.append(oper.getName());
				stringBuffer.append(TEXT_31);
				stringBuffer.append(oper.getValue());
				stringBuffer.append(TEXT_32);
				stringBuffer.append(oper.getValue());
				stringBuffer.append(TEXT_33);
			}
		}

		stringBuffer.append(TEXT_34);
		stringBuffer.append(TEXT_35);
		return stringBuffer.toString();
	}
}
