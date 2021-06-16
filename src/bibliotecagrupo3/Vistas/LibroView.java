/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotecagrupo3.Vistas;

import bibliotecaGrupo3.Controllers.Conexion;
import bibliotecagrupo3.Controllers.AutorData;
import bibliotecagrupo3.Controllers.LibroData;
import bibliotecagrupo3.Models.Autor;
import bibliotecagrupo3.Models.Libro;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Nahu
 */
public class LibroView extends javax.swing.JInternalFrame {

    private LibroData libroData;
    private AutorData autorData;

    /**
     * Creates new form LibroView
     */
    public LibroView(Conexion con) throws SQLException {
        initComponents();
        libroData = new LibroData(con);
        autorData = new AutorData(con);
        cargarAutores();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfEditorial = new javax.swing.JTextField();
        jtfAño = new javax.swing.JTextField();
        jtfTipo = new javax.swing.JTextField();
        jtfNombre = new javax.swing.JTextField();
        jtfIsbn = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();
        jbBorrar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jcbAutor = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(187, 246, 252));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("~LIBRO~");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("NOMBRE:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("EDITORIAL:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("AÑO:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("TIPO:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("ISBN:");

        jbGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbGuardar.setText("GUARDAR");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbBorrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbBorrar.setText("BORRAR");
        jbBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarActionPerformed(evt);
            }
        });

        jbModificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbModificar.setText("MODIFICAR");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbSalir.setBackground(new java.awt.Color(233, 107, 67));
        jbSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbSalir.setText("SALIR");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jbBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbBuscar.setText("BUSCAR");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbLimpiar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbLimpiar.setText("LIMPIAR CAMPOS");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Autor:");

        jcbAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAutorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtfEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfAño, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jtfTipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jbLimpiar))
                            .addComponent(jtfIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addComponent(jbBuscar)
                .addGap(18, 18, 18)
                .addComponent(jbGuardar)
                .addGap(18, 18, 18)
                .addComponent(jbBorrar)
                .addGap(18, 18, 18)
                .addComponent(jbModificar)
                .addGap(18, 18, 18)
                .addComponent(jbSalir)
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jtfEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbBorrar)
                    .addComponent(jbModificar)
                    .addComponent(jbSalir)
                    .addComponent(jbBuscar))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        
        Libro libro = new Libro();
        String isbnT = jtfIsbn.getText();
        int isbn = 0;
        try {
            isbn = Integer.parseInt(isbnT);
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "El campo isbn solo admite numeros");
            return;
        }
        libro.setIsbn(isbn);
        /////////////////////
        Autor seleccionado=(Autor)jcbAutor.getSelectedItem();
        
        
        libro.setAutor(seleccionado);
        
        String nombre = jtfNombre.getText();
        if (nombre.equals("")) {
            JOptionPane.showMessageDialog(null, "El nombre es requerido");
            return;
        }
        libro.setNombre(nombre);
        //////////////////////////////////
        String editorial = jtfEditorial.getText();
        if (editorial.equals("")) {
            JOptionPane.showMessageDialog(null, "La editorial es requerida");
            return;
        }
        libro.setEditorial(editorial);
        //////////////////////////////////
        String año = jtfAño.getText();
        if (año.equals("")) {
            JOptionPane.showMessageDialog(null, "El año es requerido");
            return;
        }
        int anio = 0;
        try {
            anio = Integer.parseInt(año);
            if(anio<=2021&&anio>=1900){
            libro.setAño(anio);
            
            }else{
            JOptionPane.showMessageDialog(null, "El año tiene que ser entre 1900 y 2021");
            return;
            }
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "El campo año solo admite numeros");
            return;
        }
        
        //////////////////////////////////
        String tipo = jtfTipo.getText();
        if (tipo.equals("")) {
            JOptionPane.showMessageDialog(null, "El tipo es un campo requerido");
            return;
        }
        libro.setTipo(tipo);
        //////////////////////////////////
        
        libroData.guardarLibro(libro);
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        String isT = jtfIsbn.getText();
        if (isT.equals("")) {
            JOptionPane.showMessageDialog(null, "Es necesario el isbn");
            return;
        }
        int isbn = 0;
        try {
            isbn = Integer.parseInt(isT);
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "El isbn solo tiene que contener numeros");
            return;
        }
        Libro libro = null;
        libro = libroData.buscarLibro(isbn);
        if (libro == null) {
            return;
        }
