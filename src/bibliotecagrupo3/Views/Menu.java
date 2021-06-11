/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo3.Views;

import bibliotecaGrupo3.Controllers.Conexion;
import bibliotecagrupo3.Controllers.PrestamoData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Menu extends javax.swing.JFrame {

    private Conexion conexion;
    
    public Menu() throws ClassNotFoundException {
        initComponents();
        
        conexion = new Conexion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuPrestamos = new javax.swing.JMenu();
        jMICrearPrestamo = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItemPrestamoByDate = new javax.swing.JMenuItem();
        jMenuItemPrestamosByLector = new javax.swing.JMenuItem();
        jMenuQuit = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 477, Short.MAX_VALUE)
        );

        jMenuPrestamos.setText("Mis cositas");

        jMICrearPrestamo.setText("Crear Prestamo");
        jMICrearPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMICrearPrestamoActionPerformed(evt);
            }
        });
        jMenuPrestamos.add(jMICrearPrestamo);

        jMenuItem1.setText("Prestamos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuPrestamos.add(jMenuItem1);

        jMenuItemPrestamoByDate.setText("Prestamos por fecha");
        jMenuPrestamos.add(jMenuItemPrestamoByDate);

        jMenuItemPrestamosByLector.setText("Prestamos por lector");
        jMenuPrestamos.add(jMenuItemPrestamosByLector);

        jMenuBar1.add(jMenuPrestamos);

        jMenuQuit.setText("Salir");
        jMenuQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuQuitActionPerformed(evt);
            }
        });

        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuQuit.add(jMenuItem2);

        jMenuBar1.add(jMenuQuit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        PrestamoView pView = null;
        
        try {
            pView = new PrestamoView(conexion);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion");
        }
        
        pView.setVisible(true);
        escritorio.add(pView);
        escritorio.moveToFront(pView);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuQuitActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuQuitActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMICrearPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMICrearPrestamoActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        NewPrestamo npView = null;
        
        try {
            npView = new NewPrestamo(conexion);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion");
        }
        
        npView.setVisible(true);
        escritorio.add(npView);
        escritorio.moveToFront(npView);
    }//GEN-LAST:event_jMICrearPrestamoActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Menu().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem jMICrearPrestamo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemPrestamoByDate;
    private javax.swing.JMenuItem jMenuItemPrestamosByLector;
    private javax.swing.JMenu jMenuPrestamos;
    private javax.swing.JMenu jMenuQuit;
    // End of variables declaration//GEN-END:variables
}
