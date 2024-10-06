import AccesoADatos.Conexion;
import Entidades.Alumno;
//import org.mariadb.jdbc.Connection;
import AccesoADatos.AlumnoData;
import AccesoADatos.InscripcionData;
import AccesoADatos.MateriaData;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pc
 */
public class TestGonzalo {

    public static void main(String[] args) {
        //Connection con =(Connection) Conexion.getConexion();
        
        Materia materia1 = new Materia();
        Inscripcion inscripcion1 = new Inscripcion();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd,mm,yyyy");
        
        Alumno alumno1 = new Alumno();
        AlumnoData aluData = new AlumnoData();
        //aluData.guardarAlumno(alumno1);
        MateriaData mateData = new MateriaData();
        mateData.guardarMateria(materia1);
        InscripcionData inscripData = new InscripcionData();
        inscripData.guardarInscripcion(inscripcion1);
        
        String fechaIngresada = "26-04-1988";
        //Date fecha = dateFormat.parse(fechaIngresada);
        
        
        
    }
     
}
