/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.algoritmo_planificacion_procesos;
/**
 *
 * @author Lenovo
 */
public class NodoTiempo {

    private String nombre;
    private int tiempoEspera;
    private int tiempoEjecucion;
    private int tiempoRespuesta;
    private float sumaEspera;
    private float promedioEspera;
    private float sumaEjecucion;
    private float promedioEjecucion;

        public NodoTiempo(String nombre, int tiempoEspera, int rafagas, int tiempoRespuesta
    ) {
        this.nombre = nombre;
        this.tiempoEspera = tiempoEspera;
        this.tiempoEjecucion = (tiempoEspera + rafagas);
        this.tiempoRespuesta = tiempoRespuesta;
    }
    
    
    
    public float getSumaEspera() {
        return sumaEspera;
    }

    public void setSumaEspera(float sumaEspera) {
        this.sumaEspera = sumaEspera;
    }

    public float getPromedioEspera() {
        return promedioEspera;
    }

    public void setPromedioEspera(float promedioEspera) {
        this.promedioEspera = promedioEspera;
    }

    public float getSumaEjecucion() {
        return sumaEjecucion;
    }

    public void setSumaEjecucion(float sumaEjecucion) {
        this.sumaEjecucion = sumaEjecucion;
    }

    public float getPromedioEjecucion() {
        return promedioEjecucion;
    }

    public void setPromedioEjecucion(float promedioEjecucion) {
        this.promedioEjecucion = promedioEjecucion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(int tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public int getTiempoRespuesta() {
        return tiempoRespuesta;
    }

    public void setTiempoRespuesta(int tiempoRespuesta) {
        this.tiempoRespuesta = tiempoRespuesta;
    }



}