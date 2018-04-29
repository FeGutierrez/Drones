/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fgutierrezf;

import becker.robots.City;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Flexxo333
 */
public class Ciudad extends City{
    
    private ArrayList<Planta> plantas;
    private Panel panelSolar;

    public Ciudad(String string) {
        super(string);
        this.plantas = new ArrayList<>();
    }

    public ArrayList<Planta> getPlantas() {
        return plantas;
    }

    public Panel getPanelSolar() {
        return panelSolar;
    }

    public void setPanelSolar(Panel panelSolar) {
        this.panelSolar = panelSolar;
    }
    
    
    
    
}
