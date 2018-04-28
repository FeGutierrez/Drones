/*
Imagenes tomadas de:
 https://www.flaticon.com/free-icon/drone_90905
 */
package co.edu.unal.poo.fgutierrezf;

import becker.robots.City;
import co.edu.unal.poo.fgutierrezf.Ciudad;
import becker.robots.Direction;
import becker.robots.Robot;

/**
 *
 * @author Fabian Giraldo
 */
public abstract class Drone extends Robot{
    
    protected String icono;
    protected int energia;
    private Ciudad ciudad;
    
    public Drone(Ciudad city, int i, int i1, Direction direccion, int nThing) {
        super(city, i, i1, direccion, nThing);
        this.ciudad = city;
        this.energia = nThing;
        setIcon(new Bicon("drone1.png"));
    }
    
    
    @Override
    public synchronized void move(){
        super.move();
        consumirEnergia();
    }
    
    public void irStreet(int street){

        if (this.getStreet() > street) {
            while(this.getDirection()!=Direction.NORTH){
                this.turnLeft();
            }
        }


        if (this.getStreet() < street) {
            while(this.getDirection()!=Direction.SOUTH){
                this.turnLeft();
            }
        }
        while(this.getStreet()!=street){
            this.move();
        }
    }

    public void irAvenue(int avenue){
        if (this.getAvenue()>avenue) {
            while(this.getDirection()!=Direction.WEST){
                this.turnLeft();
            }
        }
        if (this.getAvenue()< avenue) {
            while(this.getDirection()!=Direction.EAST){
                this.turnLeft();
            }
        }
        while (this.getAvenue()!=avenue) {                
            this.move();
        }
    }

    public void irACoordenada(int street, int avenue){
        irStreet(street);
        irAvenue(avenue);
        while (this.getDirection()!=Direction.EAST) {            
            this.turnLeft();
        }
    }
    
    public abstract int getEnergia();
    
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
    
    public void turnRight(){
        for (int i = 0; i < 3; i++) {
            this.turnLeft();
        }        
    }
    
    public abstract void recorrerZonaRectangular(int cantidad);

    public Ciudad getCiudad() {
        return ciudad;
    }
    
    

    
}
