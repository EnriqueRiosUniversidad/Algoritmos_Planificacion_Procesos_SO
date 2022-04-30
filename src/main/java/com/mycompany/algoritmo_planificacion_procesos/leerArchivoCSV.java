/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.algoritmo_planificacion_procesos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class leerArchivoCSV {


    private String[] partes;//almacena cada linea
    private BufferedReader lector;//lee el archivo
    private String linea; //recibe la linea de cada fila
    private Proceso proceso;
    private ArrayList<Proceso> Procesos;
    
    public ArrayList<Proceso> leerArchivo(String nombre_cvs) {
      int contador=0;
        try {
            lector = new BufferedReader(new FileReader(nombre_cvs));
                        
            
            int posicion= 4;
           //Va guardando los elementos de cada proceso
           //a travez de la variable posicion, que empieza en 4 y termina en 7, para luego
           //incrementar 1 y volver a usarse en la lectura de otro proceso nuevo.
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(",");
           
                 proceso = new Proceso(partes[posicion],
                         Integer.parseInt(partes[++posicion]),
                         Integer.parseInt(partes[++posicion]),
                         Integer.parseInt(partes[++posicion]));   
                 posicion++;
                 Procesos.add(proceso);
             
               // imprimirLinea();
                System.out.println("");
            }
            
            lector.close();
            linea = null;
            partes = null;
             proceso = null;
            contador++;

        } catch (Exception e) {
            System.out.println("Localization: " + e.getLocalizedMessage() + " Message: " + e.getMessage());
        }
        return Procesos;
    }
/*
    public void imprimirLinea() {
        for (int i = 0; i < Procesos.size(); i++) {
            System.out.println(i+ "Rafagas: " +Procesos.get(i).getRafaga() + "|");
        }
    }
*/
}

