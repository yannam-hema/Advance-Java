package FileHandling;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BInputStream_And_BOutputStream {
	public static void main(String[] args) throws IOException {
	     String Path1="C:\\IO Programs\\Book.txt";
	     String Path2="C:\\IO Programs\\CopiedBook.txt"; 
	     FileInputStream fis=null;
	     FileOutputStream fos=null;
	     BufferedInputStream bis=null;
	     BufferedOutputStream bos=null;
	     try {
	    	 fis=new FileInputStream(Path1);
	    	 bis=new BufferedInputStream(fis);
	    	 int x;
	    	 fos=new FileOutputStream(Path2);
	    	 bos = new BufferedOutputStream(fos);
	    	 while((x=bis.read())!=-1) {
	    		 bos.write(x);
	    	 }
	     }
	     finally {
	    	 bis.close();
	    	 bos.close();
	    	fis.close();
	    	fos.close();
	     }
		}
}
