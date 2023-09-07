
package AccesoADatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Conexion {
    private String url, bd, usuario, pass, driver;
    private Connection conexion;

    public Conexion(String bd) {
        this.bd = bd;
        url= "jdbc:mariadb://localhost:3306/";
        usuario= "root";
        pass="";
        driver="org.mariadb.jdbc.Driver";
        
    }
    
    public Connection conectar(){
        
        try {
            Class.forName(driver);
            conexion= DriverManager.getConnection(url+bd,"root","");
            JOptionPane.showMessageDialog(null, "Conexión exitosa!");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el driver");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexión");
            
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
 
   public static void main(String[] args) {
       
       Conexion conexion= new Conexion ("universidadulp");
       conexion.conectar();
       
       
       
}
}
