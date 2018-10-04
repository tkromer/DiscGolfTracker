/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discgolftracker;

import java.io.Serializable;

/**
 *
 * @author Jim
 */
public class hole implements Serializable {
    private int par;
    private int distance;
    private int best;
    
    public hole(int holePar, int holeDistance){
        this.setPar(holePar);
        this.setDistance(holeDistance);
    }
    
    public hole() {
        this.setPar(0);
        this.setDistance(0);
    }

    public void setPar(int par) {
        this.par = par;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getPar() {
        return par;
    }

    public int getDistance() {
        return distance;
    }
    
    
    
}
