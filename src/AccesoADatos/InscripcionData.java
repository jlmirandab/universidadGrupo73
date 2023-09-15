
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
import Entidades.Inscripcion;

public class InscripcionData {
    private Connection con=null;
    private MateriaData materiaData;
    private AlumnoData aludata;
    
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
            
}
