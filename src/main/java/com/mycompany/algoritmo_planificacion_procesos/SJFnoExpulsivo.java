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
public class SJFnoExpulsivo {

    private SumarProcesos sumarProcesos;
    private int cantRafagas;
    private int cantProcesos;
    private ArrayList<Proceso> auxProceso;
    private String[] arregloString; //Contenedor de datos del SJF 

    public SJFnoExpulsivo() {
        this.sumarProcesos = new SumarProcesos();
        this.auxProceso = new ArrayList();
    }

    public void SJFnoexpulsivo(ArrayList<Proceso> datos) {
        //ORDENAR LOS DATOS POR TIEMPO DE LLEGADA
        int[] arrayProcesos = sumarProcesos.totalProcesos(datos);
        cantProcesos = arrayProcesos[0];
        cantRafagas = arrayProcesos[1];
        arregloString = new String[cantRafagas];

        for (int j = 0; j < datos.size(); j++) {
            for (int k = j + 1; k < datos.size(); k++) {
                if ((datos.get(j).getTiempo_De_Llegada() == (datos.get(k).getTiempo_De_Llegada()))) {
                    auxProceso.add(datos.get(k)); //Agrega los datos en un auxiliar
                    datos.remove(k); //Remueve el dato
                    k--;
                }
            }
            //Si el ArrayList auxiliar esta vacio, signifa que no hay tiempos de llegadas repetidos
            if (auxProceso.isEmpty()) {
                addEnArregloString(datos, j);
            } else {
                auxProceso.add(datos.get(0));
                //Ordenar los datos por las rafagas
                compararRafagas(auxProceso);
            }
            datos.remove(0); //remueve el dato en la pos 0 ya que ese dato ya fue incluido dntro del arregloString
            j--;
            auxProceso.removeAll(auxProceso);
        }

    }

    /**
     * Metodo que compara las rafagas para su respectivo orden
     *
     * @param datos :Almacenada dentro del ArrayList datos que repiten su mismo
     * tiempo de llegada
     */
    public void compararRafagas(ArrayList<Proceso> datos) {
        while (datos.size() != 1) {
            for (int i = 0; i < datos.size(); i++) {
                for (int j = i + 1; j < datos.size(); j++) {
                    if ((datos.get(i).getCantidad_De_Rafagas() <= datos.get(j).getCantidad_De_Rafagas())
                            && j == datos.size() - 1) {
                        addEnArregloString(datos, i);
                        datos.remove(i);//Removemos los que se encuentra en esa posicion
                        i--;
                    } else if ((datos.get(i).getCantidad_De_Rafagas() > datos.get(j).getCantidad_De_Rafagas())) {
                        i++;
                    }
                }

            }

        }
        //El ultimo datos dentro del ArrayList se agrega dentro del arreglo de string
        addEnArregloString(datos, 0);

    }

    /**
     * Metodo encargado de agregar los datos dentro del arregloString
     *
     * @param datos
     * @param pos 
     */
    public void addEnArregloString(ArrayList<Proceso> datos, int pos) {
        int rafagas = datos.get(pos).getCantidad_De_Rafagas() + cantOcupadaArreglo();
        for (int k = cantOcupadaArreglo(); k < rafagas; k++) {
            arregloString[k] = datos.get(pos).getNombre();
        }
    }

    /**
     * Devuelve la cantidad de posiciones ocupadas del arregloString(contenedor
     * de datos) esto ayuda a saber que lugar esta disponible para comenzar a agregar
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
