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
        for(int i=0;i<users.size();i++){
            System.out.println(((Usuario)users.get(i)).getNome());
        }
        /*
        System.out.println(((Usuario)users.get(0)).getNome());
        ((Usuario)users.get(0)).PrintaAlbum();
        ((Usuario)users.get(0)).PrintaFigurinhas();
        System.out.println(((Usuario)users.get(1)).getNome());
        ((Usuario)users.get(1)).PrintaAlbum();
        ((Usuario)users.get(1)).PrintaFigurinhas();
        System.out.println(((Usuario)users.get(2)).getNome());
        ((Usuario)users.get(2)).PrintaAlbum();
        ((Usuario)users.get(2)).PrintaFigurinhas();
        System.out.println(((Usuario)users.get(3)).getNome());
        ((Usuario)users.get(3)).PrintaAlbum();
        ((Usuario)users.get(3)).PrintaFigurinhas();
        System.out.println(((Usuario)users.get(3)).ComparaNomeSenha("Saulo", "YAMETE"));*/
    }
}
