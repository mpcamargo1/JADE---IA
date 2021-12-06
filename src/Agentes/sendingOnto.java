/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes;

import Ontologia.Gravadora;
import Ontologia.Artista;
import Ontologia.Actor;
import Ontologia.CD;
import Ontologia.Component;
import Ontologia.Failures;
import Ontologia.Fault;
import Ontologia.Location;
import Ontologia.hasFailures;
import Ontologia.hasLocation;
import Ontologia.onto;
import jade.core.Agent;
import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.lang.xml.XMLCodec;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.core.AID;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import static java.lang.Thread.sleep;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcospaulo
 */
public class sendingOnto extends Agent{
  
    public void setup(){
     
        // Register the codec for the SL0 language
	getContentManager().registerLanguage(new SLCodec(), FIPANames.ContentLanguage.FIPA_SL0);	
	
	// Register the ontology used by this application
	getContentManager().registerOntology(onto.getInstance(),"CPS-Ontology");
        
        ACLMessage msg = new ACLMessage(ACLMessage.QUERY_IF);
        msg.addReceiver(new AID("onto", AID.ISLOCALNAME)); 
        Ontology o = getContentManager().lookupOntology(onto.NAME);
        msg.setOntology("CPS-Ontology");
        msg.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);
        
        
        Failures fls = new Failures();
        fls.setID(1);
        fls.setHasTime(LocalDateTime.now().toString());
        
        Component component = new Component();
        component.setDescrição(MSG_QUEUE_CLASS);
        component.setID(1);
        
        hasFailures hl = new hasFailures();
        hl.setComponent(component);
        hl.setFailures(fls);
        
        
        try {
         // Let JADE convert from Java objects to string
         getContentManager().fillContent(msg, hl);
         super.send(msg);
        }
      
        catch (OntologyException oe) {
         oe.printStackTrace();
        }  catch (Codec.CodecException ex) { 
              Logger.getLogger(sendingOnto.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch(java.lang.ExceptionInInitializerError e){
            e.printStackTrace();
        }
        


    }
    
    
}
