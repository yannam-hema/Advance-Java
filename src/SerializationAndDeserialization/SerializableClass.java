package SerializationAndDeserialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializableClass {
public static void main(String[] args) throws IOException {
	Cricketer c1 = new Cricketer("Hardik", "INDIA", 200, 120);
	System.out.println(c1);
	String path="C:\\IO Programs\\Cricketer_SZ.txt";
	FileOutputStream fos = new FileOutputStream(path);
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(c1);
	System.out.println("Object is serialized");
}
}
