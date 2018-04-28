package co.edu.unal.poo.fgutierrezf;

import becker.robots.*;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class RobotBase
{    
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
            estudiante = new Sembrador(5,objetos,0, 2, Direction.EAST,10);
            estudiante2 = new Monitor(objetos,1, 3, Direction.EAST,10);
            
            Monitor estudiante3 = new Monitor(objetos,0, 0, Direction.EAST,10);
            
            Robot robot = new Robot(objetos, 0, 0, Direction.SOUTH);
            
            System.out.println("Av:" + robot.getAvenue());
            System.out.println("St:" + robot.getStreet());
            
            panel1 = new Panel(objetos, 4, 3, 10);
            
            //estudiante3.irACoordenada(3, 3);
            
            estudiante.recorrerZonaRectangular(3);
//          

            estudiante2.irACoordenada(0, 2);
//            estudiante2.realizarMonitoreo(0, 0, 1, 4);
            estudiante2.monitorearZonaRectangular(3,3,3, estudiante, 5);
            estudiante2.irACoordenada(-1, -1);
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
            //Thread.sleep(500);
            //semaforo.cambiarEstado();
           
            
            
	}
        
        public static void creacionFuncion(int parametroEntrada){
            for (int i = 0; i < parametroEntrada; i++) 
                estudiante.move();
        }
}

