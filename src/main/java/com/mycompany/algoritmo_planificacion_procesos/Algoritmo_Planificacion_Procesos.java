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
    /*
    Prioridad.addProceso(A);
    Prioridad.addProceso(B);
    Prioridad.addProceso(C);
    Prioridad.addProceso(D);
    Prioridad.addProceso(P);
    */
    
    //Prioridad.ejecutar();
    //Prioridad.imprimirRepresentacion();
    
    
    
    
    String archivo= "C:\\Users\\wwwal\\Escritorio\\Algoritmos_Planificacion_Procesos_SO\\procesos1.csv";
    LeerArchivo leerArchivo= new LeerArchivo();
    ArrayList<Proceso> procesos= leerArchivo.leerArchivo(archivo);
    
    
    FCFS.setProcesos(procesos);
    FCFS.calcular_Representacion_Procesos();
    FCFS.imprimirRepresentacion();
    
    Prioridad.setProcesos(procesos);
    Prioridad.ejecutar();
    Prioridad.imprimirRepresentacion();

    tabla_Procesos = new JTable();
    
    
    
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
    
 
    
    /*Carga los procesos.*/
     public static  ArrayList<Proceso> cargarProceso(){
     Proceso A = new Proceso("A", 1, 3, 2);
        Proceso B = new Proceso("B", 0, 2, 1);
        Proceso C = new Proceso("C", 1, 5, 3);
        Proceso D = new Proceso("D", 3, 1, 5);
        Proceso P = new Proceso("P", 2, 2, 2);
        ArrayList<Proceso> procesos= new ArrayList();
       /* procesos.add(A);
        procesos.add(B);
        procesos.add(C);
        procesos.add(D);
        procesos.add(P);*/
        Algoritmo.addProceso(A);
        Algoritmo.addProceso(B);
        Algoritmo.addProceso(C);
        Algoritmo.addProceso(D);
        Algoritmo.addProceso(P);
        
        
    return Algoritmo.getProcesos();
    }
 
     public static void llenar_tabla_procesos(){
         int numero_filas = Algoritmo.getCantidad_De_Procesos();
         DefaultTableModel modeloDefault;     
         modeloDefault = new DefaultTableModel(
                 new String[]{"nombre", "T Llegada", "N Rafagas", "Prioridad"},
                 numero_filas );
         
         tabla_Procesos.setModel(modeloDefault);
         
        TableModel modelo_Datos = tabla_Procesos.getModel();
        
         
         Proceso proceso;
         for(int i=0; i<Algoritmo.getCantidad_De_Procesos();i++){
             proceso = Algoritmo.getProcesos().get(i);
             modelo_Datos.setValueAt(proceso.getNombre(), i, 0);
             modelo_Datos.setValueAt(proceso.getTiempo_De_Llegada(), i, 1);
             modelo_Datos.setValueAt(proceso.getCantidad_De_Rafagas(), i, 2);
             modelo_Datos.setValueAt(proceso.getPrioridad(), i, 3);
             
         }
         
     }
     
     
     /*Variables*/
 
     private static javax.swing.JTable tabla_Procesos;
}

