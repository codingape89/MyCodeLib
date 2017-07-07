package UnicodeClearBOM;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) throws Exception{
        List<String> pathList = getPerlineFileName("src/UnicodeClearBOM/test.txt");
        for(String path : pathList) {
            readContentAndSaveWithEncoding(path,"UTF-8","UTF-8");
        }
        System.out.println("成功");
    }

    private static void readContentAndSaveWithEncoding(String filePath,String readEncoding,String saveEncoding) throws Exception{
        saveContent(filePath,readContent(filePath,readEncoding),saveEncoding);
    }

    private static void saveContent(String filePath,String content,String encoding) throws Exception{
        FileOutputStream fos = new FileOutputStream(filePath);
        OutputStreamWriter w = new OutputStreamWriter(fos,encoding);
        w.write(content);
        w.flush();
    }

    private static String readContent(String filePath,String encoding) throws Exception{
        FileInputStream file = new FileInputStream(new File(filePath));
        BufferedReader br = new BufferedReader(new UnicodeReader(file, encoding));
        String line = null;
        String fileContent = "";
        while((line = br.readLine()) != null) {
            fileContent = fileContent + line;
            fileContent += "\r\n";
        }
        return fileContent;
    }

    private static List<String> getPerlineFileName(String filePath) throws Exception{
        FileInputStream file = new FileInputStream(new File(filePath));
        BufferedReader br = new BufferedReader(new InputStreamReader(file,"UTF-8"));
        String line = null;
        List<String> list = new ArrayList<String>();
        while((line = br.readLine()) != null) {
            list.add(line);
        }
        return list;
    }
} 