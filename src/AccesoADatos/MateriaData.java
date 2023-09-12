
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
        con= Conexion.getConexion();
    }
    
    public void guardarMateria (Materia materia){
        
        String sql= "INSERT INTO materia (nombre, año, estado) VALUES (?,?,?)";
        
       try {
           PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps.setString(1, materia.getNombre());
           ps.setInt(2, materia.getAño());
           ps.setBoolean(3, materia.isEstado());
           
           System.out.println(ps.executeUpdate());
           
           ResultSet rs= ps.getGeneratedKeys();
           if(rs.next()){
              materia.setIdMateria(rs.getInt("idMateria"));
              JOptionPane.showMessageDialog(null, "Materia agregada exitosamente");
               
           }else{
               JOptionPane.showMessageDialog(null, "No se pudo guardar la materia");
           }
            ps.close();
            
       } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla");
       }
        
    }
    
}
