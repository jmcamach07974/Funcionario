
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
  
   private static Connection conectar = null;
    
   private static final String usuario = "jmcamach";
   private static final String password = "jmcamach2022***";
   private static final String bd = "Funcionarios";
   private static final String ip = "localhost";
   private static final String puerto = "5432";
    
   private static final String cadena = "jdbc:postgresql://"+ip+":"+puerto+"/"+bd;

  
    
    public static Connection establecerConexion(){
        
        try{
            Class.forName("org.postgresql.Driver");
        
            conectar = DriverManager.getConnection(cadena,usuario,password);

           
        
        }catch (Exception e){
            
            JOptionPane.showMessageDialog(null, "ERROR:"+ e.toString());
        }
        
        return conectar;
    }
 
}
