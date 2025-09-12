package FileHandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamAndFileOutputStream {

	public static void main(String[] args) throws IOException {
     String Path1="C:\\IO Programs\\File1.txt";
     String Path2="C:\\IO Programs\\File2.txt"; 
     FileInputStream fis=null;
     FileOutputStream fos=null;
     try {
    	 fis=new FileInputStream(Path1);
    	 int x;
    	 fos=new FileOutputStream(Path2);
    	 
    	 while((x=fis.read())!=-1) {
    		 fos.write(x);
    	 }
     }
     finally {
    	fis.close();
    	fos.close();
     }
	}

}
