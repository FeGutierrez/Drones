/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fgutierrezf;

import co.edu.unal.poo.fgutierrezf.Ciudad;
import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Thing;
import becker.robots.icons.Icon;

/**
 *
 * @author Estudiante
 */
public class Panel extends Thing{

    public String icono;
    private int cargaRestante;
    private int street;
    private int avenue;
    
    public Panel(Ciudad city, int i, int i1, int cargaRestante) {
        super(city, i, i1);
        this.street = i;
        this.avenue=i1;
        this.cargaRestante = cargaRestante;
        setIcon(new Bicon("solar_panel.jpg"));
        city.setPanelSolar(this);        
    }

    public int getStreet() {
        return street;
    }

    public void setStreet(int street) {
        this.street = street;
    }

    public int getAvenue() {
        return avenue;
    }

    public void setAvenue(int avenue) {
        this.avenue = avenue;
    }

    public int getCargaRestante() {
        return cargaRestante;
    }

    public void setCargaRestante(int cargaRestante) {
        this.cargaRestante = cargaRestante;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
