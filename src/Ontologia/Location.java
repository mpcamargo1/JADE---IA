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
public class Location implements Concept{
    
    private int ID;
    private String nome;
    private Fault fault;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Fault getFault() {
        return fault;
    }

    public void setFault(Fault fault) {
        this.fault = fault;
    }
    
    
    
}
