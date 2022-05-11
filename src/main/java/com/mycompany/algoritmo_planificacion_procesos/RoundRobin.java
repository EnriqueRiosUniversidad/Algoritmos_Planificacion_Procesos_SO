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
public class RoundRobin {
    private ArrayList<Proceso> proceso;
    private ArrayList<String> roundRobin;
    private ArrayList<Proceso> ordenLlegada;
   // private Tiempos tiempo;
    private int Quantum;
    private int TEspera;

    public RoundRobin() {
        proceso = new ArrayList();
        roundRobin = new ArrayList();
        ordenLlegada = new ArrayList();
        Quantum = 0;
        //tiempo = new Tiempos();
        
    }

    public void roundRobin(ArrayList<Proceso> datos, int Q) {
        Quantum = Q;
        TEspera = addProceso(datos, 0);
        realizarRR(datos);
    }
    

    public void realizarRR(ArrayList<Proceso> datos) {
        int rafaga;
        String nombre;
        for (int i = 0; i < proceso.size(); i++) {
            rafaga = proceso.get(i).getCantidad_De_Rafagas();
            nombre = proceso.get(i).getNombre();
            for (int j = 0; j < Quantum; j++) {
                rafaga -= 1;               
                roundRobin.add(nombre);
                proceso.get(i).setCantidad_De_Rafagas(rafaga);
                
                if(rafaga == 0){
                    break;
                }
                
                TEspera -= 1;
                if (TEspera == 0) {
                    TEspera = addProceso(datos, 0);
                }
            }

            if (rafaga != 0) {
                encolarProceso(i);
                i--;

            } else {
                proceso.remove(i);
                i--;
            }
        }
    }

    public void encolarProceso(int pos) {
        proceso.add(proceso.get(pos));
        proceso.remove(pos);
    }

    public int addProceso(ArrayList<Proceso> datos, int TLL) {
        int difTLL = -1;
        if (TLL == 0 && !datos.isEmpty()) {

            int TLL1, TLL2;
            TLL1 = datos.get(CERO).getTiempo_De_Llegada();
            for (int j = 0; j < datos.size(); j++) {
                TLL2 = datos.get(j).getTiempo_De_Llegada();
                if (TLL1 == TLL2) {
                    proceso.add(datos.get(j));
                    datos.remove(j);
                    j--;
                }
            }
            if (!datos.isEmpty()) {
                TLL2 = datos.get(CERO).getTiempo_De_Llegada();
            } else {
                return -1;
            }
            difTLL = TLL2 - TLL1;
        }
        return difTLL;
    }

    /**
     * Aca retorna mi lista AAABBBBCCC
     * @return 
     */
    public ArrayList<String> getNombresRoundRobin() {
        for (String roundRobin1 : roundRobin) {
            return roundRobin;
        }
        return null;
    }

    
    public void imprimir(){
          for (String roundRobin1 : roundRobin) {
             
               System.out.print(" " + roundRobin1 +" ");
              
        }
   
    }
    
    private final int CERO = 0;
}
