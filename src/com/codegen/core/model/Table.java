// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Table.java

package com.codegen.core.model;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.codegen.core.model:
//			Input

public class Table
{

	private String name;
	private int colNum;
	private List inputs;

	public Table()
	{
		inputs = new ArrayList();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getColNum()
	{
		return colNum;
	}

	public void setColNum(int colNum)
	{
		if (colNum > 0)
			this.colNum = colNum;
	}

	public List getInputs()
	{
		return inputs;
	}

	public void initInputs(String inputs[], String regex)
	{
		if (regex == null || regex.trim().equals(""))
			regex = "\\^";
		for (int i = 0; i < inputs.length; i++)
		{
			String split[] = inputs[i].split(regex);
			int j = 1;
			Input input = new Input();
			input.setName(split[j++]);
			input.setCode(split[j++]);
			input.setSchema(split[j++]);
			input.setSchemaField(split[j++]);
			String type = split[j++];
			if (type == null || type.trim().equals(""))
				type = String.valueOf(Input.TYPE_COMMON);
			input.setType(Integer.parseInt(type));
			input.setSelectCode(split[j++]);
			input.setSelectField(split[j++]);
			input.setNecessary("Y".equalsIgnoreCase(split[j++]));
			input.setHidden("Y".equalsIgnoreCase(split[j++]));
			input.setDefaultValue(split[j++]);
			input.setDataType(split[j++]);
			input.setLen(split[j++]);
			input.setVal(split[j++]);
			input.setRemark(split[j++]);
			this.inputs.add(input);
		}

	}
}
