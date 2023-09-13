
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

    //hacer metodo buscarmateria que por paremetro nombre, año.
    //y de ahi llamar al metodo guardar materia si no está
    
    
    public void guardarMateria(Materia materia) {
        
        String sql1 = "SELECT COUNT (*) FROM materia WHERE nombre= ? AND año=? ";
        PreparedStatement ps= null;
        

        try {
            ps = con.prepareStatement(sql1);
            ps.setString(1, "nombre");

            ResultSet rs = ps.executeQuery();
            
            //int count = rs.getInt(sql1);
            rs.next();
            if (rs.getInt(sql1)>0) {
                
                materia = new Materia();
                materia.setNombre("nombre");
                materia.setAño(rs.getInt("año"));
                materia.setEstado(true);
                JOptionPane.showMessageDialog(null, "La materia ya esta en la lista");

            } else {
                            
                String sql = "INSERT INTO materia (nombre, año, estado) VALUES (?,?,?)";
                try {
                    PreparedStatement ps1 = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    ps1.setString(1, materia.getNombre());
                    ps1.setInt(2, materia.getAño());
                    if (rs.next()) {

                        materia.setIdMateria(rs.getInt(1));
                        JOptionPane.showMessageDialog(null, "Materia agregada exitosamente");

                    } else {

                        JOptionPane.showMessageDialog(null, "No se pudo guardar la materia");
                    }

                    ps.close();

                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla");
                }

            }
        }catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null, "ERROR"+ex);

    }
       
    
}
}

           
           
           
           
         
