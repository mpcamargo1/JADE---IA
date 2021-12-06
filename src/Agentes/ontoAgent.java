/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes;

import Ontologia.Gravadora;
import Ontologia.hasFailures;
import Ontologia.hasLocation;
import Ontologia.onto;
import jade.content.ContentElement;
import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.lang.xml.XMLCodec;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcospaulo
 */
public class ontoAgent extends Agent{
    
   
    
    protected void setup() {

         // Register the codec for the SL0 language
         getContentManager().registerLanguage(new SLCodec(), FIPANames.ContentLanguage.FIPA_SL0);	
		
         // Register the ontology used by this application
         getContentManager().registerOntology(onto.getInstance());	
                addBehaviour(new TickerBehaviour(this,2000){
                
                    public void onTick(){
                        // Create and add the behaviour for handling REQUESTS using the CPS-ontology
                        MessageTemplate mt = MessageTemplate.MatchOntology(onto.NAME);
                        ACLMessage msg = myAgent.blockingReceive(mt);
                        try {
                                
                                ContentElement ce = null;
                                ce = getContentManager().extractContent(msg);
                                
                                if (ce instanceof hasFailures) {
                                    System.out.println(((hasFailures) ce).getFailures().getHasTime());
                                }
                            
                        }   catch (Codec.CodecException ex) {
                            Logger.getLogger(ontoAgent.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (OntologyException ex) {
                            Logger.getLogger(ontoAgent.class.getName()).log(Level.SEVERE, null, ex);
                        }
                
                }});
                
                
   }
    
    

    
}
