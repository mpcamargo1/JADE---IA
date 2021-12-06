/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livro;

import jade.core.Agent;
import jade.core.AID;


/**
 *
 * @author marcospaulo
 */
public class CompradorDeLivros extends Agent {
    
    
    private String livrosComprar;
    
    protected void setup(){
    
        System.out.println("Olá, eu sou " + getLocalName() + " e estou pronto para comprar");
        
        Object[] args = getArguments();
        
        if(args != null && args.length > 0){
        
            livrosComprar = (String) args[0];
            System.out.println("Pretendo comprar o livro: "+ livrosComprar);
        
        }
        else{
            System.out.println("Não tenho livros para comprar");
            doDelete();
        }
    
    }
    
    protected void takeDown(){
    
        System.out.println("Agente comprador " + getAID().getName() + " está finalizado");
    
    }
    
}
