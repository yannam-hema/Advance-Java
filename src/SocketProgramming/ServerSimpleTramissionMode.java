package SocketProgramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// Two way communication
public class ServerSimpleTramissionMode {
public static void main(String[] args) throws IOException {
	ServerSocket listener = new ServerSocket(4000);
	Socket ssoc= listener.accept();
	System.out.println("Server is ready to accept the message :");
	InputStream is = ssoc.getInputStream();
	DataInputStream dis = new DataInputStream(is);
	String message=dis.readUTF();
	System.out.println("Message received from the server : "+message);
	System.out.println("--------------------");
	Scanner sc = new Scanner(System.in);
	System.out.println("please Enter reply ");
	message=sc.nextLine();
    OutputStream os = ssoc.getOutputStream();
    DataOutputStream dos = new DataOutputStream(os);
    dos.writeUTF(message);
	listener.close();
	sc.close();
}
}


