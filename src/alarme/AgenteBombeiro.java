/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alarme;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;


/**
 *
 * @author marcospaulo
 */
public class AgenteBombeiro extends Agent {
    
        protected void setup(){
        
            addBehaviour(new CyclicBehaviour(this){
                public void action(){
                    ACLMessage msg = myAgent.receive();
                    if(msg != null){
                        ACLMessage reply =  msg.createReply();
                        String content = msg.getContent();
                        if(content.equalsIgnoreCase("Fogo")){
                            reply.setPerformative(ACLMessage.INFORM);
                            reply.setContent("Recebi seu aviso! Obrigado por auxiliar"
                                    + " meu serviço");
                            myAgent.send(reply);
                            System.out.println("O agente " + msg.getSender().getName()
                            + " avisou de um incêndio");
                            System.out.println("Vou ativar os procedimentos de "
                                    + " combate ao incêndio");
                            }
                           
                        }
                    else{
                        block();
                    
                    }
                    
                    }
                });
            }
        
        
        }
   
