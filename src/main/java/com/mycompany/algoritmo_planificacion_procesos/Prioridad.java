/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.algoritmo_planificacion_procesos;

import java.util.ArrayList;

/**
 *
 * @author wwwal
 */
public class Prioridad extends Algoritmo{


    
    
    
    

/*carga una cantidad X en la representacion de procesos.*/
public static void cargar_representacion(int rafagas, Proceso proceso){
    ArrayList<String> representacion_Rafagas =
    Prioridad.getRepresentacion_Rafagas();
        
    for(int i=0; i< rafagas; i++){
        representacion_Rafagas.add(proceso.getNombre());
    }
    Prioridad.setRepresentacion_Rafagas(representacion_Rafagas);
}    

/*
*Cuenta las rafagas que hay entre un proceco p y el proceso mas proximo que tenga
prioridad mas alta.
o directamente devuelve todas las rafagas del proceso p, si es que
es el de mayor o solo hay iguales en prioridad durante su tiempo de vida.
-----------------------
0 si en ese tiempo ya hay otro proceso de mayor prioridad.

Se asume que el arreglo de procesos esta ordenado por tiempo de llegada. de tempranero a ultimo.S
*/
public static void cargar_proceso (Proceso p){
    
  
}

/** se debe ejecutar mientras hayan procesos con rafagas mayores a 0
 * 
 */
public static void ejecutar(){
    int aux, tiempo=0;
    int proceso_posicion=0;
   Proceso proceso_Actual = getProcesos().get(0); 
   Proceso proc_aux;
   cola_espera.add(proceso_Actual);
    ArrayList<String> Rep_temp = getRepresentacion_Rafagas();
   //Mientras hayan procesos.
   while(!cola_espera.isEmpty()){
       proceso_Actual = cola_espera.get(0); //rescato y
       cola_espera.remove(0); //saco de la cola
       
       tiempo++;
       Rep_temp.add(proceso_Actual.getNombre());
       
       
       
       /*Restamos las rafagas pendientes.*/
       aux = proceso_Actual.getCantidad_De_Rafagas();
       aux--;
       proceso_Actual.setCantidad_De_Rafagas( aux);
       
       cola_espera.add(0,proceso_Actual); //volvemos a poner en cola.
       
       if(hay_procesos_en_tiempo_T(tiempo)){//Cargamos procesos si hay en ese tiempo.           
           cargar_procesos_tiempo_T(tiempo);
       }
       remover_procesos_finalizados(); 
       
       
   }
  Prioridad.setRepresentacion_Rafagas(Rep_temp);
   
    
}


private static boolean hay_procesos_en_tiempo_T(int tiempo_actual){
    for(int i=0; i< getCantidad_De_Procesos(); i++){
        if(getProcesos().get(i).getTiempo_De_Llegada()== tiempo_actual)return true;     
    }
    return false;
}

private static void cargar_procesos_tiempo_T(int tiempo_actual){
          for(int i=0; i< getCantidad_De_Procesos(); i++){
        if(getProcesos().get(i).getTiempo_De_Llegada()== tiempo_actual)
            cola_espera.add(getProcesos().get(i));//Metemos en la cola el proceso.
    }
    Prioridad.ord_Proc_Min_Prioridad(cola_espera); //Ordenamos.
}

/*Elimina los procesos que tienen rafaga == 0*/
private static boolean remover_procesos_finalizados(){
    for(int i=0; i< cola_espera.size(); i++){
        if(cola_espera.get(i).getCantidad_De_Rafagas() <= 0){ 
            cola_espera.remove(i);
            return true;
        
        }
    }
    return false;
}




/*Averigua si aun hay procesos con rafagas pendientes.*/
public static boolean hay_procesos_pendientes(){
    
   for (int i=0; i< getCantidad_De_Procesos(); i++){
       if ( getProcesos().get(i).getCantidad_De_Rafagas() > 0 ) return true;
    }
    return false;
}

private ArrayList<ArrayList<Proceso>> Prioridades = new ArrayList();


private static ArrayList<Proceso> cola_espera= new ArrayList();


public static void imprimirRepresentacion(){
    System.out.println("");
    System.out.println("");
    System.out.println("-----------------------Algoritmo de PRIORIDAD----------------------- ");
    
    Algoritmo.imprimirRepresentacion();
    System.out.println("");
    System.out.println("");
}
}

/*
    Este algoritmo seguira ejecutandose hasta
que todos los procesos tengan su contador de rafagas en 0.
entonces significara que todos se han ejecutado.

*/