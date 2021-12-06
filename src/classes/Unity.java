/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import com.service.*;

/**
 *
 * @author marcospaulo
 */
public class Unity {
    
    private BloodPressure bp;
    private Double Temperature;
    private Double HeartRate;
    private Double Glicose;

    public Double getGlicose() {
        return Glicose;
    }

    public void setGlicose(Double Glicose) {
        this.Glicose = Glicose;
    }

    public BloodPressure getBp() {
        return bp;
    }

    public void setBp(BloodPressure bp) {
        this.bp = bp;
    }

    public Double getTemperature() {
        return Temperature;
    }

    public void setTemperature(Double Temperature) {
        this.Temperature = Temperature;
    }

    public Double getHeartRate() {
        return HeartRate;
    }

    public void setHeartRate(Double HeartRate) {
        this.HeartRate = HeartRate;
    }
    
    
    
}
