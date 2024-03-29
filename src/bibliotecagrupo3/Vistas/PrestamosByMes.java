/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo3.Vistas;

import bibliotecaGrupo3.Controllers.Conexion;
import bibliotecagrupo3.Controllers.LectorData;
import bibliotecagrupo3.Controllers.LibroData;
import bibliotecagrupo3.Controllers.PrestamoData;
import bibliotecagrupo3.Models.Lector;
import bibliotecagrupo3.Models.Libro;
import bibliotecagrupo3.Models.Prestamo;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodrigo
 */
public class PrestamosByMes extends javax.swing.JInternalFrame {
    private DefaultTableModel tableModel;
    private PrestamoData pData;
    private LectorData lData;
    private LibroData libroData;
    
    public PrestamosByMes(Conexion conexion) throws SQLException {
        initComponents();
        
        pData = new PrestamoData(conexion);
        lData = new LectorData(conexion);
        libroData = new LibroData(conexion);
        tableModel = new DefaultTableModel();
        buildTableHeader();
        
        JDateChooser chooser = new JDateChooser();
        JTextFieldDateEditor editor = (JTextFieldDateEditor) jdcFecha.getDateEditor();
        editor.setEditable(false);

        jdcFecha.setDate(Date.valueOf(LocalDate.now()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jBBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePrestamos = new javax.swing.JTable();
        jBSalir = new javax.swing.JButton();
        jBLimpiar = new javax.swing.JButton();
        jdcFecha = new com.toedter.calendar.JDateChooser();

        jTextField1.setText("jTextField1");

        setTitle("Prestamos por Mes");

        jLabel1.setText("Fecha");

        jBBuscar.setText("BUSCAR");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jTablePrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jTablePrestamos.setRowHeight(20);
        jScrollPane1.setViewportView(jTablePrestamos);

        jBSalir.setText("SALIR");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jBLimpiar.setText("LIMPIAR");
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jBBuscar)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBLimpiar)
                .addGap(18, 18, 18)
                .addComponent(jBSalir)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jBBuscar))
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalir)
                    .addComponent(jBLimpiar))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_jBLimpiarActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        
        String fecha = formato.format(jdcFecha.getDate());
        LocalDate date = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        
        ArrayList<Prestamo> prestamos = pData.getByDate(date);
        
        clearTable();
        
        for(Prestamo prestamo:prestamos){
            Libro libro = prestamo.getEjemplar().getLibro();
            
            String generoMulta = "No";
            
            Lector lector = lData.buscarLector(prestamo.getLector().getDni());
            
            if(prestamo.getMulta() != null){
                generoMulta = "Si";
            }
            
            tableModel.addRow(new Object[]{lector.getNombre(),libro.getNombre(), prestamo.getFecha(),prestamo.getFecha_devolucion(),generoMulta});
        }
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void limpiar(){
        clearTable();
    }
    
    private void clearTable(){ 
       int rowCount = tableModel.getRowCount()-1;
       
       for(int i = rowCount; i >= 0; i--){
           tableModel.removeRow(i);
       }
    }
    
    private void buildTableHeader(){
        ArrayList <Object> columnas = new ArrayList<>();
        
        columnas.add("Lector");
        columnas.add("Libro");
        columnas.add("Fecha prestamo");
        columnas.add("Fecha devolucion");
        columnas.add("Genero Multa");
        
        for(Object it:columnas){
            tableModel.addColumn(it);
        }
        
        jTablePrestamos.setModel(tableModel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePrestamos;
    private javax.swing.JTextField jTextField1;
    private com.toedter.calendar.JDateChooser jdcFecha;
    // End of variables declaration//GEN-END:variables
}
