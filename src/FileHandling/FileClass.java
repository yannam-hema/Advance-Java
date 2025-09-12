package FileHandling;

import java.io.File;
import java.io.IOException;

public class FileClass {

	public static void main(String[] args) throws IOException {
		File f = new File("C:\\IO Programs\\newFile.txt");
		boolean b1=f.createNewFile(); // It creates a new file in the specifies location with that filename in the path
		                   //It Returns boolean 
		if(b1==true) {
			System.out.println("File created");
		}
		else {
			System.out.println("File Already exists");
		}
		System.out.println("--------------");
		b1=f.canExecute();//It returns true if file has the permission to execute
		System.out.println("Pemission to execute"+b1);
		System.out.println("................");
		b1=f.canRead();//It returns true if file has the permission to Read
		System.out.println("Pemission to read "+b1);
		System.out.println("................");
		b1=f.canWrite();//It returns true if file has the permission to Write
		System.out.println("Pemission to write "+b1);
		System.out.println("................");
//		boolean b2=f.delete(); //It deletes the File 
//		System.out.println("File deleted "+b2);
		
		f.deleteOnExit();// It deletes File After Our Program Terminates
		
		b1=f.exists();//Check Whether the File Exists
		System.out.println("File Exists "+b1);
		
		System.out.println("--------------");
		
		System.out.println(f.getAbsolutePath());// It gives the absolute Path of a File
		System.out.println(f.getCanonicalPath());//returns the canonical path of a File
		
		System.out.println(f.getFreeSpace());//Returns the free space available in the File in bits
		
		System.out.println(f.getTotalSpace());//Returns The total space of a File
		
		System.out.println(f.getName()); // Returns the name of the File
		
		System.out.println(f.getParent());//Returns the Parent Name of a File
		
		System.out.println(f.getPath());//Returns The Path of a File
		
		System.out.println(f.getUsableSpace());//Returns the usable space in bits 
		
		System.out.println(f.getClass());//Returns The class of a File class
		
		System.out.println(f.getAbsoluteFile());// It gives the absolute File Path 
		System.out.println(f.getCanonicalFile());//returns the canonical File path 
		
		System.out.println(f.hashCode());//Returns the HashCode of a File object
		
		System.out.println(f.isAbsolute());//Test the Path is Absolute
		
		System.out.println(f.isDirectory());//Check it is directory or not
		
		System.out.println(f.isFile());//Check It is A File or not
		
		System.out.println(f.isHidden());//Check Whether the File is Hidden or not
		
		File f2 = new File("C:\\IO Programs\\Book.txt");
		
		System.out.println(f2.isHidden());//Check Whether the File is Hidden or not
		
		System.out.println(f2.lastModified());//Returns Time of File Last Modified
		
		System.out.println(f2.length());//Return the Length of the File
		System.out.println(f2);
		
	}

}
