/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.gui;

import com.mysql.jdbc.RowData;
import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import org.ema.cdn.util.AccesBDD;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;

/**
 *
 * @author Dorian
 */
public class InterfaceProf_v2 extends javax.swing.JFrame {

    public InterfaceProf_v2() throws SQLException {
        initComponents();
        recupNoms();
    }



    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        onglet0 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        onglet1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        onglet2 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        onglet3 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        onglet0.setBorder(javax.swing.BorderFactory.createTitledBorder("Joel Vlasak : Langage C"));

        onglet1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        onglet1.setColumnSelectionAllowed(true);
        onglet1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                onglet1ComponentAdded(evt);
            }
        });
        jScrollPane1.setViewportView(onglet1);
        onglet1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        onglet0.addTab("INFRES 6", jScrollPane1);

        onglet2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(onglet2);

        onglet0.addTab("INFRES 5", jScrollPane3);

        onglet3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(onglet3);

        onglet0.addTab("INFRES 4", jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(onglet0, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(onglet0, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onglet1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_onglet1ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_onglet1ComponentAdded

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new InterfaceProf_v2().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(InterfaceProf_v2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
//------------------------------------------------------------------------------  
    void recupNoms() throws SQLException{
//        AccesBDD bdd = new AccesBDD();
//        
//            //onglet1.add(bdd.Requete().elementAt(0), 5);
//        
//            onglet1.setModel(new javax.swing.table.DefaultTableModel(
//            new Object [][] {
//                {bdd.Requete().elementAt(0), null, null, null, null, null, null}
//            },
//            new String [] {
//                "Elève", "Test 1", "Test 2", "Test 3", "Test 4", "Partiel", "Moyenne"
//            }
//            ));
//                        onglet1.setModel(new javax.swing.table.DefaultTableModel(
//            new Object [][] {
//                {bdd.Requete().elementAt(0), null, null, null, null, null, null}
//            },
//            new String [] {
//                "Elève", "Test 1", "Test 2", "Test 3", "Test 4", "Partiel", "Moyenne"
//            }
//            ));
        onglet1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                null, null, null, null, null, null, null
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
                        
            if (onglet1.getColumnModel().getColumnCount() > 0) {
            onglet1.getColumnModel().getColumn(0).setHeaderValue("Elève");
            onglet1.getColumnModel().getColumn(1).setHeaderValue("Partiel");
            onglet1.getColumnModel().getColumn(2).setHeaderValue("Note");
            onglet1.getColumnModel().getColumn(3).setHeaderValue("Moyenne");
            onglet1.getColumnModel().getColumn(4).setHeaderValue("Test 4");
            onglet1.getColumnModel().getColumn(5).setHeaderValue("Partiel");
            onglet1.getColumnModel().getColumn(6).setHeaderValue("Moyenne");
            
        }
            
    }
//------------------------------------------------------------------------------
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane onglet0;
    private javax.swing.JTable onglet1;
    private javax.swing.JTable onglet2;
    private javax.swing.JTable onglet3;
    // End of variables declaration//GEN-END:variables

    
        
}
