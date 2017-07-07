// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Logger.java

package com.codegen.shell;

import java.io.PrintStream;

public class Logger
{

	public Logger()
	{
	}

	public static void info(String msg, PrintStream out, PrintStream err)
	{
		StringBuffer sb = new StringBuffer();
		if (!msg.startsWith("#"))
			msg = (new StringBuilder("[INFO]")).append(msg).toString();
		out.println((new StringBuilder(String.valueOf(sb.toString()))).append(msg).toString());
		System.out.println((new StringBuilder(String.valueOf(sb.toString()))).append(msg).toString());
	}

	public static void warning(String msg, PrintStream out, PrintStream err)
	{
		msg = (new StringBuilder("[WARNING]")).append(msg).toString();
		out.println(msg);
		System.out.println(msg);
	}
}
