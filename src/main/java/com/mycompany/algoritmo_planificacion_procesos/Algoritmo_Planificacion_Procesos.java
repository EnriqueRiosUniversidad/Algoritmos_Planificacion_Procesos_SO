/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.algoritmo_planificacion_procesos;

/**
 *
 * @author wwwal
 */
public class Algoritmo_Planificacion_Procesos {

    public static void main(String[] args) {
        Proceso A = new Proceso("A", 1, 3, 2);
        Proceso B = new Proceso("B", 0, 2, 1);
        Proceso C = new Proceso("C", 1, 5, 3);
        Proceso D = new Proceso("D", 3, 1, 5);
        Proceso E = new Proceso("E", 2, 2, 3);
        
    FCFS.addProceso(A);
    FCFS.addProceso(B);
    FCFS.addProceso(C);
    FCFS.addProceso(D);
    FCFS.addProceso(E);
    
    FCFS.calcular_Representacion_Procesos();
    FCFS.imprimirRepresentacion();
    
    }
}
