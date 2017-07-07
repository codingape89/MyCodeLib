// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Operation.java

package com.codegen.core.model;


// Referenced classes of package com.codegen.core.model:
//			OperationBar

public class Operation
{

	public static int TYPE_QUERY = 1;
	public static int TYPE_REPORT = 2;
	public static int TYPE_SUBMIT = 3;
	public static int TYPE_OPEN = 4;
	public static int TYPE_RESET = 5;
	public static int TYPE_RETURN = 6;
	public static int TYPE_OTHER = 7;
	private String name;
	private String value;
	private String method;
	private int type;
	private String url;
	private String remark;
	private OperationBar operationBar;

	public Operation()
	{
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public String getMethod()
	{
		return method;
	}

	public void setMethod(String method)
	{
		this.method = method;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public OperationBar getOperationBar()
	{
		return operationBar;
	}

	public void setOperationBar(OperationBar operationBar)
	{
		this.operationBar = operationBar;
	}

}
