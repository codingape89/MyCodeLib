// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CommonHTMLTemplate.java

package com.codegen.template.cms;

import com.codegen.core.model.Model;
import com.codegen.shell.Config;
import java.util.Properties;

public class CommonHTMLTemplate
{

	protected static String nl;
	public final String NL;
	protected final String TEXT_1;
	protected final String TEXT_2 = "\" contentType=\"text/html;charset=";
	protected final String TEXT_3;
	protected final String TEXT_4;
	protected final String TEXT_5;

	public CommonHTMLTemplate()
	{
		NL = nl != null ? nl : System.getProperties().getProperty("line.separator");
		TEXT_1 = (new StringBuilder("<head>")).append(NL).append("<title></title>").append(NL).append("<%@page pageEncoding=\"").toString();
		TEXT_3 = (new StringBuilder("\" %>")).append(NL).append("<script language=\"javascript\">").append(NL).append("    var intPageWidth=screen.availWidth;").append(NL).append("    var intPageHeight=screen.availHeight;").append(NL).append("    window.resizeTo(intPageWidth,intPageHeight);").append(NL).append("    window.focus();").append(NL).append("</script>").append(NL).append("</head>").append(NL).append("<!--<frameset rows=\"35,0,0,65,*\" frameborder=\"no\" border=\"1\" framespacing=\"0\" cols=\"*\"> -->").append(NL).append("<frameset name=\"fraMain\" rows=\"10,10,0,0,*\" frameborder=\"no\" border=\"1\" framespacing=\"0\" cols=\"*\">").append(NL).append("<!--标题与状态区域-->").append(NL).append("    <!--保存客户端变量的区域，该区域必须有-->").append(NL).append("    <frame name=\"VD\" src=\"../common/cvar/CVarData.html\">").append(NL).append(NL).append("    <!--保存客户端变量和WebServer实现交户的区域，该区域必须有-->").append(NL).append("    <frame name=\"EX\" src=\"../common/cvar/CExec.jsp\">").append(NL).append(NL).append("    <frame name=\"fraSubmit\"  scrolling=\"yes\" noresize src=\"about:blank\" >").append(NL).append("    <frame name=\"fraTitle\"  scrolling=\"no\" noresize src=\"about:blank\" >").append(NL).append("    <frameset name=\"fraSet\" cols=\"0%,*,0%\" frameborder=\"no\" border=\"1\" framespacing=\"0\" rows=\"*\">").append(NL).append("        <!--菜单区域-->").append(NL).append("        <frame name=\"fraMenu\" scrolling=\"yes\" noresize src=\"about:blank\">").append(NL).append("        <!--交互区域-->").append(NL).append("        <frame id=\"fraInterface\" name=\"fraInterface\" scrolling=\"auto\" src=\"./").toString();
		TEXT_4 = (new StringBuilder("Input.jsp\">")).append(NL).append("        <!--下一步页面区域-->").append(NL).append("        <frame id=\"fraNext\" name=\"fraNext\" scrolling=\"auto\" src=\"about:blank\">").append(NL).append("    </frameset>").append(NL).append("</frameset>").append(NL).append("<noframes>").append(NL).append("    <body bgcolor=\"#ffffff\">").append(NL).append("    </body>").append(NL).append("</noframes>").append(NL).append("</html>").toString();
		TEXT_5 = NL;
	}

	public static synchronized CommonHTMLTemplate create(String lineSeparator)
	{
		nl = lineSeparator;
		CommonHTMLTemplate result = new CommonHTMLTemplate();
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
		stringBuffer.append(model.getFileName());
		stringBuffer.append(TEXT_4);
		stringBuffer.append(TEXT_5);
		return stringBuffer.toString();
	}
}
