/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.algoritmo_planificacion_procesos;


import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author wwwal
 */
public class prueba extends javax.swing.JFrame {

    /**
     * Creates new form prueba
     */
    public prueba() {
        initComponents();
        ArrayList<Proceso> procesos = cargarProceso();
        llenar_tabla_procesos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_Procesos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_Procesos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_Procesos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        label_Procesos.setText("Procesos");

        tabla_Procesos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "T. Llegada", "N* Rafagas", "Prioridad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla_Procesos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(label_Procesos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_Procesos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(214, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new prueba().setVisible(true);
            }
        });
    }
 /*Carga los procesos.*/
    public static ArrayList<Proceso> cargarProceso() {
        Proceso A = new Proceso("A", 1, 3, 2);
        Proceso B = new Proceso("B", 0, 2, 1);
        Proceso C = new Proceso("C", 1, 5, 3);
        Proceso D = new Proceso("D", 3, 1, 5);
        Proceso P = new Proceso("P", 2, 2, 2);
        ArrayList<Proceso> procesos = new ArrayList();
        /* procesos.add(A);
        procesos.add(B);
        procesos.add(C);
        procesos.add(D);
        procesos.add(P);*/
        Algoritmo.addProceso(A);
        Algoritmo.addProceso(B);
        Algoritmo.addProceso(C);
        Algoritmo.addProceso(D);
        Algoritmo.addProceso(P);

        return Algoritmo.getProcesos();
    }

    
    /*Carga la tabla procesos con los procesos existentes*/
    public void llenar_tabla_procesos() {
        int numero_filas = Algoritmo.getCantidad_De_Procesos();
        DefaultTableModel modeloDefault;
        modeloDefault = new DefaultTableModel(
                new String[]{"nombre", "T Llegada", "N Rafagas", "Prioridad"},
                numero_filas);

        tabla_Procesos.setModel(modeloDefault);

        TableModel modelo_Datos = tabla_Procesos.getModel();

        Proceso proceso;
        for (int i = 0; i < Algoritmo.getCantidad_De_Procesos(); i++) {
            proceso = Algoritmo.getProcesos().get(i);
            modelo_Datos.setValueAt(proceso.getNombre(), i, 0);
            modelo_Datos.setValueAt(proceso.getTiempo_De_Llegada(), i, 1);
            modelo_Datos.setValueAt(proceso.getCantidad_De_Rafagas(), i, 2);
            modelo_Datos.setValueAt(proceso.getPrioridad(), i, 3);

        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_Procesos;
    private javax.swing.JTable tabla_Procesos;
    // End of variables declaration//GEN-END:variables
}