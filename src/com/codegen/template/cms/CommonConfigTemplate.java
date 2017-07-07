// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CommonConfigTemplate.java

package com.codegen.template.cms;

import com.codegen.core.model.*;
import com.codegen.shell.Config;
import java.util.List;
import java.util.Properties;

public class CommonConfigTemplate
{

	protected static String nl;
	public final String NL;
	protected final String TEXT_1 = "<%@page pageEncoding=\"";
	protected final String TEXT_2 = "\" contentType=\"text/html;charset=";
	protected final String TEXT_3;
	protected final String TEXT_4;
	protected final String TEXT_5;
	protected final String TEXT_6 = "=[];";
	protected final String TEXT_7;

	public CommonConfigTemplate()
	{
		NL = nl != null ? nl : System.getProperties().getProperty("line.separator");
		TEXT_3 = (new StringBuilder("\" %>")).append(NL).append("<script src='../common/javascript/Validator.js' charset=\"").toString();
		TEXT_4 = (new StringBuilder("\"></script>")).append(NL).append("<script type=\"text/javascript\">").append(NL).append("    var _vyfn={};").toString();
		TEXT_5 = (new StringBuilder(String.valueOf(NL))).append("    var _vyd_").toString();
		TEXT_7 = (new StringBuilder(String.valueOf(NL))).append("</script>").toString();
	}

	public static synchronized CommonConfigTemplate create(String lineSeparator)
	{
		nl = lineSeparator;
		CommonConfigTemplate result = new CommonConfigTemplate();
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
		stringBuffer.append("<%@page pageEncoding=\"");
		stringBuffer.append(config.getPageEncoding());
		stringBuffer.append("\" contentType=\"text/html;charset=");
		stringBuffer.append(config.getCharset());
		stringBuffer.append(TEXT_3);
		stringBuffer.append(config.getPageEncoding());
		stringBuffer.append(TEXT_4);
		List forms = model.getForms();
		for (int i = 0; i < forms.size(); i++)
		{
			Form form = (Form)forms.get(i);
			List operations = form.getOperations();
			for (int j = 0; j < operations.size(); j++)
			{
				Operation operation = (Operation)operations.get(j);
				stringBuffer.append(TEXT_5);
				stringBuffer.append(operation.getName());
				stringBuffer.append("=[];");
			}

		}

		stringBuffer.append(TEXT_7);
		return stringBuffer.toString();
	}
}
