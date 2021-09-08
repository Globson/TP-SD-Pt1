import java.net.*;
import java.io.*;

public class TCPClient{
    public static void main(String args[]){
        Socket s = null;
        try{
            int serverPort=7896;
            s = new Socket("127.0.0.1",serverPort);
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            System.out.println("Eu sou um cliente!");
            System.out.println("PING....");
            out.writeUTF("PING!");
            String data = in.readUTF();
            System.out.println(data);
        }
        catch(IOException e){

        }finally{
            if(s!=null) try{s.close();}catch(IOException e){}
        }
    }
}