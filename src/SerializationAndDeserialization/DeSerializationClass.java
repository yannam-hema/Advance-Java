package SerializationAndDeserialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializationClass {
public static void main(String[] args) throws IOException, ClassNotFoundException {
	String path ="C:\\IO Programs\\Cricketer_SZ.txt";
	FileInputStream fis = new FileInputStream(path);
	ObjectInputStream ois = new ObjectInputStream(fis);
	Cricketer c2 =(Cricketer)ois.readObject();
	System.out.println(c2);
	
}
}
