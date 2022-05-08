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
   private final SumarProcesos sumarProcesos;
    private int cantRafagas;
    private int cantProcesos;
    private int cantTotalTiempoLlegada;
    private final ArrayList<Proceso> auxProceso;
    private String[] arregloString; //Contenedor de datos del SJF 

    public SJFExpulsivo() {
        this.sumarProcesos = new SumarProcesos();
        this.auxProceso = new ArrayList();
    }

    public void SJFExpulsivo(ArrayList<Proceso> datos) {
        //ORDENAR LOS DATOS POR TIEMPO DE LLEGADA
        int[] arrayProcesos = sumarProcesos.totalProcesos(datos);
        cantProcesos = arrayProcesos[0];
        cantRafagas = arrayProcesos[1];
        arregloString = new String[cantRafagas];
        int tiempo_llegada1, tiempo_llegada2;

        for (int i = 0; i < datos.size(); i++) {
            tiempo_llegada1 = datos.get(i).getTiempo_De_Llegada();
            for (int j = i; j < datos.size(); j++) {
                if (datos.get(j).getTiempo_De_Llegada() == tiempo_llegada1) {
                    auxProceso.add(datos.get(j));
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
        while (!auxProceso.isEmpty()) {
            compararRafagas();
        }

    }

    public void compararRafagas() {
        int ultima_posicion = auxProceso.size() - 1;

        if (auxProceso.size() > 1) {
            for (int i = 0; i < auxProceso.size(); i++) {
                for (int j = i + 1; j < auxProceso.size(); j++) {
                    if ((auxProceso.get(i).getCantidad_De_Rafagas() <= auxProceso.get(j).getCantidad_De_Rafagas())
                            && j == ultima_posicion) {

                        if (addEnArregloString(i)) {
                            auxProceso.remove(i);
                        }
                        i = ultima_posicion;
                    } else if ((auxProceso.get(i).getCantidad_De_Rafagas() > auxProceso.get(j).getCantidad_De_Rafagas())) {
                        i = j;

                        if (i == ultima_posicion && addEnArregloString(ultima_posicion)) {
                            auxProceso.remove(ultima_posicion);
                        }

                    }

                }

            }
            //El ultimo datos dentro del ArrayList se agrega dentro del arreglo de string
            //addEnArregloString(datos, 0);
        } else {
            if (addEnArregloString(0)) {
                auxProceso.remove(0);
            }
        }

    }

    /**
     * Metodo encargado de agregar los datos dentro del arregloString
     *
     * @param pos
     * @return
     */
    public boolean addEnArregloString(int pos) {
        int rafagas = auxProceso.get(pos).getCantidad_De_Rafagas();

        int posicion = cantOcupadaArreglo();
        
        arregloString[posicion] = auxProceso.get(pos).getNombre();
        //Restarle 1 a la cantidad de rafagas que tiene    
        auxProceso.get(pos).setCantidad_De_Rafagas(rafagas - 1);
       //Si la cantidad de rafagas es cero, retorna true

        return auxProceso.get(pos).getCantidad_De_Rafagas() == 0;
    }

    /**
     * Devuelve la cantidad de posiciones ocupadas del arregloString(contenedor
     * de datos)
     *
     * @return
     */
    public int cantOcupadaArreglo() {
        int posiciones = 0;
        for (String arregloString1 : arregloString) {
            if (arregloString1 != null) {
                posiciones++;
            } else {
                break;
            }
        }
        return posiciones;
    }

    public void imprimir() {
        for (String arregloString1 : arregloString) {
            System.out.println(arregloString1 + " ");
        }

    }
}
