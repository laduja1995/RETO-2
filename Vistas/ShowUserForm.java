package Vistas;

// 1. importamkos libreria y clase conexión
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ShowUserForm extends java.awt.Dialog {

    // 2. Atributos
    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    ResultSet rs;

    public ShowUserForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        //3. centramos la vista
        this.setLocationRelativeTo(parent);

    }
    //4. Creamos el método que recibe los datos de la tabla de la vista UserMenu

    public void recibeDatos(int idEmp, String nombreEmp, String apellidos, String document, String correo) {
        System.out.println(idEmp + "" nombreEmp + ""  document + "" correo
        );
        txtId.setText("" + idEmp);
        txtNombre.setText(nombreEmp);
        txtApellidos.setText(apellidos);
        txtDocumento.setText(document);
        txtCorreo.setText(correo);
    }
//5. creamos el método que actualizará el nombre, apellidos y correo del usuario

    public void actualizarEmpleado() {
        int idEmp = Integer.parseInt(txtId.getText());
        String documento = txtDocumento.getText();
        String nombre = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        String correo = txtCorreo.getText();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "el nombre del empleado es un campo requerido", " ", JOptionPane.WARNING_MESSAGE);
        } else if (apellidos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "el valor del campo apellidos es requerido.", " ", JOptionPane.WARNING_MESSAGE);
        } else if (correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "el correo del empleado es un campo requerido", " ", JOptionPane.WARNING_MESSAGE);

        } else {

            String query = "UPDATE "empleados" SET "nombreEmp" =  + nombre + " '', 'apellidos'= '"+apellidos+"'  , 'correo'= ' "+correo+"'
            WHERE '+IdEmp+'
            ";";
            try {
                connection = conexion.getConnection();
                st = connection.createStatement();
                st.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Se han actualizado los datos del empleado", "", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "No fue posible actualizar los datos del empleado", "", JOptionPane.ERROR_MESSAGE);
            }

        }
        this.dispose();
    }

    public void EliminarEmpleado (){
        //convierte es tec¿xto que esta entre parentesis en número
        //Integer.parseInt("101");
        int idEmp = Integer.parseInt(txtId.getText());
        String nombreEmp = txtNombre.getText();
        
        String query = "DELETE FROM 'empleados' WHERE idEmp = " + idEmp + ";";
        System.out.println(query);
        try{
            connection = conexion.getConnection();
            st = connection.createStatement();
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(this, "el empleado" + nombreEmp + "ha sido eliminado.");
            
        }catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "el usuario no fue eleiminado.", "", JOptionPane.ERROR_MESSAGE);
        }
        
            this.dispose();
    }
    
    
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnatras = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel1.setText("Id");
        jPanel1.add(jLabel1);

        txtId.setEditable(false);
        txtId.setText("teteteteyd");
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        jPanel1.add(txtId);

        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2);

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre);

        jLabel5.setText("Apellidos");
        jPanel1.add(jLabel5);
        jPanel1.add(txtApellidos);

        jLabel3.setText("Documento");
        jPanel1.add(jLabel3);

        txtDocumento.setEditable(false);
        txtDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoActionPerformed(evt);
            }
        });
        jPanel1.add(txtDocumento);

        jLabel4.setText("correo");
        jPanel1.add(jLabel4);
        jPanel1.add(txtCorreo);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N
        jLabel6.setText("-");
        jPanel1.add(jLabel6);

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/editUser.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/deleteUser.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        jPanel1.add(btnEliminar);

        btnatras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/showUser.png"))); // NOI18N
        btnatras.setText("Ir hacia atras");
        btnatras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnatrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnatras);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizarEmpleado();
        UserMenu userMenu = new UserMenu();
        userMenu.eliminarDatosTablaEmpleado();
        userMenu.listarEmpleados();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentoActionPerformed
        // TODO add your
    }//GEN-LAST:event_txtDocumentoActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnatrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatrasActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnatrasActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ShowUserForm dialog = new ShowUserForm(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnatras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
