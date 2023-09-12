
package universidadGrupo73;

import AccesoADatos.Conexion;
import java.sql.Connection;
import AccesoADatos.AlumnoData;
import AccesoADatos.MateriaData;



import Entidades.Alumno;
import Entidades.Materia;
import java.time.LocalDate;


public class universidadGrupo73 {
    
    public static void main (String []args){
        
        Connection conexion = Conexion.getConexion();
        Alumno alumno1= new Alumno( 4, 36314380, "Caselli", "Paula", LocalDate.now(), true);
        Alumno alumno2= new Alumno ( 5, 3952415, "Lorena", "Peralta", LocalDate.now(), true);
        Alumno alumno3= new Alumno (8, 36314370, "Matias", "Perez", LocalDate.now(), true);
        
       AlumnoData alum= new AlumnoData();
       //alum.buscarAlumnoPorId(4);
       //alum.buscarAlumnoPorDni(35314380);
       
      //alum.guardarAlumno(alumno3);
       // alum.listarAlumnos();
       //alum.modificarAlumno(alumno1);
       //alum.eliminarAlumnoPorId(4);
       //alum.activarAlumnoPorId(4);
      Materia materia1= new Materia("Lengua", 1, true);
       Materia materia2= new Materia ("Matemática", 2, true);
       Materia materia3= new Materia ("Estadística", 2, true);
     
     MateriaData mater= new MateriaData();
//       
      mater.guardarMateria(materia3);
      
       
    }
        
        
    }