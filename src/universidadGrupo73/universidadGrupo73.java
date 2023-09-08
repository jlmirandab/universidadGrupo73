
package universidadGrupo73;

import AccesoADatos.Conexion;
import java.sql.Connection;
import AccesoADatos.AlumnoData;
import Entidades.Alumno;


import Entidades.Alumno;
import java.time.LocalDate;

public class universidadGrupo73 {
    
    public static void main (String []args){
        
        Connection conexion = Conexion.getConexion();
        Alumno alumno1= new Alumno(36314380, "Redondo", "Paula", LocalDate.now(), true);
        alumno1.
        
    }
    
}
