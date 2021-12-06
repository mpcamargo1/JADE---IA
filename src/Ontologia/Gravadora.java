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
public class Gravadora implements Predicate {
    
    private CD cd;
    private Artista at;

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
