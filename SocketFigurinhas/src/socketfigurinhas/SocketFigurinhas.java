/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketfigurinhas;
import java.util.Scanner;
/**
 *
 * @author grobs
 */
public class SocketFigurinhas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Usuario user = new Usuario("Pablo","EUAMOODANIEL");
        VendaFigurinha Vendas = new VendaFigurinha();
        user.AdicionaCoins(25);
        user.CompraPacoteFigurinha(5);
        user.PrintaFigurinhas();
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<4;i++){
          System.out.printf("Entre com o numero da figurinha que deseja colar: ");
          System.out.println(user.ColaFigurinha(sc.nextInt()));  
        }
        System.out.println("Entre com a figurinha e valor a vender:");
        Vendas.ColocaFigurinhaAVenda(user, sc.nextInt(), sc.nextFloat());
        System.out.println("Entre com a figurinha e valor a vender:");
        Vendas.ColocaFigurinhaAVenda(user, sc.nextInt(), sc.nextFloat());
        System.out.println("Entre com a figurinha e valor a vender:");
        Vendas.ColocaFigurinhaAVenda(user, sc.nextInt(), sc.nextFloat());
        Vendas.PrintaFigurinhasAVenda();
        Usuario user2 = new Usuario ("Samuel", "EuNaoJogoPokemon");
        user2.AdicionaCoins(250);
        Vendas.CompraFigurinha(user2, sc.nextInt());
        System.out.println("Coins de user: "+ user.GetCoins());
        Vendas.PrintaFigurinhasAVenda();
        user.PrintaAlbum();
        user2.PrintaFigurinhas();
    }
    
}
