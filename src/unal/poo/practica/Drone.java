/*
Imagenes tomadas de:
 https://www.flaticon.com/free-icon/drone_90905
 */
package unal.poo.practica;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;

/**
 *
 * @author Fabian Giraldo
 */
public abstract class Drone extends Robot{
    
    protected String icono;
    protected int combustible;
    
    public Drone(City city, int i, int i1, Direction drctn, int i2) {
        super(city, i, i1, drctn, i2);
        setIcon(new Bicon("drone1.png"));
    }
    
    
    @Override
    public synchronized void move(){
        super.move();
        consumirEnergia();
    }
    
    public abstract int consumirEnergia();
    
    
    
    
    public int cargarEnergia(int cargaAdicional){
        return this.combustible += cargaAdicional;
    }
    
    public int medirDistancia(int x, int y){
        return 0;
    }
    
    public void irZonadeCarga(int x,int  y, int a, int b){
        
    }

    
}
