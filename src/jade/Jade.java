/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jade;

import jade.core.Agent;
/**
 *
 * @author marcospaulo
 */
public class Jade extends Agent {

    /**
     * @param args the command line arguments
     */
    protected void setup() {
  	System.out.println("Hello World! My name is "+getLocalName());
  	
  	// Make this agent terminate	
  } 
    
}
