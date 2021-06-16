/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo3.Vistas;

import bibliotecaGrupo3.Controllers.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class MenuPrincipal extends javax.swing.JFrame {
    private Conexion conexion;

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() throws ClassNotFoundException {
        initComponents();
        conexion = new Conexion();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiPrestamosVencidos = new javax.swing.JMenuItem();
        jmiMultasMes = new javax.swing.JMenuItem();
        jmiOperaciones = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jmMultasXLector = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jmGuardarEjemplar = new javax.swing.JMenuItem();
        jmVerActualizarEjemplar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jmLibro = new javax.swing.JMenu();
        jrbmLibro = new javax.swing.JRadioButtonMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jrbmAutor = new javax.swing.JRadioButtonMenuItem();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        jMenu1.setText("Lector");

        jmiPrestamosVencidos.setText("Prestamos Vencidos");
        jmiPrestamosVencidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPrestamosVencidosActionPerformed(evt);
            }
        });
        jMenu1.add(jmiPrestamosVencidos);

        jmiMultasMes.setText("Multas de un mes");
        jmiMultasMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMultasMesActionPerformed(evt);
            }
        });
        jMenu1.add(jmiMultasMes);

        jmiOperaciones.setText("Operaciones");
        jmiOperaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiOperacionesActionPerformed(evt);
            }
        });
        jMenu1.add(jmiOperaciones);

        jMenuBar1.add(jMenu1);

        jMenu5.setText("Multas");
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jmMultasXLector.setText("historial de multas por Lector");
        jmMultasXLector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHistorialActionPerformed(evt);
            }
        });
        jMenu5.add(jmMultasXLector);

        jMenuBar1.add(jMenu5);

        jMenu4.setText("Ejemplar");

        jmGuardarEjemplar.setText("Guardar Ejemplar");
        jmGuardarEjemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmGuardarEjemplarActionPerformed(evt);
            }
        });
        jMenu4.add(jmGuardarEjemplar);

        jmVerActualizarEjemplar.setText("Ver y Actualizar ");
        jmVerActualizarEjemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmVerActualizarEjemplarActionPerformed(evt);
            }
        });
        jMenu4.add(jmVerActualizarEjemplar);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("Salir");

        jMenuItem4.setText("jMenuItem4");
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jmLibro.setText("Libro");
        jmLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmLibroActionPerformed(evt);
            }
        });

        jrbmLibro.setSelected(true);
        jrbmLibro.setText("Libro");
        jrbmLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbmLibroActionPerformed(evt);
            }
        });
        jmLibro.add(jrbmLibro);

        jMenuBar1.add(jmLibro);

        jMenu6.setText("Autor");

        jrbmAutor.setSelected(true);
        jrbmAutor.setText("Autor");
        jrbmAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbmAutorActionPerformed(evt);
            }
        });
        jMenu6.add(jrbmAutor);

        jMenuBar1.add(jMenu6);

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

    private void jrbmAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbmAutorActionPerformed
        try {
            escritorio.removeAll();
            escritorio.repaint();
            AutorView av = new AutorView(conexion);
            av.setVisible(true);
            escritorio.add(av);
            escritorio.moveToFront(av);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
    }//GEN-LAST:event_jrbmAutorActionPerformed

    private void jrbmLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbmLibroActionPerformed
        try {
            escritorio.removeAll();
            escritorio.repaint();
            LibroView lv = new LibroView(conexion);
            lv.setVisible(true);
            escritorio.add(lv);
            escritorio.moveToFront(lv);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
    }//GEN-LAST:event_jrbmLibroActionPerformed

    private void jmiOperacionesActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jmiOperacionesActionPerformed
        try {
            escritorio.removeAll();
            escritorio.repaint();
            LectoresView lv = new LectoresView(conexion);
            lv.setVisible(true);
            escritorio.add(lv);
            escritorio.moveToFront(lv);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }

    }// GEN-LAST:event_jmiOperacionesActionPerformed

    private void jmiPrestamosVencidosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jmiPrestamosVencidosActionPerformed
        try {
            escritorio.removeAll();
            escritorio.repaint();
            PrestamosVencidosView pv = new PrestamosVencidosView(conexion);
            pv.setVisible(true);
            escritorio.add(pv);
            escritorio.moveToFront(pv);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
    }// GEN-LAST:event_jmiPrestamosVencidosActionPerformed

    private void jmiMultasMesActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jmiMultasMesActionPerformed
        try {
            escritorio.removeAll();
            escritorio.repaint();
            MultasXMesView pv = new MultasXMesView(conexion);
            pv.setVisible(true);
            escritorio.add(pv);
            escritorio.moveToFront(pv);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
    }// GEN-LAST:event_jmiMultasMesActionPerformed

    private void jmLibroActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jmLibroActionPerformed

    }// GEN-LAST:event_jmLibroActionPerformed

    private void jrmiMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jrmiMenuActionPerformed
        try {
            escritorio.removeAll();
            escritorio.repaint();
            LibroView lv = new LibroView(conexion);
            lv.setVisible(true);
            escritorio.add(lv);
            escritorio.moveToFront(lv);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
    }// GEN-LAST:event_jrmiMenuActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenu3ActionPerformed

    }// GEN-LAST:event_jMenu3ActionPerformed

    private void jHistorialActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jHistorialActionPerformed
        //TODO quitar estos comentarios cuando se suban las vistas
        try {
            escritorio.removeAll();
            escritorio.repaint();
            HistorialMultasView hm = new HistorialMultasView(conexion);
            hm.setVisible(true);
            escritorio.add(hm);
            escritorio.moveToFront(hm);
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error de conexion");
        }

    }// GEN-LAST:event_jHistorialActionPerformed

    private void jmGuardarEjemplarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jmGuardarEjemplarActionPerformed
        //TODO quitar estos comentarios cuando se suban las vistas
        try {
           escritorio.removeAll();
            escritorio.repaint();
            CargarEjemplarView ce = new CargarEjemplarView(conexion);
            ce.setVisible(true);
            escritorio.add(ce);
           escritorio.moveToFront(ce);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error de conexion");
        }
    }// GEN-LAST:event_jmGuardarEjemplarActionPerformed

    private void jmVerActualizarEjemplarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jmVerActualizarEjemplarActionPerformed
        //TODO quitar estos comentarios cuando se suban las vistas
        try {
            escritorio.removeAll();
           escritorio.repaint();
           VerActualizarEjemplarVew va = new VerActualizarEjemplarVew(conexion);
            va.setVisible(true);
            escritorio.add(va);
            escritorio.moveToFront(va);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
    }// GEN-LAST:event_jmVerActualizarEjemplarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MenuPrincipal().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jmGuardarEjemplar;
    private javax.swing.JMenu jmLibro;
    private javax.swing.JMenuItem jmMultasXLector;
    private javax.swing.JMenuItem jmVerActualizarEjemplar;
    private javax.swing.JMenuItem jmiMultasMes;
    private javax.swing.JMenuItem jmiOperaciones;
    private javax.swing.JMenuItem jmiPrestamosVencidos;
    private javax.swing.JRadioButtonMenuItem jrbmAutor;
    private javax.swing.JRadioButtonMenuItem jrbmLibro;
    // End of variables declaration//GEN-END:variables
}
