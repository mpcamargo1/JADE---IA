/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes;

import form.MainJFrame;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.AMSService;
import jade.domain.FIPAAgentManagement.AMSAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcospaulo
 */
public class manager extends Agent {
    
    public static Queue<String> queue = new LinkedList();
    AMSAgentDescription[] agents  = null;
    SearchConstraints c = new SearchConstraints();
    
    public void setup(){
            new MainJFrame().setVisible(true);
            c.setMaxResults((long)-1);
            addBehaviour(new TickerBehaviour(this,5000){
                public void onTick(){
                     
                    try {
                        /*Analisando a quantidade de agentes em execução*/
                        agents = AMSService.search(myAgent, new AMSAgentDescription(), c);
                        if(agents.length < 10)
                            queue.add("Sistema não está funcionando corretamente");
                        
                        if(agents.length == 10)
                            queue.add("Todos os agentes funcionando corretamente");
                        
                    } catch (FIPAException ex) {
                        Logger.getLogger(manager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    if(queue.size() > 150){
                         sendMessage();  
                         queue.clear();
                      }
                }
            
            });
    
    
    }
    
    public void sendMessage(){
        String concatStr = new String();
        String aux = new String();
        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
        msg.addReceiver(new AID("neg",AID.ISLOCALNAME));
        msg.setLanguage("Português");
        msg.setOntology("Resource");
        
        /*Construindo a string*/
        while(!queue.isEmpty()){
            aux = queue.poll();
            concatStr = concatStr + "\t" +aux + "\n";
        }
        msg.setContent(concatStr);
        super.send(msg);
    }
    
    
}
