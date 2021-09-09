/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketfigurinhas;
import java.net.*;
import java.io.*;
/**
 *
 * @author grobs
 */
public class TCPServer {
    public static void main(String[] args) {
        // TODO code application logic here
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
