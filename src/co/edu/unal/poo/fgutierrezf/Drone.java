/*
Imagenes tomadas de:
 https://www.flaticon.com/free-icon/drone_90905
 */
package co.edu.unal.poo.fgutierrezf;

//import becker.robots.City;
import co.edu.unal.poo.fgutierrezf.Ciudad;
import becker.robots.Direction;
import becker.robots.Robot;
import co.edu.unal.poo.fgutierrezf.Panel;

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
        if (this.energia>0) {
            super.move();
            consumirEnergia();
            System.out.println("Energia: " + this.energia);
        }
    }
    
    
    public void irPanelEnergia(){
        int a = this.getCiudad().getPanelSolar().getStreet();
        int b = this.getCiudad().getPanelSolar().getAvenue();
        irACoordenada(a, b);
    }
    
    public void recargarEnergia(){
        this.irPanelEnergia();
        this.cargarEnergia(this.getCiudad().getPanelSolar().getCargaRestante());
        
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
            int i=0;
            while (i<cargaAdicional) {                
                this.energia += 1;
                this.ciudad.getPanelSolar().setCargaRestante(cargaAdicional-(i+1));
                System.out.println("Energia drone " + this.energia);
                System.out.println("Energia panel: " + this.ciudad.getPanelSolar().getCargaRestante());
                i +=1;
            }
            
            
        }
    }
    
    public int medirDistancia(int x, int y){
        return 0;
    }
    
    public boolean irZonadeCarga(int x,int  y, int a, int b){
        return false;
    }
    
    public int calcularDistanciaAPanel(){
        int a = this.ciudad.getPanelSolar().getStreet();
        int b = this.ciudad.getPanelSolar().getAvenue();
        int c = this.getStreet();
        int d = this.getAvenue();
        int y=(a-c);
        int x=(b-d);
        int res=0;
        //a = y2 b = x2
        if (y<0) {
            y *= -1;
        }
        if (x<0) {
            x *= -1;
        }
        res = x+y;
        
        return res;
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
