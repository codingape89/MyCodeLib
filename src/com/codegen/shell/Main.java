// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Main.java

package com.codegen.shell;

import com.codegen.core.model.*;
import java.io.*;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;
import jxl.*;
import jxl.write.WritableWorkbook;

// Referenced classes of package com.codegen.shell:
//			Logger, Config

public class Main{

	public boolean packaged;
	private static int TYPE_TABLE = 1;
	private static int TYPE_MULLINE = 2;
	private static int TYPE_OPERATION = 3;
	private String currContainer;
	private Set sheetNames;
	private static PrintStream out;
	private static PrintStream err;

	public Main()
	{
		packaged = true;
		sheetNames = new HashSet();
	}

	public static void main(String args[])
	{
		Main main  = new Main();
		main.init();
		Config config = main.getConfig();
		PrintStream psOut = null;
		PrintStream psErr = null;
		
//		main.gentrateExample(config);
		
		out = System.out;
		err = System.err;
		
		try{
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat((new StringBuilder("yyyy-MM-dd(")).append(date.getTime()).append(")").toString());
			String curr = df.format(date);
			File outFile = new File((new StringBuilder("./codegen/log/")).append(curr).append(".log").toString());
			File errFile = new File((new StringBuilder("./codegen/log/")).append(curr).append(".err").toString());
			outFile.createNewFile();
			errFile.createNewFile();
			psOut = new PrintStream(outFile);
			psErr = new PrintStream(errFile);
			System.setOut(psOut);
			System.setErr(psErr);
			main.start(config);
		}catch (Exception e){
			e.printStackTrace();
			err.println("####发生异常，请查看异常文件");
		}finally{
			System.setOut(out);
			System.setErr(err);
			if (psOut != null)
				psOut.close();
			if (psErr != null)
				psErr.close();
			out = null;
			err = null;
		}
	}

	private void start(Config config)
	{
		File containers[];
		File def = new File("codegen/def");
		containers = def.listFiles(new FileFilter() {
			public boolean accept(File pathname){
				return pathname.isDirectory();
			}
		});
		
		for (int i=0;i<containers.length;i++){
			File files[];
			File container = containers[i];
			currContainer = container.getName();
			Logger.info((new StringBuilder("扫描文件夹：")).append(currContainer).toString(), out, err);
			files = container.listFiles(new FileFilter() {
				public boolean accept(File pathname)
				{
					return pathname.isFile() && pathname.getName().toLowerCase().endsWith(".xls");
				}
			});

			for(int j=0;j<files.length;j++){

				File file;
				Workbook workbook;
				workbook = null;
				try{
					file = files[j];
					Logger.info((new StringBuilder("解析文件：")).append(file).toString(), out, err);
					workbook = Workbook.getWorkbook(file);
					if (workbook != null)
					Logger.warning((new StringBuilder("读取文件失败：")).append(file).toString(), out, err);
					Sheet sheet = workbook.getSheet(0);
					parseSheet(sheet, workbook, config, false);
					if (workbook != null)
						workbook.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
					err.println("####发生异常，请查看异常文件");
				}finally{
					if (workbook != null)
						workbook.close();
				}
			}
		}
	}

