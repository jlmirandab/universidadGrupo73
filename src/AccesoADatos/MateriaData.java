
package AccesoADatos;

import Entidades.Alumno;
import Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class MateriaData {
    
   private Connection con= null;

    public MateriaData() {
        con = Conexion.getConexion();
    }
    
    public Materia buscarMateriaid (int idMateria){
        Materia materia = null;
    String sql1 = "SELECT idMateria FROM materia WHERE idMateria=?";
    PreparedStatement ps = null;
    try {
        ps = con.prepareStatement(sql1);
        ps.setInt(1, idMateria); 
        ResultSet rs = ps.executeQuery();


        if (rs.next()) {
            materia = new Materia();
            materia.setIdMateria(rs.getInt("idMateria"));
            JOptionPane.showMessageDialog(null, "La materia está en la lista");
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
    public Materia buscarMateria(String nombre, int año) {
    Materia materia = null; 
    String sql1 = "SELECT nombre, año FROM materia WHERE nombre = ? AND año = ?";
    PreparedStatement ps = null;

    try {
        // Preparamos la consulta SQL con parámetros.
        ps = con.prepareStatement(sql1);
        ps.setString(1, nombre); 
        ps.setInt(2, año);
        

        ResultSet rs = ps.executeQuery();


        if (rs.next()) {
            materia = new Materia();
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
            

            String sql= "UPDATE materia SET nombre=?, año=?, estado=? WHERE idMateria=? ";

            PreparedStatement ps= null;
            
        try {
           ps= con.prepareStatement(sql);
           ps.setString(1, materia.getNombre());
           ps.setInt(2, materia.getAño());

           ps.setBoolean(3, materia.isEstado());
           ps.setInt(4, materia.getIdMateria());
           

           ps.setBoolean(3, (true));
          

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
        
        public void eliminarMateria(int id){
        try {
            String sql= "UPDATE materia SET estado =0 WHERE idMateria=?";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, id);
           
            int fila= ps.executeUpdate();
            
            
            if(fila==1){
                JOptionPane.showMessageDialog(null, "Se elimino la materia, ID: " + id);
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }
        
        
        }
        
        public void activarMateria(int id){
        try {
            String sql= "UPDATE materia SET estado =1 WHERE idMateria=?";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, id);
           
            int fila= ps.executeUpdate();
            
            
            if(fila==1){
                JOptionPane.showMessageDialog(null, "Se activo la materia, ID: " + id);
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }
        
        
        }
        
        public List <Materia> listarMateria(){
        List<Materia> materias = new ArrayList<>();
        
        String sql= "SELECT * FROM materia WHERE estado=1";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Materia materia= new Materia();
                
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("Nombre"));
                materia.setAño(rs.getInt("Año"));
                materia.setEstado(rs.getBoolean("estado"));
                
                
                materias.add(materia);
                System.out.println(materia);
                
            }
            JOptionPane.showMessageDialog(null, "Materias listadas" );
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la tabla materia"+ ex.getMessage());
            
        }
        return materias;
        
    }
    }

    
    
    
    
    
    
    
    
    
    


           
           
           
           
         