//        jtfIdAutor.setText;
        jtfNombre.setText(libro.getNombre());
        jtfEditorial.setText(libro.getEditorial());
        jtfAño.setText("" + libro.getAño());
        jtfTipo.setText(libro.getTipo());
        jtfIsbn.setText("" + libro.getIsbn());

    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        Libro libro=new Libro();
        Autor seleccionado=(Autor)jcbAutor.getSelectedItem();
        libro.setAutor(seleccionado);
        //1//
        String isbnT = jtfIsbn.getText();
         if (isbnT.equals("")) {
            JOptionPane.showMessageDialog(null, "El dni es requerido para hacer la busqueda, mostrar los resultados y luego modificar el Autor");
            return;
        }
        int isbn = 0;
        try {
            isbn = Integer.parseInt(isbnT);
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "El dni del autor solo admite numeros");
            return;
        }
        libro.setIsbn(isbn);
        //2//
        String nombre = jtfNombre.getText();
        if(nombre.equals("")){
            JOptionPane.showMessageDialog(null,"El nombre es requerido.");
            return;
        }
        libro.setNombre(nombre);
        //3//
        String editorial = jtfEditorial.getText();
        if(editorial.equals("")){
            JOptionPane.showMessageDialog(null,"La editorial es requerida.");
            return;
        }
        libro.setEditorial(editorial);
        //4//
        String añoT = jtfAño.getText();
         if (añoT.equals("")) {
            JOptionPane.showMessageDialog(null, "El año es requerido");
            return;
        }
        int año = 0;
        try {
            año = Integer.parseInt(añoT);
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "El año del libro solo admite numeros");
            return;
        }
        libro.setAño(año);
        //5//
        String tipo = jtfTipo.getText();
        if(tipo.equals("")){
        JOptionPane.showMessageDialog(null, "El tipo es requerido");
        }
        libro.setTipo(tipo);
        libroData.modificarLibro(libro);
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarActionPerformed
       jtfIsbn.requestFocus();
       String isbnString=jtfIsbn.getText();
       if(isbnString.equals("")){
       JOptionPane.showMessageDialog(null,"Para borrar un libro ingrese su isbn");
       return;
       }
       int isbn = 0;
       
       try{
           isbn = Integer.parseInt(isbnString);
       }catch(NumberFormatException nf){
       JOptionPane.showMessageDialog(null, "El campo isbn solo admite numeros.");
       return;
       }

       int op = JOptionPane.showConfirmDialog(this, "Esta seguro borrar el libro?", "ATENCION!!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
       if(op==JOptionPane.YES_OPTION){
       
       libroData.borrarLibro(isbn);
       limpiar();
       }
       
    }//GEN-LAST:event_jbBorrarActionPerformed

    private void jcbAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAutorActionPerformed
        
    }//GEN-LAST:event_jcbAutorActionPerformed
    public void cargarAutores(){
    List<Autor> lista=autorData.getAllAutores();
    for(Autor it:lista){
    jcbAutor.addItem(it);}
    }
    
    public void limpiar() {
        jtfNombre.setText("");
        jtfEditorial.setText("");
        jtfAño.setText("");
        jtfTipo.setText("");
        jtfIsbn.setText("");
    }

    /*public void cargarAutores() {
        List<Autor> lista = autorData.getAllAutores();
        for (Autor a : lista) {
            jcbAutor.addItem(a);
        }}*/
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton jbBorrar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Autor> jcbAutor;
    private javax.swing.JTextField jtfAño;
    private javax.swing.JTextField jtfEditorial;
    private javax.swing.JTextField jtfIsbn;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfTipo;
    // End of variables declaration//GEN-END:variables
}
