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
public class ListaTiempos {

    private NodoTiempo nodoTiempo;
    private ArrayList<NodoTiempo> arrayNodoTiempo;
    private Tiempo tiempo;
    private int[] TEspera;
    private int[] TRespuesta;

    public ListaTiempos() {
        arrayNodoTiempo = new ArrayList();
    }

    public void ListaTiempos(ArrayList<Proceso> auxdatos, ArrayList<String> nombresProcesos) {

        TEspera = new int[auxdatos.size()];//tiempos.tiempoEspera(auxdatos);   
        TRespuesta = new int[auxdatos.size()]; //tiempos.tiempoRespuesta(auxdatos);

        tiempo = new Tiempo();

        TEspera = tiempo.tiempoEspera(auxdatos, nombresProcesos);
        TRespuesta = tiempo.tiempoRespuesta(auxdatos, nombresProcesos);

        addAuxDatos(auxdatos);

    }

    public void addAuxDatos(ArrayList<Proceso> auxdatos) {

        for (int i = 0; i < auxdatos.size(); i++) {
            String NombreProceso = auxdatos.get(i).getNombre();
            int Rafagas = auxdatos.get(i).getCantidad_De_Rafagas();

            nodoTiempo = new NodoTiempo(NombreProceso, TEspera[i], Rafagas, TRespuesta[i]);
            arrayNodoTiempo.add(nodoTiempo);
        }
    }

    public void retornarDatos() {
        float sumaEspera = 0,sumaEjecucion=0,sumaRespuesta=0;
        float promedioEspera=0,promedioEjecucion=0,promedioRespuesta=0;
        for (int i = 0; i < arrayNodoTiempo.size(); i++) {
            System.out.println(arrayNodoTiempo.get(i).getNombre() + " " + arrayNodoTiempo.get(i).getTiempoEspera() + " " + arrayNodoTiempo.get(i).getTiempoEjecucion() + " " + arrayNodoTiempo.get(i).getTiempoRespuesta());
        sumaEspera += arrayNodoTiempo.get(i).getTiempoEspera();
        sumaEjecucion += arrayNodoTiempo.get(i).getTiempoEjecucion();
        sumaRespuesta += arrayNodoTiempo.get(i).getTiempoRespuesta();
        }
        promedioEspera = sumaEspera/arrayNodoTiempo.size();
        promedioEjecucion = sumaEjecucion/arrayNodoTiempo.size();
        promedioRespuesta = sumaRespuesta/arrayNodoTiempo.size();
        
        System.out.println("------suma--------");
        System.out.print(sumaEspera+" "+sumaEjecucion+" "+sumaRespuesta+"\n");
        System.out.println("-------promedio-------");
        System.out.println(promedioEspera+" "+promedioEjecucion+" "+promedioRespuesta+"\n");
    }
}


