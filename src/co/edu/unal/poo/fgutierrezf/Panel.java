/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fgutierrezf;

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
    
    public Panel(City city, int i, int i1, int cargaRestante) {
        super(city, i, i1);
        this.cargaRestante = cargaRestante;
        setIcon(new Bicon("solar_panel.jpg"));
    }
    
    
    
    
}
