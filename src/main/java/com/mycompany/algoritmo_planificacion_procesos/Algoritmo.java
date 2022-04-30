/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.algoritmo_planificacion_procesos;
import java.util.ArrayList;

public class Algoritmo {
/*
    Consiste en dos valores basicos, el conteo total de rafagas
    y una lista donde se guardara una representacion de cada rafaga
    donde cada proceso ocupara un lugar de acuerdo al algoritmo empleado
    ej= [A,A,A,B,B,B,B,C,C,C,C]
    
*/
    public Algoritmo( int numero_Rafagas) {
       this.numero_Rafagas = numero_Rafagas;
       this.representacion_Rafagas = new ArrayList(numero_Rafagas);
    }
    
    public ArrayList<String> getRepresentacion_Rafagas() {
        return representacion_Rafagas;
    }

    public int getNumero_Rafagas() {
        return numero_Rafagas;
    }

    public void setRepresentacion_Rafagas(ArrayList<String> representacion_Rafagas) {
        this.representacion_Rafagas = representacion_Rafagas;
    }

    public void setNumero_Rafagas(int numero_Rafagas) {
        this.numero_Rafagas = numero_Rafagas;
    }
    
    
    private ArrayList<String> representacion_Rafagas;
    private int numero_Rafagas;
    private int cantidad_De_Procesos;
}
