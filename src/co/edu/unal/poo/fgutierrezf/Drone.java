/*
Imagenes tomadas de:
 https://www.flaticon.com/free-icon/drone_90905
 */
package co.edu.unal.poo.fgutierrezf;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;

/**
 *
 * @author Fabian Giraldo
 */
public abstract class Drone extends Robot{
    
    protected String icono;
    protected int energia;
    
    public Drone(City city, int i, int i1, Direction direccion, int nThing) {
        super(city, i, i1, direccion, nThing);
        this.energia = nThing;
        setIcon(new Bicon("drone1.png"));
    }
    
    
    @Override
    public synchronized void move(){
        super.move();
        consumirEnergia();
    }
    
    public abstract void consumirEnergia();
    
    public void cargarEnergia(int cargaAdicional){
        if(cargaAdicional>0){
            this.energia += cargaAdicional;
        }
    }
    
    public int medirDistancia(int x, int y){
        return 0;
    }
    
    public boolean irZonadeCarga(int x,int  y, int a, int b){
        return false;
    }

    
}
