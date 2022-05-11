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
public class SJFExpulsivo {

    private final ArrayList<Proceso> proceso;
    private ArrayList<String> sjfexpulsivo; //Contenedor de datos del SJF 

    public SJFExpulsivo() {
        this.sjfexpulsivo = new ArrayList();
        this.proceso = new ArrayList();
    }

    public void SJFExpulsivo(ArrayList<Proceso> datos) {
        int tiempo_llegada1, tiempo_llegada2;

        for (int i = 0; i < datos.size(); i++) {
            tiempo_llegada1 = datos.get(i).getTiempo_De_Llegada();
            for (int j = i; j < datos.size(); j++) {
                if (datos.get(j).getTiempo_De_Llegada() == tiempo_llegada1) {
                    proceso.add(datos.get(j));
                    datos.remove(j);
                    j--;
                }
            }

            //En esta parte se encarga de comparar si es que el tiempo de llegada actual tiene un ligero            
            //tiempo de espera con el proceso que le sigue, para que el actual continue ingresando antes de que
            //otro proceso llegue
            if (!datos.isEmpty()) {
                tiempo_llegada2 = datos.get(0).getTiempo_De_Llegada();
                while (tiempo_llegada1 != tiempo_llegada2) {
                    compararRafagas();
                    tiempo_llegada1++;
                }
                i--;
            } else {
                break;
            }
        }

        //Una vez que los for concluyan, llamo al metodo comparar procesos
        //que hara que los datos que ingresaron, se comparar y terminen de ordenarse
        while (!proceso.isEmpty()) {
            compararRafagas();
        }

    }

    public void compararRafagas() {
        int ultima_posicion = proceso.size() - 1;

        if (proceso.size() > 1) {
            for (int i = 0; i < proceso.size(); i++) {
                for (int j = i + 1; j < proceso.size(); j++) {
                    if ((proceso.get(i).getCantidad_De_Rafagas() <= proceso.get(j).getCantidad_De_Rafagas())
                            && j == ultima_posicion) {

                        if (addsjfexpulsivo(i)) {
                            proceso.remove(i);
                        }
                        i = ultima_posicion;
                    } else if ((proceso.get(i).getCantidad_De_Rafagas() > proceso.get(j).getCantidad_De_Rafagas())) {
                        i = j;

                        if (i == ultima_posicion && addsjfexpulsivo(ultima_posicion)) {
                            proceso.remove(ultima_posicion);
                        }

                    }

                }

            }
            //El ultimo datos dentro del ArrayList se agrega dentro del arreglo de string
            //addEnArregloString(datos, 0);
        } else {
            if (addsjfexpulsivo(0)) {
                proceso.remove(0);
            }
        }

    }

    /**
     * Metodo encargado de agregar los datos dentro del arregloString
     *
     * @param pos
     * @return
     */
    public boolean addsjfexpulsivo(int pos) {
        int rafagas = proceso.get(pos).getCantidad_De_Rafagas();
        sjfexpulsivo.add(proceso.get(pos).getNombre());
        //Restarle 1 a la cantidad de rafagas que tiene    
        proceso.get(pos).setCantidad_De_Rafagas(rafagas - 1);
        //Si la cantidad de rafagas es cero, retorna true
        return proceso.get(pos).getCantidad_De_Rafagas() == 0;
    }

    public void imprimir() {
        sjfexpulsivo.forEach((arregloString1) -> {
            System.out.println(arregloString1 + " ");
        });

    }
}
