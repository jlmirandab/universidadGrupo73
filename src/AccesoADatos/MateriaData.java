
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
    
    public Materia buscarMateria (String nombre, int año){
        Materia materia= null;
        String sql1 = "SELECT nombre, año FROM materia WHERE nombre= ? AND año=? ";
        PreparedStatement ps= null;
        
       try {
           ps = con.prepareStatement(sql1);
           ps.setString(1, "nombre");
           ps.setInt(2, año);
           ResultSet rs = ps.executeQuery();
           System.out.println(rs.next());
            if (rs.next()) {
                
                materia = new Materia();
                materia.setNombre(rs.getString(nombre));
                materia.setAño(rs.getInt(año));
                materia.setEstado(true);
                JOptionPane.showMessageDialog(null, "La materia ya esta en la lista");
            }else{
                JOptionPane.showMessageDialog(null, "No se encontró la materia");
                ps.close();
            }
           
                
       } catch (SQLException ex) {
           Logger.getLogger(MateriaData.class.getName()).log(Level.SEVERE, null, ex);
       }
       return materia;
    }
        
    }
    
//    
//    public void guardarMateria(Materia materia) {
//        
//String sql = "INSERT INTO materia (nombre, año, estado) VALUES (?,?,?)";
//    
//                            
//                
//                try {
//                    PreparedStatement ps1 = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//                    ps1.setString(1, materia.getNombre());
//                    ps1.setInt(2, materia.getAño());
//                    if (rs.next()) {
//
//                        materia.setIdMateria(rs.getInt(1));
//                        JOptionPane.showMessageDialog(null, "Materia agregada exitosamente");
//
//                    } else {
//
//                        JOptionPane.showMessageDialog(null, "No se pudo guardar la materia");
//                    }
//
//                    ps.close();
//
//                } catch (SQLException ex) {
//
//                    JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla");
//                }
//
//            }
//        
//
//    
//       
//    
//}
//}

           
           
           
           
         
