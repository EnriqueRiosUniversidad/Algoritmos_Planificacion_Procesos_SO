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

    ----Nos permite tambien ordenar los arreglos de mayor a menor.
*/
protected Algoritmo() {}
/*
private Algoritmo( int numero_Rafagas) {
   this.numero_Rafagas = numero_Rafagas;
   this.representacion_Rafagas = new ArrayList(numero_Rafagas);
}*/

public static void crear_lista_Vacia_Representacion(int numero_Rafagas){
    Algoritmo.total_Rafagas = numero_Rafagas;
    representacion_Rafagas = new ArrayList(numero_Rafagas);
}

//Retorna un arreglo ordenado de menor a mayor de acuerdo a sus 
//RAFAGAS.
public static ArrayList<Proceso> ord_Proc_Min_Rafagas(ArrayList<Proceso> procesos ){
   // ArrayList<Proceso> temp = new ArrayList(procesos.size());
   // temp = (ArrayList<Proceso>)procesos.clone(); //Por seguridad copio esta lista.
    Proceso clave;
    int j = 1;
    for (int i=1; i< procesos.size(); i++){
        clave=  procesos.get(i);

        while( j>= 0  &&  procesos.get(j).getCantidad_De_Rafagas() > clave.getCantidad_De_Rafagas()  ){
               procesos.set(j+1,procesos.get(j));
                j--;
        }

        procesos.set(j+1, clave);

    }
    return procesos;
}

//Tiempo de llegada
//Retorna un arreglo ordenado de menor a mayor.
public static ArrayList<Proceso> ord_Proc_Min_LLegada(ArrayList<Proceso> procesos){
    Proceso aux;
    for (int i = 0; i < procesos.size() - 1; i++) {
            for (int j = 0; j < procesos.size() - i - 1; j++) {                                                              
                if (procesos.get(j + 1).getTiempo_De_Llegada() < procesos.get(j).getTiempo_De_Llegada()) {
                    aux = procesos.get(j + 1);
                    procesos.set(j + 1, procesos.get(j));
                    procesos.set(j, aux);             
                }
            }
        }
    
    return procesos;
}

/*Ordena el array segun prioridad, de mayor a menor.*/
public static ArrayList<Proceso> ord_Proc_Min_Prioridad(ArrayList<Proceso> procesos){
    Proceso aux;
    for (int i = 0; i < procesos.size() - 1; i++) {
            for (int j = 0; j < procesos.size() - i - 1; j++) {                                                              
                if (procesos.get(j + 1).getPrioridad()< procesos.get(j).getPrioridad()) {
                    aux = procesos.get(j + 1);
                    procesos.set(j + 1, procesos.get(j));
                    procesos.set(j, aux);             
                }
            }
        }
    
    
return procesos;
}



public static void sumar_rafagas(){
    int suma=0;
    for( int i=0; i< getProcesos().size();i++ ){
        suma+= getProcesos().get(i).getCantidad_De_Rafagas();
    }
    Algoritmo.setTotal_Rafagas(suma);
}


public static ArrayList<Proceso> getProcesos() {
        return procesos;
    }

public static ArrayList<String> getRepresentacion_Rafagas() {
    return representacion_Rafagas;
}

public static int getTotal_Rafagas() {
    return total_Rafagas;
}

public static int getCantidad_De_Procesos() {
        return cantidad_De_Procesos;
}

public static void setRepresentacion_Rafagas(ArrayList<String> representacion_Rafagas) {
    Algoritmo.representacion_Rafagas = representacion_Rafagas;
}

public static void setTotal_Rafagas(int numero_Rafagas) {
    Algoritmo.total_Rafagas = numero_Rafagas;
}

public static void setCantidad_De_Procesos(int cantidad_De_Procesos) {
        Algoritmo.cantidad_De_Procesos = cantidad_De_Procesos;
}

public static void setProcesos(ArrayList<Proceso> procesos) {
    Algoritmo.procesos = procesos;
}

/*Cada que a;adimos un proceso, la lista de redimenciona
y afecta los valores internos de esta clase.*/
public static void addProceso(Proceso proceso){
    procesos.add(proceso);
    sumar_rafagas();
    setCantidad_De_Procesos(procesos.size());
    crear_lista_Vacia_Representacion(total_Rafagas);
    procesos = ord_Proc_Min_LLegada(procesos);    
}

public static void imprimirRepresentacion(){
    System.out.print(" | ");
    for(int i=0; i<total_Rafagas ;i++){
        System.out.print( representacion_Rafagas.get(i)+ " | ");
    }
}


private static ArrayList<String> representacion_Rafagas;
private static ArrayList<Proceso> procesos = new ArrayList();
private static int total_Rafagas;
private static int cantidad_De_Procesos;


}
