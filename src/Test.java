import java.io.File;

public class Test {

	public static void main(String[] args){
//		String fromPath = "C:\\Users\\Eleven\\Desktop\\6.1规则引擎打包\\ui\\rulelibrary\\ImpBaseFr.jsp";
		String fromPath = "F:\\EProject\\CMS_ChinaLife_Dev\\ui\\acc\\AccountPriceInit.jsp";
        File ftmp = new File(fromPath);  
		GetCharSet t=new GetCharSet();
		System.out.println(t.getCharset(ftmp));
	}
}
