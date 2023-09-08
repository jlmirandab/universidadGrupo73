
package AccesoADatos;

import Entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
        
public class AlumnoData {
    
    private Connection con=null;

    public AlumnoData() {
        con= Conexion.getConexion();
        
        
    }
    
    public void guardarAlumno (Alumno alumno){
        
        String sql= "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado)"
                + "VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString (3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate();
            
            ResultSet rs= ps.getGeneratedKeys();
            
            if(rs.next()){
                alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno Agregado Exitosamente!");
               
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla alumno");
            
        }
        
        
    }
    
    

  
    
    
    
    
    
    
}
