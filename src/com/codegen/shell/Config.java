// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Config.java

package com.codegen.shell;


public class Config
{

	public static String INPUT_CLASS = "inputclass";
	public static String INPUTJS_CLASS = "inputjsclass";
	public static String INIT_CLASS = "initclass";
	public static String SAVE_CLASS = "saveclass";
	public static String UI_CLASS = "uiclass";
	public static String BL_CLASS = "blclass";
	public static String HTML_CLASS = "htmlclass";
	public static String CONFIG_CLASS = "configclass";
	public static String GENERATE_EXAMPLE = "generatexample";
	public static String GENERATE_CONFIG = "generatconfig";
	public static String PAGE_ENCODING = "pageencoding";
	public static String CHARSET = "charset";
	private String InputClass;
	private String InputjsClass;
	private String InitClass;
	private String SaveClass;
	private String uiClass;
	private String blClass;
	private String htmlclass;
	private String configclass;
	private boolean generateExample;
	private boolean generatConfig;
	public String pageEncoding;
	public String charset;

	public Config()
	{
		InputClass = "com.codegen.template.cms.CommonInputTemplate";
		InputjsClass = "com.codegen.template.cms.CommonInputJsTemplate";
		InitClass = "com.codegen.template.cms.CommonInitTemplate";
		SaveClass = "com.codegen.template.cms.CommonSaveTemplate";
		uiClass = "com.codegen.template.cms.CommonUITemplate";
		blClass = "com.codegen.template.cms.CommonBLTemplate";
		htmlclass = "com.codegen.template.cms.CommonHTMLTemplate";
		configclass = "com.codegen.template.cms.CommonConfigTemplate";
		generateExample = true;
		generatConfig = false;
		pageEncoding = "GBK";
		charset = "UTF-8";
	}

	public String getInputClass()
	{
		return InputClass;
	}

	public void setInputClass(String inputClass)
	{
		if (inputClass != null && !inputClass.trim().equals(""))
			InputClass = inputClass;
	}

	public String getInputjsClass()
	{
		return InputjsClass;
	}

	public void setInputjsClass(String inputjsClass)
	{
		if (inputjsClass != null && !inputjsClass.trim().equals(""))
			InputjsClass = inputjsClass;
	}

	public String getInitClass()
	{
		return InitClass;
	}

	public void setInitClass(String initClass)
	{
		if (initClass != null && !initClass.trim().equals(""))
			InitClass = initClass;
	}

	public String getSaveClass()
	{
		return SaveClass;
	}

	public void setSaveClass(String saveClass)
	{
		if (saveClass != null && !saveClass.trim().equals(""))
			SaveClass = saveClass;
	}

	public String getUiClass()
	{
		return uiClass;
	}

	public void setUiClass(String uiClass)
	{
		if (uiClass != null && !uiClass.trim().equals(""))
			this.uiClass = uiClass;
	}

	public String getBlClass()
	{
		return blClass;
	}

	public void setBlClass(String blClass)
	{
		if (blClass != null && !blClass.trim().equals(""))
			this.blClass = blClass;
	}

	public String getHtmlclass()
	{
		return htmlclass;
	}

	public void setHtmlclass(String htmlclass)
	{
		this.htmlclass = htmlclass;
	}

	public boolean isGenerateExample()
	{
		return generateExample;
	}

	public void setGenerateExample(boolean generateExample)
	{
		this.generateExample = generateExample;
	}

	public String getConfigclass()
	{
		return configclass;
	}

	public void setConfigclass(String configclass)
	{
		this.configclass = configclass;
	}

	public boolean isGeneratConfig()
	{
		return generatConfig;
	}

	public void setGeneratConfig(boolean generatConfig)
	{
		this.generatConfig = generatConfig;
	}

	public String getPageEncoding()
	{
		return pageEncoding;
	}

	public void setPageEncoding(String pageEncoding)
	{
		this.pageEncoding = pageEncoding;
	}

	public String getCharset()
	{
		return charset;
	}

	public void setCharset(String charset)
	{
		this.charset = charset;
	}

}
