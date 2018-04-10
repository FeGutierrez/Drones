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
public class Monitor extends Drone{
    
    private String tipodeCamara;

    public Monitor(City city, int i, int i1, Direction direccion, int nThing) {
        super(city, i, i1, direccion, nThing);
        this.tipodeCamara = tipodeCamara;
    }
    
    @Override
    public int consumirEnergia(){
        return this.combustible -= 1;
    }
    
    public int realizarMonitoreo(double humedad, double temp, int x, int y){
        return 0;
    }
    
    public int medirFertilizante(int cantFertilizante, int x, int y){
        return 0;
        
    }
    
    public boolean ponerFertilizante(int x, int y, int cantidadFertilizante){
        return false;
    }
}
