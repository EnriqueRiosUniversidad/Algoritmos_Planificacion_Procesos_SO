/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.proyecto;

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
    private Nodo nodo;
    private ArrayList<Nodo> valoresNodo;
    
    public void leerArchivo(String nombre_cvs) {
      int contador=0;
        try {
            lector = new BufferedReader(new FileReader(nombre_cvs));
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(",");
             if(contador != 0){
                 nodo = new Nodo(partes[0],Integer.parseInt(partes[1]),Integer.parseInt(partes[2]),Integer.parseInt(partes[3]));   
                 valoresNodo.add(nodo);
             }
                imprimirLinea();
                System.out.println("");
            }
            lector.close();
            linea = null;
            partes = null;
            nodo = null;
            contador++;

        } catch (Exception e) {
            System.out.println("Localization: " + e.getLocalizedMessage() + " Message: " + e.getMessage());
        }
    }

    public void imprimirLinea() {
        for (int i = 0; i < valoresNodo.size(); i++) {
            System.out.println(i+ "Rafagas: " +valoresNodo.get(i).getRafaga() + "|");
        }
    }

}

