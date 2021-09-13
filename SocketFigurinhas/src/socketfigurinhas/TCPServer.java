/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketfigurinhas;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author grobs
 */
public class TCPServer {
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList <Usuario> ListaUsuarios = new ArrayList();
        VendaFigurinha VendasFig = new VendaFigurinha();
        ServerSocket listenSocket = null;
        Socket clientSocket = null;
        DataInputStream in;
        DataOutputStream out;
        ObjectInputStream inObj;
        int serverPort = 7896;
        //Implementar leitura de arquivo persistente 
        while(true){
            try{
            listenSocket = new ServerSocket (serverPort);
            System.out.println("Servidor Alpokebum!");
            System.out.println("Esperando...");
            clientSocket = listenSocket.accept();
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());
            inObj = new ObjectInputStream(clientSocket.getInputStream());
            //String data = in.readUTF();
            Usuario user = (Usuario)inObj.readObject();
            //System.out.println("Um cliente chegou! Ele disse "+data);
            out.writeUTF("PONG");
            System.out.println("Eu respondi PONG!");

            }catch(IOException e){}
            catch(ClassNotFoundException e){}
            finally{
                try{
                    listenSocket.close();
                    clientSocket.close();
                }catch(IOException e){}
            }
        }
        
    }
}
