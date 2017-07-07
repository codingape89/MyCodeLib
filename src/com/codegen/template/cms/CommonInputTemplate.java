// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   CommonInputTemplate.java

package com.codegen.template.cms;

import com.codegen.core.model.*;
import com.codegen.shell.Config;
import java.util.*;

public class CommonInputTemplate
{

	protected static String nl;
	public final String NL;
	protected final String TEXT_1 = "<%@page pageEncoding=\"";
	protected final String TEXT_2 = "\" contentType=\"text/html;charset=";
	protected final String TEXT_3;
	protected final String TEXT_4;
	protected final String TEXT_5;
	protected final String TEXT_6;
	protected final String TEXT_7;
	protected final String TEXT_8;
	protected final String TEXT_9;
	protected final String TEXT_10;
	protected final String TEXT_11;
	protected final String TEXT_12;
	protected final String TEXT_13 = "Config.jsp\"%>";
	protected final String TEXT_14;
	protected final String TEXT_15 = "Input.js\" charset=\"";
	protected final String TEXT_16;
	protected final String TEXT_17;
	protected final String TEXT_18;
	protected final String TEXT_19 = "\" method=post name=";
	protected final String TEXT_20 = " target=\"";
	protected final String TEXT_21 = "\">";
	protected final String TEXT_22;
	protected final String TEXT_23;
	protected final String TEXT_24;
	protected final String TEXT_25;
	protected final String TEXT_26 = "        <div ";
	protected final String TEXT_27 = "style='width:100%'>";
//	protected final String TEXT_27 = "style=''>"; //20151014 tianzf 100%会导致下拉位置显示不正确
	protected final String TEXT_28;
	protected final String TEXT_29 = "' colNum='";
	protected final String TEXT_30 = "'>";
	protected final String TEXT_31;
	protected final String TEXT_32;
	protected final String TEXT_33;
	protected final String TEXT_34;
	protected final String TEXT_35 = "' class='common'";
	protected final String TEXT_36 = " ";
	protected final String TEXT_37 = " ";
	protected final String TEXT_38 = "/></td>";
	protected final String TEXT_39;
	protected final String TEXT_40;
	protected final String TEXT_41 = "name='";
	protected final String TEXT_42 = "'";
	protected final String TEXT_43 = " ";
	protected final String TEXT_44 = " ";
	protected final String TEXT_45 = "/></td>";
	protected final String TEXT_46;
	protected final String TEXT_47;
	protected final String TEXT_48 = "'";
	protected final String TEXT_49 = " ondblclick=\"return showCodeList('";
	protected final String TEXT_50 = "',[this,";
//	protected final String TEXT_51 = "],[0,1],null,null,null,null,null,1);\" onkeyup=\"return showCodeListKey('";
	protected final String TEXT_51 = "],[0,1],null,null,null,1,null,1);\" onkeyup=\"return showCodeListKey('";//20151014 tianzf 修改为强制刷新
	protected final String TEXT_52 = "',[this,";
//	protected final String TEXT_53 = "],[0,1],null,null,null,null,null,1)\"/><input class=codename name='";
	protected final String TEXT_53 = "],[0,1],null,null,null,1,null,1)\"/><input class=codename name='";//20151014 tianzf 修改为强制刷新
	protected final String TEXT_54 = "' ";
	protected final String TEXT_55 = " readonly/></td>";
	protected final String TEXT_56;
	protected final String TEXT_57;
	protected final String TEXT_58 = "'";
	protected final String TEXT_59 = " readonly/></td>";
	protected final String TEXT_60;
	protected final String TEXT_61;
	protected final String TEXT_62 = "'";
	protected final String TEXT_63 = " type='hidden' readonly/></td>";
	protected final String TEXT_64;
	protected final String TEXT_65;
	protected final String TEXT_66;
	protected final String TEXT_67;
	protected final String TEXT_68;
	protected final String TEXT_69;
	protected final String TEXT_70;
	protected final String TEXT_71;
	protected final String TEXT_72;
	protected final String TEXT_73 = ".lastPage();\" class=\"cssButton\"/>";
	protected final String TEXT_74;
	protected final String TEXT_75 = ",";
	protected final String TEXT_76 = ")\">";
	protected final String TEXT_77;
	protected final String TEXT_78;
	protected final String TEXT_79 = ";padding-right:10px;\">";
	protected final String TEXT_80;
	protected final String TEXT_81 = "' value=\"";
	protected final String TEXT_82 = "\" type=\"button\" onclick=\"return ";
	protected final String TEXT_83 = ";\"";
	protected final String TEXT_84 = "/>";
	protected final String TEXT_85;
	protected final String TEXT_86;
	protected final String TEXT_87;
	protected final String TEXT_88 = "        <div ";
	protected final String TEXT_89 = "style='width:100%'>";
//	protected final String TEXT_89 = "style=''>";//20151014 tianzf 100%会导致下拉位置显示不正确
	protected final String TEXT_90;
	protected final String TEXT_91 = "' colNum='";
	protected final String TEXT_92 = "'>";
	protected final String TEXT_93;
	protected final String TEXT_94;
	protected final String TEXT_95;
	protected final String TEXT_96;
	protected final String TEXT_97 = "' class='common'";
	protected final String TEXT_98 = " ";
	protected final String TEXT_99 = " ";
	protected final String TEXT_100 = "/></td>";
	protected final String TEXT_101;
	protected final String TEXT_102;
	protected final String TEXT_103 = "name='";
	protected final String TEXT_104 = "'";
	protected final String TEXT_105 = " ";
	protected final String TEXT_106 = " ";
	protected final String TEXT_107 = "/></td>";
	protected final String TEXT_108;
	protected final String TEXT_109;
	protected final String TEXT_110 = "'";
	protected final String TEXT_111 = " ondblclick=\"return showCodeList('";
	protected final String TEXT_112 = "',[this,";
//	protected final String TEXT_113 = "],[0,1],null,null,null,null,null,1);\" onkeyup=\"return showCodeListKey('";
	protected final String TEXT_113 = "],[0,1],null,null,null,1,null,1);\" onkeyup=\"return showCodeListKey('";//20151014 tianzf 修改为强制刷新
	protected final String TEXT_114 = "',[this,";
//	protected final String TEXT_115 = "],[0,1],null,null,null,null,null,1)\"/><input class=codename name='";
	protected final String TEXT_115 = "],[0,1],null,null,null,1,null,1)\"/><input class=codename name='";//20151014 tianzf 修改为强制刷新
	protected final String TEXT_116 = "' ";
	protected final String TEXT_117 = " readonly/></td>";
	protected final String TEXT_118;
	protected final String TEXT_119;
	protected final String TEXT_120 = "'";
	protected final String TEXT_121 = " readonly/></td>";
	protected final String TEXT_122;
	protected final String TEXT_123;
	protected final String TEXT_124 = "'";
	protected final String TEXT_125 = " type='hidden' readonly/></td>";
	protected final String TEXT_126;
	protected final String TEXT_127;
	protected final String TEXT_128;
	protected final String TEXT_129;
	protected final String TEXT_130;
	protected final String TEXT_131;
	protected final String TEXT_132;
	protected final String TEXT_133;
	protected final String TEXT_134;
	protected final String TEXT_135 = ".lastPage();\" class=\"cssButton\"/>";
	protected final String TEXT_136;
	protected final String TEXT_137 = ",";
	protected final String TEXT_138 = ")\">";
	protected final String TEXT_139;
	protected final String TEXT_140;
	protected final String TEXT_141 = ";padding-right:10px;\">";
	protected final String TEXT_142;
	protected final String TEXT_143 = "' value=\"";
	protected final String TEXT_144 = "\" type=\"button\" onclick=\"return ";
	protected final String TEXT_145 = ";\"";
	protected final String TEXT_146 = "/>";
	protected final String TEXT_147;
	protected final String TEXT_148;
	protected final String TEXT_149;
	protected final String TEXT_150;

