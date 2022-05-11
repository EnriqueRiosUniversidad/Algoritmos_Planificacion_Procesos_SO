/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.algoritmo_planificacion_procesos;

import java.util.ArrayList;

/**
 *
 * @author wwwal
 */
public class Algoritmo_Planificacion_Procesos {

    public static void main(String[] args) {
        //String nombre, int tiempo_De_Llegada, int cantidad_De_Rafagas, int prioridad
        Proceso A = new Proceso("A", 1, 3, 2);
        Proceso B = new Proceso("B", 0, 2, 1);
        Proceso C = new Proceso("C", 1, 5, 3);
        Proceso D = new Proceso("D", 3, 1, 5);
        Proceso P = new Proceso("P", 2, 2, 2);
       // Proceso E = new Proceso("E", 2, 2, 4);
    /*    
    FCFS.addProceso(A);
    FCFS.addProceso(B);
    FCFS.addProceso(C);
    FCFS.addProceso(D);
    FCFS.addProceso(E);
    
    FCFS.calcular_Representacion_Procesos();
    FCFS.imprimirRepresentacion();
    */
    
    Prioridad.addProceso(A);
    Prioridad.addProceso(B);
    Prioridad.addProceso(C);
    Prioridad.addProceso(D);
    Prioridad.addProceso(P);
    
    
    Prioridad.ejecutar();
    Prioridad.imprimirRepresentacion();
    /*
    
    String proceso_NAME;
    int posicion=0;
    ArrayList<String> representacion_Rafagas = Prioridad.getRepresentacion_Rafagas();
    for (int i=0; i< Prioridad.getCantidad_De_Procesos(); i++ ){
        proceso_NAME = Prioridad.getProcesos().get(i).getNombre(); //guardamos el nombre
        while(representacion_Rafagas.contains(proceso_NAME)){
            
            if(representacion_Rafagas.get(posicion).equals(proceso_NAME)){
                System.out.print("| "+ proceso_NAME + " |");
                representacion_Rafagas.set(posicion, "");
            }else
            {System.out.print("| "+ "_" + " |");}
            posicion++;
            
            
        }
        posicion=0;
        for(int j=posicion; j< Prioridad.getTotal_Rafagas();j++){
        System.out.print("| "+ "_" + " |");
        }
        
        System.out.println("");
        
        
        
    }
    */
    }
}


/*if(proceso_Actual.getPrioridad() == cola_espera.get(0).getPrioridad())//para evitar que un proceso 
                                                //ya en ejecucion sea frenado por otro de igual prioridad
       {
           proc_aux = cola_espera.get(0);
           cola_espera.remove(0);
           Prioridad.ord_Proc_Min_Prioridad(cola_espera);
           cola_espera.add(0, proceso_Actual);
           cola_espera.add(proc_aux);
           
       }*/