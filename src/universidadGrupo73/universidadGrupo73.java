
package universidadGrupo73;

import AccesoADatos.Conexion;
import java.sql.Connection;
import AccesoADatos.AlumnoData;
import AccesoADatos.InscripcionData;
import AccesoADatos.MateriaData;



import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.time.LocalDate;
import java.time.Month;
//sintaxis para cambiar modificar la fecha del Localdate al crear un alumno
//Hacer un if en MateriaData en el metodo de ModificarMateria para poder encontrar la materia sin el id

public class universidadGrupo73 {
    
    public static void main (String []args){
        
        Connection conexion = Conexion.getConexion();
        Alumno alumno1= new Alumno( 4, 36314380, "Caselli", "Paula", LocalDate.of(1950,5,25), true);
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
       Materia materia3= new Materia (8,"Estadística", 2, true);
       Materia materia4= new Materia ("Quimica", 1, true);
       Materia materia5= new Materia("Fisica", 3, true);
       Materia materia6= new Materia(15,"Taller", 3, true);
       
       
       
       MateriaData mater= new MateriaData();
//       
       //mater.buscarMateria("Lengua", 1);
       //mater.guardarMateria(materia6); 
       //mater.modificarMateria(materia3);
      //mater.eliminarMateria(6);
      //mater.activarMateria(4);
      //mater.listarMateria();
        InscripcionData id=new InscripcionData();
        
      
//       Alumno Matias=alum.buscarAlumnoPorId(5);
//       Materia mate=mater.buscarMateriaid(4);
//       Inscripcion insc=new Inscripcion(9,Matias, mate);
       
        
        //id.guardarInscripcion(insc);
        
        for (Inscripcion inscripcion: id.obtenerInscripciones() ){
            
            System.out.println("id inscripción: " + inscripcion.getIdInscripcion());
            System.out.println("Apellido: " + inscripcion.getAlumno().getApellido());
            System.out.println("Materia: " + inscripcion.getMateria().getNombre());
            
        }
       
        
        //id.actualizarNota(8, 8, 7);
       
      

    }
        
        
    }