	public CommonInputTemplate()
	{
		NL = nl != null ? nl : System.getProperties().getProperty("line.separator");
		TEXT_3 = (new StringBuilder("\" %>")).append(NL).append("<%@include file=\"../common/jsp/UsrCheck.jsp\"%>").append(NL).append("<%@include file=\"../common/jsp/ManageComLimit.jsp\"%>").append(NL).append("<head>").append(NL).append("  <script src=\"../common/easyQueryVer3/EasyQueryCache.js\" charset=\"").toString();
		TEXT_4 = (new StringBuilder("\"></script>")).append(NL).append("  <script src=\"../common/easyQueryVer3/EasyQueryVer3.js\" charset=\"").toString();
		TEXT_5 = (new StringBuilder("\"></script>")).append(NL).append("  <script src=\"../common/javascript/jquery.js\" charset=\"").toString();
		TEXT_6 = (new StringBuilder("\"></script>")).append(NL).append("  <script src=\"../common/javascript/VerifyInput.js\" charset=\"").toString();
		TEXT_7 = (new StringBuilder("\"></script>")).append(NL).append("  <script src=\"../common/javascript/Common.js\" charset=\"").toString();
		TEXT_8 = (new StringBuilder("\"></script>")).append(NL).append("  <script src=\"../common/cvar/CCodeOperate.js\" charset=\"").toString();
		TEXT_9 = (new StringBuilder("\"></script>")).append(NL).append("  <script src=\"../common/Calendar/Calendar.js\" charset=\"").toString();
		TEXT_10 = (new StringBuilder("\"></script>")).append(NL).append("  <script src=\"../common/javascript/MulLine.js\" charset=\"").toString();
		TEXT_11 = (new StringBuilder("\"></script>")).append(NL).append("  <link href=\"../common/css/Project.css\" rel=stylesheet type=text/css>").append(NL).append("  <link href=\"../common/css/mulLine.css\" rel=stylesheet type=text/css>").toString();
		TEXT_12 = (new StringBuilder(String.valueOf(NL))).append("  <%@include file=\"./").toString();
		TEXT_14 = (new StringBuilder("  ")).append(NL).append("  <script src=\"./").toString();
		TEXT_16 = (new StringBuilder("\"></script>")).append(NL).append("  <%@include file=\"./").toString();
		TEXT_17 = (new StringBuilder("Init.jsp\"%>")).append(NL).append("</head>").append(NL).append("<body  onload=\"initForms();initElementtype();\">").toString();
		TEXT_18 = (new StringBuilder(String.valueOf(NL))).append("    <form action=\"./").toString();
		TEXT_22 = (new StringBuilder(String.valueOf(NL))).append("        <table>").append(NL).append("            <tr class=common>").append(NL).append("                <td class=common><img  src= \"../common/images/butExpand.gif\" style= \"cursor:hand;\" OnClick= \"showPage(this,").toString();
		TEXT_23 = (new StringBuilder(");\"></td>")).append(NL).append("                <td class=titleImg>").toString();
		TEXT_24 = (new StringBuilder("</td>")).append(NL).append("            </tr>").append(NL).append("        </table>").toString();
		TEXT_25 = NL;
		TEXT_28 = (new StringBuilder(String.valueOf(NL))).append("            <table class=common name='").toString();
		TEXT_31 = (new StringBuilder(String.valueOf(NL))).append("                </tr>").toString();
		TEXT_32 = (new StringBuilder(String.valueOf(NL))).append("                <tr>").toString();
		TEXT_33 = (new StringBuilder(String.valueOf(NL))).append("                    <td class=title>").toString();
		TEXT_34 = (new StringBuilder("</td>")).append(NL).append("                    <td class=input><input name='").toString();
		TEXT_39 = (new StringBuilder(String.valueOf(NL))).append("                    <td class=title>").toString();
		TEXT_40 = (new StringBuilder("</td>")).append(NL).append("                    <td class=input><input class='coolDatePicker' ").toString();
		TEXT_46 = (new StringBuilder(String.valueOf(NL))).append("                    <td class=title>").toString();
		TEXT_47 = (new StringBuilder("</td>")).append(NL).append("                    <td class=input><input class='codeno' name='").toString();
		TEXT_56 = (new StringBuilder(String.valueOf(NL))).append("                    <td class=title>").toString();
		TEXT_57 = (new StringBuilder("</td>")).append(NL).append("                    <td class=input><input class='readonly' name='").toString();
		TEXT_60 = (new StringBuilder(String.valueOf(NL))).append("                    <td class=title style='display:none;'>").toString();
		TEXT_61 = (new StringBuilder("</td>")).append(NL).append("                    <td class=input style='display:none;'><input class='readonly' name='").toString();
		TEXT_64 = (new StringBuilder(String.valueOf(NL))).append("                </tr>").toString();
		TEXT_65 = (new StringBuilder(String.valueOf(NL))).append("            </table>").toString();
		TEXT_66 = (new StringBuilder(String.valueOf(NL))).append("            <div id=\"div").toString();
		TEXT_67 = (new StringBuilder("\">")).append(NL).append("                <table class= common>").append(NL).append("                    <tr class= common>").append(NL).append("                        <td text-align: left colSpan=1>").append(NL).append("                            <span id=\"span").toString();
		TEXT_68 = (new StringBuilder("\" ></span>")).append(NL).append("                        </td>").append(NL).append("                    </tr>").append(NL).append("                </table>").toString();
		TEXT_69 = (new StringBuilder(String.valueOf(NL))).append("                <input value=\"首  页\" type=button onclick=\"turnPage").toString();
		TEXT_70 = (new StringBuilder(".firstPage();\" class=\"cssButton\"/>")).append(NL).append("                <input value=\"上一页\" type=button onclick=\"turnPage").toString();
		TEXT_71 = (new StringBuilder(".previousPage();\" class=\"cssButton\"/>")).append(NL).append("                <input value=\"下一页\" type=button onclick=\"turnPage").toString();
		TEXT_72 = (new StringBuilder(".nextPage();\" class=\"cssButton\"/>")).append(NL).append("                <input value=\"尾  页\" type=button onclick=\"turnPage").toString();
		TEXT_74 = (new StringBuilder(String.valueOf(NL))).append("                <input value=\"导出EXCEL\" type=button class=\"cssbutton\" onclick = \"makeExcel(").toString();
		TEXT_77 = (new StringBuilder(String.valueOf(NL))).append("            </div>").toString();
		TEXT_78 = (new StringBuilder(String.valueOf(NL))).append("            <div style=\"float:").toString();
		TEXT_80 = (new StringBuilder(String.valueOf(NL))).append("                <input class=\"cssButton\" buttonname='").toString();
		TEXT_85 = (new StringBuilder(String.valueOf(NL))).append("            </div>").toString();
		TEXT_86 = (new StringBuilder(String.valueOf(NL))).append("        </div>").toString();
		TEXT_87 = NL;
		TEXT_90 = (new StringBuilder(String.valueOf(NL))).append("            <table class=common name='").toString();
		TEXT_93 = (new StringBuilder(String.valueOf(NL))).append("                </tr>").toString();
		TEXT_94 = (new StringBuilder(String.valueOf(NL))).append("                <tr>").toString();
		TEXT_95 = (new StringBuilder(String.valueOf(NL))).append("                    <td class=title>").toString();
		TEXT_96 = (new StringBuilder("</td>")).append(NL).append("                    <td class=input><input name='").toString();
		TEXT_101 = (new StringBuilder(String.valueOf(NL))).append("                    <td class=title>").toString();
		TEXT_102 = (new StringBuilder("</td>")).append(NL).append("                    <td class=input><input class='coolDatePicker' ").toString();
		TEXT_108 = (new StringBuilder(String.valueOf(NL))).append("                    <td class=title>").toString();
		TEXT_109 = (new StringBuilder("</td>")).append(NL).append("                    <td class=input><input class='codeno' name='").toString();
		TEXT_118 = (new StringBuilder(String.valueOf(NL))).append("                    <td class=title>").toString();
		TEXT_119 = (new StringBuilder("</td>")).append(NL).append("                    <td class=input><input class='readonly' name='").toString();
		TEXT_122 = (new StringBuilder(String.valueOf(NL))).append("                    <td class=title style='display:none;'>").toString();
		TEXT_123 = (new StringBuilder("</td>")).append(NL).append("                    <td class=input style='display:none;'><input class='readonly' name='").toString();
		TEXT_126 = (new StringBuilder(String.valueOf(NL))).append("                </tr>").toString();
		TEXT_127 = (new StringBuilder(String.valueOf(NL))).append("            </table>").toString();
		TEXT_128 = (new StringBuilder(String.valueOf(NL))).append("            <div id=\"div").toString();
		TEXT_129 = (new StringBuilder("\">")).append(NL).append("                <table class= common>").append(NL).append("                    <tr class= common>").append(NL).append("                        <td text-align: left colSpan=1>").append(NL).append("                            <span id=\"span").toString();
		TEXT_130 = (new StringBuilder("\" ></span>")).append(NL).append("                        </td>").append(NL).append("                    </tr>").append(NL).append("                </table>").toString();
		TEXT_131 = (new StringBuilder(String.valueOf(NL))).append("                <input value=\"首  页\" type=button onclick=\"turnPage").toString();
		TEXT_132 = (new StringBuilder(".firstPage();\" class=\"cssButton\"/>")).append(NL).append("                <input value=\"上一页\" type=button onclick=\"turnPage").toString();
		TEXT_133 = (new StringBuilder(".previousPage();\" class=\"cssButton\"/>")).append(NL).append("                <input value=\"下一页\" type=button onclick=\"turnPage").toString();
		TEXT_134 = (new StringBuilder(".nextPage();\" class=\"cssButton\"/>")).append(NL).append("                <input value=\"尾  页\" type=button onclick=\"turnPage").toString();
		TEXT_136 = (new StringBuilder(String.valueOf(NL))).append("                <input value=\"导出EXCEL\" type=button class=\"cssbutton\" onclick = \"makeExcel(").toString();
		TEXT_139 = (new StringBuilder(String.valueOf(NL))).append("            </div>").toString();
		TEXT_140 = (new StringBuilder(String.valueOf(NL))).append("            <div style=\"float:").toString();
		TEXT_142 = (new StringBuilder(String.valueOf(NL))).append("                <input class=\"cssButton\" buttonname='").toString();
		TEXT_147 = (new StringBuilder(String.valueOf(NL))).append("            </div>").toString();
		TEXT_148 = (new StringBuilder(String.valueOf(NL))).append("        </div>").toString();
		TEXT_149 = (new StringBuilder(String.valueOf(NL))).append("        <input type=\"hidden\" name=\"hideOperate\" />").append(NL).append("        <input type=\"hidden\" name=\"tSQL\" />").append(NL).append("    </form>").toString();
		TEXT_150 = (new StringBuilder(String.valueOf(NL))).append("    <span id=\"spanCode\"  style=\"display: none; position:absolute; slategray\"></span>").append(NL).append("</body>").append(NL).append("</html>").toString();
	}

