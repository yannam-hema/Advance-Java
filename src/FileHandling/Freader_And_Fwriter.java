package FileHandling;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Freader_And_Fwriter {
	public static void main(String[] args) throws IOException {
	     String Path1="C:\\IO Programs\\File1.txt";
	     String Path2="C:\\IO Programs\\File3.txt"; 
	     FileReader fr=null;
	     FileWriter fw=null;
	     try {
	    	 fr=new FileReader(Path1);
	    	 int x;
	    	 fw=new FileWriter(Path2);
	    	 
	    	 while((x=fr.read())!=-1) {
	    		 fw.write(x);
	    	 }
	     }
	     finally {
	    	fr.close();
	    	fw.close();
	     }
		}

}
