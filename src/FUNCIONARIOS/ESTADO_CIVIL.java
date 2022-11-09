
package FUNCIONARIOS;

public class ESTADO_CIVIL {

    int id_serial_est_ci;
    String nombre;

    public ESTADO_CIVIL() {

    }

    public ESTADO_CIVIL(int id_serial_est_ci, String nombre) {
        this.id_serial_est_ci = id_serial_est_ci;
        this.nombre = nombre;

    }

    public int getId_serial_est_ci() {
        return id_serial_est_ci;
    }

    public void setId_serial_est_ci(int id_serial_est_ci) {
        this.id_serial_est_ci = id_serial_est_ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
