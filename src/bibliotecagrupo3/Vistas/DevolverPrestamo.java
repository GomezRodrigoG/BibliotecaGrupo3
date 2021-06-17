/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo3.Vistas;

import bibliotecagrupo3.Vistas.NewPrestamo;
import bibliotecaGrupo3.Controllers.Conexion;
import bibliotecagrupo3.Controllers.EjemplarData;
import bibliotecagrupo3.Controllers.Helpers;
import bibliotecagrupo3.Controllers.LectorData;
import bibliotecagrupo3.Controllers.LibroData;
import bibliotecagrupo3.Controllers.MultaData;
import bibliotecagrupo3.Controllers.PrestamoData;
import bibliotecagrupo3.Models.Lector;
import bibliotecagrupo3.Models.Libro;
import bibliotecagrupo3.Models.Multa;
import bibliotecagrupo3.Models.Prestamo;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodrigo
 */
public class DevolverPrestamo extends javax.swing.JInternalFrame {
    private DefaultTableModel tableModel;
    private PrestamoData pData;
    private LectorData lData;
    private LibroData libroData;
    private MultaData mData;
    private EjemplarData eData;
    private ArrayList<Prestamo> prestamosActivos = new ArrayList<Prestamo>();
    private Lector lector;

    public DevolverPrestamo(Conexion conexion) throws SQLException {
        initComponents();
        
        pData = new PrestamoData(conexion);
        lData = new LectorData(conexion);
        libroData = new LibroData(conexion);
        mData = new MultaData(conexion);
        tableModel = new DefaultTableModel();
        eData = new EjemplarData(conexion);
        buildTableHeader();
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
        jTFDni = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePrestamos = new javax.swing.JTable();
        jCB1 = new javax.swing.JCheckBox();
        jCB2 = new javax.swing.JCheckBox();
        jCB3 = new javax.swing.JCheckBox();
        jBSalir = new javax.swing.JButton();
        jBLimpiar = new javax.swing.JButton();
        jBDevolver = new javax.swing.JButton();

        setTitle("Devolver prestamo");

        jLabel1.setText("DNI del lector");

        jBBuscar.setText("BUSCAR");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jTablePrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jTablePrestamos.setRowHeight(30);
        jScrollPane1.setViewportView(jTablePrestamos);

        jCB1.setText("Devolver");

        jCB2.setText("Devolver");
        jCB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB2ActionPerformed(evt);
            }
        });

        jCB3.setText("Devolver");
        jCB3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB3ActionPerformed(evt);
            }
        });

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

        jBDevolver.setText("DEVOLVER");
        jBDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDevolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addComponent(jTFDni, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBBuscar)
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCB1)
                            .addComponent(jCB2)
                            .addComponent(jCB3))
                        .addContainerGap(25, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBDevolver)
                .addGap(18, 18, 18)
                .addComponent(jBLimpiar)
                .addGap(18, 18, 18)
                .addComponent(jBSalir)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBBuscar))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jCB1)
                        .addGap(18, 18, 18)
                        .addComponent(jCB2)
                        .addGap(18, 18, 18)
                        .addComponent(jCB3))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalir)
                    .addComponent(jBLimpiar)
                    .addComponent(jBDevolver))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB2ActionPerformed

    }//GEN-LAST:event_jCB2ActionPerformed
   
    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jCB3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB3ActionPerformed

    }//GEN-LAST:event_jCB3ActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        String dniRequerido = "Dni requerido para poder buscar";
        String dniSinLetras = "Un DNI solo debe contener numeros.";
        
        int dniLector = Helpers.parseStringToInt(jTFDni.getText(), dniRequerido , dniSinLetras);
        
        lector = lData.buscarLector(dniLector);
        
        if(lector == null) return;
        
        ArrayList<Prestamo> prestamos = pData.getByLector(lector);
        
        prestamosActivos = new ArrayList<>();
        
        for(Prestamo prestamo: prestamos){
            if(prestamo.getFecha_devolucion() == null && prestamo.isEstado()){
                prestamosActivos.add(prestamo);
            }
        }
        
        clearTable();
        
        for(Prestamo prestamo:prestamosActivos){
            Libro libro = prestamo.getEjemplar().getLibro();
            
            tableModel.addRow(new Object[]{libro.getNombre(), prestamo.getFecha()});
        }
        
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jBDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDevolverActionPerformed
        ArrayList<Boolean> cbSelected = new ArrayList<>();
        
        cbSelected.add(jCB1.isSelected());
        cbSelected.add(jCB2.isSelected());
        cbSelected.add(jCB3.isSelected());
        
        int count = 0;
        int countMultas = 0;
        int idMulta = 0;
        boolean darDeBajaLector = false;
        
        // reviso cuantas multas le corresponden
        for(Prestamo prestamo: prestamosActivos){
            if(!cbSelected.get(count)){
                count ++;
                continue;
            }
            
            LocalDate fechaPlus30 = prestamo.getFecha().plusDays(30);
            LocalDate fechaPlus90 = prestamo.getFecha().plusDays(90);
            
            //genero multa
            if(fechaPlus30.isBefore(LocalDate.now())){
                countMultas++;
                
                if(fechaPlus90.isBefore(LocalDate.now())){
                    darDeBajaLector = true;
                    JOptionPane.showMessageDialog(null, "El prestamo vencio hace mas de 90 dias. Por lo que el lector sera dado de baja.");
                    
                    continue;
                }
                
                JOptionPane.showMessageDialog(null, "El prestamo esta vencido. Debera esperar los dias de la multa que le correspondan para volver a pedir un prestamo.");
                continue;
            }
            
            count ++;
        }
        
        //creo la multa y doy de baja si es necesario
        if(countMultas > 0){
            idMulta = mData.guardarMulta(countMultas);
            
            if(darDeBajaLector){
                try {
                    lData.desactivarLector(this.lector.getDni());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(NewPrestamo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(NewPrestamo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        count = 0;
        
        for(Prestamo prestamo: prestamosActivos){
            if(!cbSelected.get(count)){
                count ++;
                continue;
            }
            
            prestamo.setFecha_devolucion(LocalDate.now());
            
            prestamo.getEjemplar().setEstado("disponible");
            
            eData.actualizarEjemplar(prestamo.getEjemplar());
            
            if(idMulta != 0){
                Multa multa = new Multa();
                multa.setId_multa(idMulta);
                
                prestamo.setMulta(multa);
                
                pData.devolverConMulta(prestamo);
                count ++;
                continue;
            }
            
            pData.devolverSinMulta(prestamo);
            count ++;
            continue;
            
        }
        
        limpiar();
    }//GEN-LAST:event_jBDevolverActionPerformed

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_jBLimpiarActionPerformed

    private void limpiar(){
        clearTable();
        jTFDni.setText("");
        jCB1.setSelected(false);
        jCB2.setSelected(false);
        jCB3.setSelected(false);
    }
    
    private void clearTable(){ 
       int rowCount = tableModel.getRowCount()-1;
       
       for(int i = rowCount; i >= 0; i--){
           tableModel.removeRow(i);
       }
    }
    
    private void buildTableHeader(){
        ArrayList <Object> columnas = new ArrayList<>();
        
        columnas.add("Libro");
        columnas.add("Fecha de prestamo");
        
        for(Object it:columnas){
            tableModel.addColumn(it);
        }
        
        jTablePrestamos.setModel(tableModel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBDevolver;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JCheckBox jCB1;
    private javax.swing.JCheckBox jCB2;
    private javax.swing.JCheckBox jCB3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTFDni;
    private javax.swing.JTable jTablePrestamos;
    // End of variables declaration//GEN-END:variables
}