	private void parseSheet(Sheet sheet, Workbook workbook, Config config, boolean isSubSheet)
	{
		if (sheet == null)
			return;
		if (sheetNames.contains((new StringBuilder(String.valueOf(currContainer))).append(sheet.getName()).toString()))
			return;
		sheetNames.add((new StringBuilder(String.valueOf(currContainer))).append(sheet.getName()).toString());
		Logger.info((new StringBuilder("解析Sheet：")).append(sheet.getName()).toString(), out, err);
		int rows = sheet.getRows();
		Model model = new Model(sheet.getName(), currContainer);
		model.addParameter("config", config);
		Form currForm = null;
		Div currDiv = null;
		int currType = 0;
		StringBuffer args = new StringBuffer();
		List inits = new ArrayList();
		for (int i = 0; i < rows; i++)
		{
			String form = sheet.getCell(2, i).getContents();
			if (form != null && form.trim().equalsIgnoreCase("[Form名称]"))
			{
				cle(currDiv, currType, args, inits);
				String formName = sheet.getCell(2, i + 1).getContents();
				Logger.info((new StringBuilder("解析表单：")).append(formName).toString(), out, err);
				if (formName == null || formName.trim().equals(""))
					Logger.warning("表单名称为空", out, err);
				currForm = Model.createForm(formName);
				model.addForm(currForm);
				i++;
				continue;
			}
			String contents = sheet.getCell(0, i).getContents();
			if (contents != null && !contents.trim().equals(""))
			{
				if (currType != 0)
				{
					cle(currDiv, currType, args, inits);
					currType = 0;
					args = new StringBuffer();
					inits = new ArrayList();
				}
				Logger.info((new StringBuilder("解析Div：")).append(contents).toString(), out, err);
				if (currForm != null)
				{
					currDiv = Model.createDiv(contents.trim(), (new StringBuilder("div")).append(currForm.getDivs().size()).toString());
					currForm.addDiv(currDiv);
				} else
				{
					Logger.warning("Div出现在Form之前", out, err);
				}
				continue;
			}
			String c2 = sheet.getCell(2, i).getContents();
			String c3 = sheet.getCell(3, i).getContents();
			String c4 = sheet.getCell(4, i).getContents();
			if ("列数".equalsIgnoreCase(c2))
			{
				if (i + 2 < rows)
				{
					String cn2 = sheet.getCell(2, i + 2).getContents();
					String cn3 = sheet.getCell(3, i + 2).getContents();
					String cn4 = sheet.getCell(4, i + 2).getContents();
					if ("显示名称".equalsIgnoreCase(cn2) && "代码".equalsIgnoreCase(cn3) && "Schema".equalsIgnoreCase(cn4))
					{
						cle(currDiv, currType, args, inits);
						currType = TYPE_TABLE;
						args = new StringBuffer();
						inits = new ArrayList();
						String colContents = sheet.getCell(2, i + 1).getContents();
						if (colContents == null || colContents.trim().equals(""))
							colContents = "2";
						args.append(colContents);
						i += 2;
						continue;
					}
				}
			} else
			{
				if ("ID".equalsIgnoreCase(c2) && "是否需要提交".equalsIgnoreCase(c3) && "增加按钮".equalsIgnoreCase(c4))
				{
					cle(currDiv, currType, args, inits);
					currType = TYPE_MULLINE;
					args = new StringBuffer("@");
					inits = new ArrayList();
					for (int m = 2; m <= 16; m++)
					{
						String colContents = sheet.getCell(m, i + 1).getContents();
						if (m == 3)
						{
							if (colContents != null && colContents.trim().equals("是"))
								colContents = "Y";
							else
								colContents = "N";
						} else if (m == 4)
						{
							if (colContents != null && colContents.trim().equals("显示"))
								colContents = "Y";
							else
								colContents = "N";
						} else if (m == 5)
						{
							if (colContents != null && colContents.trim().equals("显示"))
								colContents = "Y";
							else
								colContents = "N";
						} else if (m == 6)
						{
							if (colContents != null && colContents.trim().equals("显示"))
								colContents = "Y";
							else
								colContents = "N";
						} else if (m == 7)
						{
							if (colContents != null)
							{
								if (colContents.trim().equals("单选"))
									colContents = "S";
								else
								if (colContents.trim().equals("多选"))
									colContents = "C";
								else
									colContents = "";
							} else
							{
								colContents = "";
							}
						} else if (m == 15)
							if (colContents != null)
							{
								if (colContents.trim().equals("不显示翻页和导出"))
									colContents = String.valueOf(MulLine.BUTTONTYPE_NONE);
								else
								if (colContents.trim().equals("显示翻页不显示导出"))
									colContents = String.valueOf(MulLine.BUTTONTYPE_PAGE_ONLY);
								else
								if (colContents.trim().equals("显示导出不显示翻页"))
									colContents = String.valueOf(MulLine.BUTTONTYPE_EXPORT_ONLY);
								else
									colContents = String.valueOf(MulLine.BUTTONTYPE_ALL);
							} else
							{
								colContents = "";
							}
						args.append("^").append(colContents);
					}

					args.append("^@");
					i += 2;
					continue;
				}
				if ("对齐方式".equalsIgnoreCase(c2) && i + 2 < rows)
				{
					String cn3 = sheet.getCell(3, i + 2).getContents();
					if ("代码".equalsIgnoreCase(cn3.trim()))
					{
						cle(currDiv, currType, args, inits);
						currType = TYPE_OPERATION;
						args = new StringBuffer();
						inits = new ArrayList();
						String colContents = sheet.getCell(2, i + 1).getContents();
						if (colContents != null && colContents.trim().equals("右对齐"))
							colContents = "2";
						else
							colContents = "1";
						args.append(colContents);
						i += 2;
						continue;
					}
				}
			}
			if (c2 != null && !c2.trim().equals("") || c3 != null && !c3.trim().equals(""))
				setupInits(sheet, i, currType, inits, workbook, config);
		}

		cle(currDiv, currType, args, inits);
		File container = new File((new StringBuilder("codegen/code/ui/")).append(currContainer).toString());
		File container2 = new File((new StringBuilder("codegen/code/src/com/sinosoft/lis/")).append(currContainer).toString());
		container.mkdirs();
		container2.mkdirs();
		String directory = (new StringBuilder("codegen/code/ui/")).append(currContainer).toString();
		String directory2 = (new StringBuilder("codegen/code/src/com/sinosoft/lis/")).append(currContainer).toString();
		if (isSubSheet)
			write(config.getHtmlclass(), model, directory, ".jsp", config);
		write(config.getInputClass(), model, directory, "Input.jsp", config);
		write(config.getInitClass(), model, directory, "Init.jsp", config);
		write(config.getInputjsClass(), model, directory, "Input.js", config);
		if (config.isGeneratConfig())
			write(config.getConfigclass(), model, directory, "Config.jsp", config);
		Iterator iter = model.getForms().iterator();
		boolean needSubmit;
		for (needSubmit = false; iter.hasNext() && !needSubmit;)
		{
			Form form = (Form)iter.next();
			for (Iterator operations = form.getOperations().iterator(); operations.hasNext() && !needSubmit;)
			{
				Operation oper = (Operation)operations.next();
				if (oper.getType() == Operation.TYPE_SUBMIT || oper.getType() == Operation.TYPE_REPORT)
					needSubmit = true;
			}

		}

		if (needSubmit)
		{
			write(config.getSaveClass(), model, directory, "Save.jsp", config);
			write(config.getUiClass(), model, directory2, "UI.java", config);
			write(config.getBlClass(), model, directory2, "BL.java", config);
		}
		Logger.info((new StringBuilder("Sheet")).append(sheet.getName()).append("解析完成").toString(), out, err);
	}

