package FileHandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class Breader_and_Bwriter {
	public static void main(String[] args) throws IOException {
	     String Path1="C:\\IO Programs\\PalaceOfIllusions.txt";
	     String Path2="C:\\IO Programs\\POI_copied.txt"; 
	     FileReader fr=null;
	     FileWriter fw=null;
	     BufferedReader br = null;
	     BufferedWriter bw = null;
	     try {
	    	 fr=new FileReader(Path1);
	    	 br=new BufferedReader(fr);
	    	 int x;
	    	 fw=new FileWriter(Path2);
	    	 bw= new BufferedWriter(fw);
	    	 while((x=br.read())!=-1) {
	    		 bw.write(x);
	    	 }
	     }
	     finally {
	    	 br.close();
	    	 bw.close();
	    	fr.close();
	    	fw.close();
	     }
		}


}
