/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.proyecto;

/**
 *
 * @author Lenovo
 */
public class Nodo {

        public Nodo(String nombre_proceso,int rafaga,int tiempo_llegada,int prioridad){
        this.nombre_proceso = nombre_proceso;
        this.rafaga = rafaga;
        this.tiempo_llegada = tiempo_llegada;
        this.prioridad = prioridad;
    }
    

    
    
    public String getNombre_proceso() {
        return nombre_proceso;
    }

    public void setNombre_proceso(String nombre_proceso) {
        this.nombre_proceso = nombre_proceso;
    }

    public int getRafaga() {
        return rafaga;
    }

    public void setRafaga(int rafaga) {
        this.rafaga = rafaga;
    }

    public int getTiempo_llegada() {
        return tiempo_llegada;
    }

    public void setTiempo_llegada(int tiempo_llegada) {
        this.tiempo_llegada = tiempo_llegada;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    
    
    private String nombre_proceso;
    private int rafaga;
    private int tiempo_llegada;
    private int prioridad;
}