	private void write(String className, Model model, String directory, String endStr, Config config)
	{
		String result;
		String fileName;
		BufferedWriter writer;
		result = "";
		try
		{
			Object instance = Class.forName(className).newInstance();
			Method method = instance.getClass().getMethod("generate", new Class[] {java.lang.Object.class});
			result = (String)method.invoke(instance, new Object[] {model});
		}
		catch (Exception e)
		{
			e.printStackTrace();
			err.println("####发生异常，请查看异常文件");
		}

		fileName = (new StringBuilder(String.valueOf(directory))).append("/").append(model.getFileName()).append(endStr).toString();
		writer = null;
		try{
			File tmpFile = new File(fileName);
			if (tmpFile.exists() && tmpFile.isFile())
				Logger.warning((new StringBuilder("覆盖文件：")).append(tmpFile.getAbsolutePath()).toString(), out, err);
			else
				Logger.info((new StringBuilder("生成文件：")).append(tmpFile.getAbsolutePath()).toString(), out, err);
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tmpFile), config.getPageEncoding()));
			writer.write(result);
		}catch(Exception e){
			e.printStackTrace();
			err.println("####发生异常，请查看异常文件");
		}finally{
			if (writer != null)
				try{writer.close();}catch (Exception exception1) { exception1.printStackTrace();}
		}
	}

	private void setupInits(Sheet sheet, int rowNum, int currType, List inits, Workbook workbook, Config config)
	{
		if (currType == TYPE_TABLE)
		{
			StringBuffer init = new StringBuffer("#");
			for (int m = 2; m <= 15; m++)
			{
				String col = sheet.getCell(m, rowNum).getContents();
				if (m == 6)
				{
					if (col != null && col.trim().equals("日期"))
						col = String.valueOf(Input.TYPE_DATE);
					else
					if (col != null && col.trim().equals("双击下拉"))
						col = String.valueOf(Input.TYPE_SELECT);
					else
					if (col != null && col.trim().equals("只读"))
						col = String.valueOf(Input.TYPE_READONLY);
					else
						col = String.valueOf(Input.TYPE_COMMON);
				} else
				if (m == 9)
				{
					if (col != null && col.trim().equals("是"))
						col = "Y";
					else
						col = "N";
				} else
				if (m == 10)
					if (col != null && col.trim().equals("是"))
						col = "Y";
					else
						col = "N";
				init.append("^").append(col);
			}

			init.append("^#");
			inits.add(init.toString());
		} else
		if (currType == TYPE_MULLINE)
		{
			StringBuffer init = new StringBuffer("$");
			for (int m = 2; m <= 15; m++)
			{
				String col = sheet.getCell(m, rowNum).getContents();
				if (m == 6)
				{
					if (col != null && col.trim().equals("一般录入"))
						col = String.valueOf(MulLineCol.TYPE_WRITEABLE);
					else
					if (col != null && col.trim().equals("双击下拉"))
						col = String.valueOf(MulLineCol.TYPE_SELECT);
					else
						col = String.valueOf(MulLineCol.TYPE_READONLY);
				} else
				if (m == 9)
				{
					if (col != null && col.trim().equals("是"))
						col = "Y";
					else
						col = "N";
				} else
				if (m == 12)
				{
					if (col != null && col.trim().equals("包含"))
						col = String.valueOf(MulLineCol.LIKE_KIND_CONTAINS);
					else
					if (col != null && col.trim().equals("结束于"))
						col = String.valueOf(MulLineCol.LIKE_KIND_ENDWITH);
					else
						col = String.valueOf(MulLineCol.LIKE_KIND_STARTWITH);
				} else
				if (m == 14)
					if (col != null && col.trim().equals("右对齐"))
						col = String.valueOf(MulLineCol.ALIGN_RIGHT);
					else
					if (col != null && col.trim().equals("居中"))
						col = String.valueOf(MulLineCol.ALIGN_CENTER);
					else
						col = String.valueOf(MulLineCol.ALIGN_LEFT);
				init.append("^").append(col);
			}

			init.append("^$");
			inits.add(init.toString());
		} else
		if (currType == TYPE_OPERATION)
		{
			StringBuffer init = new StringBuffer("!");
			for (int m = 2; m <= 7; m++)
			{
				String col = sheet.getCell(m, rowNum).getContents();
				if (m == 5)
					if (col != null && col.trim().equals("查询"))
						col = String.valueOf(Operation.TYPE_QUERY);
					else
					if (col != null && col.trim().equals("打印报表"))
						col = String.valueOf(Operation.TYPE_REPORT);
					else
					if (col != null && col.trim().equalsIgnoreCase("提交Form"))
						col = String.valueOf(Operation.TYPE_SUBMIT);
					else
					if (col != null && col.trim().equalsIgnoreCase("打开新窗口"))
						col = String.valueOf(Operation.TYPE_OPEN);
					else
					if (col != null && col.trim().equalsIgnoreCase("reset"))
						col = String.valueOf(Operation.TYPE_RESET);
					else
					if (col != null && col.trim().equalsIgnoreCase("返回父窗口"))
						col = String.valueOf(Operation.TYPE_RETURN);
					else
						col = String.valueOf(Operation.TYPE_OTHER);
				init.append("^").append(col);
			}

			init.append("^!");
			inits.add(init.toString());
			String url = sheet.getCell(6, rowNum).getContents();
			if (url != null && !url.trim().equals(""))
			{
				Sheet childSheet = workbook.getSheet(url);
				parseSheet(childSheet, workbook, config, true);
			}
		}
	}

	private void cle(Div currDiv, int currType, StringBuffer args, List inits)
	{
		if (inits.size() == 0)
			return;
		String initsArr[] = new String[inits.size()];
		inits.toArray(initsArr);
		if (currType == TYPE_TABLE)
		{
			Table table = Model.createTable(initsArr, 2);
			table.setColNum(Integer.parseInt(args.toString()));
			if (currDiv != null)
			{
				currDiv.addTable(table);
				Logger.info((new StringBuilder("解析Table：")).append(table.getName()).toString(), out, err);
			} else
			{
				Logger.warning("Table出现在Div之前", out, err);
			}
		} else
		if (currType == TYPE_MULLINE)
		{
			MulLine mulLine = Model.createMulLine(args.toString(), initsArr);
			if (currDiv != null)
			{
				Logger.info("解析MulLine", out, err);
				currDiv.addMulLine(mulLine);
			} else
			{
				Logger.warning("MulLine出现在Div之前", out, err);
			}
		} else
		if (currType == TYPE_OPERATION)
		{
			com.codegen.core.model.OperationBar operationBar = Model.createOperationBar(Integer.parseInt(args.toString()), initsArr);
			if (currDiv != null)
			{
				Logger.info("解析操作", out, err);
				currDiv.addOperationBar(operationBar);
			} else
			{
				Logger.warning("Operation出现在Div之前", out, err);
			}
		}
	}

	private void init()
	{
		File code = new File("codegen/code");
		code.mkdirs();
		File log = new File("codegen/log");
		log.mkdirs();
		File def = new File("codegen/def");
		def.mkdirs();
	}

	private static void copy(File sourceFile, File targetFile)
	{
		File tarpath;
		InputStream is;
		OutputStream os;
		tarpath = new File(targetFile, sourceFile.getName());
		if (sourceFile.isDirectory())
		{
			tarpath.mkdir();
			File dir[] = sourceFile.listFiles();
			for (int i = 0; i < dir.length; i++)
				copy(dir[i], tarpath);
		}
		is = null;
		os = null;
		
		try{
			is = new FileInputStream(sourceFile);
			os = new FileOutputStream(tarpath);
			for (byte buf[] = new byte[1024]; is.read(buf) != -1; os.write(buf));
			is.close();
			os.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (is != null)try{is.close();}catch (Exception e) { e.printStackTrace();}
			if (os != null)try{os.close();}catch (Exception e) { e.printStackTrace();}
		}
	}

	private Config getConfig()
	{
		Config config;
		File init;
		BufferedReader reader;
		config = new Config();
		init = new File("codegen/codegen.ini");
		if (!init.exists() || !init.isFile()){
			return null;
		}
		reader = null;
		try
		{
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(init)));
			String line;
			while ((line = reader.readLine()) != null) 
			{
				String str = line.trim();
				if (!str.startsWith("#"))
				{
					String split[] = str.split("=");
					if (split.length == 2)
					{
						String val = split[1] == null ? "" : split[1].trim();
						if (Config.INPUT_CLASS.equals(split[0]))
							config.setInputClass(val);
						else if (Config.INPUTJS_CLASS.equals(split[0]))
							config.setInputjsClass(val);
						else if (Config.INIT_CLASS.equals(split[0]))
							config.setInitClass(val);
						else if (Config.SAVE_CLASS.equals(split[0]))
							config.setSaveClass(val);
						else if (Config.UI_CLASS.equals(split[0]))
							config.setUiClass(val);
						else if (Config.BL_CLASS.equals(split[0]))
							config.setBlClass(val);
						else if (Config.HTML_CLASS.equals(split[0]))
							config.setHtmlclass(val);
						else if (Config.GENERATE_EXAMPLE.equals(split[0]))
							config.setGenerateExample("true".equalsIgnoreCase(val));
						else if (Config.CONFIG_CLASS.equals(split[0]))
							config.setConfigclass(val);
						else if (Config.GENERATE_CONFIG.equals(split[0]))
							config.setGeneratConfig("true".equalsIgnoreCase(val));
						else if (Config.PAGE_ENCODING.equals(split[0]))
							config.setPageEncoding(val);
						else if (Config.CHARSET.equals(split[0]))
							config.setCharset(val);
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			err.println("####发生异常，请查看异常文件");
		}finally{
			if (reader != null)try{reader.close();}catch (IOException e){e.printStackTrace();}
		}
		
		PrintStream printer = null;
		try
		{
			init.createNewFile();
			printer = new PrintStream(init);
			printer.println((new StringBuilder(String.valueOf(Config.INPUT_CLASS))).append("=").append(config.getInputClass()).toString());
			printer.println((new StringBuilder(String.valueOf(Config.INPUTJS_CLASS))).append("=").append(config.getInputjsClass()).toString());
			printer.println((new StringBuilder(String.valueOf(Config.INIT_CLASS))).append("=").append(config.getInitClass()).toString());
			printer.println((new StringBuilder(String.valueOf(Config.SAVE_CLASS))).append("=").append(config.getSaveClass()).toString());
			printer.println((new StringBuilder(String.valueOf(Config.UI_CLASS))).append("=").append(config.getUiClass()).toString());
			printer.println((new StringBuilder(String.valueOf(Config.BL_CLASS))).append("=").append(config.getBlClass()).toString());
			printer.println((new StringBuilder(String.valueOf(Config.HTML_CLASS))).append("=").append(config.getHtmlclass()).toString());
			printer.println((new StringBuilder(String.valueOf(Config.CONFIG_CLASS))).append("=").append(config.getConfigclass()).toString());
			printer.println((new StringBuilder(String.valueOf(Config.GENERATE_EXAMPLE))).append("=false").toString());
			printer.println((new StringBuilder(String.valueOf(Config.GENERATE_CONFIG))).append("=").append(config.isGeneratConfig()).toString());
			printer.println((new StringBuilder(String.valueOf(Config.PAGE_ENCODING))).append("=").append(config.getPageEncoding()).toString());
			printer.println((new StringBuilder(String.valueOf(Config.CHARSET))).append("=").append(config.getCharset()).toString());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			err.println("####发生异常，请查看异常文件");
		}finally{
			if (printer != null)try{printer.close();}catch (Exception e){e.printStackTrace();}
		}
		
		return config;
	}

	private void gentrateExample(Config config)
	{
		File defFun;
		InputStream in;
		Workbook workbookin;
		WritableWorkbook workbookout;
		if (!packaged)
			return;
		File toFile = new File("codegen/template");
		toFile.mkdir();
		defFun = new File("codegen/template/功能定义.xls");
		if (defFun.exists()){
			return;
		}
		in = null;
		workbookin = null;
		workbookout = null;
		try
		{
			in = getClass().getResourceAsStream("/resource/template/template.xls");
			workbookin = Workbook.getWorkbook(in);
			workbookout = Workbook.createWorkbook(defFun, workbookin);
			workbookout.write();
			workbookout.close();
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}finally{
			if (in != null)try{in.close();}catch (IOException e){e.printStackTrace();}
			if (workbookin != null)try{workbookin.close();}catch (Exception e){e.printStackTrace();}
			if (workbookout != null)try{workbookout.close();}catch (Exception e){e.printStackTrace();}
		}

		File example;
		FileOutputStream out;
		if (!config.isGenerateExample())
			return;
		File efilder = new File("codegen/def/example");
		efilder.mkdir();
		example = new File("codegen/def/example/人员信息维护.xls");
		if (example.exists()){
			return;
		}
		in = null;
		out = null;
		try
		{
			in = getClass().getResourceAsStream("/resource/example/agent.xls");
			out = new FileOutputStream(example);
			for (byte buf[] = new byte[1024]; in.read(buf) != -1; out.write(buf));
			out.flush();
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}finally{
			if (in != null)try{in.close();}catch (Exception e){e.printStackTrace();}
			if (out != null)try{out.close();}catch (Exception e){e.printStackTrace();}
		}
	}

}
