
package act6_postgresql;

import DAO.Conexion;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTextField;
import java.sql.CallableStatement;  
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JComboBox;

public class CFuncionarios {

    int id_serial_funcionario;
    int tipo_documento;
    int  numero_documento;
    String nombres;
    String apellidos;
    int  est_civil;
    String sexo;
    String  direccion;
    String telefono;
    String fecha_nacimiento;
    int id_sexo;

    public int getId_sexo() {
        return id_sexo;
    }

    public void setId_sexo(int id_sexo) {
        this.id_sexo = id_sexo;
    }

   
   
    
    public int getId_serial_funcionario() {
        return id_serial_funcionario;
    }

    public void setId_serial_funcionario(int id_serial_funcionario) {
        this.id_serial_funcionario = id_serial_funcionario;
    }

    public int getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(int tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public int getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(int numero_documento) {
        this.numero_documento = numero_documento;
    }

      public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

   

    public int getEst_civil() {
        return est_civil;
    }

    public void setEst_civil(int est_civil) {
        this.est_civil = est_civil;
    }

   public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public Date getFecha_nacimiento() throws ParseException {
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       java.sql.Date fechaConvertida=null;

       try {
           java.util.Date parsed =  dateFormat.parse(this.fecha_nacimiento);
           fechaConvertida = new java.sql.Date(parsed.getTime());
       } catch(Exception e) {
           System.out.println("Error occurred"+ e.getMessage());
       }
       return fechaConvertida;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
   
 
    
    public void MostrarFuncionarios (JTable paramTableTotalFuncionarios){
        
        Conexion objetoConexion = new Conexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql = "";
     
        modelo.addColumn("Id Serial Funcionario");
        modelo.addColumn("Tipo Documento");
        modelo.addColumn("Numero Documento");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("est_civil");
        modelo.addColumn("Sexo");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        modelo.addColumn("Fecha Nacimiento");
        
        paramTableTotalFuncionarios.setModel(modelo);
        
        sql = "SELECT id_serial_funcionario, d.\"Nombre\", f.numero_documento, nombres, apellidos, e.\"Nombre\", s.\"Nombre\", direccion, telefono, fecha_nacimiento FROM funcionario.\"Funcionario\" AS f INNER JOIN  funcionario.\"TipoDocumento\" AS d ON f.id_tipo_documento=d.id_tipo_documento INNER JOIN funcionario.\"EstadoCivil\" AS e ON f.id_serial_est_ci = e.id_serial_est_ci INNER JOIN funcionario.sexo AS s ON f.id_serial_sexo = s.id_serial_sexo ORDER BY id_serial_funcionario DESC;";
        
        String [] datos = new String[10];
        Statement st;
        
        try{
        
            st= objetoConexion.establecerConexion().createStatement();

           ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                
                datos[0]= rs.getString(1);
                datos[1]= rs.getString(2);
                datos[2]= rs.getString(3);
                datos[3]= rs.getString(4);
                datos[4]= rs.getString(5);
                datos[5]= rs.getString(6);
                datos[6]= rs.getString(7);
                datos[7]= rs.getString(8);
                datos[8]= rs.getString(9);
                datos[9]= rs.getString(10);

                modelo.addRow(datos);
                  
        }
        
        paramTableTotalFuncionarios.setModel(modelo);
    
        }catch(Exception e){
        
             JOptionPane.showMessageDialog(null, "ERROR:"+ e.toString());
             
        }
        
    }
    
    public boolean verficarCampos( JTextField paramNumero_documento, JTextField paramNombre, JTextField paramApellido, JTextField paramSexo, JTextField paramDireccion, JTextField paramTelefono, JTextField paramFecha){
        
        boolean enblanco = false;
        
        if ( "".equals(paramNumero_documento.getText()) || "".equals(paramNombre.getText()) || "".equals(paramApellido.getText()) || "".equals(paramSexo.getText()) || "".equals(paramDireccion.getText()) || "".equals(paramTelefono.getText()) || "".equals(paramFecha.getText())){
            enblanco = true;
            JOptionPane.showMessageDialog(null, "Campos vacios, Ingresa todos los datos");
        }
        return enblanco;
    }
    
    public int SelectIdTexto(String columna,String Tabla, String Texto){
        int id = 0;
        Conexion objetoConexion = new Conexion();
        String consultaTipoDoc = "SELECT "+columna+" FROM funcionario.\""+Tabla+"\" WHERE \"Nombre\"="+"'"+Texto+"'"+";";
        try{
            Statement st = objetoConexion.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(consultaTipoDoc);
            
            while(rs.next()){
                id = Integer.parseInt(rs.getString(1));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR:"+ e.toString());
        }
        
        return id;
    }
    
    public void insertarFuncionarios( JComboBox paramTipo_documento, JTextField paramNumero_documento, JTextField paramNombre, JTextField paramApellido, JComboBox paramEst_civil, JTextField paramSexo, JTextField paramDireccion, JTextField paramTelefono, JTextField paramFecha) throws SQLException{
       
        Conexion objetoConexion = new Conexion();
        
        
        
        
        boolean vacios = verficarCampos(paramNumero_documento, paramNombre, paramApellido,  paramSexo, paramDireccion, paramTelefono, paramFecha  );
   
        if(vacios==true){
            return;
        }
        
        String consulta2 = "INSERT INTO funcionario.sexo(\"Nombre\") SELECT UPPER(?) WHERE NOT EXISTS(SELECT \"Nombre\" FROM funcionario.sexo WHERE \"Nombre\" = UPPER(?));";
        
        try {
            
        CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta2);
        cs.setString(1, getSexo());
        cs.setString(2, getSexo());
        
        cs.execute();
         
       
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR:"+ e.toString());
        }
        
        
        int TipoDoc = SelectIdTexto("id_tipo_documento", "TipoDocumento", paramTipo_documento.getSelectedItem().toString());
        int EstCivil =SelectIdTexto("id_serial_est_ci","EstadoCivil", paramEst_civil.getSelectedItem().toString());;
        int Sexo =SelectIdTexto("id_serial_sexo","sexo", paramSexo.getText().toUpperCase());

        setTipo_documento(TipoDoc); 
        setNumero_documento(Integer.parseInt( paramNumero_documento.getText()));
        setNombres(paramNombre.getText());
        setApellidos(paramApellido.getText());
        setEst_civil(EstCivil);
        setSexo(paramSexo.getText());  
        setId_sexo(Sexo);
        setDireccion(paramDireccion.getText());
        setTelefono(paramTelefono.getText());
        setFecha_nacimiento(paramFecha.getText());
        
        
        
        String sSQL = "SELECT numero_documento FROM funcionario.\"Funcionario\" WHERE numero_documento='"+getNumero_documento()+"';";
        try
        {
          Statement st = objetoConexion.establecerConexion().createStatement();
          ResultSet rs = st.executeQuery(sSQL);
          while (rs.next()){
                    JOptionPane.showMessageDialog(null, "Num Documento ya existe");
            return;
          }
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
        String consulta = "INSERT INTO funcionario.\"Funcionario\"(id_tipo_documento, numero_documento, nombres, apellidos, id_serial_est_ci, id_serial_sexo, direccion, telefono, fecha_nacimiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
             
        
        try {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setInt(1, getTipo_documento());
            cs.setInt(2, getNumero_documento());
            cs.setString(3, getNombres());
            cs.setString(4, getApellidos());
            cs.setInt(5, getEst_civil());
            cs.setInt(6,  getId_sexo());
            cs.setString(7, getDireccion());
            cs.setString(8, getTelefono());
            cs.setDate(9,  getFecha_nacimiento());
            //JOptionPane.showMessageDialog(null,cs);
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Inserto Correctamente"); 
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR:"+ e.toString());
        }
        
      
        
     
     
    }
    
    
    public void SeleccionarFuncionario(JTable paramTablaFuncionario,JTextField paramId_serial_funcionario, JComboBox paramTipo_documento, JTextField paramNumero_documento, JTextField paramNombre, JTextField paramApellido, JComboBox paramEst_civil, JTextField paramSexo, JTextField paramDireccion, JTextField paramTelefono, JTextField paramFecha){
        try {
            
            int fila =paramTablaFuncionario.getSelectedRow();
            
            int TipoDoc = SelectIdTexto("id_tipo_documento","TipoDocumento", paramTablaFuncionario.getValueAt(fila, 1).toString());
            int EstCivil =SelectIdTexto("id_serial_est_ci","EstadoCivil", paramTablaFuncionario.getValueAt(fila, 5).toString());
            
            if (fila>=0){
                
              paramId_serial_funcionario.setText(paramTablaFuncionario.getValueAt(fila, 0).toString());
              paramTipo_documento.setSelectedIndex(TipoDoc-1);  
              paramNumero_documento.setText(paramTablaFuncionario.getValueAt(fila, 2).toString());
              paramNombre.setText(paramTablaFuncionario.getValueAt(fila, 3).toString());
              paramApellido.setText(paramTablaFuncionario.getValueAt(fila, 4).toString());
              paramEst_civil.setSelectedIndex(EstCivil-1);
              paramSexo.setText(paramTablaFuncionario.getValueAt(fila, 6).toString());
              paramDireccion.setText(paramTablaFuncionario.getValueAt(fila, 7).toString());
              paramTelefono.setText(paramTablaFuncionario.getValueAt(fila, 8).toString());
              paramFecha.setText(paramTablaFuncionario.getValueAt(fila, 9).toString());
              
                  
            }else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR:"+ e.toString());
        }
       
        
    }
    
    public void actualizarFuncionarios(JTextField paramId_serial_funcionario, JComboBox paramTipo_documento, JTextField paramNumero_documento, JTextField paramNombre, JTextField paramApellido, JComboBox paramEst_civil, JTextField paramSexo, JTextField paramDireccion, JTextField paramTelefono, JTextField paramFecha){
        
          boolean vacios;
        vacios = verficarCampos(paramNumero_documento, paramNombre, paramApellido, paramSexo, paramDireccion, paramTelefono, paramFecha  );
         Conexion objetoConexion = new Conexion();
        if(vacios==true){
            return;
        }
        
      int TipoDoc = SelectIdTexto("id_tipo_documento", "TipoDocumento", paramTipo_documento.getSelectedItem().toString());
        int EstCivil =SelectIdTexto("id_serial_est_ci","EstadoCivil", paramEst_civil.getSelectedItem().toString());;
        int Sexo =SelectIdTexto("id_serial_sexo","sexo", paramSexo.getText());

        setId_serial_funcionario(Integer.parseInt( paramId_serial_funcionario.getText()));
        setTipo_documento(TipoDoc); 
        setNumero_documento(Integer.parseInt( paramNumero_documento.getText()));
        setNombres(paramNombre.getText());
        setApellidos(paramApellido.getText());
        setEst_civil(EstCivil);
        setSexo(paramSexo.getText());
        setId_sexo(Sexo);
        setDireccion(paramDireccion.getText());
        setTelefono(paramTelefono.getText());
        setFecha_nacimiento(paramFecha.getText());
        
        
         String sSQL = "SELECT numero_documento FROM funcionario.\"Funcionario\" WHERE numero_documento='"+getNumero_documento()+"';";
        try
        {
          Statement st = objetoConexion.establecerConexion().createStatement();
          ResultSet rs = st.executeQuery(sSQL);
          while (rs.next()){
                    JOptionPane.showMessageDialog(null, "Num Documento ya existe");
            return;
          }
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
        String consulta = "UPDATE funcionario.\"Funcionario\" SET id_tipo_documento=?, numero_documento=?, nombres=?, apellidos=?, id_serial_est_ci=?, id_serial_sexo=?, direccion=?, telefono=?, fecha_nacimiento=? WHERE id_serial_funcionario=?";
        
        try {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setInt(1, getTipo_documento());
            cs.setInt(2, getNumero_documento());
            cs.setString(3, getNombres());
            cs.setString(4, getApellidos());
            cs.setInt(5, getEst_civil());
            cs.setInt(6, getId_sexo());
            cs.setString(7, getDireccion());
            cs.setString(8, getTelefono());
            cs.setDate(9,  getFecha_nacimiento());
            cs.setInt(10, getId_serial_funcionario());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se Modificó Correctamente"); 
            
            
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR:"+ e.toString());
        }
     
     
    }
    
    public void EliminarFuncionario(JTextField paramId_serial_funcionario){
        
        setId_serial_funcionario(Integer.parseInt( paramId_serial_funcionario.getText()));
        
        Conexion objetoConexion = new Conexion();
        
        String consulta = "DELETE FROM funcionario.\"Funcionario\" WHERE id_serial_funcionario=?;";
        
        try {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
           
            cs.setInt(1, getId_serial_funcionario());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se Elimino Correctamente"); 
            
            
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR:"+ e.toString());
        }
     
        
        
        
    }
}


