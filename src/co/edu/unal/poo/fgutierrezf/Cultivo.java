/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fgutierrezf;

import becker.robots.*;
import java.util.ArrayList;
import unal.poo.practica.Drone;

/**
 *
 * @author Estudiante
 */
public class Cultivo extends City {
    private int largo;
    private int ancho;
    private ArrayList<Thing> objetos;
    private Drone[] drones;

    public Cultivo(int largo, int ancho) {
        this.largo = largo;
        this.ancho = ancho;
        this.objetos = new ArrayList<>();
        this.drones = new Drone[2];
    }
    
    //Realizar monitoreo
    public boolean realizarMonitoreo(double humedad, double temp){
        return false;
    }
    
    //Medir Fertilizante
    public boolean medirFertilizante(int cantFertilizante){
        return false;
    }
    
    //Poner Fertilizante
    public boolean ponerFertilizante(int x, int y, int cantidad){
        return false;
    }
    
    //Sembrar
    public boolean sembrar(double humedad, double temperatura,
            int fertilizante, int x, int y){
        return false;
    }
    //Añadir planta
    public boolean addPlanta(){
        return false;
    }
    //Añadir panel
    public boolean addPanel(){
        return false;
    }
    //Añadir drone
    public boolean addDrone(){
        return false;
    }

    
    
}
