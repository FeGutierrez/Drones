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
import java.util.Scanner;
/**
 *
 * @author Estudiante
 */
public class Monitor extends Drone{
    
    private String tipodeCamara;
    private Planta planta;
    private int stOrigen;
    private int avOrigen;

    public Monitor(Ciudad city, int i, int i1, Direction direccion, int nThing) {
        super(city, i, i1, direccion, nThing);
        this.tipodeCamara = tipodeCamara;
    }
    
    @Override
    public void consumirEnergia(){
        this.energia -= 1;
    }
    
    
    
    public void monitZonaRectangular(int distancia, double humedad, double temperatura, 
            Sembrador ayudante, int cantFertilizante) {
        int j=0;
        while (j < distancia-1) {            
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
                this.monitor(distancia, humedad, temperatura, ayudante, cantFertilizante);                
                this.move();
                j+=1;
        }
        this.turnLeft();
        for (int i = 0; i < distancia; i++) {
            j=0;
            
            while (j < distancia-(i+1)) {
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
                this.monitor(distancia, humedad, temperatura, ayudante, cantFertilizante);
                this.move();
                j+=1;
            }
            this.turnLeft();
            j=0;
            while (j < distancia-(i+1)) { 
                this.monitor(distancia, humedad, temperatura, ayudante, cantFertilizante);
                this.move();
                j+=1;
            }
            this.turnLeft();
        }
        this.monitor(distancia, humedad, temperatura, ayudante, cantFertilizante);
        this.irAlOrigen();
    }
        public void irAlOrigen(){
        this.irACoordenada(this.stOrigen,this.avOrigen);
    }
    
    public void monitor(int distancia, double humedad, double temperatura, 
            Sembrador ayudante, int cantFertilizante){
        if (this.canPickThing()==true) {
            this.medirFertilizante(cantFertilizante, this.getStreet(), this.getAvenue(), ayudante);
            this.realizarMonitoreoTempHum(humedad, temperatura, this.getStreet(), this.getAvenue());
            System.out.println("Temperatura: " + this.getPlanta().getTemperatura());
        }        
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
                int st = ayudante.getStreet();
                int av = ayudante.getAvenue();
                ayudante.irACoordenada(this.getStreet(), this.getAvenue());
                this.planta.adicionarFertilizante(20); 
                System.out.println("Fertilizante" + planta.getCantidadFertilizante());
                ayudante.irACoordenada(st, av);
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

    @Override
    public void recorrerZonaRectangular(int cantidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //Este metodo no se uso, porque los atributos esperados son diferenes a los del sembrador
    }
    
    //    public void monitorearZonaRectangular(int distancia, double humedad, double temperatura, 
//            Sembrador ayudante, int cantFertilizante){
//        for (int i = 0; i < 4; i++) {
//            
//            for (int j = 0; j < distancia-1; j++) {
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
//                if (this.canPickThing()==true) {
//                    this.medirFertilizante(cantFertilizante, this.getStreet(), this.getAvenue(), ayudante);
//                    this.realizarMonitoreoTempHum(humedad, temperatura, this.getStreet(), this.getAvenue());
//                    System.out.println("Temperatura: " + this.getPlanta().getTemperatura());
//                }
//                this.move();
//            }
//            this.turnRight();
//        }
//        this.planta = null;
//    }



    
    
}
