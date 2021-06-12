/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo3.Vistas;

import bibliotecaGrupo3.Controllers.Conexion;
import bibliotecagrupo3.Controllers.LectorData;
import bibliotecagrupo3.Controllers.PrestamoData;
import bibliotecagrupo3.Models.Lector;
import bibliotecagrupo3.Models.Prestamo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class PrestamosVencidosView extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;
    private ArrayList<Lector> listaLectores;
    private ArrayList<Prestamo> listaPrestamos;
    private LectorData lectorData;
    private PrestamoData prestamoData;
    /**
     * Creates new form PrestamosVencidosView
     */
    public PrestamosVencidosView(Conexion conexion) throws SQLException{
        initComponents();
        modelo = new DefaultTableModel();
        lectorData = new LectorData(conexion);
        listaLectores = lectorData.getPrestamoVencido();
        prestamoData = new PrestamoData(conexion);
        cargarLectores();
        armarCabeceraTabla();
        cargarDatos();
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
        jLabel2 = new javax.swing.JLabel();
        jcbLectores = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtLectores = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("LECTORES CON PRESTAMOS VENCIDOS");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("LECTORES");

        jcbLectores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbLectoresActionPerformed(evt);
            }
        });

        jtLectores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtLectores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34)
                        .addComponent(jcbLectores, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbLectores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void cargarLectores(){
        for(Lector item:listaLectores){
                jcbLectores.addItem(item);
        }
    }
    
    public void armarCabeceraTabla(){
        ArrayList <Object> columnas = new ArrayList<>();
        columnas.add("ISBN LIBRO");
        columnas.add("FECHA PRESTAMO");
        for(Object it:columnas){
            modelo.addColumn(it);
        }
        jtLectores.setModel(modelo);
    }
    
    public void borrarFilasTabla(){
       int a = modelo.getRowCount()-1;
       for(int i=a; i>=0; i--){
           modelo.removeRow(i);
       }
    }
    
    public void cargarDatos(){
        borrarFilasTabla();
        Lector lector = (Lector)jcbLectores.getSelectedItem();
        
        listaPrestamos = prestamoData.getByLector(lector);
        for(Prestamo i:listaPrestamos){
            if(i.getLector().getDni()==lector.getDni()){
                modelo.addRow(new Object[]{i.getEjemplar().getIsbn_libro(), i.getFecha() });
            }
        }
    }
    private void jcbLectoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbLectoresActionPerformed
        // TODO add your handling code here:
        cargarDatos();
    }//GEN-LAST:event_jcbLectoresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<Lector> jcbLectores;
    private javax.swing.JTable jtLectores;
    // End of variables declaration//GEN-END:variables
}
