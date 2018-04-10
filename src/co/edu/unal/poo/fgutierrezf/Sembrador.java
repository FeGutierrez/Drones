/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fgutierrezf;

import becker.robots.City;
import becker.robots.Direction;
import unal.poo.practica.Drone;

/**
 *
 * @author Estudiante
 */
public class Sembrador extends Drone {
    
    private int semillas;

    public Sembrador(int semillas, City city, int i, int i1, Direction direccion, int nThing) {
        super(city, i, i1, direccion, nThing);
        this.semillas = semillas;
    }

       
    @Override
    public int consumirEnergia(){
        return this.combustible -= 1;
    }
    
    public boolean sembrar(Planta planta){
        if (this.semillas>0) {
            return true;
        }
        return false;
    }
    
    
}
