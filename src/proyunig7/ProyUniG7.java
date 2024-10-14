/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyunig7;

import AccesoADatos.AlumnoData;
import AccesoADatos.Conexion;
import AccesoADatos.InscripcionData;
import AccesoADatos.MateriaData;
//import AccesoADatos.Conexion;
import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import Vistas.MenuPrincipal;
import java.sql.Connection;
//import java.sql.*;
import java.time.LocalDate;



/**
 *
 * @author pc
 */
public class ProyUniG7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Connection con = (Connection) Conexion.getConexion();
        
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        Alumno santi =new Alumno(42065601,"Amayaaa","Santiago",LocalDate.of(1999, 7, 3),true);
        AlumnoData alu=new AlumnoData();
        
        //ESTE metodo es paraguardar un alumno manualmente
        alu.guardarAlumno(santi);
        
        //Este metodo es para modificar un alumno manualmente
        //alu.modificarAlumno(santi);
        
        //Este metodo es para eliminar un alumno *lo pone en estado inactivo
        //alu.eliminarAlumno(18);
        
        //Esto es para buscar Alumnos por el id
        /*Alumno alumnoEncontrado = alu.buscarAlumno(14);
            System.out.println("El dni del Alumno buscado por ID es " + alumnoEncontrado.getDni());
            System.out.println("El nombre del Alumno buscado por ID es " + alumnoEncontrado.getNombre());
            System.out.println("El apellido del alumno buscado pro ID es: " + alumnoEncontrado.getApellido());*/
        
        //Este metodo es para uscar alumnos por dni
        /* Alumno alumnoEncontrado = alu.buscarAlumnoPorDni(21345678);
            System.out.println("El nombre del Alumno buscado por DNI es " + alumnoEncontrado.getNombre());
            System.out.println("El apellido del alumno buscado pro DNI es: " + alumnoEncontrado.getApellido());
            System.out.println("El ID del alumno buscado pro DNI es: " + alumnoEncontrado.getIdAlumno());*/
       
        //Este metodo es para mostrar a todos los alumnos en una lista con sus dni nombre etc
       // AlumnoData alu=new AlumnoData();
       /* for(Alumno alumno:alu.listaAlumnos()){
            
            System.out.println(alumno.getDni());
            System.out.println(alumno.getApellido());
            System.out.println(alumno.getNombre());
            System.out.println(alumno.getFechaNac());
        }*/
       
       // *****PRUEBAS*******
       //Cargo para probar una materia
        Materia h = new Materia("HISTORIA", 2024,true);
        MateriaData mate = new MateriaData();
        mate.guardarMateria(h);
        //INSCRIBIR ALUMNO
        Inscripcion id = new Inscripcion(santi, h, 10);
        InscripcionData in = new InscripcionData ();
        
        in.guardarInscripcion(id);
            
    }
    
}