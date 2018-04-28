/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fgutierrezf;

import becker.robots.City;
import becker.robots.Direction;
import co.edu.unal.poo.fgutierrezf.Drone;
import co.edu.unal.poo.fgutierrezf.*;

/**
 *
 * @author Estudiante
 */
public class Sembrador extends Drone {
    
    private int semillas;

    public Sembrador(int semillas, Ciudad city, int i, int i1, Direction direccion, int nThing) {
        super(city, i, i1, direccion, nThing);
        this.semillas = semillas;
    }

       
    @Override
    public void consumirEnergia(){
        this.energia -= 1;
    }
    
    public int getEnergia(){
        return this.energia;
    }
    
    @Override
    public void recorrerZonaRectangular(int cantidad){
        for (int i = 0; i < 4; i++) {
            
            for (int j = 0; j < cantidad-1; j++) {
                
                this.move();
                this.sembrar(10.0+i+j, 25.0+i-j, this.semillas*3);
                
            }
            this.turnRight();
        }
    }
    
    public boolean sembrar(double humedad, double temperatura, int cantidadFertilizante){
        if (this.semillas>0) {
            //public Planta(City city, int i, int i1, double humedad, double temperatura, int cantidadFertilizante) {
            Planta planta = new Planta(this.getCity(), this.getStreet(), this.getAvenue(), humedad, temperatura, cantidadFertilizante);
            this.getCiudad().getPlantas().add(planta);
            planta.setStreet(this.getStreet());
            planta.setAvenue(this.getAvenue());
            this.semillas -= 1;
            return true;
        }
        return false;
    }
    
    
    
    
}
