
package INTERFACES;

import FUNCIONARIOS.FUNCIONARIO;
import java.util.List;

public interface DAO_METODOS {
    
    public void registar(FUNCIONARIO funcionario);
    public void modificar(FUNCIONARIO funcionario);
    public void eliminar(FUNCIONARIO funcionario);
    public void seleccionar(FUNCIONARIO funcionario);
    public List<?> CargarTabla ();
    
}
