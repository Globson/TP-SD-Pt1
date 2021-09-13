/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketfigurinhas;
import java.util.ArrayList;
/**
 *
 * @author grobs
 */
public class TestePersistencia {
    public static void main(String[] args){
        ArrayList<Object> users = Persistencia.lerArquivoBinario("Persistencia.txt");
        System.out.println(((Usuario)users.get(0)).getNome());
        ((Usuario)users.get(0)).PrintaAlbum();
        System.out.println(((Usuario)users.get(1)).getNome());
        ((Usuario)users.get(1)).PrintaAlbum();
        System.out.println(((Usuario)users.get(2)).getNome());
        ((Usuario)users.get(2)).PrintaAlbum();
        System.out.println(((Usuario)users.get(3)).getNome());
        ((Usuario)users.get(3)).PrintaAlbum();
    }
}
