/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo3.Vistas;

import bibliotecaGrupo3.Controllers.Conexion;
import bibliotecagrupo3.Controllers.EjemplarData;
import bibliotecagrupo3.Controllers.LibroData;
import bibliotecagrupo3.Models.Ejemplar;
import bibliotecagrupo3.Models.Libro;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pablo
 */
public class VerActualizarEjemplarVew extends javax.swing.JInternalFrame {
        private DefaultTableModel modelo;
        private Libro libro;
        private LibroData ld;
        private EjemplarData ed;
        private ArrayList<Ejemplar> ejemplar;
       
    /**
     * Creates new form VerActualizarEjemplarVew
     */
    public VerActualizarEjemplarVew(Conexion conexion) throws SQLException {
        initComponents();
        modelo = new DefaultTableModel();
        libro = new Libro();
        ld = new LibroData(conexion);
        ed = new EjemplarData(conexion);
        ejemplar = new ArrayList<>();
       
        armarCabeceraTabla();
        cargarComboBox();
    }
    
    public void cargarComboBox(){
    jcEstado.addItem("disponible");
    jcEstado.addItem("prestado");
    jcEstado.addItem("retraso");
    jcEstado.addItem("reparación");
    }
    
      public void armarCabeceraTabla(){
        ArrayList <Object> columnas = new ArrayList<>();
        columnas.add("ID");
        columnas.add("Estado");
        columnas.add("Libro");
        columnas.add("Tipo");
        columnas.add("Autor");
        
        
                
        for(Object it:columnas){
            modelo.addColumn(it);
        }
        jtaEjemplar.setModel(modelo);
    }
    
      public void borrarFilasTabla(){
       int a = modelo.getRowCount()-1;
       for(int i=a; i>=0; i--){
           modelo.removeRow(i);
       }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtIsbn = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaEjemplar = new javax.swing.JTable();
        jbBuscar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jbSalir = new javax.swing.JButton();
        jcEstado = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("ISBN");

        jtaEjemplar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtaEjemplar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtaEjemplarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtaEjemplar);

        jbBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbActualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Id Ejemplar");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Estado");

        jbSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jcEstado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addGap(99, 99, 99)
                        .addComponent(jtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtId, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addComponent(jbActualizar)))
                .addContainerGap(167, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbBuscar))
                    .addComponent(jLabel1))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbActualizar))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jbSalir)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
      try{
        Ejemplar ejem=new Ejemplar();
        
       ejem=ed.buscarEjemplar(Integer.parseInt(jtId.getText()));
       ejem.setEstado(jcEstado.getSelectedItem().toString());
      
       ed.actualizarEjemplar(ejem);
       } catch (NumberFormatException co) {
            JOptionPane.showMessageDialog(null, "Isbn o Id ingresado no existe");
        }

    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
    try{
        borrarFilasTabla();
        Libro l= ld.buscarLibro(Integer.parseInt(jtIsbn.getText()));
        ejemplar=ed.buscarEjemplarXIsbn(Integer.parseInt(jtIsbn.getText()));
        for(Ejemplar it:ejemplar){
             modelo.addRow(new Object[]{it.getId_ejemplar(),it.getEstado(),it.getLibro().getNombre(),it.getLibro().getTipo(),});
        }
        jtIsbn.setText("");
        } catch (NumberFormatException co) {
            JOptionPane.showMessageDialog(null, "Isbn ingresado no existe");
        }

    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jtaEjemplarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtaEjemplarMouseClicked
       jtId.setText(jtaEjemplar.getValueAt(jtaEjemplar.getSelectedRow(),0).toString());
    }//GEN-LAST:event_jtaEjemplarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<String> jcEstado;
    private javax.swing.JTextField jtId;
    private javax.swing.JTextField jtIsbn;
    private javax.swing.JTable jtaEjemplar;
    // End of variables declaration//GEN-END:variables
}
