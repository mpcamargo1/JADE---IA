/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.data.time.Second;

/**
 *
 * @author marcospaulo
 */
public class diagnostic extends Agent {
    
    long content;
    int count=0;
    
    public void setup(){
        
        MessageTemplate MT1 = MessageTemplate.MatchPerformative(ACLMessage.FAILURE);
        MessageTemplate MT2 = MessageTemplate.MatchOntology("Tempo/Resposta");
        
         addBehaviour(new TickerBehaviour(this,500){
               public void onTick(){
                    
                    ACLMessage msg = myAgent.receive(MT1);
                    if(msg != null){
                            /*Falha ao acesso ao servidor*/
                            if(msg.getPerformative() == ACLMessage.FAILURE
                                    & msg.getOntology().equals("Conexão recusada (Connection refused)")){
                                if(collector.server.equals(0))
                                    collector.server = 1;
                                else
                                    collector.server = 0;
                                
                                
                            }
                    }
                      
                }
            });
         
         addBehaviour(new TickerBehaviour(this,5000){
             public void onTick(){
                Agentes.manager.queue.add("Memória Usada: " + String.valueOf(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
             }
         });
         
         addBehaviour(new TickerBehaviour(this,1000){
             public void onTick(){
             
                   
                    ACLMessage msg = myAgent.receive(MT2);
                    if(msg != null){
                        
                        /*Análisa a mensagem com filtro da Ontologia Tempo/Resposta*/
                        long content = 0;
                        try {
                            content = (long) msg.getContentObject();
                        } catch (UnreadableException ex) {
                            Logger.getLogger(diagnostic.class.getName()).log(Level.SEVERE, null, ex);
                        }
                                    if(content > 200){
                                         count++;
                                         Second scn = new Second();
                                         Agentes.manager.queue.add("Tempo de resposta WS excedido -- " + scn.toString());
                                    }
                                
                                else
                                    count=0;
                        
                    }
                    
             
             }
         });
         
    }
}
