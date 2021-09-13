/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketfigurinhas;
import java.util.ArrayList;
import java.io.Serializable;
/**
 *
 * @author grobs
 */
public class VendaFigurinha implements Serializable{
    private ArrayList<Integer> Lista_Figurinhas;
    private ArrayList<Float> Valor_Figurinhas;
    private ArrayList<Usuario> Proprietarios;
    
    public VendaFigurinha(){
        this.Lista_Figurinhas = new ArrayList();
        this.Valor_Figurinhas = new ArrayList();
        this.Proprietarios = new ArrayList();
    }
    
    public void PrintaFigurinhasAVenda(){
        System.out.println("------Inicio de lista figurinhas a venda------");
        for(int i=0;i<this.Lista_Figurinhas.size();i++){
            System.out.println("Figurinha: "+this.Lista_Figurinhas.get(i)+" Valor: "+this.Valor_Figurinhas.get(i));
        }
        System.out.println("------Fim de lista figurinhas a venda------");
    }
    
    public boolean ColocaFigurinhaAVenda(Usuario A,Integer Figurinha,float Valor){
        if(A.RetiraFigurinhaSemColar(Figurinha)){
            this.Lista_Figurinhas.add(Figurinha);
            this.Valor_Figurinhas.add(Valor);
            this.Proprietarios.add(A);
            return true;
        }
            return false;
    }
    
    public boolean CompraFigurinha(Usuario A, Integer Figurinha){
        if(this.Lista_Figurinhas.contains(Figurinha)){
            int index = this.Lista_Figurinhas.lastIndexOf(Figurinha);
            if(A.SubtraiCoins(this.Valor_Figurinhas.get(index))){
                A.AdicionaFigurinhaSemColar(Figurinha);
                this.Proprietarios.get(index).SomaCoins(this.Valor_Figurinhas.get(index));
                
                this.Valor_Figurinhas.remove(index); //Pode acontecer bugs, verificar dps se remove figurinha por indice ou por conteudo, pois ambos sao int
                this.Lista_Figurinhas.remove(index);
                this.Proprietarios.remove(index);
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
}
