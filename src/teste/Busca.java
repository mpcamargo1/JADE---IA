/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.*;
import jade.domain.FIPAException;
import jade.util.leap.Iterator;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.data.time.Second;

/**
 *
 * @author marcospaulo
 */
public class Busca extends Agent{
    
    public static boolean alive = true;
    
    protected void setup(){
        
        try {
            sleep(400);
        } catch (InterruptedException ex) {
            Logger.getLogger(Busca.class.getName()).log(Level.SEVERE, null, ex);
        }
        addBehaviour(new TickerBehaviour(this,1000){
            public void onTick(){
                getServices();
                   
            }
        
        });
        
        
        
    }
    
    protected void getServices(){
        DFAgentDescription template = new DFAgentDescription();
        ServiceDescription sd = new ServiceDescription();
        sd.setType("Web Service");
        template.addServices(sd);
        
        
        try{
           
            if(alive== false)
                doDelete();
            
            DFAgentDescription[] result =  DFService.search(Busca.this,template);
            //result[i].getName() fornece o AID do agent
            for(int i=0;i<result.length;i++){
                String out = "Agente "+ result[i].getName().getLocalName() + " provê ";
                String aux = out;
                Iterator iter = result[i].getAllServices();
                
                while(iter.hasNext()){
                    out = aux;
                    Second scn = new Second();
                    ServiceDescription SD = (ServiceDescription) iter.next();
                    out += " " + SD.getName();
                    System.out.println(out);
                    Agentes.manager.queue.add(out + " -- " + scn.toString());
                }
                 System.out.println("\n"+ Agentes.manager.queue.size());
            }
        
        } catch (FIPAException e){
            e.printStackTrace();
        
        
        }
    
    
    }
    
    
}
