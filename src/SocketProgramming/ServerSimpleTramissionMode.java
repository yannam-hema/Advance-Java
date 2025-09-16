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

// CLIENT code should be in other work space to see the results

//package Networking;
//
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.Socket;
//import java.net.UnknownHostException;
//import java.util.Scanner;
//
//public class ClientCode {
//public static void main(String[] args) throws UnknownHostException, IOException {
//	Socket csoc = new Socket("192.168.110.188",4000);
//	OutputStream os = csoc.getOutputStream();
//	DataOutputStream dos = new DataOutputStream(os);
//	Scanner sc = new Scanner(System.in);
//	System.out.println("Enter the message ");
//	String msg = sc.nextLine();
//	dos.writeUTF(msg);
//	System.out.println("---------------");
//	InputStream is = csoc.getInputStream();
//	DataInputStream dis = new DataInputStream(is);
//	msg=dis.readUTF();
//	System.out.println("reply : "+msg);
//}
//}
