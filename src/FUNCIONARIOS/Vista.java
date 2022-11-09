
package FUNCIONARIOS;

import DAO.Conexion;
import INTERFACES.DAO_METODOS_IMPLEMENTACION;
import java.sql.*;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Vista extends javax.swing.JFrame {

    String[] columnas = {"id_serial_funcionar", "id_tipo_documento", "numero_documento", "nombres", "apellidos", "id_serial_est_ci", "id_serial_sexo", "direccion", "telefono", "fecha_nacimiento"};
    DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
        @Override
        public boolean isCellEditable(int filas, int columnas) {
            if (columnas == 10) {
                return true;
            } else {
                return false;
            }

        }

    };
    DAO_METODOS_IMPLEMENTACION dao = new DAO_METODOS_IMPLEMENTACION();
    List<FUNCIONARIO2> data = new ArrayList<>();

    
    public Vista() {
        initComponents();
        CargarTabla();
        CargarCombo();
        CargarCombo2();
    }

    public void limpiar() {
        txtId.setText("");
        jComboBox1.setSelectedIndex(0);
        txtNumDoc.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        jComboBox2.setSelectedIndex(0);
        txtSexo.setText("");
        txtDire.setText("");
        txtTelef.setText("");
        txtFecNaci.setText("");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNumDoc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtSexo = new javax.swing.JTextField();
        txtDire = new javax.swing.JTextField();
        txtTelef = new javax.swing.JTextField();
        txtFecNaci = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        txtApellido = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFuncionarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos "));

        jLabel1.setText("Tipo Documento");

        txtNumDoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumDocKeyTyped(evt);
            }
        });

        jLabel2.setText("Numero Documento");

        jLabel3.setText("Nombre");

        jLabel4.setText("Estado Civil");

        jLabel5.setText("Género");

        jLabel6.setText("Dirección");

        jLabel7.setText("Teléfono");

        jLabel8.setText("Fecha Nacimiento");

        txtTelef.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefKeyTyped(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 51));
        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 255, 102));
        jButton3.setText("Insertar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtId.setEditable(false);
        txtId.setBackground(new java.awt.Color(204, 204, 204));

        jLabel9.setText("Id:");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel10.setText("Apellidos");

        jButton4.setText("Limpiar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(46, 46, 46)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNumDoc, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtSexo, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtDire, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtFecNaci, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTelef, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTelef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFecNaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Funcionarios"));

        tbFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbFuncionarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DAO_METODOS_IMPLEMENTACION funcionario_dao = new DAO_METODOS_IMPLEMENTACION();
        FUNCIONARIO funcio = new FUNCIONARIO();

        if (txtNumDoc.getText().equals("") || txtNombre.getText().equals("") || txtApellido.getText().equals("") || txtSexo.getText().equals("") || txtDire.getText().equals("") || txtTelef.getText().equals("") || txtFecNaci.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor complete los campos faltantes");
        } else {
            
        
        int numero_documento = Integer.parseInt(txtNumDoc.getText());
        String nombres = txtNombre.getText();
        String apellidos = txtApellido.getText();
        String sexo = txtSexo.getText().toUpperCase();
        String direccion = txtDire.getText();
        String telefono = txtTelef.getText();
        String Fecha_nacimiento = txtFecNaci.getText();
        funcio.setNumero_documento(numero_documento);
        funcio.setNombres(nombres);
        funcio.setApellidos(apellidos);
        funcio.setSexo(sexo);
        funcio.setDireccion(direccion);
        funcio.setTelefono(telefono);
        funcio.setFecha_nacimiento(Fecha_nacimiento);

        for (int i = 0; i < listTypeDocument.size(); i++) {
            //System.out.println(listTypeDocument.get(i).getNombre());
            if (listTypeDocument.get(i).getNombre().equals(jComboBox1.getSelectedItem().toString())) {
                funcio.setTipo_documento(listTypeDocument.get(i).getId_tipo_documento());
                //System.out.println(listTypeDocument.get(i).getId_tipo_documento());
                break;
            }
        }

        for (int i = 0; i < listTypeEstado_Cilvil.size(); i++) {

            if (listTypeEstado_Cilvil.get(i).getNombre().equals(jComboBox2.getSelectedItem().toString())) {
                funcio.setEst_civil(listTypeEstado_Cilvil.get(i).getId_serial_est_ci());
                break;
            }
        }

        funcionario_dao.registar(funcio);
        limpiar(); }
        CargarTabla();
    }//GEN-LAST:event_jButton3ActionPerformed

    List<TIPO_DOCUMENTO> listTypeDocument;

    private void CargarCombo() {
        DAO_METODOS_IMPLEMENTACION dato = new DAO_METODOS_IMPLEMENTACION();
        List<TIPO_DOCUMENTO> data2 = (List<TIPO_DOCUMENTO>) dato.CargarTablacombo();

        listTypeDocument = data2;

        jComboBox1.removeAllItems();

        for (int i = 0; i < data2.size(); i++) {

            jComboBox1.addItem(data2.get(i).getNombre());

        }
    }

    List<ESTADO_CIVIL> listTypeEstado_Cilvil;

    private void CargarCombo2() {
        DAO_METODOS_IMPLEMENTACION dato = new DAO_METODOS_IMPLEMENTACION();
        List<ESTADO_CIVIL> data3 = (List<ESTADO_CIVIL>) dato.CargarTablacombo2();

        listTypeEstado_Cilvil = data3;

        jComboBox2.removeAllItems();

        for (int i = 0; i < data3.size(); i++) {
            jComboBox2.addItem(data3.get(i).getNombre());
        }
    }

    public void CargarTabla() {
        tbFuncionarios.getTableHeader().setReorderingAllowed(false); //Para evitar que se puedan mover las columnas del JTable
        this.modelo.setRowCount(0);
        data.clear();
        data = (List<FUNCIONARIO2>) dao.CargarTabla();
        Object[] obj = new Object[10];
        for (FUNCIONARIO2 fila : data) {
            //System.out.println(fila.getId_sexo());
            obj[0] = fila.getId_serial_funcionario();
            obj[1] = fila.getTipo_documento();
            obj[2] = fila.getNumero_documento();
            obj[3] = fila.getNombres();
            obj[4] = fila.getApellidos();
            obj[5] = fila.getEst_civil();
            obj[6] = fila.getSexo();
            obj[7] = fila.getDireccion();
            obj[8] = fila.getTelefono();
            obj[9] = fila.getFecha_nacimiento();

           
            this.modelo.addRow(obj);
        }

        this.tbFuncionarios.setModel(modelo);
    }

    private void tbFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbFuncionariosMouseClicked

        this.txtId.setText(tbFuncionarios.getValueAt(tbFuncionarios.getSelectedRow(), 0).toString());
        this.jComboBox1.setSelectedItem(tbFuncionarios.getValueAt(tbFuncionarios.getSelectedRow(), 1).toString());
        this.txtNumDoc.setText(tbFuncionarios.getValueAt(tbFuncionarios.getSelectedRow(), 2).toString());
        this.txtNombre.setText(tbFuncionarios.getValueAt(tbFuncionarios.getSelectedRow(), 3).toString());
        this.txtApellido.setText(tbFuncionarios.getValueAt(tbFuncionarios.getSelectedRow(), 4).toString());
        this.jComboBox2.setSelectedItem(tbFuncionarios.getValueAt(tbFuncionarios.getSelectedRow(), 5).toString());
        this.txtSexo.setText(tbFuncionarios.getValueAt(tbFuncionarios.getSelectedRow(), 6).toString());
        this.txtDire.setText(tbFuncionarios.getValueAt(tbFuncionarios.getSelectedRow(), 7).toString());
        this.txtTelef.setText(tbFuncionarios.getValueAt(tbFuncionarios.getSelectedRow(), 8).toString());
        this.txtFecNaci.setText(tbFuncionarios.getValueAt(tbFuncionarios.getSelectedRow(), 9).toString());

    }//GEN-LAST:event_tbFuncionariosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DAO_METODOS_IMPLEMENTACION funcionario_dao = new DAO_METODOS_IMPLEMENTACION();
        FUNCIONARIO funcio = new FUNCIONARIO();
        
        if (txtNumDoc.getText().equals("") || txtNombre.getText().equals("") || txtApellido.getText().equals("") || txtSexo.getText().equals("") || txtDire.getText().equals("") || txtTelef.getText().equals("") || txtFecNaci.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor complete los campos");
        } else {
            
        
        int id_serial_funcionario = Integer.parseInt(txtId.getText());
        int numero_documento = Integer.parseInt(txtNumDoc.getText());
        String nombres = txtNombre.getText();
        String apellidos = txtApellido.getText();
        String sexo = txtSexo.getText().toUpperCase();
        String direccion = txtDire.getText();
        String telefono = txtTelef.getText();
        String Fecha_nacimiento = txtFecNaci.getText();
        funcio.setId_serial_funcionario(id_serial_funcionario);
        funcio.setNumero_documento(numero_documento);
                funcio.setNombres(nombres);
        funcio.setApellidos(apellidos);
        funcio.setSexo(sexo);
        funcio.setDireccion(direccion);
        funcio.setTelefono(telefono);
        funcio.setFecha_nacimiento(Fecha_nacimiento);

        for (int i = 0; i < listTypeDocument.size(); i++) {
            //System.out.println(listTypeDocument.get(i).getNombre());
            if (listTypeDocument.get(i).getNombre().equals(jComboBox1.getSelectedItem().toString())) {
                funcio.setTipo_documento(listTypeDocument.get(i).getId_tipo_documento());
                //System.out.println(listTypeDocument.get(i).getId_tipo_documento());
                break;
            }
        }

        for (int i = 0; i < listTypeEstado_Cilvil.size(); i++) {

            if (listTypeEstado_Cilvil.get(i).getNombre().equals(jComboBox2.getSelectedItem().toString())) {
                funcio.setEst_civil(listTypeEstado_Cilvil.get(i).getId_serial_est_ci());
                break;
            }
        }

        funcionario_dao.modificar(funcio);
        limpiar();}
        CargarTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DAO_METODOS_IMPLEMENTACION funcionario_dao = new DAO_METODOS_IMPLEMENTACION();
        FUNCIONARIO funcio = new FUNCIONARIO();

        if (txtId.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un registro");
        } else {
            int id_serial_funcionario = Integer.parseInt(txtId.getText());
            funcio.setId_serial_funcionario(id_serial_funcionario);

            funcionario_dao.eliminar(funcio);
            limpiar();
            JOptionPane.showMessageDialog(null, "registro eliminado");

        }
        CargarTabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtNumDocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumDocKeyTyped

        if (txtNumDoc.getText().length() >= 10) {
            evt.consume();
        }

        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txtNumDoc.getText().trim().length() == 10) {
            evt.consume();
        }      
        
    }//GEN-LAST:event_txtNumDocKeyTyped

    private void txtTelefKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefKeyTyped

if (txtTelef.getText().length() >= 10) {
            evt.consume();
        }

        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (txtTelef.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefKeyTyped

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        limpiar();
    }//GEN-LAST:event_jButton4ActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbFuncionarios;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDire;
    private javax.swing.JTextField txtFecNaci;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumDoc;
    private javax.swing.JTextField txtSexo;
    private javax.swing.JTextField txtTelef;
    // End of variables declaration//GEN-END:variables

}
