// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   OperationBar.java

package com.codegen.core.model;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.codegen.core.model:
//			Operation, Div

public class OperationBar
{

	public static int FLOAT_LEFT = 1;
	public static int FLOAT_RIGHT = 2;
	private int cssFloat;
	private List operations;
	private Div div;

	public OperationBar()
	{
		cssFloat = FLOAT_LEFT;
		operations = new ArrayList();
	}

	public int getCssFloat()
	{
		return cssFloat;
	}

	public void setCssFloat(int cssFloat)
	{
		this.cssFloat = cssFloat;
	}

	public List getOperations()
	{
		return operations;
	}

	public void addOperations(Operation operation)
	{
		operations.add(operation);
	}

	public boolean init(String operations[], String regex)
	{
		if (regex == null || regex.trim().equals(""))
			regex = "\\^";
		for (int i = 0; i < operations.length; i++)
		{
			Operation o = new Operation();
			int j = 1;
			String split[] = operations[i].split(regex);
			o.setValue(split[j++]);
			String name = split[j++];
			String method = split[j++];
			o.setName(name);
			o.setMethod(method);
			o.setType(Integer.parseInt(split[j++]));
			o.setUrl(split[j++]);
			o.setRemark(split[j++]);
			o.setOperationBar(this);
			this.operations.add(o);
		}

		return true;
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
