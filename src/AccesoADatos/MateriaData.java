
package AccesoADatos;

import Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class MateriaData {
    
   private Connection con= null;

    public MateriaData() {
        con = Conexion.getConexion();
    }
    public Materia buscarMateria(String nombre, int año) {
    Materia materia = null; // Inicializamos materia como nulo (no encontrada) por defecto.
    String sql1 = "SELECT nombre, año FROM materia WHERE nombre = ? AND año = ?";
    PreparedStatement ps = null;

    try {
        // Preparamos la consulta SQL con parámetros.
        ps = con.prepareStatement(sql1);
        ps.setString(1, nombre); // Establecemos el primer parámetro (nombre).
        ps.setInt(2, año); // Establecemos el segundo parámetro (año).
        
        // Ejecutamos la consulta SQL y obtenemos el resultado.
        ResultSet rs = ps.executeQuery();

        // Comprobamos si encontramos un resultado.
        if (rs.next()) {
            // Si encontramos un resultado, creamos un objeto "Materia".
            materia = new Materia();
            // Configuramos los atributos de la materia con los valores de la consulta.
            materia.setNombre(rs.getString("nombre"));
            materia.setAño(rs.getInt("año"));
            materia.setEstado(true); 
            
            JOptionPane.showMessageDialog(null, "La materia ya está en la lista");
        } else {
            
            JOptionPane.showMessageDialog(null, "No se encontró la materia");
        }
        rs.close();
        ps.close();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "ERROR en la consulta");
    } 
    return materia;
}
    
    public void guardarMateria (Materia materia){
       String sql = "INSERT INTO materia (nombre, año, estado) VALUES (?,?,?)";
     
        try {
           PreparedStatement ps1 = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps1.setString(1, materia.getNombre());
           ps1.setInt(2, materia.getAño());
           ps1.setBoolean(3, true);
           ps1.executeUpdate();
           ResultSet rs= ps1.getGeneratedKeys();
                    
           if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia agregada exitosamente");
                }
                ps1.close();

                }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No se pudo guardar la materia");
                }

            } 
        
        public void modificarMateria(Materia materia){
            
            String sql= "UPDATE materia SET nombre=?, año=?, estado=? WHERE estado=1 ";
            PreparedStatement ps= null;
            
        try {
           ps= con.prepareStatement(sql);
           ps.setString(1, materia.getNombre());
           ps.setInt(2, materia.getAño());
           ps.setBoolean(3, materia.isEstado());
           int exito=ps.executeUpdate();
           
           if(exito==1){
               JOptionPane.showMessageDialog(null, "Se modificó la materia");
               
           }else{
               JOptionPane.showMessageDialog(null, "La materia no existe");
           }
           
           
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "ERROR al acceder a la tabla materia"+ex.getMessage());
       }   
        }
        
    }
    
    
    
    
    
    
    
    
    
    


           
           
           
           
         
