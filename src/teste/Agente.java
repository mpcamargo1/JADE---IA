/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import form.MainJFrame;
import jade.core.Agent;

import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.domain.JADEAgentManagement.KillAgent;
import static java.lang.Thread.sleep;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcospaulo
 */
public class Agente extends Agent {
    
    public static Queue<com.service.Musica> q = new LinkedList();
    public static boolean status = true;
    
    protected void setup(){
        new MainJFrame().setVisible(true);
        
        DFAgentDescription dfd =  new DFAgentDescription();
        dfd.setName(getAID());
        
        ServiceDescription sd  = new ServiceDescription();
        sd.setType("Web Service");
        sd.setName("Sum");
        dfd.addServices(sd);
        
        sd = new ServiceDescription();
        sd.setType("Web Service");
        sd.setName("Sub");
        
        dfd.addServices(sd);
        
        try{
            DFService.register(this,dfd);
        } catch (FIPAException e){
            e.printStackTrace();
        }
        
        /*
            com.service.Musica msc = Operacao.addClass();
            q.add(msc);
            
            addBehaviour(new TickerBehaviour(this,1200){
            
            public void onTick(){
            
            if(q.isEmpty() == false){
                System.out.println(q.size());
                com.service.Musica m = q.remove();
                System.out.println(m.getNome());
                System.out.println(m.getAlbum());
            }
            
            }
            });
            
          */  
        
    
    }

    protected void takeDown(){
    
        try{
            DFService.deregister(Agente.this);  
        } catch (FIPAException e){
            e.printStackTrace();
        }
     }
}
