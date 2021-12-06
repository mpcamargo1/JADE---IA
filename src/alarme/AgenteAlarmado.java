/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarme;

import form.MainJFrame;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.core.AID;
import javax.swing.JFrame;


/**
 *
 * @author marcospaulo
 */
public class AgenteAlarmado extends Agent {
    
    
    protected void setup(){
    
    addBehaviour(new OneShotBehaviour(this){
    
        public void action(){
        
           ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
           msg.addReceiver(new AID("Bombeiro",AID.ISLOCALNAME));
           msg.setLanguage("Português");
           msg.setOntology("Emergência");
           msg.setContent("Fogo");
           myAgent.send(msg);
           
        }
    });
    
    addBehaviour(new CyclicBehaviour(this){
    
        public void action(){
            ACLMessage msg = myAgent.receive();
            if(msg != null){
                String content = msg.getContent();
                System.out.println("---> " + msg.getSender().getName() + " " + 
                        content);
            }
            else{
                block();
            }
        
        }
    
    
    
    
    });
       
        new MainJFrame().setVisible(true);
     
        
    
    }
    
}
