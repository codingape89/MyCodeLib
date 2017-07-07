import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;


public class CombineFile {
	
	public boolean doCombine(String filePath,String combinePath){
		ArrayList fileArray=new ArrayList();

		File ftmp = new File(filePath);
        if (!ftmp.exists()) {
            return false;  
        }
        if (ftmp.isFile()){
        	filePath= filePath.replace('\\', '/');
        	fileArray.add(filePath);
        }else{
            File[] childFiles = ftmp.listFiles();  
            for (int i = 0, n = childFiles.length; i < n; i++) {  
                File child = childFiles[i];  
                String childFrom = filePath + "/" + child.getName();  
                ftmp = new File(childFrom);
                if (ftmp.isFile()){
                	childFrom= childFrom.replace('\\', '/');
                	fileArray.add(childFrom);
                }
            }
        }
        
        try{
        	combinePath= combinePath.replace('\\', '/');
        	File ftmp1 = new File(combinePath);
        	if(!ftmp1.exists()){
	        	ftmp1.createNewFile();
	        }
            File file;
            InputStream is=null;
            OutputStream os=new FileOutputStream(combinePath);
        	for(int i=0;i<fileArray.size();i++){
        	    String tPath = (String)fileArray.get(i);
        	    System.out.println(tPath);
                System.out.println(tPath.lastIndexOf("/"));
                System.out.println(tPath.length());
                System.out.println(tPath.substring(tPath.lastIndexOf("/")+1, tPath.length()));
        	    String tFileName = tPath.substring(tPath.lastIndexOf("/")+1, tPath.length());
                os.write(("--------------------------------"+tFileName+"----Start-------------------------------").getBytes());
                os.write("\r\n".getBytes());
                is=new FileInputStream(String.valueOf(fileArray.get(i)));
                int len=0;
                while((len=is.read())!=-1)
                {
               	 os.write(len);
                }
                os.write("\r\n".getBytes());
                os.write(("--------------------------------"+tFileName+"----End-------------------------------").getBytes());
                os.write("\r\n".getBytes());
                os.write("\r\n".getBytes());
                os.write("\r\n".getBytes());
                os.write("\r\n".getBytes());
                os.write("\r\n".getBytes());
        	}
        }catch(Exception e){
        	e.printStackTrace();
        }

        return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CombineFile cf=new CombineFile();
		String fromPath="F:\\Workspace_Eclipse\\MetLifeHK_CMS_DEV\\sql\\BS20161201_PersistencyEnhancement";
		String toPath="F:\\Workspace_Eclipse\\MetLifeHK_CMS_DEV\\sql\\Combine.sql";
		cf.doCombine(fromPath, toPath);

	}

}
