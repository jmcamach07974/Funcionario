
package FUNCIONARIOS;

public class FUNCIONARIO2 {

    int id_serial_funcionario;
    String tipo_documento;
    int numero_documento;
    String nombres;
    String apellidos;
    String est_civil;
    String sexo;
    String direccion;
    String telefono;
    String fecha_nacimiento;

    public FUNCIONARIO2() {

    }

    public FUNCIONARIO2(int id_serial, String tipo_documento, int numero_documento, String nombres, String apellidos, String est_civil,
            String sexo, String direccion, String telefono, String fecha_nacimiento) {

        this.id_serial_funcionario = id_serial;
        this.tipo_documento = tipo_documento;
        this.numero_documento = numero_documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.est_civil = est_civil;
        this.sexo = sexo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setId_serial_funcionario(int id_serial_funcionario) {
        this.id_serial_funcionario = id_serial_funcionario;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public void setNumero_documento(int numero_documento) {
        this.numero_documento = numero_documento;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEst_civil(String est_civil) {
        this.est_civil = est_civil;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getId_serial_funcionario() {
        return id_serial_funcionario;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public int getNumero_documento() {
        return numero_documento;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEst_civil() {
        return est_civil;
    }

    public String getSexo() {
        return sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

}
