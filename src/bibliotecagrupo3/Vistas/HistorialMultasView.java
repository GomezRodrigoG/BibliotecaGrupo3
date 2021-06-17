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
import bibliotecagrupo3.Models.Ejemplar;
import bibliotecagrupo3.Models.Lector;
import bibliotecagrupo3.Models.Libro;
import bibliotecagrupo3.Models.Prestamo;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.naming.Context;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pablo
 */
public class HistorialMultasView extends javax.swing.JInternalFrame {
        private DefaultTableModel modelo;
        private Libro libro;
        private ArrayList<Prestamo> prestamo;
        private Ejemplar ejemplar;
        private Lector lector;
        private LectorData ld;
        private PrestamoData pd;
        private LibroData librod;
        private LocalDate fecha;
    /**
     * Creates new form HistorialDeMultasView
     * @param conexion
     
     */
    public HistorialMultasView(Conexion conexion) throws SQLException {
        initComponents();
        modelo = new DefaultTableModel();
        libro = new Libro();
        lector = new Lector();
        ejemplar = new Ejemplar();
        ld = new LectorData(conexion);
        pd = new PrestamoData(conexion);
        librod = new LibroData(conexion);
        fecha= LocalDate.now();
        armarCabeceraTabla();
       
    }
    
    
        public void armarCabeceraTabla(){
        ArrayList <Object> columnas = new ArrayList<>();
        columnas.add("ID");
        columnas.add("Fecha Inicio");
        columnas.add("Fecha de Fin");
        columnas.add("Libro");
                
        for(Object it:columnas){
            modelo.addColumn(it);
        }
        jtMultas.setModel(modelo);
    }
    
      public void borrarFilasTabla(){
       int a = modelo.getRowCount()-1;
       for(int i=a; i>=0; i--){
           modelo.removeRow(i);
       }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jbBuscar = new javax.swing.JButton();
        jrMultasAVencer = new javax.swing.JRadioButton();
        jrMultasVencidas = new javax.swing.JRadioButton();
        jtDni = new javax.swing.JTextField();
        jtNombre = new javax.swing.JTextField();
        jtApellido = new javax.swing.JTextField();
        JbSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMultas = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("DNI");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Apellido");

        jbBuscar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jrMultasAVencer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrMultasAVencer.setText("Multas a Vencer");
        jrMultasAVencer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrMultasAVencerActionPerformed(evt);
            }
        });

        jrMultasVencidas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrMultasVencidas.setText("Multas Vencidas");
        jrMultasVencidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrMultasVencidasActionPerformed(evt);
            }
        });

        jtNombre.setEditable(false);

        jtApellido.setEditable(false);

        JbSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JbSalir.setText("Salir");
        JbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbSalirActionPerformed(evt);
            }
        });

        jtMultas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtMultas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtDni)
                            .addComponent(jtNombre)
                            .addComponent(jtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jrMultasAVencer)
                        .addGap(83, 83, 83)
                        .addComponent(jrMultasVencidas)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrMultasAVencer)
                    .addComponent(jrMultasVencidas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                .addComponent(jbBuscar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(JbSalir)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        try {
            lector = ld.buscarLector(Integer.parseInt(jtDni.getText()));
            jtNombre.setText(lector.getNombre());
            jtApellido.setText(lector.getApellido());
            jrMultasAVencer.setSelected(true);
            jtDni.setText("");
        } catch (NumberFormatException co) {
            JOptionPane.showMessageDialog(null, "DNI ingresado no existe");
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jrMultasAVencerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrMultasAVencerActionPerformed
        borrarFilasTabla();
        jrMultasVencidas.setSelected(false);
        prestamo = pd.getByLector(lector);
        for(int i=0;i<prestamo.size();i++){
        libro=prestamo.get(i).getEjemplar().getLibro();
        
           if(prestamo.get(i).getMulta()!= null ){
               LocalDate fechaFin = prestamo.get(i).getMulta().getFecha_fin();
               //devuelve si la fecha actual es menor a la que se termnina la multa
               if(fecha.isBefore( fechaFin) ){
               modelo.addRow(new Object[]{prestamo.get(i).getMulta().getId_multa(),prestamo.get(i).getMulta().getFecha_inicio(),
                   prestamo.get(i).getMulta().getFecha_fin(),libro.getNombre()});
               }
           }    
        }
    }//GEN-LAST:event_jrMultasAVencerActionPerformed

    private void jrMultasVencidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrMultasVencidasActionPerformed
        borrarFilasTabla();
        jrMultasAVencer.setSelected(false);
        prestamo = pd.getByLector(lector);
        for(int i=0;i<prestamo.size();i++){
        libro=prestamo.get(i).getEjemplar().getLibro();
        
           if(prestamo.get(i).getMulta()!= null ){
               LocalDate fechaFin = prestamo.get(i).getMulta().getFecha_fin();
               //devuelve si la fecha actual es Mayor a la que se termnina la multa
               if(fecha.isAfter(fechaFin) ){
               modelo.addRow(new Object[]{prestamo.get(i).getMulta().getId_multa(),prestamo.get(i).getMulta().getFecha_inicio(),
                   prestamo.get(i).getMulta().getFecha_fin(),libro.getNombre()});
               }
           }    
        } 
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jrMultasVencidasActionPerformed

    private void JbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbSalirActionPerformed
    this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_JbSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JRadioButton jrMultasAVencer;
    private javax.swing.JRadioButton jrMultasVencidas;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtDni;
    private javax.swing.JTable jtMultas;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables
}
