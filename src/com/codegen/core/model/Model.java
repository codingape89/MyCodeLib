// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Model.java

package com.codegen.core.model;

import java.util.*;

// Referenced classes of package com.codegen.core.model:
//			Form, Div, Table, MulLine, 
//			OperationBar

public class Model
{

	private String fileName;
	private String container;
	private String menuName;
	private List forms;
	private Map parameters;

	public String getFileName()
	{
		return fileName;
	}

	public Model(String fileName, String container)
	{
		forms = new ArrayList();
		parameters = new HashMap();
		this.fileName = fileName;
		this.container = container;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public String getMenuName()
	{
		return menuName;
	}

	public void setMenuName(String menuName)
	{
		this.menuName = menuName;
	}

	public String getContainer()
	{
		return container;
	}

	public void setContainer(String container)
	{
		this.container = container;
	}

	public List getForms()
	{
		return forms;
	}

	public void addForm(Form form)
	{
		form.setModel(this);
		forms.add(form);
	}

	public static Form createForm(String name)
	{
		Form form = new Form();
		form.setName(name);
		return form;
	}

	public static Div createDiv(String name)
	{
		Div div = new Div();
		div.setId(null);
		div.setName(name);
		return div;
	}

	public static Div createDiv(String name, String id)
	{
		Div div = new Div();
		div.setId(id);
		div.setName(name);
		return div;
	}

	public static Table createTable(String inputs[], int colNum)
	{
		Table table = new Table();
		table.setColNum(colNum);
		table.setName(null);
		table.initInputs(inputs, null);
		return table;
	}

	public static Table createTable(String name, String inputs[], int colNum)
	{
		Table table = new Table();
		table.setColNum(colNum);
		table.setName(name);
		table.initInputs(inputs, null);
		return table;
	}

	public static MulLine createMulLine(String args, String cols[])
	{
		return createMulLine(args, null, cols, null);
	}

	public static MulLine createMulLine(String args, String regex1, String cols[], String regex2)
	{
		MulLine mulLine = new MulLine();
		mulLine.init(args, regex1);
		mulLine.initCols(cols, regex2);
		return mulLine;
	}

	public static OperationBar createOperationBar(int cssFloat, String operations[])
	{
		OperationBar o = new OperationBar();
		o.setCssFloat(cssFloat);
		o.init(operations, null);
		return o;
	}

	public static OperationBar createOperationBar(int cssFloat, String operations[], String regex)
	{
		OperationBar o = new OperationBar();
		o.setCssFloat(cssFloat);
		o.init(operations, regex);
		return o;
	}

	public Object addParameter(String name, Object value)
	{
		return parameters.put(name, value);
	}

	public Object getParameter(String name)
	{
		return parameters.get(name);
	}
}
