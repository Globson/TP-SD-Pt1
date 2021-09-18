/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketfigurinhas;
import java.util.Scanner;
import java.util.ArrayList;
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
        ArrayList<Object> users = new ArrayList();
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<4;i++){
          System.out.printf("Entre com o numero da figurinha que deseja colar: ");
          System.out.println(user.ColaFigurinha(sc.nextInt()));  
        }
        for(int i=0;i<4;i++){
          System.out.println("Entre com a figurinha e valor a vender:");
          Vendas.ColocaFigurinhaAVenda(user, sc.nextInt(), sc.nextFloat());
        }
        Vendas.PrintaFigurinhasAVenda();
        Usuario samuel = new Usuario ("Samuel", "EuNaoJogoPokemon");
        samuel.AdicionaCoins(250);
        samuel.CompraPacoteFigurinha(1);
        samuel.PrintaFigurinhas();
        System.out.println("Entre com a figurinha e valor a vender do samuel:");
        Vendas.ColocaFigurinhaAVenda(samuel, sc.nextInt(), sc.nextFloat());
        Usuario arthur = new Usuario ("Arthur", "VAPOVAPO");
        arthur.AdicionaCoins(300);
        Usuario saulo = new Usuario ("Saulo", "YAMETE");
        saulo.AdicionaCoins(50);
        for(int i=0;i<4;i++){
          System.out.println("Entre com a figurinha que deseja comprar: ");  
          Vendas.CompraFigurinha(samuel, sc.nextInt(),sc.nextFloat());
        }
        for(int i=0;i<4;i++){
          System.out.printf("Entre com o numero da figurinha que deseja colar: ");
          System.out.println(samuel.ColaFigurinha(sc.nextInt()));  
        }
        for(int i=0;i<4;i++){
          System.out.println("Entre com a figurinha que deseja comprar: ");  
          Vendas.CompraFigurinha(arthur, sc.nextInt(),sc.nextFloat());
        }
        for(int i=0;i<4;i++){
          System.out.printf("Entre com o numero da figurinha que deseja colar: ");
          System.out.println(arthur.ColaFigurinha(sc.nextInt()));  
        }
        for(int i=0;i<4;i++){
          System.out.println("Entre com a figurinha que deseja comprar: ");  
          Vendas.CompraFigurinha(saulo, sc.nextInt(),sc.nextFloat());
        }
        for(int i=0;i<4;i++){
          System.out.printf("Entre com o numero da figurinha que deseja colar: ");
          System.out.println(saulo.ColaFigurinha(sc.nextInt()));  
        }
        Vendas.PrintaFigurinhasAVenda();
        System.out.printf("Pablo: ");
        user.PrintaAlbum();
        user.PrintaFigurinhas();
        System.out.printf("Samuel: ");
        samuel.PrintaAlbum();
        samuel.PrintaFigurinhas();
        System.out.printf("Arthur: ");
        arthur.PrintaAlbum();
        arthur.PrintaFigurinhas();
        System.out.printf("Saulo: ");
        saulo.PrintaAlbum();
        saulo.PrintaFigurinhas();
        users.add(user);
        users.add(samuel);
        users.add(arthur);
        users.add(saulo);
        Persistencia.gravarArquivoBinario(users, "Persistencia.txt");
        ArrayList <Object> LVendas = new ArrayList(); LVendas.add(Vendas);
        Persistencia.gravarArquivoBinario(LVendas, "VendasFigurinha.txt");
    }
    
}
