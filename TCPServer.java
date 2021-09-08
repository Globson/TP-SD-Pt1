import java.net.*;
import java.io.*;

public class TCPServer{
    public static void main(String args[]){
        ServerSocket listenSocket = null;
        Socket clientSocket = null;
        DataInputStream in;
        DataOutputStream out;
        int serverPort = 7896;
        try{
            listenSocket = new ServerSocket (serverPort);
            System.out.println("Eu sou o servidor e estou rodando!");
            System.out.println("Esperando...");
            clientSocket = listenSocket.accept();
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());
            String data = in.readUTF();
            System.out.println("Um cliente chegou! Ele disse "+data);
            out.writeUTF("PONG");
            System.out.println("Eu respondi PONG!");

        }catch(IOException e){}
        finally{
            try{
                listenSocket.close();
                clientSocket.close();
            }catch(IOException e){}
        }
    }
}