/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.algoritmo_planificacion_procesos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *Esta clase consiste en poder leer un archivo con formato .cvs y luego almacenar sus valores dentro
 * del ArrayList de la clase Procesos
 * @author Lenovo
 */
public class LeerArchivo {

    public LeerArchivo() {
        this.Procesos = new ArrayList();
    }

    public ArrayList<Proceso> leerArchivo(String nombre_cvs) {
        try {
            lector = new BufferedReader(new FileReader(nombre_cvs));
            //Almacena la primera linea del archivo que serian los titulos 
            String IgnoreTitle = lector.readLine();
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(",");
                proceso = new Proceso(partes[CERO],
                        Integer.parseInt(partes[UNO]),
                        Integer.parseInt(partes[DOS]),
                        Integer.parseInt(partes[TRES]));
                Procesos.add(proceso);
            }
            lector.close();
            linea = null;
            partes = null;
            proceso = null;

        } catch (IOException | NumberFormatException e) {
            System.out.println("Localization: " + e.getLocalizedMessage() + " Message: " + e.getMessage());
        }
        return Procesos;
    }

    private String[] partes;//almacena cada linea
    private BufferedReader lector;//lee el archivo
    private String linea; //recibe la linea de cada fila
    private Proceso proceso;
    private final ArrayList<Proceso> Procesos;
    private String[] prueba;
    //Constantes
    private final int CERO = 0;
    private final int UNO = 1;
    private final int DOS = 2;
    private final int TRES = 3;
}