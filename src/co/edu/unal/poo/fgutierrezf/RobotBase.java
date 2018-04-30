package co.edu.unal.poo.fgutierrezf;

import becker.robots.*;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class RobotBase
{    
    
        //Al llegar el combustible de un Robot a Cero, la estructura que he adoptado detiene todo el proceso.
        //¿Con el uso de threads se elimina ese inconveniente?
        //¿Hay una función que detenga un robot, sin necesidad de usar un break éxplicito?
    //La condicion del combustible para retornar la coloque en la distancia+1 para asegurar que el robot llegara al panel
    //Ya que hay casos como por ejemplo interseccion_sub_1: Combustible 5 Distancia: 4
    //E interseccion_sub_2 Combustible 4 Distancia 5 En ese caso el robot se quedará sin energia antes de siquiera llegar al panel
    //Pendiente **Modificar el constuctor del icon para las flores marchitas
        
       //Declaracion de Variables -- Forma temporal - No es buena practica tener
       //variables estaticas
        //public static City objetos;
        public static Ciudad objetos;
        public static Sembrador estudiante;
        public static Monitor estudiante2;
        public static Panel panel1;
        
        
//        public static void irStreet(Robot robot, int street){
//            
//            if (robot.getStreet() > street) {
//                while(robot.getDirection()!=Direction.NORTH){
//                    robot.turnLeft();
//                }
//            }
//
//
//            if (robot.getStreet() < street) {
//                while(robot.getDirection()!=Direction.SOUTH){
//                    robot.turnLeft();
//                }
//            }
//            while(robot.getStreet()!=street){
//                robot.move();
//            }
//        }
//        
//        public static void irAvenue(Robot robot, int avenue){
//            if (robot.getAvenue()>avenue) {
//                while(robot.getDirection()!=Direction.WEST){
//                    robot.turnLeft();
//                }
//            }
//            if (robot.getAvenue()< avenue) {
//                while(robot.getDirection()!=Direction.EAST){
//                    robot.turnLeft();
//                }
//            }
//            while (robot.getAvenue()!=avenue) {                
//                robot.move();
//            }
//        }
//        
//        public static void coordenadaRobot(Robot robot, int street, int avenue){
//            irStreet(robot, street);
//            irAvenue(robot, avenue);
//        }
        //Streets son Y, Avenues son X
	public static void main (String[] args) throws InterruptedException{
            //Declarar la creacion de la ciudad
            //objetos = new City("Field.txt");
            objetos = new Ciudad("Field.txt");
            objetos.showThingCounts(true);
            
            //Direction.NORTH, EAST, SOUTH, WEST
            //Definicion de la ubicacion del robot, Ciudad, posicion, Direccion, Numero things en el bolso.
            estudiante = new Sembrador(100,objetos,0, 0, Direction.EAST,100);
            estudiante2 = new Monitor(objetos,0, 0, Direction.EAST,20);
            
            //Robot robot = new Robot(objetos, 0, 0, Direction.SOUTH);
            
//            System.out.println("Av:" + robot.getAvenue());
//            System.out.println("St:" + robot.getStreet());
            
            panel1 = new Panel(objetos, 4, 3, 25);
            
            //estudiante3.irACoordenada(3, 3);
            
           //estudiante.recorrerZonaRectangular(7);
           estudiante.recorrerZonaRectangular(7);
           Thread.sleep(500);
           Thread.sleep(500);
           estudiante2.monitorearZonaRectangular(7, 20, 20, estudiante, 5);
           estudiante.move();
//          

            //estudiante2.irACoordenada(0, 2);
//            estudiante2.realizarMonitoreo(0, 0, 1, 4);
            //estudiante2.monitorearZonaRectangular(3,3,3, estudiante, 5);
//            estudiante2.irACoordenada(0, 0);
//            
//            System.out.println(objetos.getPanelSolar());
//            System.out.println(estudiante2.calcularDistanciaAPanel());
//            
            //estudiante2.recargarEnergia();
//            System.out.println("Fertilizante: " + estudiante2.getPlanta().getCantidadFertilizante());
//            System.out.println("HUmedad: " +estudiante2.getPlanta().getHumedad());
//            System.out.println("Temperatura: " +estudiante2.getPlanta().getTemperatura());
//            System.out.println(estudiante2.getPlanta().getCantidadFertilizante());
            
        //    estudiante3.irACoordenada(2, 3);
            

            

            
         
            //Semaforo semaforo = new Semaforo(objetos, 0, 6);
	    //Mover una interseccion en el sentido al cual este apuntando el objeto.

            
            //Thing t = estudiante.examineThings(new FlorPred()).next();
            //if(t instanceof Flor){
            //   estudiante.pickThing();
            //}
            //estudiante.recorrerZonaRectangular(3);
////            estudiante.move();
////            estudiante.move();
////            estudiante.sembrar();
////            estudiante.turnLeft();
////            estudiante.turnLeft();
////            estudiante.move();
////            System.out.println(estudiante.getEnergia());
            //semaforo.cambiarEstado();
//            Thread.sleep(500);
            //semaforo.cambiarEstado();
           
            
            
	}
        
        public static void creacionFuncion(int parametroEntrada){
            for (int i = 0; i < parametroEntrada; i++) 
                estudiante.move();
        }
}

