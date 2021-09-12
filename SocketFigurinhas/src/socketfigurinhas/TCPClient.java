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
        }catch(Exception e){
            System.out.println("Erro! Entrada invalida!");
        }
        if(jacadastrado==1){
            String nome;
            String senha;
            System.out.print("Entre com o nome de usuario: ");
            nome = sc.nextLine();
            System.out.print("Entre com a senha:");
            senha = sc.nextLine();
            //enviar requisição de login
            
        }else{
            System.out.println("Vamos criar seu usuário!");
            String nome;
            String senha;
            System.out.print("Entre com o nome de usuario: ");
            nome = sc.nextLine();
            System.out.print("Entre com a senha:");
            senha = sc.nextLine();
            Usuario newuser = new Usuario(nome, senha);
            //enviar requisição de verificar se nome esta disponivel e de criar novo usuario.
        }
        
        
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
