/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes;

import classes.Unity;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author marcospaulo
 */
public class processingdata extends Agent {
    
    ArrayList<Integer> list = new ArrayList<Integer>();
    LinkedList<String> cacheData = new LinkedList<String>();
    BufferedReader reader;
    public void setup(){
        for(int i=0;i<6;i++)
            list.add(i, 1);
        
        
        
        addBehaviour(new TickerBehaviour(this,1000){
               public void onTick(){
                    MessageTemplate MT1 = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
                    MessageTemplate MT2 = MessageTemplate.MatchOntology("Unity");
                    MessageTemplate MT3 = MessageTemplate.and(MT1, MT2) ;
                    ACLMessage msg = myAgent.receive(MT3);
                    if(msg != null){
                       try {
                                String out = (String) msg.getContentObject();
                                try {
                                    /*Adiciona no cache os dados para serem posteriormente processados*/
                                    cacheData.add(out);
                                    
                                }catch (NumberFormatException ex){
                                    System.out.println(ex);
                                } 
                                
                            } catch (UnreadableException ex) {
                                Logger.getLogger(processingdata.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                            
                      }
                });
        
        addBehaviour(new TickerBehaviour(this,5000){
            public void onTick() {
                while(!cacheData.isEmpty()){
                    try {
                        checkData();
                        manager.queue.add("Dados analisados do "
                            + "agente collector -- OK\n");
                    } catch (IOException ex) {
                        Logger.getLogger(processingdata.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            
            }
        });
        
    
    }
    
    
    private void checkData() throws IOException{
     DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
     LocalDateTime now = LocalDateTime.now();
    
     Double aux;
     
     /*Retira a string da fila*/
     String out = cacheData.poll();
     /*Inicializa o leitor de string*/
     reader = new BufferedReader(new StringReader(out));
     
     /*Temperature*/
     aux = Double.parseDouble(reader.readLine());
        
     if (aux >= 36.5 & aux <= 37.5)
         manager.queue.add("Temperatura Normal -- " + now);
     else if (37.5 <= aux & aux <= 38.5)
         manager.queue.add("Temperatura Febril -- " + now);
     else
         manager.queue.add("Temperatura Alta -- " + now);
     
     /*Heart Rate*/
     aux = Double.parseDouble(reader.readLine());
     now = LocalDateTime.now(); 
     if(60 < aux & aux < 100)
         manager.queue.add("Frequência cardíaca normal -- " + now);
     else
         manager.queue.add("Frequência cardíaca anormal -- " + now);
     
     /*Sistólica*/
     aux = Double.parseDouble(reader.readLine());
     now = LocalDateTime.now(); 
     if(aux < 120 & aux > 90)
          manager.queue.add("Pressão sistólica normal -- " + now);
     else
          manager.queue.add("Pressão sistólica anormal -- " + now);
     
     /*Diastólica*/
     aux = Double.parseDouble(reader.readLine());
     now = LocalDateTime.now(); 
     if(aux < 80 & aux > 60)
          manager.queue.add("Pressão diastólica normal -- " + now);
     else
          manager.queue.add("Pressão diastólica anormal -- " + now);
    
    
    /*Glicose*/
     aux = Double.parseDouble(reader.readLine());
     now = LocalDateTime.now(); 
     if(aux < 120 & aux > 89)
          manager.queue.add("Glicose normal -- " + now);
     else
          manager.queue.add("Glicose anormal -- " + now);
    
    }
    
    
}
