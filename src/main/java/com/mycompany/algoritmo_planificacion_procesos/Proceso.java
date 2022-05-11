/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.algoritmo_planificacion_procesos;
//
/**
 *Podemos interpretar esto como un nodo
 * con todos los datos de cada proveso
 * su nombre, tiempo de llegada, cantidad de rafagas, y prioridad
 */
public class Proceso {

    public Proceso(String nombre, int tiempo_De_Llegada, int cantidad_De_Rafagas, int prioridad) {
        this.nombre = nombre;
        this.tiempo_De_Llegada = tiempo_De_Llegada;
        this.cantidad_De_Rafagas = cantidad_De_Rafagas;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTiempo_De_Llegada() {
        return tiempo_De_Llegada;
    }

    public int getCantidad_De_Rafagas() {
        return cantidad_De_Rafagas;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTiempo_De_Llegada(int tiempo_De_Llegada) {
        this.tiempo_De_Llegada = tiempo_De_Llegada;
    }

    public void setCantidad_De_Rafagas(int cantidad_De_Rafagas) {
        this.cantidad_De_Rafagas = cantidad_De_Rafagas;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    //Compara por nombre.
    public boolean equals(Proceso A,Proceso B){      
        return A.nombre.equals(B.nombre);
    }
    
    public String[] getString(){
        String[] cadena = {getNombre(), getTiempo_De_Llegada()+""
        , getCantidad_De_Rafagas()+"", getPrioridad()+""};
        
        return cadena;
    }
    
    private String nombre;
    private int tiempo_De_Llegada;
    private int cantidad_De_Rafagas;
    private int prioridad;
}