	public static synchronized CommonInputTemplate create(String lineSeparator)
	{
		nl = lineSeparator;
		CommonInputTemplate result = new CommonInputTemplate();
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
		stringBuffer.append(config.getPageEncoding());
		stringBuffer.append(TEXT_4);
		stringBuffer.append(config.getPageEncoding());
		stringBuffer.append(TEXT_5);
		stringBuffer.append(config.getPageEncoding());
		stringBuffer.append(TEXT_6);
		stringBuffer.append(config.getPageEncoding());
		stringBuffer.append(TEXT_7);
		stringBuffer.append(config.getPageEncoding());
		stringBuffer.append(TEXT_8);
		stringBuffer.append(config.getPageEncoding());
		stringBuffer.append(TEXT_9);
		stringBuffer.append(config.getPageEncoding());
		stringBuffer.append(TEXT_10);
		stringBuffer.append(config.getPageEncoding());
		stringBuffer.append(TEXT_11);
		if (config.isGeneratConfig())
		{
			stringBuffer.append(TEXT_12);
			stringBuffer.append(model.getFileName());
			stringBuffer.append("Config.jsp\"%>");
		}
		stringBuffer.append(TEXT_14);
		stringBuffer.append(model.getFileName());
		stringBuffer.append("Input.js\" charset=\"");
		stringBuffer.append(config.getPageEncoding());
		stringBuffer.append(TEXT_16);
		stringBuffer.append(model.getFileName());
		stringBuffer.append(TEXT_17);
		for (int i = 0; i < forms.size(); i++)
		{
			Form form = (Form)forms.get(i);
			stringBuffer.append(TEXT_18);
			stringBuffer.append(form.getAction());
			stringBuffer.append("\" method=post name=");
			stringBuffer.append(form.getName());
			stringBuffer.append(" target=\"");
			stringBuffer.append(form.getTarget());
			stringBuffer.append("\">");
			List divs = form.getDivs();
			for (int j = 0; j < divs.size(); j++)
			{
				Div div = (Div)divs.get(j);
				if (div.isDisplayTitle())
				{
					stringBuffer.append(TEXT_22);
					stringBuffer.append(div.getId());
					stringBuffer.append(TEXT_23);
					stringBuffer.append(div.getName());
					stringBuffer.append(TEXT_24);
					stringBuffer.append(TEXT_25);
					stringBuffer.append("        <div ");
					stringBuffer.append(div.getId() != null && !div.getId().trim().equals("") ? (new StringBuilder("id='")).append(div.getId()).append("' ").toString() : "");
					stringBuffer.append("style='width:100%'>");
//					stringBuffer.append("style=''>");//20151014 tianzf 100%会导致下拉位置显示不正确
					List children = div.getChildren();
					for (int m = 0; m < children.size(); m++)
					{
						Object o = children.get(m);
						if (o instanceof Table)
						{
							Table table = (Table)o;
							int colNum = table.getColNum();
							stringBuffer.append(TEXT_28);
							stringBuffer.append(table.getName());
							stringBuffer.append("' colNum='");
							stringBuffer.append(colNum);
							stringBuffer.append("'>");
							List inputs = table.getInputs();
							for (int n = 0; n < inputs.size(); n++)
							{
								if (n > 0 && n < inputs.size() - 1 && n % colNum == 0)
									stringBuffer.append(TEXT_31);
								if (n % colNum == 0)
									stringBuffer.append(TEXT_32);
								Input input = (Input)inputs.get(n);
								String defaltValue = input.getDefaultValue();
								if (defaltValue != null && !defaltValue.trim().equals(""))
									defaltValue = (new StringBuilder(" value='")).append(defaltValue).append("'").toString();
								else
									defaltValue = "";
								StringBuffer sb = new StringBuffer();
								if (input.isNecessary())
									if (sb.length() == 0)
										sb.append("notnull");
									else
										sb.append("&notnull");
								String dataType = input.getDataType();
								if (dataType != null && !dataType.trim().equals(""))
									if (sb.length() == 0)
										sb.append(dataType);
									else
										sb.append((new StringBuilder("&")).append(dataType).toString());
								String len = input.getLen();
								if (len != null && !len.trim().equals(""))
									if (sb.length() == 0)
										sb.append(len);
									else
										sb.append((new StringBuilder("&")).append(len).toString());
								String val = input.getVal();
								if (val != null && !val.trim().equals(""))
									if (sb.length() == 0)
										sb.append(val);
									else
										sb.append((new StringBuilder("&")).append(val).toString());
								int tType = input.getType();
								if (tType == Input.TYPE_SELECT)
									if (sb.length() == 0)
										sb.append((new StringBuilder("code:")).append(input.getSelectCode()).toString());
									else
										sb.append((new StringBuilder("&code:")).append(input.getSelectCode()).toString());
								String tVerify = "";
								if (sb.length() > 0)
									tVerify = (new StringBuilder(" verify='")).append(input.getName()).append("|").append(sb.toString()).append("'").toString();
								String et = "";
								if (input.isNecessary())
									et = "elementtype=nacessary";
								switch (input.getType())
								{
								case 1: // '\001'
									stringBuffer.append(TEXT_33);
									stringBuffer.append(input.getName());
									stringBuffer.append(TEXT_34);
									stringBuffer.append(input.getCode());
									stringBuffer.append("' class='common'");
									stringBuffer.append(defaltValue);
									stringBuffer.append(tVerify);
									stringBuffer.append(" ");
									stringBuffer.append(input.isReadonly() ? "readonly" : "");
									stringBuffer.append(" ");
									stringBuffer.append(et);
									stringBuffer.append("/></td>");
									break;

								case 2: // '\002'
									stringBuffer.append(TEXT_39);
									stringBuffer.append(input.getName());
									stringBuffer.append(TEXT_40);
									stringBuffer.append(input.isReadonly() ? "class='readonly' " : "");
									stringBuffer.append("name='");
									stringBuffer.append(input.getCode());
									stringBuffer.append("'");
									stringBuffer.append(defaltValue);
									stringBuffer.append(tVerify);
									stringBuffer.append(" ");
									stringBuffer.append(input.isReadonly() ? "readonly" : "");
									stringBuffer.append(" ");
									stringBuffer.append(et);
									stringBuffer.append("/></td>");
									break;

								case 3: // '\003'
									stringBuffer.append(TEXT_46);
									stringBuffer.append(input.getName());
									stringBuffer.append(TEXT_47);
									stringBuffer.append(input.getCode());
									stringBuffer.append("'");
									stringBuffer.append(defaltValue);
									stringBuffer.append(tVerify);
									stringBuffer.append(" ondblclick=\"return showCodeList('");
									stringBuffer.append(input.getSelectCode());
									stringBuffer.append("',[this,");
									stringBuffer.append(input.getSelectField());
//									stringBuffer.append("],[0,1],null,null,null,null,null,1);\" onkeyup=\"return showCodeListKey('");
									stringBuffer.append("],[0,1],null,null,null,1,null,1);\" onkeyup=\"return showCodeListKey('");
									stringBuffer.append(input.getSelectCode());
									stringBuffer.append("',[this,");
									stringBuffer.append(input.getSelectField());
//									stringBuffer.append("],[0,1],null,null,null,null,null,1)\"/><input class=codename name='");
									stringBuffer.append("],[0,1],null,null,null,1,null,1)\"/><input class=codename name='");
									stringBuffer.append(input.getSelectField());
									stringBuffer.append("' ");
									stringBuffer.append(et);
									stringBuffer.append(" readonly/></td>");
									break;

								case 4: // '\004'
									stringBuffer.append(TEXT_56);
									stringBuffer.append(input.getName());
									stringBuffer.append(TEXT_57);
									stringBuffer.append(input.getCode());
									stringBuffer.append("'");
									stringBuffer.append(defaltValue);
									stringBuffer.append(" readonly/></td>");
									break;

								case 5: // '\005'
									stringBuffer.append(TEXT_60);
									stringBuffer.append(input.getName());
									stringBuffer.append(TEXT_61);
									stringBuffer.append(input.getCode());
									stringBuffer.append("'");
									stringBuffer.append(defaltValue);
									stringBuffer.append(" type='hidden' readonly/></td>");
									break;
								}
								if (n == inputs.size() - 1)
									stringBuffer.append(TEXT_64);
							}

							stringBuffer.append(TEXT_65);
						} else
						if (o instanceof MulLine)
						{
							MulLine mulLine = (MulLine)o;
							stringBuffer.append(TEXT_66);
							stringBuffer.append(mulLine.getId());
							stringBuffer.append(TEXT_67);
							stringBuffer.append(mulLine.getId());
							stringBuffer.append(TEXT_68);
							if (mulLine.getButtonType() == MulLine.BUTTONTYPE_PAGE_ONLY || mulLine.getButtonType() == MulLine.BUTTONTYPE_ALL)
							{
								stringBuffer.append(TEXT_69);
								stringBuffer.append(mulLine.getId());
								stringBuffer.append(TEXT_70);
								stringBuffer.append(mulLine.getId());
								stringBuffer.append(TEXT_71);
								stringBuffer.append(mulLine.getId());
								stringBuffer.append(TEXT_72);
								stringBuffer.append(mulLine.getId());
								stringBuffer.append(".lastPage();\" class=\"cssButton\"/>");
							}
							if (mulLine.getButtonType() == MulLine.BUTTONTYPE_EXPORT_ONLY || mulLine.getButtonType() == MulLine.BUTTONTYPE_ALL)
							{
								stringBuffer.append(TEXT_74);
								stringBuffer.append(mulLine.getDiv().getForm().getName());
								stringBuffer.append(",");
								stringBuffer.append(mulLine.getId());
								stringBuffer.append(")\">");
							}
							stringBuffer.append(TEXT_77);
						} else
						if (o instanceof OperationBar)
						{
							OperationBar operationBar = (OperationBar)o;
							int cssFloat = operationBar.getCssFloat();
							String floatStr = "left";
							if (cssFloat == OperationBar.FLOAT_RIGHT)
								floatStr = "right";
							stringBuffer.append(TEXT_78);
							stringBuffer.append(floatStr);
							stringBuffer.append(";padding-right:10px;\">");
							for (Iterator operationIter = operationBar.getOperations().iterator(); operationIter.hasNext(); stringBuffer.append("/>"))
							{
								Operation operation = (Operation)operationIter.next();
								stringBuffer.append(TEXT_80);
								stringBuffer.append(operation.getName());
								stringBuffer.append("' value=\"");
								stringBuffer.append(operation.getValue());
								stringBuffer.append("\" type=\"button\" onclick=\"return ");
								stringBuffer.append(operation.getMethod());
								stringBuffer.append(";\"");
								stringBuffer.append(cssFloat != OperationBar.FLOAT_RIGHT ? "" : " style='margin-right:20px;'");
							}

							stringBuffer.append(TEXT_85);
						}
					}

					stringBuffer.append(TEXT_86);
				} else
				{
					stringBuffer.append(TEXT_87);
					stringBuffer.append("        <div ");
					stringBuffer.append(div.getId() != null && !div.getId().trim().equals("") ? (new StringBuilder("id='")).append(div.getId()).append("' ").toString() : "");
					stringBuffer.append("style='width:100%'>");
//					stringBuffer.append("style=''>");//20151014 tianzf 100%会导致下拉位置显示不正确
					List children = div.getChildren();
					for (int m = 0; m < children.size(); m++)
					{
						Object o = children.get(m);
						if (o instanceof Table)
						{
							Table table = (Table)o;
							int colNum = table.getColNum();
							stringBuffer.append(TEXT_90);
							stringBuffer.append(table.getName());
							stringBuffer.append("' colNum='");
							stringBuffer.append(colNum);
							stringBuffer.append("'>");
							List inputs = table.getInputs();
							for (int n = 0; n < inputs.size(); n++)
							{
								if (n > 0 && n < inputs.size() - 1 && n % colNum == 0)
									stringBuffer.append(TEXT_93);
								if (n % colNum == 0)
									stringBuffer.append(TEXT_94);
								Input input = (Input)inputs.get(n);
								String defaltValue = input.getDefaultValue();
								if (defaltValue != null && !defaltValue.trim().equals(""))
									defaltValue = (new StringBuilder(" value='")).append(defaltValue).append("'").toString();
								else
									defaltValue = "";
								StringBuffer sb = new StringBuffer();
								if (input.isNecessary())
									if (sb.length() == 0)
										sb.append("notnull");
									else
										sb.append("&notnull");
								String dataType = input.getDataType();
								if (dataType != null && !dataType.trim().equals(""))
									if (sb.length() == 0)
										sb.append(dataType);
									else
										sb.append((new StringBuilder("&")).append(dataType).toString());
								String len = input.getLen();
								if (len != null && !len.trim().equals(""))
									if (sb.length() == 0)
										sb.append(len);
									else
										sb.append((new StringBuilder("&")).append(len).toString());
								String val = input.getVal();
								if (val != null && !val.trim().equals(""))
									if (sb.length() == 0)
										sb.append(val);
									else
										sb.append((new StringBuilder("&")).append(val).toString());
								int tType = input.getType();
								if (tType == Input.TYPE_SELECT)
									if (sb.length() == 0)
										sb.append((new StringBuilder("code:")).append(input.getSelectCode()).toString());
									else
										sb.append((new StringBuilder("&code:")).append(input.getSelectCode()).toString());
								String tVerify = "";
								if (sb.length() > 0)
									tVerify = (new StringBuilder(" verify='")).append(input.getName()).append("|").append(sb.toString()).append("'").toString();
								String et = "";
								if (input.isNecessary())
									et = "elementtype=nacessary";
								switch (input.getType())
								{
								case 1: // '\001'
									stringBuffer.append(TEXT_95);
									stringBuffer.append(input.getName());
									stringBuffer.append(TEXT_96);
									stringBuffer.append(input.getCode());
									stringBuffer.append("' class='common'");
									stringBuffer.append(defaltValue);
									stringBuffer.append(tVerify);
									stringBuffer.append(" ");
									stringBuffer.append(input.isReadonly() ? "readonly" : "");
									stringBuffer.append(" ");
									stringBuffer.append(et);
									stringBuffer.append("/></td>");
									break;

								case 2: // '\002'
									stringBuffer.append(TEXT_101);
									stringBuffer.append(input.getName());
									stringBuffer.append(TEXT_102);
									stringBuffer.append(input.isReadonly() ? "class='readonly' " : "");
									stringBuffer.append("name='");
									stringBuffer.append(input.getCode());
									stringBuffer.append("'");
									stringBuffer.append(defaltValue);
									stringBuffer.append(tVerify);
									stringBuffer.append(" ");
									stringBuffer.append(input.isReadonly() ? "readonly" : "");
									stringBuffer.append(" ");
									stringBuffer.append(et);
									stringBuffer.append("/></td>");
									break;

								case 3: // '\003'
									stringBuffer.append(TEXT_108);
									stringBuffer.append(input.getName());
									stringBuffer.append(TEXT_109);
									stringBuffer.append(input.getCode());
									stringBuffer.append("'");
									stringBuffer.append(defaltValue);
									stringBuffer.append(tVerify);
									stringBuffer.append(" ondblclick=\"return showCodeList('");
									stringBuffer.append(input.getSelectCode());
									stringBuffer.append("',[this,");
									stringBuffer.append(input.getSelectField());
//									stringBuffer.append("],[0,1],null,null,null,null,null,1);\" onkeyup=\"return showCodeListKey('");
									stringBuffer.append("],[0,1],null,null,null,1,null,1);\" onkeyup=\"return showCodeListKey('");
									stringBuffer.append(input.getSelectCode());
									stringBuffer.append("',[this,");
									stringBuffer.append(input.getSelectField());
//									stringBuffer.append("],[0,1],null,null,null,null,null,1)\"/><input class=codename name='");
									stringBuffer.append("],[0,1],null,null,null,1,null,1)\"/><input class=codename name='");
									stringBuffer.append(input.getSelectField());
									stringBuffer.append("' ");
									stringBuffer.append(et);
									stringBuffer.append(" readonly/></td>");
									break;

								case 4: // '\004'
									stringBuffer.append(TEXT_118);
									stringBuffer.append(input.getName());
									stringBuffer.append(TEXT_119);
									stringBuffer.append(input.getCode());
									stringBuffer.append("'");
									stringBuffer.append(defaltValue);
									stringBuffer.append(" readonly/></td>");
									break;

								case 5: // '\005'
									stringBuffer.append(TEXT_122);
									stringBuffer.append(input.getName());
									stringBuffer.append(TEXT_123);
									stringBuffer.append(input.getCode());
									stringBuffer.append("'");
									stringBuffer.append(defaltValue);
									stringBuffer.append(" type='hidden' readonly/></td>");
									break;
								}
								if (n == inputs.size() - 1)
									stringBuffer.append(TEXT_126);
							}

							stringBuffer.append(TEXT_127);
						} else
						if (o instanceof MulLine)
						{
							MulLine mulLine = (MulLine)o;
							stringBuffer.append(TEXT_128);
							stringBuffer.append(mulLine.getId());
							stringBuffer.append(TEXT_129);
							stringBuffer.append(mulLine.getId());
							stringBuffer.append(TEXT_130);
							if (mulLine.getButtonType() == MulLine.BUTTONTYPE_PAGE_ONLY || mulLine.getButtonType() == MulLine.BUTTONTYPE_ALL)
							{
								stringBuffer.append(TEXT_131);
								stringBuffer.append(mulLine.getId());
								stringBuffer.append(TEXT_132);
								stringBuffer.append(mulLine.getId());
								stringBuffer.append(TEXT_133);
								stringBuffer.append(mulLine.getId());
								stringBuffer.append(TEXT_134);
								stringBuffer.append(mulLine.getId());
								stringBuffer.append(".lastPage();\" class=\"cssButton\"/>");
							}
							if (mulLine.getButtonType() == MulLine.BUTTONTYPE_EXPORT_ONLY || mulLine.getButtonType() == MulLine.BUTTONTYPE_ALL)
							{
								stringBuffer.append(TEXT_136);
								stringBuffer.append(mulLine.getDiv().getForm().getName());
								stringBuffer.append(",");
								stringBuffer.append(mulLine.getId());
								stringBuffer.append(")\">");
							}
							stringBuffer.append(TEXT_139);
						} else
						if (o instanceof OperationBar)
						{
							OperationBar operationBar = (OperationBar)o;
							int cssFloat = operationBar.getCssFloat();
							String floatStr = "left";
							if (cssFloat == OperationBar.FLOAT_RIGHT)
								floatStr = "right";
							stringBuffer.append(TEXT_140);
							stringBuffer.append(floatStr);
							stringBuffer.append(";padding-right:10px;\">");
							for (Iterator operationIter = operationBar.getOperations().iterator(); operationIter.hasNext(); stringBuffer.append("/>"))
							{
								Operation operation = (Operation)operationIter.next();
								stringBuffer.append(TEXT_142);
								stringBuffer.append(operation.getName());
								stringBuffer.append("' value=\"");
								stringBuffer.append(operation.getValue());
								stringBuffer.append("\" type=\"button\" onclick=\"return ");
								stringBuffer.append(operation.getMethod());
								stringBuffer.append(";\"");
								stringBuffer.append(cssFloat != OperationBar.FLOAT_RIGHT ? "" : " style='margin-right:20px;'");
							}

							stringBuffer.append(TEXT_147);
						}
					}

					stringBuffer.append(TEXT_148);
				}
			}

			stringBuffer.append(TEXT_149);
		}

		stringBuffer.append(TEXT_150);
		return stringBuffer.toString();
	}
}
