/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ontologia;

import jade.content.Concept;
import jade.core.AID;

/**
 *
 * @author marcospaulo
 */
public class Actor implements Concept{

    private CD cd;
    private Artista at;
    private AID actor;

    public AID getActor() {
        return actor;
    }

    public void setActor(AID actor) {
        this.actor = actor;
    }

    public CD getCd() {
        return cd;
    }

    public void setCd(CD cd) {
        this.cd = cd;
    }

    public Artista getAt() {
        return at;
    }

    public void setAt(Artista at) {
        this.at = at;
    }
    
}
