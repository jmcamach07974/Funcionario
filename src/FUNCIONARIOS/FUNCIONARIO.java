
package FUNCIONARIOS;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class FUNCIONARIO {

    int id_serial_funcionario;
    int tipo_documento;
    int numero_documento;
    String nombres;
    String apellidos;
    int est_civil;
    String sexo;
    String direccion;
    String telefono;
    String fecha_nacimiento;
    int id_sexo;
    
   
    
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
        return this.sexo;
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
        java.sql.Date fechaConvertida = null;

        try {
            java.util.Date parsed = dateFormat.parse(this.fecha_nacimiento);
            fechaConvertida = new java.sql.Date(parsed.getTime());
        } catch (Exception e) {
            System.out.println("Error occurred" + e.getMessage());
        }
        return fechaConvertida;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getId_sexo() {
        return id_sexo;
    }

    public void setId_sexo(int id_sexo) {
        this.id_sexo = id_sexo;
    }
}
