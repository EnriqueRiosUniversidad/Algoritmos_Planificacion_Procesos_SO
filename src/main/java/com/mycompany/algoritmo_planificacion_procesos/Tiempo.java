/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.algoritmo_planificacion_procesos;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class Tiempo {

   // private ArrayList<Proceso> proceso;
    private int[]TEspera;
    private int[]TRespuesta;

    public Tiempo() {
       // this.proceso = new ArrayList();
    }

    
    public int[] tiempoEspera(ArrayList<Proceso> datos, ArrayList<String> proceso) {
        TEspera = new int[datos.size()];
        
        for (int i = 0; i < datos.size(); i++) {
            int TLL1 = datos.get(i).getTiempo_De_Llegada();
            int totalAparaciones = 0;
            int TLL2 = 0;
            String nombre = datos.get(i).getNombre();
            for (int j = 0; j < proceso.size(); j++) {
                if (nombre.equalsIgnoreCase(proceso.get(j))) {
                    TLL2 = j + 1;
                    totalAparaciones++;
                }
            }
            datos.get(i).setCantidad_De_Rafagas(totalAparaciones);
            TEspera[i] = TLL2 - totalAparaciones - TLL1;
        }
        return TEspera;
    }

    
    public int[] tiempoRespuesta(ArrayList<Proceso> datos, ArrayList<String> proceso) {
         TRespuesta = new int[datos.size()];
         
        for (int i = 0; i < datos.size(); i++) {
            int TLL1 = datos.get(i).getTiempo_De_Llegada();
            int TLL2;
            String nombre = datos.get(i).getNombre();
            for (int j = 0; j < proceso.size(); j++) {
                if (nombre.equalsIgnoreCase(proceso.get(j))) {
                    TLL2 = j + 1;
                    TRespuesta[i] = TLL2 - TLL1;
                    j = proceso.size();
                }
            }
        }
        return TRespuesta;
    }
}
