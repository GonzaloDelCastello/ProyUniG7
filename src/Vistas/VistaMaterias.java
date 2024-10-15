/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vistas;
import AccesoADatos.MateriaData;
import Entidades.Materia;
import javax.swing.JOptionPane;


/**
 *
 * @author bruno
 */
public class VistaMaterias extends javax.swing.JInternalFrame {

   
    private MateriaData materiaData;
    public VistaMaterias() {
        materiaData = new MateriaData();

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Materia = new javax.swing.JLabel();
        jLabel_Codigo = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        jLabel_Año = new javax.swing.JLabel();
        jLabel_Estado = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        JAño = new javax.swing.JTextField();
        Jnombre = new javax.swing.JTextField();
        jButton_Buscar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jButton_Guardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jButton_Salir = new javax.swing.JButton();
        rbtestado = new javax.swing.JRadioButton();

        jLabel_Materia.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel_Materia.setText("Materia");

        jLabel_Codigo.setText("Código:");

        jLabel_Nombre.setText("Nombre:");

        jLabel_Año.setText("Año:");

        jLabel_Estado.setText("Estado:");

        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });

        JAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JAñoActionPerformed(evt);
            }
        });

        Jnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JnombreActionPerformed(evt);
            }
        });

        jButton_Buscar.setText("Buscar");
        jButton_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BuscarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jButton_Guardar.setText("Guardar");
        jButton_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jButton_Salir.setText("Salir");
        jButton_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel_Año)
                                        .addComponent(jLabel_Estado))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(33, 33, 33)
                                            .addComponent(JAño, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(93, 93, 93)
                                            .addComponent(rbtestado))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnNuevo)
                                    .addGap(28, 28, 28)
                                    .addComponent(btnEliminar)
                                    .addGap(40, 40, 40)
                                    .addComponent(jButton_Guardar)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_Nombre)
                                    .addComponent(jLabel_Codigo))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(codigo, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                    .addComponent(Jnombre)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel_Materia)))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_Salir)
                    .addComponent(jButton_Buscar))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel_Materia)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Codigo)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Buscar))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Nombre)
                    .addComponent(Jnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Año)
                    .addComponent(JAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_Estado)
                    .addComponent(rbtestado))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(jButton_Salir)
                    .addComponent(jButton_Guardar)
                    .addComponent(btnEliminar))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoActionPerformed

    private void JAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JAñoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JAñoActionPerformed

    private void JnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JnombreActionPerformed

    private void jButton_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BuscarActionPerformed
        // TODO add your handling code here:
         try {
        int idMateria = Integer.parseInt(codigo.getText()); 

        MateriaData materiaData = new MateriaData(); // 
        Materia materia = materiaData.buscarMateria(idMateria); 

        if (materia != null) {
           
            Jnombre.setText(materia.getNombre());
            JAño.setText(String.valueOf(materia.getAnioMateria()));
            rbtestado.setSelected(materia.isActivo());

            JOptionPane.showMessageDialog(this, "Materia encontrada");
        } else {
            JOptionPane.showMessageDialog(this, "Materia no encontrada");
            limpiarCampos(); 
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El código debe ser un número válido.");
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al buscar la materia: " + ex.getMessage());
    }

    }//GEN-LAST:event_jButton_BuscarActionPerformed

    private void jButton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarActionPerformed
        // TODO add your handling code here:
        try {
            int id = Integer.parseInt(codigo.getText());
            String nombre = Jnombre.getText();
            int anio = Integer.parseInt(JAño.getText());
            boolean estado = rbtestado.isSelected();
            Materia materia = new Materia(id,nombre,anio,estado);
            if (materiaData.buscarMateria(id)== null) {
                materiaData.guardarMateria(materia);
                JOptionPane.showMessageDialog(this, "Materia Guardado");
                
            } else {
                materiaData.modificarMateria(materia);
                JOptionPane.showMessageDialog(this, "Materia modificada");
            }
            
        btnNuevoActionPerformed(evt); 
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ingresar un código y año válido");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al guardar la materia: " + e.getMessage());
    }

    }//GEN-LAST:event_jButton_GuardarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
         codigo.setText("");
        Jnombre.setText("");
        JAño.setText("");
        rbtestado.setSelected(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
         try {
        int idMateria = Integer.parseInt(codigo.getText()); 

        MateriaData materiaData = new MateriaData(); 
        materiaData.eliminarMateria(idMateria); 
        JOptionPane.showMessageDialog(this, "Materia eliminada ");

        limpiarCampos(); 
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El código debe ser un número válido");
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error al eliminar la materia: " + ex.getMessage());
    }


    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton_SalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JAño;
    private javax.swing.JTextField Jnombre;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JTextField codigo;
    private javax.swing.JButton jButton_Buscar;
    private javax.swing.JButton jButton_Guardar;
    private javax.swing.JButton jButton_Salir;
    private javax.swing.JLabel jLabel_Año;
    private javax.swing.JLabel jLabel_Codigo;
    private javax.swing.JLabel jLabel_Estado;
    private javax.swing.JLabel jLabel_Materia;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JRadioButton rbtestado;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}