/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.poo.fgutierrezf;

import becker.robots.*;
import unal.poo.practica.Bicon;

/**
 *
 * @author Estudiante
 */
public class Planta extends Thing{
    
    private double humedad;
    private double temperatura;
    private int cantidadFertilizante;
    private String color;
    
    public Planta(City city, int i, int i1, double humedad, double temperatura, int cantidadFertilizante) {
        super(city, i, i1);
        //setColor(Color.red);
        this.humedad = humedad;
        this.temperatura = temperatura;
        this.cantidadFertilizante = cantidadFertilizante;
         setIcon(new Bicon("SuperMario.gif"));
    }
    public boolean adicionarFertilizante(int cantFertilizante){
        if (cantFertilizante>=0) {
            return true;
        }
        return false;
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
        
    }
    
    
    
    
    
}
