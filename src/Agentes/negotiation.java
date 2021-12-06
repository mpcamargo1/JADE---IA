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
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.data.time.Second;

/**
 *
 * @author marcospaulo
 */
public class negotiation extends Agent {
    
    
    protected void setup(){
        File myObj = new File("log.txt");
        try {
            Second scn = new Second();
            myObj.delete();
            myObj.createNewFile();
            Files.write(Paths.get("log.txt"), "---------------------------------------------------------------------\nLog criado em ".getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get("log.txt"), scn.toString().getBytes(), StandardOpenOption.APPEND);
            Files.write(Paths.get("log.txt"), "\n".getBytes(), StandardOpenOption.APPEND);
        } catch (IOException ex) {
            Logger.getLogger(negotiation.class.getName()).log(Level.SEVERE, null, ex);
        }
        addBehaviour(new TickerBehaviour(this,2500){
        
            public void onTick(){
                    
                    /*Aplicando filtro nas mensagens*/
                    MessageTemplate MT1 = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
                    MessageTemplate MT2 = MessageTemplate.MatchOntology("Resource");
                    MessageTemplate MT3 = MessageTemplate.and(MT1, MT2) ;
                    ACLMessage msg = myAgent.receive(MT3);
                    
                    /*Se existir a mensagem*/
                    if(msg != null){
                        
                        /*Escrevendo no arquivo*/
                        try {
                            Files.write(Paths.get("log.txt"), msg.getContent().getBytes(), StandardOpenOption.APPEND);
                        }catch (IOException e) {
                        //exception handling left as an exercise for the reader
                        }
                    
                    
                    
                    
                    }
                    
            }
        
        
        
        });
    
    }
    
    
}
