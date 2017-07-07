// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Input.java

package com.codegen.core.model;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.codegen.core.model:
//			Handler

public class Input
{

	public static int TYPE_COMMON = 1;
	public static int TYPE_DATE = 2;
	public static int TYPE_SELECT = 3;
	public static int TYPE_READONLY = 4;
	public static int TYPE_HIDDEN = 5;
	private String name;
	private String code;
	private int type;
	private String selectCode;
	private String selectField;
	private boolean readonly;
	private String schema;
	private String schemaField;
	private boolean necessary;
	private boolean hidden;
	private String defaultValue;
	private String dataType;
	private String len;
	private String val;
	private String remark;
	private List handlers;

	public Input()
	{
		handlers = new ArrayList();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public String getSelectCode()
	{
		return selectCode;
	}

	public void setSelectCode(String selectCode)
	{
		this.selectCode = selectCode;
	}

	public String getSelectField()
	{
		return selectField;
	}

	public void setSelectField(String selectField)
	{
		this.selectField = selectField;
	}

	public boolean isReadonly()
	{
		return readonly;
	}

	public void setReadonly(boolean readonly)
	{
		this.readonly = readonly;
	}

	public String getSchema()
	{
		return schema;
	}

	public void setSchema(String schema)
	{
		this.schema = schema;
	}

	public String getSchemaField()
	{
		return schemaField;
	}

	public void setSchemaField(String schemaField)
	{
		this.schemaField = schemaField;
	}

	public boolean isNecessary()
	{
		return necessary;
	}

	public void setNecessary(boolean necessary)
	{
		this.necessary = necessary;
	}

	public boolean isHidden()
	{
		return hidden;
	}

	public void setHidden(boolean hidden)
	{
		if (hidden)
			setType(TYPE_HIDDEN);
		this.hidden = hidden;
	}

	public String getDefaultValue()
	{
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue)
	{
		this.defaultValue = defaultValue;
	}

	public String getDataType()
	{
		return dataType;
	}

	public void setDataType(String dataType)
	{
		this.dataType = dataType;
	}

	public String getLen()
	{
		return len;
	}

	public void setLen(String len)
	{
		this.len = len;
	}

	public String getVal()
	{
		return val;
	}

	public void setVal(String val)
	{
		this.val = val;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public List getHandlers()
	{
		return handlers;
	}

	public void addHandler(Handler handler)
	{
		handlers.add(handler);
	}

}
