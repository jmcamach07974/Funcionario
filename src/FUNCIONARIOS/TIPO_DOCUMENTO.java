
package FUNCIONARIOS;

public class TIPO_DOCUMENTO {

    int id_tipo_documento;
    String nombre;

    public TIPO_DOCUMENTO() {

    }

    public TIPO_DOCUMENTO(int id_tipo_documento, String nombre) {
        this.id_tipo_documento = id_tipo_documento;
        this.nombre = nombre;

    }

    public int getId_tipo_documento() {
        return id_tipo_documento;
    }

    public void setId_tipo_documento(int id_tipo_documento) {
        this.id_tipo_documento = id_tipo_documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
