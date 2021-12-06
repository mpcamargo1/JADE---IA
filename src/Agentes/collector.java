/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes;

import classes.Unity;
import com.service.BloodPressure;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import teste.Data;
import teste.Operacao;

/**
 *
 * @author marcospaulo
 */
public class collector extends Agent {
    
    public  static  Queue<Double> queue_Temperature   = new LinkedList();
    public  static  Queue<BloodPressure> queue_BloodPressure = new LinkedList();
    public  static  Queue<Double> queue_HeartRate = new LinkedList();
    public static Queue<Double> queue_Glicose = new LinkedList();
    private static  Queue<Long>  elapsedTime = new LinkedList();
    public static   Integer server= 0;      // Inicia recuperando os dados do primeiro servidor
    public Unity unity = new Unity();
    
    long start;
    public void setup(){
        addBehaviour(new TickerBehaviour(this,1000){
               public void onTick(){
                   try{
                      System.out.println("Servidor:" + collector.server); 
                      getData();
                      sendToProcessingData();
                      }
                   catch (Exception e){
                       // Adicionar código enviando dados para o agente diagnóstico
                       System.out.println(e);
                       Agentes.manager.queue.add("Conexão recusada (Connection refused) "
                               + "-- Trocando de servidor");
                       
                            ACLMessage msg = new ACLMessage(ACLMessage.FAILURE);
                            msg.addReceiver(new AID("diag",AID.ISLOCALNAME));
                            msg.setLanguage("Português");
                            msg.setOntology("Conexão recusada (Connection refused)");
                            myAgent.send(msg);
                       
                   }
                   try{
                      
                       int size = elapsedTime.size();
                        for(int i=0;i<size;i++){
                             ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                             msg.addReceiver(new AID("diag",AID.ISLOCALNAME));
                             msg.setLanguage("Português");
                             msg.setOntology("Tempo/Resposta");
                             msg.setContentObject(elapsedTime.poll());
                             myAgent.send(msg);
                         }
                       
                        } catch (IOException ex) {
                            Logger.getLogger(Data.class.getName()).log(Level.SEVERE, null, ex);
                        }
                   
                   
                  
               }

           });   
    }
    
    
    private void getData(){
    
    if(server.equals(0)){
        
            start =  System.currentTimeMillis();
            unity.setTemperature(Operacao.getTemperature());
            queue_Temperature.add(unity.getTemperature());
            elapsedTime.add(System.currentTimeMillis() - start);
            
            start =  System.currentTimeMillis();
            unity.setBp(Operacao.getBloodPressure());
            queue_BloodPressure.add(unity.getBp());
            elapsedTime.add(System.currentTimeMillis() - start);
            
            start =  System.currentTimeMillis();
            unity.setHeartRate(Operacao.getHeartRate());
            queue_HeartRate.add(unity.getHeartRate());
            elapsedTime.add(System.currentTimeMillis() - start);
            
             start =  System.currentTimeMillis();
            unity.setGlicose(Operacao.getGlicose());
            queue_Glicose.add(unity.getGlicose());
            elapsedTime.add(System.currentTimeMillis() - start);
            
            
    }
    else{
           
            start =  System.currentTimeMillis();
            unity.setTemperature(Operacao.getTemperatureBackup());
            queue_Temperature.add(unity.getTemperature());
            elapsedTime.add(System.currentTimeMillis() - start);
            
            start =  System.currentTimeMillis();
            unity.setBp(Operacao.getBloodPressureBackup());
            queue_BloodPressure.add(unity.getBp());
            elapsedTime.add(System.currentTimeMillis() - start);
            
            start =  System.currentTimeMillis();
            unity.setHeartRate(Operacao.getHeartRateBackup());
            queue_HeartRate.add(unity.getHeartRate());
            elapsedTime.add(System.currentTimeMillis() - start);
            
            start =  System.currentTimeMillis();
            unity.setGlicose(Operacao.getGlicoseBackup());
            queue_Glicose.add(unity.getGlicose());
            elapsedTime.add(System.currentTimeMillis() - start);
            
     }
    
    }
    
    private void sendToProcessingData(){
        
        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
        msg.addReceiver(new AID("proc",AID.ISLOCALNAME));
        msg.setLanguage("Português");
        msg.setOntology("Unity");
        try {
            msg.setContentObject(  unity.getTemperature() + "\n"
                                 + unity.getHeartRate() + "\n"
                                 + unity.getBp().getSystolic() + "\n" 
                                 + unity.getBp().getDiastolic() + "\n"
                                 + unity.getGlicose()
            );
        } catch (IOException ex) {
            Logger.getLogger(collector.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.send(msg);
    }
    
}
