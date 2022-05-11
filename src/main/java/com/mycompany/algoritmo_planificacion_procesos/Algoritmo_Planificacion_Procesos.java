/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.algoritmo_planificacion_procesos;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author wwwal
 */
public class Algoritmo_Planificacion_Procesos {


    public static void main(String[] args) {
     
    String archivo= "C:\\Users\\wwwal\\Escritorio\\Algoritmos_Planificacion_Procesos_SO\\procesos1.csv";
    LeerArchivo leerArchivo= new LeerArchivo();
    ArrayList<Proceso> procesos= leerArchivo.leerArchivo(archivo);
    
        
   // ArrayList<Proceso> auxdatos, ArrayList<String> nombresProcesos
    
    FCFS.setProcesos(procesos);
    FCFS.calcular_Representacion_Procesos();
    FCFS.imprimirRepresentacion();
    
    tabla_ver();
    
    Prioridad.setProcesos(procesos);
    Prioridad.ejecutar();
    Prioridad.imprimirRepresentacion();
    
    tabla_ver();
    
    
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
    private static void tabla_ver(){
        String proceso_NAME;
    int posicion=0;
    ArrayList<String> representacion_Rafagas = Algoritmo.getRepresentacion_Rafagas();
    for (int i=0; i< Algoritmo.getCantidad_De_Procesos(); i++ ){
        proceso_NAME = Algoritmo.getProcesos().get(i).getNombre(); //guardamos el nombre
        while(representacion_Rafagas.contains(proceso_NAME)){
            
            if(representacion_Rafagas.get(posicion).equals(proceso_NAME)){
                System.out.print("| "+ proceso_NAME + " |");
                representacion_Rafagas.set(posicion, "");
            }else
            {System.out.print("| "+ "_" + " |");}
            posicion++;
            
            
        }
        posicion=0;
        for(int j=posicion; j< Algoritmo.getTotal_Rafagas();j++){
        System.out.print("| "+ "_" + " |");
        }
        
        System.out.println("");
               
    }
    
    }
}




    

    
   