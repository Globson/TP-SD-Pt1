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
        user.AdicionaCoins(10);
        user.CompraPacoteFigurinha(2);
        user.PrintaFigurinhas();
        Scanner sc = new Scanner(System.in);
        user.ColaFigurinha(sc.nextInt());
        user.ColaFigurinha(sc.nextInt());
        user.ColaFigurinha(sc.nextInt());
        user.ColaFigurinha(sc.nextInt());
        user.PrintaAlbum();
    }
    
}
