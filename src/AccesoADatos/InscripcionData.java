
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

import javax.swing.JOptionPane;
import Entidades.Inscripcion;

public class InscripcionData {
    private Connection con=null;
    private MateriaData materiadata = new MateriaData();
    private AlumnoData aludata= new AlumnoData();
    
    Alumno a=new Alumno();

    public InscripcionData() {
        con=Conexion.getConexion();
    }
        public void guardarInscripcion (Inscripcion insc){
       String sql = "INSERT INTO inscripcion  (nota, idAlumno, idMateria) VALUES (?,?,?)";
     
        try {
           PreparedStatement ps1 = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps1.setDouble(1, insc.getNota());
           ps1.setInt(2, insc.getAlumno().getIdAlumno());
           ps1.setInt(3, insc.getMateria().getIdMateria());
           ps1.executeUpdate();
           ResultSet rs= ps1.getGeneratedKeys();
                    
           if (rs.next()) {
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripcion registrada");
                }
                ps1.close();

                }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
                }

            }
            
            
        public void actualizarNota(int idAlumno, int idMateria, double nota){
            
            String sql= "UPDATE inscripcion SET nota=? WHERE idAlumno= ? AND idMateria= ?";
            
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            
            int filas= ps.executeUpdate();
            
            if(filas==1){
                JOptionPane.showMessageDialog(null, "Se actualizó la nota");
            
            }
            ps.close();
            
            
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
            
        }    
            
       public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria){
           
           String sql= "DELETE FROM inscripcion WHERE idAlumno= ? And idMateria= ?";
           
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int filas =ps.executeUpdate();
            
            if(filas==1){
                JOptionPane.showMessageDialog(null, "Se Borro la inscripción a la materia");
                
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
           
           
       }
      
       public List<Inscripcion> obtenerInscripciones(){
           
           ArrayList<Inscripcion> cursadas= new ArrayList<>();
           
           String sql= "SELECT * FROM inscripcion";
           
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                
                Inscripcion insc= new Inscripcion();
                
                //Recupero del rs los datos de la inscripcion
                
                insc.setIdInscripcion(rs.getInt("idInscripto"));
                Alumno alu= aludata.buscarAlumnoPorId(rs.getInt("idAlumno"));
                Materia mat= materiadata.buscarMateriaid(rs.getInt("idMateria"));
                
                //los seteo
                insc.setAlumno(alu);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                 //los agrego a la lista   
                cursadas.add(insc);
                
            }
            
            ps.close();
            
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion"); 
        }
           
           
         return cursadas;  
           
       }
       
       
       
       
       
}
