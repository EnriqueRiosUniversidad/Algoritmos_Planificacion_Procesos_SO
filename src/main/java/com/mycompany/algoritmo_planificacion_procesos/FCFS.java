
package com.mycompany.algoritmo_planificacion_procesos;
import java.util.ArrayList;


public class FCFS extends Algoritmo{
    
    public static void calcular(){
        
    }
   /*Calcula la representacion 
   * de procesos. 
   * Los guarda en un string
   */
    public static void calcular_Representacion_Procesos(){
        ArrayList<String> temp_representacion = getRepresentacion_Rafagas();
        ArrayList<Proceso> procesos= getProcesos(); //solo para simplificar
        int rafagas_Transcurridas=0;
        if(FCFS.getCantidad_De_Procesos() > 0){
            for(int proceso_n= 0; proceso_n < getCantidad_De_Procesos(); proceso_n++){
                int tope = rafagas_Transcurridas + procesos.get(proceso_n).getCantidad_De_Rafagas();
                while(rafagas_Transcurridas < tope){
                    temp_representacion.add(procesos.get(proceso_n).getNombre());
                    rafagas_Transcurridas++;
                }
            }
            setRepresentacion_Rafagas(temp_representacion);
        }else{
            System.out.println("Numero de procesos 0, entrada invalida.");
        }
        
    }
    
    
    
}
//Primero quiero ordenar mi lista de procesos segun orden de llegada.

/*Lo que hace mi algoritmo es tener.
-Lista de procesos.
-lista de representacion.
-numero de rafagas.
-numero de procesos.

Lo que hace
-Ordenar de acuerdo a tiempo de llegada
-Ordenar de acuerdo a cantidad de rafagas
-Calcular la cantidad total de rafagas
-addProceso, y recalcular las variables internas.
-Imprimir su lista de representacion.
*/

/*Lo que hace FCFS
-Rellenar la lista 'Representacion_procesos' con el nombre de cada proceso.
*/