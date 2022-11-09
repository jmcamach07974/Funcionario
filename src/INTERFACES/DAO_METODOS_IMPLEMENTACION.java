
package INTERFACES;

import DAO.Conexion;
import FUNCIONARIOS.ESTADO_CIVIL;
import FUNCIONARIOS.FUNCIONARIO;
import FUNCIONARIOS.FUNCIONARIO2;
import FUNCIONARIOS.TIPO_DOCUMENTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAO_METODOS_IMPLEMENTACION implements DAO_METODOS {

    Connection conexion = Conexion.establecerConexion();
    List<FUNCIONARIO2> data = new ArrayList<>();
    List<TIPO_DOCUMENTO> data2 = new ArrayList<>();
    List<ESTADO_CIVIL> data3 = new ArrayList<>();

    public int SelectIdTexto(String columna, String Tabla, String Texto) {
        int id = 0;
        String consultaTipoDoc = "SELECT " + columna + " FROM funcionario.\"" + Tabla + "\" WHERE \"Nombre\"=" + "'" + Texto + "'" + ";";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(consultaTipoDoc);

            while (rs.next()) {
                id = Integer.parseInt(rs.getString(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.toString());
        }

        return id;
    }

    @Override
    public void registar(FUNCIONARIO funcionario) {

        String ConsultaSexo = "INSERT INTO funcionario.sexo(\"Nombre\") SELECT UPPER(?) WHERE NOT EXISTS(SELECT \"Nombre\" FROM funcionario.sexo WHERE \"Nombre\" = UPPER(?));";

        try {

            CallableStatement cs = conexion.prepareCall(ConsultaSexo);
            cs.setString(1, funcionario.getSexo());
            cs.setString(2, funcionario.getSexo());

            cs.execute();

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.toString());
        }

        String sSQL = "SELECT numero_documento FROM funcionario.\"Funcionario\" WHERE numero_documento='" + funcionario.getNumero_documento() + "';";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                JOptionPane.showMessageDialog(null, "Num Documento ya existe");
                return;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        int Sexo = SelectIdTexto("id_serial_sexo", "sexo", funcionario.getSexo());
        String consulta = "INSERT INTO funcionario.\"Funcionario\"(id_tipo_documento, numero_documento, nombres, apellidos, id_serial_est_ci, id_serial_sexo, direccion, telefono, fecha_nacimiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            CallableStatement cs = conexion.prepareCall(consulta);

            cs.setInt(1, funcionario.getTipo_documento());
            cs.setInt(2, funcionario.getNumero_documento());
            cs.setString(3, funcionario.getNombres());
            cs.setString(4, funcionario.getApellidos());
            cs.setInt(5, funcionario.getEst_civil());
            cs.setInt(6, Sexo);
            cs.setString(7, funcionario.getDireccion());
            cs.setString(8, funcionario.getTelefono());
            cs.setDate(9, funcionario.getFecha_nacimiento());

            
            cs.execute();

            JOptionPane.showMessageDialog(null, "Inserto Correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.toString());
        }

    }

    @Override
    public void modificar(FUNCIONARIO funcionario) {

        String ConsultaSexo = "INSERT INTO funcionario.sexo(\"Nombre\") SELECT UPPER(?) WHERE NOT EXISTS(SELECT \"Nombre\" FROM funcionario.sexo WHERE \"Nombre\" = UPPER(?));";

        try {

            CallableStatement cs = conexion.prepareCall(ConsultaSexo);
            cs.setString(1, funcionario.getSexo());
            cs.setString(2, funcionario.getSexo());

            cs.execute();

             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.toString());
        }

        String sSQL = "SELECT numero_documento FROM funcionario.\"Funcionario\" WHERE numero_documento='" + funcionario.getNumero_documento() + "';";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                String sSQL2 = "SELECT numero_documento FROM funcionario.\"Funcionario\" WHERE id_serial_funcionario='" + funcionario.getId_serial_funcionario() + "';";
                try {
                    Statement st2 = conexion.createStatement();
                    ResultSet rs2 = st2.executeQuery(sSQL2);

                    while (rs2.next()) {
                        if (!rs2.getString(1).equals(rs.getString(1))) {
                            JOptionPane.showMessageDialog(null, "Num Documento ya existe");
                            return;
                        }
                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        int Sexo = SelectIdTexto("id_serial_sexo", "sexo", funcionario.getSexo());
        String consulta = "UPDATE funcionario.\"Funcionario\" SET id_tipo_documento=?, numero_documento=?, nombres=?, apellidos=?, id_serial_est_ci=?, id_serial_sexo=?, direccion=?, telefono=?, fecha_nacimiento=? WHERE id_serial_funcionario=?";

        try {
            CallableStatement cs = conexion.prepareCall(consulta);
            cs.setInt(1, funcionario.getTipo_documento());
            cs.setInt(2, funcionario.getNumero_documento());
            cs.setString(3, funcionario.getNombres());
            cs.setString(4, funcionario.getApellidos());
            cs.setInt(5, funcionario.getEst_civil());
            cs.setInt(6, Sexo);
            cs.setString(7, funcionario.getDireccion());
            cs.setString(8, funcionario.getTelefono());
            cs.setDate(9, funcionario.getFecha_nacimiento());
            cs.setInt(10, funcionario.getId_serial_funcionario());
            cs.execute();

            JOptionPane.showMessageDialog(null, "Se Modificó Correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.toString());
        }

    }

    @Override
    public void eliminar(FUNCIONARIO funcionario) {

        String consulta = "DELETE FROM funcionario.\"Funcionario\" WHERE id_serial_funcionario=?;";

        try {
            CallableStatement cs = conexion.prepareCall(consulta);

            cs.setInt(1, funcionario.getId_serial_funcionario());

            cs.execute();

            JOptionPane.showMessageDialog(null, "Se Elimino Correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e.toString());
        }
    }

    @Override
    public void seleccionar(FUNCIONARIO funcionario) {

    }

    @Override
    public List<?> CargarTabla() {

        String sSQL = "SELECT id_serial_funcionario, d.\"Nombre\" AS tipo_docum, f.numero_documento, nombres, apellidos, e.\"Nombre\" AS estado_civil, s.\"Nombre\" AS sexo, direccion, telefono, fecha_nacimiento FROM funcionario.\"Funcionario\" AS f INNER JOIN  funcionario.\"TipoDocumento\" AS d ON f.id_tipo_documento=d.id_tipo_documento INNER JOIN funcionario.\"EstadoCivil\" AS e ON f.id_serial_est_ci = e.id_serial_est_ci INNER JOIN funcionario.sexo AS s ON f.id_serial_sexo = s.id_serial_sexo ORDER BY id_serial_funcionario DESC;";

        try {

            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                data.add(new FUNCIONARIO2(
                        rs.getInt("id_serial_funcionario"),
                        rs.getString("tipo_docum"),
                        rs.getInt("numero_documento"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("estado_civil"),
                        rs.getString("sexo"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("fecha_nacimiento")
                ));
                //System.out.println(data);
            }

        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("Excepciones controladas: " + e.getMessage());
        }

        return data;

    }

    public List<?> CargarTablacombo() {

        String sSQL = "SELECT id_tipo_documento, \"Nombre\" FROM funcionario.\"TipoDocumento\";";

        try {

            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {

                data2.add(new TIPO_DOCUMENTO(
                        rs.getInt("id_tipo_documento"),
                        rs.getString("nombre")
                ));

            }

        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("Excepciones controladas: " + e.getMessage());
        }

        return data2;

    }

    public List<?> CargarTablacombo2() {

        String sSQL = "SELECT id_serial_est_ci, \"Nombre\" FROM funcionario.\"EstadoCivil\";";

        try {

            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {

                data3.add(new ESTADO_CIVIL(
                        rs.getInt("id_serial_est_ci"),
                        rs.getString("nombre")
                ));

            }

        } catch (SQLException e) {
            
            System.out.println("Excepciones controladas: " + e.getMessage());
        }

        return data3;

    }

}


