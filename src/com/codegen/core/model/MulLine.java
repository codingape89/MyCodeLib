// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MulLine.java

package com.codegen.core.model;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.codegen.core.model:
//			MulLineCol, Div

public class MulLine
{

	public static int BUTTONTYPE_ALL = 1;
	public static int BUTTONTYPE_PAGE_ONLY = 2;
	public static int BUTTONTYPE_EXPORT_ONLY = 3;
	public static int BUTTONTYPE_NONE = 4;
	private String id;
	private boolean needSubmit;
	private List cols;
	private String sql;
	private String manageComLimit;
	private boolean displayTitle;
	private boolean hiddenPlus;
	private boolean hiddenSubtraction;
	private boolean canChk;
	private boolean canSel;
	private String selBoxEventFuncName;
	private String selBoxEventFuncParm;
	private String addEventFuncName;
	private String addEventFunParm;
	private String delEventFuncName;
	private String delEventFunParm;
	private int mulLineCount;
	private int ButtonType;
	private Div div;

	public MulLine()
	{
		cols = new ArrayList();
		manageComLimit = "managecom";
		displayTitle = true;
		hiddenPlus = false;
		hiddenSubtraction = false;
		canChk = false;
		canSel = false;
	}

	public boolean init(String args, String regex)
	{
		if (regex == null || regex.trim().equals(""))
			regex = "\\^";
		int j = 1;
		String split[] = args.split(regex);
		setId(split[j++]);
		setNeedSubmit("Y".equalsIgnoreCase(split[j++]));
		setHiddenPlus("N".equalsIgnoreCase(split[j++]));
		setHiddenSubtraction("N".equalsIgnoreCase(split[j++]));
		setDisplayTitle("Y".equalsIgnoreCase(split[j++]));
		String tmp = split[j++];
		setCanChk("C".equalsIgnoreCase(tmp));
		setCanSel("S".equalsIgnoreCase(tmp));
		setSelBoxEventFuncName(split[j++]);
		setSelBoxEventFuncParm(split[j++]);
		setAddEventFuncName(split[j++]);
		setAddEventFunParm(split[j++]);
		setDelEventFuncName(split[j++]);
		setDelEventFunParm(split[j++]);
		String count = split[j++];
		if (count == null || count.trim().equals(""))
			count = "10";
		String type = split[j++];
		if (type == null || type.trim().equals(""))
			type = String.valueOf(BUTTONTYPE_PAGE_ONLY);
		setMulLineCount(Integer.parseInt(count));
		setButtonType(Integer.parseInt(type));
		String sql = split[j++];
		if (sql != null)
		{
			if (!sql.endsWith(" "))
				sql = (new StringBuilder(String.valueOf(sql))).append(" ").toString();
		} else
		{
			sql = " ";
		}
		setSql(sql);
		return true;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public boolean isNeedSubmit()
	{
		return needSubmit;
	}

	public void setNeedSubmit(boolean needSubmit)
	{
		this.needSubmit = needSubmit;
	}

	public List getCols()
	{
		return cols;
	}

	public boolean isDisplayTitle()
	{
		return displayTitle;
	}

	public void setDisplayTitle(boolean displayTitle)
	{
		this.displayTitle = displayTitle;
	}

	public boolean isHiddenPlus()
	{
		return hiddenPlus;
	}

	public void setHiddenPlus(boolean hiddenPlus)
	{
		this.hiddenPlus = hiddenPlus;
	}

	public boolean isHiddenSubtraction()
	{
		return hiddenSubtraction;
	}

	public void setHiddenSubtraction(boolean hiddenSubtraction)
	{
		this.hiddenSubtraction = hiddenSubtraction;
	}

	public boolean isCanChk()
	{
		return canChk;
	}

	public void setCanChk(boolean canChk)
	{
		this.canChk = canChk;
	}

	public boolean isCanSel()
	{
		return canSel;
	}

	public void setCanSel(boolean canSel)
	{
		this.canSel = canSel;
	}

	public String getSelBoxEventFuncName()
	{
		return selBoxEventFuncName;
	}

	public void setSelBoxEventFuncName(String selBoxEventFuncName)
	{
		this.selBoxEventFuncName = selBoxEventFuncName;
	}

	public String getSelBoxEventFuncParm()
	{
		return selBoxEventFuncParm;
	}

	public void setSelBoxEventFuncParm(String selBoxEventFuncParm)
	{
		this.selBoxEventFuncParm = selBoxEventFuncParm;
	}

	public String getAddEventFuncName()
	{
		return addEventFuncName;
	}

	public void setAddEventFuncName(String addEventFuncName)
	{
		this.addEventFuncName = addEventFuncName;
	}

	public String getAddEventFunParm()
	{
		return addEventFunParm;
	}

	public void setAddEventFunParm(String addEventFunParm)
	{
		this.addEventFunParm = addEventFunParm;
	}

	public String getDelEventFuncName()
	{
		return delEventFuncName;
	}

	public void setDelEventFuncName(String delEventFuncName)
	{
		this.delEventFuncName = delEventFuncName;
	}

	public String getDelEventFunParm()
	{
		return delEventFunParm;
	}

	public void setDelEventFunParm(String delEventFunParm)
	{
		this.delEventFunParm = delEventFunParm;
	}

	public int getMulLineCount()
	{
		return mulLineCount;
	}

	public void setMulLineCount(int mulLineCount)
	{
		if (mulLineCount >= 0)
			this.mulLineCount = mulLineCount;
	}

	public void initCols(String cols[], String regex)
	{
		if (regex == null || regex.trim().equals(""))
			regex = "\\^";
		for (int i = 0; i < cols.length; i++)
		{
			String split[] = cols[i].split(regex);
			int j = 1;
			MulLineCol col = new MulLineCol();
			col.setName(split[j++]);
			col.setDbCode(split[j++]);
			col.setSchema(split[j++]);
			col.setSchemaField(split[j++]);
			String type = split[j++];
			if (type == null || type.trim().equals(""))
				type = "0";
			col.setType(Integer.parseInt(type));
			col.setSelectCode(split[j++]);
			String tmp = split[j++];
			if (tmp != null && !tmp.trim().equals(""))
				col.setSelectCodeNameIndex(Integer.parseInt(tmp));
			col.setHidden("Y".equalsIgnoreCase(split[j++]));
			col.setCode(split[j++]);
			col.setOperation(split[j++]);
			col.setLikeKind(split[j++]);
			String width = split[j++];
			if (width == null || width.trim().equals(""))
				width = "100";
			String align = split[j++];
			if (align == null || align.trim().equals(""))
				align = "1";
			col.setWidth(Integer.parseInt(width));
			col.setAlign(Integer.parseInt(align));
			col.setRemark(split[j++]);
			this.cols.add(col);
		}

	}

	public String getSql()
	{
		return sql;
	}

	public void setSql(String sql)
	{
		this.sql = sql;
	}

	public String getManageComLimit()
	{
		return manageComLimit;
	}

	public void setManageComLimit(String manageComLimit)
	{
		this.manageComLimit = manageComLimit;
	}

	public int getButtonType()
	{
		return ButtonType;
	}

	public void setButtonType(int buttonType)
	{
		ButtonType = buttonType;
	}

	public Div getDiv()
	{
		return div;
	}

	public void setDiv(Div div)
	{
		this.div = div;
	}

}
