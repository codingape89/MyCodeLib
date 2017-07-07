// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   MulLineCol.java

package com.codegen.core.model;


public class MulLineCol
{

	public static int ALIGN_LEFT = 1;
	public static int ALIGN_CENTER = 2;
	public static int ALIGN_RIGHT = 3;
	public static int TYPE_READONLY = 0;
	public static int TYPE_WRITEABLE = 1;
	public static int TYPE_SELECT = 2;
	public static int LIKE_KIND_STARTWITH = 1;
	public static int LIKE_KIND_ENDWITH = 2;
	public static int LIKE_KIND_CONTAINS = 3;
	private String name;
	private String code;
	private String dbCode;
	private String schema;
	private String schemaField;
	private boolean hidden;
	private String operation;
	private String likeKind;
	private int type;
	private String selectCode;
	private int selectCodeNameIndex;
	private int width;
	private int align;
	private String remark;

	public MulLineCol()
	{
		type = -1;
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

	public String getDbCode()
	{
		return dbCode;
	}

	public void setDbCode(String dbCode)
	{
		this.dbCode = dbCode;
	}

	public String getOperation()
	{
		return operation;
	}

	public void setOperation(String operation)
	{
		this.operation = operation;
	}

	public int getAlign()
	{
		return align;
	}

	public void setAlign(int align)
	{
		this.align = align;
	}

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
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

	public int getSelectCodeNameIndex()
	{
		return selectCodeNameIndex;
	}

	public void setSelectCodeNameIndex(int selectCodeNameIndex)
	{
		this.selectCodeNameIndex = selectCodeNameIndex;
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

	public boolean isHidden()
	{
		return hidden;
	}

	public void setHidden(boolean hidden)
	{
		this.hidden = hidden;
		if (hidden)
			setType(3);
	}

	public String getLikeKind()
	{
		return likeKind;
	}

	public void setLikeKind(String likeKind)
	{
		this.likeKind = likeKind;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

}
