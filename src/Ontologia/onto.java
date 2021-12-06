/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ontologia;

import jade.content.onto.*;
import jade.content.schema.*;


/**
 *
 * @author marcospaulo
 */
public class onto extends Ontology{
         // The name identifying this ontology
         public static final String NAME = "CPS-Ontology";

         // VOCABULARY
         public static final String COMPONENT = "Component";
         public static final String COMPONENT_ID = "ID";
         public static final String COMPONENT_DESC = "descrição";
         
         public static final String FAILURES = "Failures";
         public static final String FAILURES_ID = "ID";
         public static final String FAILURES_HASDETECTION = "hasDetection";
         public static final String FAILURES_HASOCCURRENCE = "hasOccurrence";
         public static final String FAILURES_HASSEVERITY = "hasSeverity";
         public static final String FAILURES_HASTIME = "hasTime";
         
         public static final String FAULT = "Fault";
         public static final String FAULT_HASTIME = "hasTime";
         public static final String FAULT_HASDESC = "hasDesc";
         
         public static final String LOCATION = "Location";
         public static final String LOCATION_ID = "ID";
         public static final String LOCATION_NOME = "nome";
         public static final String LOCATION_FAULT = "fault";
         
         public static final String HASLOCATION = "hasLocation";
         public static final String HASLOCATION_COMPONENT = "component";
         public static final String HASLOCATION_LOCATION = "location";
         
         public static final String HASFAILURES = "hasFailures";
         public static final String HASFAILURES_COMPONENT = "component";
         public static final String HASFAILURES_FAILURES = "failures";

         // The singleton instance of this ontology
         private static Ontology theInstance = new onto();

         // This is the method to access the singleton music shop ontology object
         public static Ontology getInstance() {
            return theInstance;
         }

         // Private constructor
         private onto() {
         // The music shop ontology extends the basic ontology
         super(NAME, BasicOntology.getInstance());
         try {
         add(new ConceptSchema(COMPONENT), Component.class);
         add(new ConceptSchema(FAILURES), Failures.class);
         add(new ConceptSchema(FAULT), Fault.class);
         add(new ConceptSchema(LOCATION), Location.class);
         add(new PredicateSchema(HASLOCATION), hasLocation.class);
         add(new PredicateSchema(HASFAILURES), hasFailures.class);
         

            // Structure of the schema for the Component concept
            ConceptSchema cs = (ConceptSchema) getSchema(COMPONENT);
            cs.add(COMPONENT_ID, (PrimitiveSchema) getSchema(BasicOntology.INTEGER));
            cs.add(COMPONENT_DESC, (PrimitiveSchema) getSchema(BasicOntology.STRING));
            
            cs = (ConceptSchema) getSchema(FAILURES);
            cs.add(FAILURES_ID, (PrimitiveSchema) getSchema(BasicOntology.INTEGER));
            cs.add(FAILURES_HASDETECTION, (PrimitiveSchema) getSchema(BasicOntology.INTEGER));
            cs.add(FAILURES_HASOCCURRENCE, (PrimitiveSchema) getSchema(BasicOntology.INTEGER));
            cs.add(FAILURES_HASSEVERITY, (PrimitiveSchema) getSchema(BasicOntology.INTEGER));
            cs.add(FAILURES_HASTIME, (PrimitiveSchema) getSchema(BasicOntology.STRING));
            
            cs = (ConceptSchema) getSchema(FAULT);
            cs.add(FAULT_HASTIME, (PrimitiveSchema) getSchema(BasicOntology.INTEGER));
            cs.add(FAULT_HASDESC, (PrimitiveSchema) getSchema(BasicOntology.STRING));
            
            cs = (ConceptSchema) getSchema(LOCATION);
            cs.add(LOCATION_ID, (PrimitiveSchema) getSchema(BasicOntology.INTEGER));
            cs.add(LOCATION_NOME, (PrimitiveSchema) getSchema(BasicOntology.STRING));
            cs.add(LOCATION_FAULT, (ConceptSchema) getSchema(FAULT));
            
            // Structure of the schema for the Predicate concept
            PredicateSchema ps = (PredicateSchema)getSchema(HASLOCATION);
            ps.add(HASLOCATION_COMPONENT, (ConceptSchema)getSchema(COMPONENT));
            ps.add(HASLOCATION_LOCATION, (ConceptSchema)getSchema(LOCATION));
            
            ps = (PredicateSchema)getSchema(HASFAILURES);
            ps.add(HASFAILURES_COMPONENT,(ConceptSchema)getSchema(COMPONENT));
            ps.add(HASFAILURES_FAILURES,(ConceptSchema)getSchema(FAILURES));
           
            }
            catch (OntologyException oe) {
            oe.printStackTrace();
            }
        } 
               
}
