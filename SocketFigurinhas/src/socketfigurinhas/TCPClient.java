/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketfigurinhas;
import java.net.*;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author grobs
 */
public class TCPClient {
    public static void main(String[] args) {

        // TODO code application logic here
        Socket s = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("\tOla, bem-vindo ao cliente do Alpokebum!");
        
        int jacadastrado = 0;
        System.out.println("1 - Ja tenho cadastro");
        System.out.println("2 - Nao tenho cadastro");
        System.out.print("Entre com a opcao desejada: ");
        try{
            jacadastrado = sc.nextInt();
            sc.nextLine();
        }catch(Exception e){
            System.out.println("Erro! Entrada invalida!");
        }
        System.out.println(jacadastrado);
        
        try{
            int serverPort=7896;
            s = new Socket("127.0.0.1",serverPort);
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            //ObjectInputStream inObj = new ObjectInputStream(s.getInputStream());
            ObjectOutputStream outObj = new ObjectOutputStream(s.getOutputStream());
            if(jacadastrado==2){
                out.writeInt(0);
                if(in.readBoolean()){
                    System.out.println("Vamos criar seu usuário!");
                    String nome;
                    String senha;
                    System.out.print("Entre com o nome de usuario: ");
                    nome = sc.nextLine();
                    System.out.print("Entre com a senha:");
                    senha = sc.nextLine();
                    Usuario newuser = new Usuario(nome, senha);
                    outObj.writeObject(newuser);
                    if(in.readBoolean()){
                        System.out.println("Usuario criado com sucesso!");
                    }
                }
                
            //enviar requisição de verificar se nome esta disponivel e de criar novo usuario.
            
            }else{
                out.writeInt(1);
                if(in.readBoolean()){
                    String nome;
                    String senha;
                    System.out.print("Entre com o nome de usuario: ");
                    nome = sc.nextLine();
                    System.out.print("Entre com a senha:");
                    senha = sc.nextLine();
                    out.writeUTF(nome);
                    //if(in.readBoolean()){
                        out.writeUTF(senha);
                        //if(in.readBoolean()){
                            if(in.readBoolean()){
                                System.out.println("Usuario logado com sucesso!");
                            }
                            else{
                                System.out.println("Falha! Nome ou senha errado!");
                            }
                        //}
                    //}
                    
                }
                
            //enviar requisição de login
            }
        
        
        
            
            //System.out.println("Eu sou um cliente!");
            //System.out.println("PING....");
            //out.writeUTF("PING!");
            //String data = in.readUTF();
            //System.out.println(data);
        }
        catch(IOException e){

        }finally{
            if(s!=null) try{s.close();}catch(IOException e){}
        }
    }
}
