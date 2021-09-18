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
        ArrayList <Object> ListaUsuarios = new ArrayList();
        ListaUsuarios = Persistencia.lerArquivoBinario("Persistencia.txt");
        VendaFigurinha VendasFig = new VendaFigurinha();
        ServerSocket listenSocket = null;
        Socket clientSocket = null;
        DataInputStream in;
        DataOutputStream out;
        ObjectInputStream inObj;
        ObjectOutputStream outObj;
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
            outObj = new ObjectOutputStream(clientSocket.getOutputStream());
            int Entrada = in.readInt();
            if(Entrada==0){ //criar cliente
                out.writeBoolean(true); //ack
                Usuario user = (Usuario)inObj.readObject();
                ListaUsuarios.add(user);
                out.writeBoolean(true); //ack
                System.out.println("Usuario criado: "+ user.getNome());
                
            }
            else if(Entrada==1){// logar cliente ja existente
                //System.out.println("Entrou em usuario existente");
                out.writeBoolean(true); //ack
                String nome = in.readUTF();
                //out.writeBoolean(true);
                String senha = in.readUTF();
                //out.writeBoolean(true);
                boolean user_encontrado = false;
                int index_user_encontrado=0;
                //System.out.println("Credenciais recebidas: "+ nome+senha);
                for(int i=0;i<ListaUsuarios.size();i++){
                    //System.out.println(((Usuario)ListaUsuarios.get(i)).getNome());
                    if(((Usuario)ListaUsuarios.get(i)).ComparaNomeSenha(nome,senha)){
                        index_user_encontrado = i;
                        user_encontrado = true;
                    }
                }
                out.writeBoolean(user_encontrado);
                if(user_encontrado){
                    outObj.writeObject(((Usuario)ListaUsuarios.get(index_user_encontrado)));
                }
            }
            
            
            //String data = in.readUTF();
            //Usuario user = (Usuario)inObj.readObject();
            //System.out.println("Um cliente chegou! Ele disse "+data);
            //out.writeUTF("PONG");
            //System.out.println("Eu respondi PONG!");

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
