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
        user.AdicionaCoins(25);
        user.CompraPacoteFigurinha(5);
        user.PrintaFigurinhas();
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<10;i++){
          System.out.printf("Entre com o numero da figurinha que deseja colar: ");
          System.out.println(user.ColaFigurinha(sc.nextInt()));  
        }
        user.PrintaAlbum();
    }
    
}
