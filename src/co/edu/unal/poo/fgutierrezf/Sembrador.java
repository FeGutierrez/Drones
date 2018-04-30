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
    private int stOrigen;
    private int avOrigen;

    public Sembrador(int semillas, Ciudad city, int i, int i1, Direction direccion, int nThing) {
        super(city, i, i1, direccion, nThing);
        this.stOrigen=i;
        this.avOrigen=i1;
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
        int j=0;
        while (j < cantidad-1) {            
                this.suficienteCombustible();
                this.sembrar(10.0+j+1, 25.0+j, this.semillas*4);
                this.move();
                j+=1;
        }
        this.turnLeft();
        for (int i = 0; i < cantidad; i++) {
            j=0;
            
            while (j < cantidad-(i+1)) {
                this.suficienteCombustible();
                this.sembrar(10.0+j+1, 25.0+j+(i*2), this.semillas*5);
                this.move();
                j+=1;
            }
            this.turnLeft();
            j=0;
            while (j < cantidad-(i+1)) {
                this.suficienteCombustible();
                this.sembrar(10.0+j+1, 25.0+j+i, this.semillas*6);
                this.move();
                j+=1;
            }
            
            this.turnLeft();
        }
        this.sembrar(10.0+j+1, 25.0+j, 14);
        this.irAlOrigen();
        
    }
    
    public void suficienteCombustible(){
        int a = this.calcularDistanciaAPanel();
        System.out.println("Distancia hasta el panel: "+ a);
            if ((this.energia)<=a+1) {
                Direction dirAct = this.getDirection();
                int stAct = this.getStreet();
                int avAct = this.getAvenue();
                this.recargarEnergia();
                this.irACoordenada(stAct, avAct);
                while (this.getDirection()!=dirAct){
                    this.turnLeft();
                }
            }
        
    }
    
    public void irAlOrigen(){
        this.irACoordenada(this.stOrigen,this.avOrigen);
    }
    
    
//    @Override
//    public void recorrerZonaRectangular(int cantidad){
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < cantidad-1; j++) {
//                int a = this.calcularDistanciaAPanel();
//                System.out.println("Distancia hasta el panel: "+ a);
//                if ((this.energia)<=a+1) {
//                    Direction dirAct = this.getDirection();
//                    int stAct = this.getStreet();
//                    int avAct = this.getAvenue();
//                    this.recargarEnergia();
//                    this.irACoordenada(stAct, avAct);
//                    while (this.getDirection()!=dirAct){
//                        this.turnLeft();
//                    }
//                }       
//                this.sembrar(10.0+i+j, 25.0+i-j, this.semillas*3);
//                this.move();
//            }
//            this.turnRight();
//        }
//    }
    
    public boolean sembrar(double humedad, double temperatura, int cantidadFertilizante){
        if (this.semillas>0) {
            //public Planta(City city, int i, int i1, double humedad, double temperatura, int cantidadFertilizante) {
            Planta planta = new Planta(this.getCiudad(), this.getStreet(), this.getAvenue(), humedad, temperatura, cantidadFertilizante);
            this.getCiudad().getPlantas().add(planta);
            planta.setStreet(this.getStreet());
            planta.setAvenue(this.getAvenue());
            this.semillas -= 1;
            return true;
        }
        return false;
    }

}
