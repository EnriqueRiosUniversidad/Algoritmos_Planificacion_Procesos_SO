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
public class SumarProcesos {

    public int[] totalProcesos(ArrayList<Proceso> procesos) {
        int sumaProcesos = 0, sumaRafagas = 0;
        int[] suma = new int[2];

        for (Proceso e : procesos) {
            if (e.getNombre() != null) {
                sumaProcesos++;
            }
            sumaRafagas += e.getCantidad_De_Rafagas();
        }
        suma[0] = sumaProcesos;  //En la posicion 0 se guarda la suma de la cantidad de procesos
        suma[1] = sumaRafagas;   //En la posicion 1 se guarda la el total de las rafagas

        return suma;
    }
}
