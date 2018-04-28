/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fgutierrezf;

import becker.robots.City;
import becker.robots.Direction;
import co.edu.unal.poo.fgutierrezf.Drone;
import java.util.Scanner;
/**
 *
 * @author Estudiante
 */
public class Monitor extends Drone{
    
    private String tipodeCamara;
    private Planta planta;

    public Monitor(Ciudad city, int i, int i1, Direction direccion, int nThing) {
        super(city, i, i1, direccion, nThing);
        this.tipodeCamara = tipodeCamara;
    }
    
    @Override
    public void consumirEnergia(){
        this.energia -= 1;
    }
    @Override
    public void recorrerZonaRectangular(int cantidad) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < cantidad-1; j++) {
                this.move();
            }
            this.turnRight();
        }
    }
    
    

    public void monitorearZonaRectangular(int distancia, double humedad, double temperatura, 
            Sembrador ayudante, int cantFertilizante){
        for (int i = 0; i < 4; i++) {
            
            for (int j = 0; j < distancia-1; j++) {
                if (this.canPickThing()==true) {
                    this.medirFertilizante(cantFertilizante, this.getStreet(), this.getAvenue(), ayudante);
                    this.realizarMonitoreoTempHum(humedad, temperatura, this.getStreet(), this.getAvenue());
                    System.out.println("Temperatura: " + this.getPlanta().getTemperatura());
                }
                this.move();
            }
            this.turnRight();
        }
        this.planta = null;
    }
    

    
    public int realizarMonitoreoTempHum(double humedad, double temp, int x, int y){
        for (int i = 0; i < this.getCiudad().getPlantas().size(); i++) {
            if (this.getCiudad().getPlantas().get(i).getStreet()==x && this.getCiudad().getPlantas().get(i).getAvenue()==y) {
                this.planta = this.getCiudad().getPlantas().get(i);
            }
            if (temp!=this.planta.getTemperatura() || humedad!=this.planta.getHumedad()) {
                this.planta.cambiarColor();
            }
        }
        return 0;
    }
    
    public int medirFertilizante(int cantFertilizante, int x, int y, Sembrador ayudante){
        for (int i = 0; i < this.getCiudad().getPlantas().size(); i++) {
            if (this.getCiudad().getPlantas().get(i).getStreet()==x && this.getCiudad().getPlantas().get(i).getAvenue()==y) {
                this.planta = this.getCiudad().getPlantas().get(i);
                System.out.println(planta.getCantidadFertilizante());
            }
            if (cantFertilizante>this.planta.getCantidadFertilizante()) {
                ayudante.irACoordenada(this.getStreet(), this.getAvenue());
                this.planta.adicionarFertilizante(20); 
                System.out.println("Fertilizante" + planta.getCantidadFertilizante());
                ayudante.irACoordenada(0, 2);
            }
        }
        return 0;
        
    }
    
    public boolean ponerFertilizante(int x, int y, int cantidadFertilizante){
        return false;
    }

    @Override
    public int getEnergia() {
        return this.energia;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }


    
    
}
