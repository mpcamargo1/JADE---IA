/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ontologia;

import jade.content.Concept;
import java.time.LocalDateTime;

/**
 *
 * @author marcospaulo
 */
public class Fault implements Concept{
    
    private int hasTime;
    private String hasDesc;

    public String getHasDesc() {
        return hasDesc;
    }

    public void setHasDesc(String hasDesc) {
        this.hasDesc = hasDesc;
    }

    public int getHasTime() {
        return hasTime;
    }

    public void setHasTime(int hasTime) {
        this.hasTime = hasTime;
    }

  

    
    
    
}
