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
public class Usuario {
    private String nome_de_usuario;
    private String senha;
    private AlbumFigurinhas album;
    private float coins;
    private ArrayList<Integer> figurinhas_sem_colar;
    
    public Usuario(String nomeusuario,String senha){
        this.nome_de_usuario = nomeusuario;
        this.senha = senha;
        this.album = new AlbumFigurinhas();
        this.coins = 0;
        this.figurinhas_sem_colar = new ArrayList();
    }
    
    public boolean AdicionaCoins(float valor){
        this.coins += valor;
        return true;
    }
    
    public boolean CompraPacoteFigurinha(int pacotes){
        if(this.coins >= 4 * pacotes ){
            this.coins -= (4*pacotes);
            for(int i=0;i<pacotes;i++){
                PacoteFigurinha Pacote = new PacoteFigurinha();
                int figurinhas[] = Pacote.GetFigurinhas();
                for(int y=0;y<4;y++){
                    //System.out.println("Fig: "+figurinhas[i]);
                    this.figurinhas_sem_colar.add(figurinhas[y]);
                }
            }
            return true;
        }
        return false;
    }
    
    public boolean ColaFigurinha(int figurinha){
        if(this.figurinhas_sem_colar.contains(figurinha)){
            this.figurinhas_sem_colar.remove(this.figurinhas_sem_colar.indexOf(figurinha));
            return this.album.AdicionaFigurinha(figurinha);
        }else{
            return false;
        }
    }
    
    public void PrintaAlbum(){
        this.album.Printa();
    }
    
    public void PrintaFigurinhas(){
        for(int i=0;i<this.figurinhas_sem_colar.size();i++){
            System.out.print(this.figurinhas_sem_colar.get(i)+" ");
        }
        System.out.println("Coins: "+this.coins);
    }
}
