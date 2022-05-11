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
        LeerArchivo csv = new LeerArchivo();
        SJFExpulsivo algoritmos = new SJFExpulsivo();
        ArrayList<Proceso> datos = new ArrayList();
        datos = csv.leerArchivo("C:\\Users\\Lenovo\\Desktop\\procesos - Hoja 1.csv");
        //csv.imprimirLinea();
        algoritmos.SJFExpulsivo(datos);
        algoritmos.imprimir();

    }
}
