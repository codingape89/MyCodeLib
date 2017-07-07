// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CommonUITemplate.java

package com.codegen.template.cms;

import com.codegen.core.model.Model;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class CommonUITemplate
{

	protected static String nl;
	public final String NL;
	protected final String TEXT_1;
	protected final String TEXT_2;
	protected final String TEXT_3;
	protected final String TEXT_4;
	protected final String TEXT_5;
	protected final String TEXT_6 = "BL mBL = new ";
	protected final String TEXT_7;
	protected final String TEXT_8;
	protected final String TEXT_9;

	public CommonUITemplate()
	{
		NL = nl != null ? nl : System.getProperties().getProperty("line.separator");
		TEXT_1 = (new StringBuilder("/*")).append(NL).append(" *************************************************************************").append(NL).append(" * Copyright (C) 2010-").toString();
		TEXT_2 = (new StringBuilder(", Sinosoft Corporation and others.             *")).append(NL).append(" * All Rights Reserved.                                                  *").append(NL).append(" *************************************************************************").append(NL).append(" */").append(NL).append("package com.sinosoft.lis.").toString();
		TEXT_3 = (new StringBuilder(";")).append(NL).append(NL).append("import com.sinosoft.utility.*;").append(NL).append(NL).append("public class ").toString();
		TEXT_4 = (new StringBuilder("UI {")).append(NL).append("    /** 错误处理类，每个需要错误处理的类中都放置该类 */").append(NL).append("    public CErrors mErrors = new CErrors();").append(NL).append("    private VData mResult = new VData();").toString();
		TEXT_5 = (new StringBuilder(String.valueOf(NL))).append("    ").toString();
		TEXT_7 = (new StringBuilder("BL();")).append(NL).append(NL).append("    public ").toString();
		TEXT_8 = (new StringBuilder("UI() {")).append(NL).append("    }").append(NL).append(NL).append("    /**").append(NL).append("     * 传输数据的公共方法").append(NL).append("     */").append(NL).append("    public boolean submitData(VData cInputData, String cOperate) {").append(NL).append("        if (!getInputData(cInputData)) {").append(NL).append("            return false;").append(NL).append("        }").append(NL).append("        // 进行业务处理").append(NL).append("        if (!dealData()) {").append(NL).append("            return false;").append(NL).append("        }").append(NL).append("        // 准备往后台的数据").append(NL).append("        if (!prepareOutputData()) {").append(NL).append("            return false;").append(NL).append("        }").append(NL).append("        mBL.submitData(cInputData, cOperate);").append(NL).append("        // 如果有需要处理的错误，则返回").append(NL).append("        if (mBL.mErrors.needDealError()) {").append(NL).append("            this.mErrors.copyAllErrors(mBL.mErrors);").append(NL).append("            return false;").append(NL).append("        } else {").append(NL).append("            mResult = mBL.getResult();").append(NL).append("        }").append(NL).append("        return true;").append(NL).append("    }").append(NL).append(NL).append("    /**").append(NL).append("     * 从输入数据中得到所有对象").append(NL).append("     * 输出：如果没有得到足够的业务数据对象，则返回false,否则返回true").append(NL).append("     */").append(NL).append("    private boolean getInputData(VData cInputData) {").append(NL).append("        return true;").append(NL).append("    }").append(NL).append(NL).append("    /**").append(NL).append("     * 根据前面的输入数据，进行UI逻辑处理").append(NL).append("     * 如果在处理过程中出错，则返回false,否则返回true").append(NL).append("     */").append(NL).append("    private boolean dealData() {").append(NL).append("        return true;").append(NL).append("    }").append(NL).append(NL).append("    /**").append(NL).append("     * 准备往后层输出所需要的数据").append(NL).append("     * 输出：如果准备数据时发生错误则返回false,否则返回true").append(NL).append("     */").append(NL).append("    private boolean prepareOutputData() {").append(NL).append("        return true;").append(NL).append("    }").append(NL).append(NL).append("    public VData getResult() {").append(NL).append("        return mResult;").append(NL).append("    }").append(NL).append("}").toString();
		TEXT_9 = NL;
	}

	public static synchronized CommonUITemplate create(String lineSeparator)
	{
		nl = lineSeparator;
		CommonUITemplate result = new CommonUITemplate();
		nl = null;
		return result;
	}

	public String generate(Object argument)
	{
		StringBuffer stringBuffer = new StringBuffer();
		Model model = (Model)argument;
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
		stringBuffer.append(TEXT_5);
		stringBuffer.append(model.getFileName());
		stringBuffer.append("BL mBL = new ");
		stringBuffer.append(model.getFileName());
		stringBuffer.append(TEXT_7);
		stringBuffer.append(model.getFileName());
		stringBuffer.append(TEXT_8);
		stringBuffer.append(TEXT_9);
		return stringBuffer.toString();
	}
}
