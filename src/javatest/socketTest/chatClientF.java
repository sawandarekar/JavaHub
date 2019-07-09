package javatest.socketTest;

import java.awt.Button;
import java.awt.Event;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

class chatClientF extends Frame implements Runnable
{
    Socket soc;

    TextField tf,tfile;
    TextArea ta;
    Button btnSend,btnClose,btnSendFile,btnReceive;
    String sendTo,filename;
    String LoginName;
    String savefile;
    Thread t=null;
    DataOutputStream dout;
    DataInputStream din;
    chatClientF(String LoginName,String chatwith) throws Exception
    {
        super(LoginName);
        this.LoginName=LoginName;
        sendTo=chatwith;
        tf=new TextField(50);
        tfile=new TextField(50);
        ta=new TextArea(50,50);
        btnSend=new Button("Send");
        btnClose=new Button("Close");
        btnSendFile=new Button("Send file");
        btnReceive=new Button("Receive");

        soc=new Socket("localhost",5217);

        din=new DataInputStream(soc.getInputStream());
        dout=new DataOutputStream(soc.getOutputStream());
        dout.writeUTF(LoginName);

        t=new Thread(this);
        t.start();

    }
    void setup()
    {
        setSize(600,400);
        setLayout(new GridLayout(4,2));

        add(ta);
        Panel p=new Panel();

        p.add(tf);
        p.add(btnSend);
        p.add(btnClose);
        add(p);
        add(tfile);
        add(btnSendFile);
        add(btnReceive);
        show();
    }
    @Override
    public boolean action(Event e,Object o)
    {
        if(e.arg.equals("Send"))
        {
            try
            {
                dout.writeUTF(sendTo + " "  + "DATA" + " " + tf.getText().toString());
                ta.append("\n" + LoginName + " Says:" + tf.getText().toString());
                tf.setText("");
            }
            catch(Exception ex)
            {
            }
        }
        else if(e.arg.equals("Close"))
        {
            try
            {
                dout.writeUTF(LoginName + " LOGOUT");
                System.exit(1);
            }
            catch(Exception ex)
            {
            }

        }
        else if(e.arg.equals("Send file"))
        {

            try{
                filename=tfile.getText().toString();
                dout.writeUTF(sendTo + " "  + "DATA"+"Sending file. Please click RECEIVE");
                sendFile(filename);
            }
            catch(Exception ex)
            {
            }

        }
        else if(e.arg.equals("Receive"))
        {
            try{

                saveFile(soc);

            }
            catch(Exception ex)
            {
            }

        }
        return super.action(e,o);
    }
    public void sendFile(String file) throws IOException
    {
        File myfile = new File(file);
        byte[] buffer = new byte[(int)myfile.length()];
        FileInputStream fis = new FileInputStream(myfile);
        BufferedInputStream in = new BufferedInputStream(fis);
        in.read(buffer,0,buffer.length);
        dout.write(buffer,0,buffer.length);
        dout.flush();

        fis.close();
        dout.close();
    }

    private void saveFile(Socket soc) throws IOException
    {
        int byteread,current=0;
        savefile=tfile.getText().toString();
        File test = new File(savefile);
        test.createNewFile();
        FileOutputStream fos = new FileOutputStream(test);
        BufferedOutputStream out = new BufferedOutputStream(fos);
        byte[] buffer = new byte[9999999];
        byteread = din.read(buffer,0,buffer.length);
        current = byteread;

        do{
            byteread = din.read(buffer,0,buffer.length-current);
            out.write(buffer,0,current);
            if(byteread >=0) {
                current+=byteread;
            }
        }while(byteread > -1);
        //out.write(buffer,0,current);
        out.flush();

        fos.close();
        //	din.close();
    }

    public static void main(String args[]) throws Exception
    {
        //chatClientF Client1=new chatClientF(args[0],args[1]);
        chatClientF Client1=new chatClientF("loginname","chatname");
        Client1.setup();
    }
    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                ta.append( "\n" + sendTo + " Says :" + din.readUTF());

            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
}

