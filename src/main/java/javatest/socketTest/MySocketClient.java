package javatest.socketTest;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MySocketClient {

    public static void main(String[] args) {
        try {
            System.out.println("Starting Socket Client");
            Socket socket = new Socket("localhost", 1411);
            DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("Socket Test from client");
            dos.flush();
            dos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
