/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fgutierrezf;

import becker.robots.*;
import co.edu.unal.poo.fgutierrezf.Bicon;

/**
 *
 * @author Estudiante
 */
public class Planta extends Thing{
    
    private double humedad;
    private double temperatura;
    private int cantidadFertilizante;
    private Bicon color;
    private int street;
    private int avenue;
    
    public Planta(City city, int i, int i1, double humedad, double temperatura, int cantidadFertilizante) {
        super(city, i, i1);
        //setColor(Color.red);
        this.humedad = humedad;
        this.temperatura = temperatura;
        this.cantidadFertilizante = cantidadFertilizante;
        setIcon(new Bicon("flower.png"));
    }
    public boolean adicionarFertilizante(int cantFertilizante){
        if (cantFertilizante>=0) {
            this.cantidadFertilizante+=cantFertilizante;
            return true;
        }
        return false;
    }

    public double getHumedad() {
        return humedad;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public int getCantidadFertilizante() {
        return cantidadFertilizante;
    }
        
    public void setHumedad(double humedad) {
        this.humedad = humedad;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
    
    public void cambiarColor(){
        setIcon(new Bicon("SuperMario.gif"));
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
    
    
    
    
    
    
}
