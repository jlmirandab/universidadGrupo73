
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

public class universidadGrupo73 {
    
    public static void main (String []args){
        
        Connection conexion = Conexion.getConexion();
        
        Alumno alumno1= new Alumno( 4, 36314380, "Caselli", "Paula", LocalDate.of(1950,5,25), true);
        Alumno alumno2= new Alumno ( 5, 3952415, "Peralta", "Lorena", LocalDate.now(), true);
        Alumno alumno3= new Alumno (8, 36314370, "Perez", "Matias", LocalDate.now(), true);
        
        AlumnoData alum= new AlumnoData();
       

        Materia materia1= new Materia("Lengua", 1, true);
        Materia materia2= new Materia ("Matemática", 2, true);
        Materia materia3= new Materia ("Estadística", 2, true);
        Materia materia4= new Materia ("Quimica", 1, true);
        Materia materia5= new Materia("Fisica", 3, true);
        Materia materia6= new Materia("Taller", 3, true);
        
       
        MateriaData mater= new MateriaData();
        
        //mater.guardarMateria(materia2);
       
        Inscripcion insc=new Inscripcion(7, alumno1, materia4);
        InscripcionData id=new InscripcionData();
       //id.actualizarNota(8, 8, 10);
        //mater.modificarMateria(materia7);
       
//        for (Inscripcion inscripcion: id.obtenerInscripciones() ){
//            
//            System.out.println("id inscripción: " + inscripcion.getIdInscripcion());
//            System.out.println("Apellido: " + inscripcion.getAlumno().getApellido());
//            System.out.println("Materia: " + inscripcion.getMateria().getNombre());

//            }
               Materia materia7=new Materia("Literatura", 1, true);
        Materia materia8= new Materia ("Estadística", 3, true);
        Materia materia9= new Materia ("Matematica", 2, true);
        Materia materia10= new Materia ("Matematica", 1, true);
        
        //mater.guardarMateria(materia9);
        //mater.guardarMateria(materia10);
       

        
        //id.guardarInscripcion(insc);
        

//            
//        }
       
//        for (Inscripcion inscripcion: id.obtenerInscripcionesporAlumno(4)){
////            
////            System.out.println("id: "+inscripcion.getIdInscripcion());
////            System.out.println("Apellido: " + inscripcion.getAlumno().getApellido());
////            System.out.println("Materia :"+inscripcion.getMateria().getNombre()); 
////        }
//
//    }
//                for (Materia materias: id.obtenerMateriasCursadas(4)){
//           
//           System.out.println("id: "+ materias.getIdMateria());
//           
//            System.out.println("Materia :"+materias.getNombre());
//       
//        
//    }
//   for (Materia materias: id.obtenerMateriasNoCursadas(4)){
////            
////            System.out.println("id: "+ materias.getIdMateria());
////            
////            System.out.println("Materia :"+materias.getNombre());
////    }
        for (Alumno alumno: id.obtenerAlumnosXMateria(8)){
            
            System.out.println("id: "+alumno.getIdAlumno());
            System.out.println("Nombre: "+alumno.getNombre());
            System.out.println("Apellido: "+alumno.getApellido());
            


       
       

//            
//            
//        }
       
//              for (Inscripcion inscripcion: id.obtenerInscripcionesporAlumno(4)){
//            
//            System.out.println("id: "+inscripcion.getIdInscripcion());
//            System.out.println("Apellido: " + inscripcion.getAlumno().getApellido());
//            System.out.println("Materia :"+inscripcion.getMateria().getNombre()); 
//        }
        

//           for (Materia materias: id.obtenerMateriasCursadas(4)){
//           
//           System.out.println("id: "+ materias.getIdMateria());
//           
//            System.out.println("Materia :"+materias.getNombre());
//         }
//            for (Materia materias: id.obtenerMateriasNoCursadas(4)){
//            
//            System.out.println("id: "+ materias.getIdMateria());
//            
//            System.out.println("Materia :"+materias.getNombre());
//    }
        





    } 
}

}
    
   
