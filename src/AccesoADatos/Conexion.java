
package AccesoADatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class Conexion {
    private static final String URL= "jdbc:mariadb://localhost/";
    private static final String DB= "universidadulp";
    private static final String USUARIO= "root";
    private static final String PASSWORD= "";
    private static Connection conexion;

    public Conexion() {
        
    }
    
    
    public static Connection getConexion(){
        
        if (conexion == null){
            
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conexion= DriverManager.getConnection(URL+DB, USUARIO, PASSWORD);
                JOptionPane.showMessageDialog(null, "Conexión exitosa");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar los drivers");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos");
            }
            
            
        }return conexion;
        
    } 
    
    
    
    public void desconectar(){
        try {
            conexion.close();
            JOptionPane.showMessageDialog(null, "La base de datos se ha desconectado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error");
        }
        
    }
 
   
       
}

