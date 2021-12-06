/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ontologia;

import jade.content.Concept;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author marcospaulo
 */
public class Failures  implements Concept{
    
    private int ID;
    private int hasDetection;
    private int hasOccurrence;
    private int hasSeverity;
    private String hasTime;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getHasDetection() {
        return hasDetection;
    }

    public void setHasDetection(int hasDetection) {
        this.hasDetection = hasDetection;
    }

    public int getHasOccurrence() {
        return hasOccurrence;
    }

    public void setHasOccurrence(int hasOccurrence) {
        this.hasOccurrence = hasOccurrence;
    }

    public int getHasSeverity() {
        return hasSeverity;
    }

    public void setHasSeverity(int hasSeverity) {
        this.hasSeverity = hasSeverity;
    }

    public String getHasTime() {
        return hasTime;
    }

    public void setHasTime(String hasTime) {
        this.hasTime = hasTime;
    }

   
    
    
    
}
