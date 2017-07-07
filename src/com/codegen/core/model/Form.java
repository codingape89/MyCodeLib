// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Form.java

package com.codegen.core.model;

import java.util.*;

// Referenced classes of package com.codegen.core.model:
//			Model, Div, Table, MulLine, 
//			OperationBar, Operation

public class Form
{

	public static String METHOD_GET = "get";
	public static String METHOD_POST = "post";
	private String name;
	private String action;
	private String method;
	private String target;
	private List divs;
	private Model model;

	public Form()
	{
		name = "fm";
		method = METHOD_GET;
		target = "fraSubmit";
		divs = new ArrayList();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAction()
	{
		return action == null ? (new StringBuilder(String.valueOf(model.getFileName()))).append("Save.jsp").toString() : action;
	}

	public void setAction(String action)
	{
		this.action = action;
	}

	public String getMethod()
	{
		return method;
	}

	public void setMethod(String method)
	{
		this.method = method;
	}

	public String getTarget()
	{
		return target;
	}

	public void setTarget(String target)
	{
		this.target = target;
	}

	public List getDivs()
	{
		return divs;
	}

	public void addDiv(Div div)
	{
		div.setForm(this);
		divs.add(div);
		if (div.getId() == null || div.getId().trim().equals(""))
			div.setId((new StringBuilder("div")).append(divs.size()).toString());
	}

	public Model getModel()
	{
		return model;
	}

	public void setModel(Model model)
	{
		this.model = model;
	}

	public List getTables()
	{
		List tables = new ArrayList();
		for (int i = 0; i < divs.size(); i++)
		{
			Div div = (Div)divs.get(i);
			for (Iterator iterator = div.getTables().iterator(); iterator.hasNext(); tables.add((Table)iterator.next()));
		}

		return tables;
	}

	public List getMulLines()
	{
		List mulLines = new ArrayList();
		for (int i = 0; i < divs.size(); i++)
		{
			Div div = (Div)divs.get(i);
			for (Iterator iterator = div.getMulLines().iterator(); iterator.hasNext(); mulLines.add((MulLine)iterator.next()));
		}

		return mulLines;
	}

	public List getOperationBars()
	{
		List operationBars = new ArrayList();
		for (int i = 0; i < divs.size(); i++)
		{
			Div div = (Div)divs.get(i);
			for (Iterator iterator = div.getOperationBars().iterator(); iterator.hasNext(); operationBars.add((OperationBar)iterator.next()));
		}

		return operationBars;
	}

	public List getOperations()
	{
		List operations = new ArrayList();
		for (Iterator iter = getOperationBars().iterator(); iter.hasNext();)
		{
			OperationBar operationBar = (OperationBar)iter.next();
			for (Iterator operationIter = operationBar.getOperations().iterator(); operationIter.hasNext(); operations.add((Operation)operationIter.next()));
		}

		return operations;
	}

}
