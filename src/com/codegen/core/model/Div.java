// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Div.java

package com.codegen.core.model;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.codegen.core.model:
//			Table, MulLine, OperationBar, Form

public class Div
{

	private String id;
	private String name;
	private List tables;
	private List mulLines;
	private List operationBars;
	private boolean displayTitle;
	private List children;
	private Form form;

	public Div()
	{
		tables = new ArrayList();
		mulLines = new ArrayList();
		operationBars = new ArrayList();
		displayTitle = true;
		children = new ArrayList();
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
		if (id == null || id.trim().equals(""))
			setDisplayTitle(false);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
		if (name == null || name.trim().equals(""))
			setDisplayTitle(false);
	}

	public List getTables()
	{
		return tables;
	}

	public void addTable(Table table)
	{
		tables.add(table);
		if (table.getName() == null || table.getName().trim().equals(""))
			table.setName((new StringBuilder("table")).append(tables.size()).toString());
		children.add(table);
	}

	public List getMulLines()
	{
		return mulLines;
	}

	public void addMulLine(MulLine mulLine)
	{
		mulLine.setDiv(this);
		mulLines.add(mulLine);
		children.add(mulLine);
	}

	public List getOperationBars()
	{
		return operationBars;
	}

	public void addOperationBar(OperationBar operationBar)
	{
		setDisplayTitle(false);
		operationBars.add(operationBar);
		children.add(operationBar);
		operationBar.setDiv(this);
	}

	public boolean isDisplayTitle()
	{
		return displayTitle;
	}

	public void setDisplayTitle(boolean displayTitle)
	{
		this.displayTitle = displayTitle;
	}

	public List getChildren()
	{
		return children;
	}

	public Form getForm()
	{
		return form;
	}

	public void setForm(Form form)
	{
		this.form = form;
	}
}
