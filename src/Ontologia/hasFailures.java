/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ontologia;

import jade.content.Predicate;

/**
 *
 * @author marcospaulo
 */
public class hasFailures implements Predicate{
    
    private Component component;
    private Failures failures;

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public Failures getFailures() {
        return failures;
    }

    public void setFailures(Failures failures) {
        this.failures = failures;
    }
    
    
    
}
