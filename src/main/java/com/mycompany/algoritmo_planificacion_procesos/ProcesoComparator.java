/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.algoritmo_planificacion_procesos;

import java.util.Comparator;

/**
 *
 * @author Lenovo
 */
public class ProcesoComparator implements Comparator {
      
    @Override
    public int compare(Object t, Object t1) {
        Proceso proceso1 = (Proceso)t;
        Proceso proceso2 = (Proceso)t1;     
        return proceso1.getTiempo_De_Llegada() - proceso2.getTiempo_De_Llegada();
    }
}



