
package AccesoADatos;

import Entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la acción");
            
        }
        
       
    }
    public Alumno buscarAlumnoPorId(int id){
        Alumno alumno= null;
        String sql= "SELECT dni, apellido, nombre, fechaNacimiento FROM alumno WHERE idAlumno=? AND estado=1";
        PreparedStatement ps= null;
        
        try {
            
            ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
             alumno= new Alumno();
             alumno.setIdAlumno(id);
             alumno.setDni(rs.getInt("dni"));
             alumno.setApellido(rs.getString("apellido"));
             alumno.setNombre(rs.getNString("nombre"));
             alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
             alumno.setEstado(true);
             JOptionPane.showMessageDialog(null, "Se encontró el alumno " + alumno.toString());
              
            }else{
               JOptionPane.showMessageDialog(null, "No se encontró el alumno");
               ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR al acceder a la tabla alumno"+ ex.getMessage());
         
        }return alumno;
     
    }
    
    public Alumno buscarAlumnoPorDni(int dni){
        
        Alumno alumno= null;
        String sql= "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento FROM alumno WHERE dni= ? AND estado=1";
        PreparedStatement ps= null;
       
        try {
            ps= con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                alumno= new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
                JOptionPane.showMessageDialog(null, "Se encontró el alumno " + alumno.toString());
            }else{
                JOptionPane.showMessageDialog(null, "No existe el alumno");
            }        
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se encontró el dni");
        }
        
        return alumno;
     
    }
    
    public List<Alumno> listarAlumnos(){
        List<Alumno> alumnos= new ArrayList<>();
        
        String sql= "SELECT * FROM alumno WHERE estado=1";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Alumno alumno= new Alumno();
                
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                
                alumnos.add(alumno);
                System.out.println(alumno);
                
            }
            JOptionPane.showMessageDialog(null, "Alumnos listados " );
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la tabla Alumno"+ ex.getMessage());
            
        }
        return alumnos;
        
    }

    public void modificarAlumno(Alumno alumno){
        
        String sql= "UPDATE alumno SET dni= ?, apellido= ?, nombre=?, fechaNacimiento= ? WHERE idAlumno=? ";
        
        PreparedStatement ps= null;
        
        try {
            ps= con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setInt(5, alumno.getIdAlumno());
            int exito= ps.executeUpdate();
            
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Modificado exitósamente");
            }else{
                JOptionPane.showMessageDialog(null, "El alumno NO existe");
                
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno"+ ex.getMessage());
            
        }
        
        
    }
    
    
    
    
    
    
}
