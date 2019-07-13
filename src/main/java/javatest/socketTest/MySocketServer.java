package javatest.socketTest;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class MySocketServer {

    public static void main(String[] args) {
        try {
            System.out.println("Starting Socket Server");
            ServerSocket serverSocket = new ServerSocket(1411);
            Socket s = serverSocket.accept();
            DataInputStream dis=new DataInputStream(s.getInputStream());
            String message = dis.readUTF();
            System.out.println("Message:"+message);
            //serverSocket.close();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
