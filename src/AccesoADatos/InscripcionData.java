/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;


/**
 *
 * @author Pc
 */
public class InscripcionData {

    private Connection con = null;
    private MateriaData md= new MateriaData();
    private AlumnoData ad= new AlumnoData();

    public InscripcionData() {
        con = (Connection) Conexion.getConexion();
    }

    public void guardarInscripcion(Inscripcion inscripcion) {

        String sql = "INSERT INTO inscripcion(nota, idAlumno, idMateria) VALUES (?, ?, ?)";     
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, inscripcion.getNota());
            ps.setInt(2, inscripcion.getAlumno().getIdAlumno());
            ps.setInt(3, inscripcion.getMateria().getIdMateria());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                inscripcion.setIdInscripcion(rs.getInt(1));
                System.out.println("Inscripcion realizada con exito");
            }
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error no se pudo guardar la isncripcion");
        }

    }
    public void actualizarNota(int idAlumno, int idMateria, double nota){
        
        String sql = "UPDATE incripcion SET nota = ? WHERE idAlumno = ? and idMateria = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int fila=ps.executeUpdate();
            if(fila >0){
                System.out.println("Nota actualizada");
                
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al actualizar nota");
        }
    
    }
    
    
    public List <Inscripcion> obtenerIncripciones(){
        ArrayList<Inscripcion> cursadas= new ArrayList <>();
        String sql="SELECT * FROM inscripcion";
    try {
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs= ps.executeQuery();
        while(rs.next()){ 
            Inscripcion insc= new Inscripcion(); //creo objeto inscripcion
            insc.setIdInscripcion(rs.getInt("idInscripcion"));
            Alumno alu=ad.buscarAlumno(rs.getInt("idAlumno"));
            Materia mat=md.buscarMateria(rs.getInt("idMateria"));
            insc.setAlumno(alu);
            insc.setMateria(mat);
            insc.setNota(rs.getInt("nota"));
            cursadas.add(insc);           //guardo la inscripcion en el arraylist  

        }
        ps.close();

    } catch (SQLException ex) {
        System.out.println("Error al acceder a tabla inscripcion");
    }
        return cursadas;
    }
    
    
    public List <Inscripcion> obtenerIncripcionesPorAlumno(int id){ //idAlumno
                    ArrayList<Inscripcion> cursadas= new ArrayList <>();
        String sql="SELECT * FROM inscripcion WHERE idAlumno = ?";
    try {
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs= ps.executeQuery();
        while(rs.next()){ 
            Inscripcion insc= new Inscripcion(); //creo objeto inscripcion
            insc.setIdInscripcion(rs.getInt("idInscripcion"));
            Alumno alu=ad.buscarAlumno(rs.getInt("idAlumno"));
            Materia mat=md.buscarMateria(rs.getInt("idMateria"));
            insc.setAlumno(alu);
            insc.setMateria(mat);
            insc.setNota(rs.getInt("nota"));
            cursadas.add(insc);           //guardo la inscripcion en el arraylist  

        }
        ps.close();

    } catch (SQLException ex) {
        System.out.println("Error al acceder a tabla inscripcion");
    }
        return cursadas;

    }
        
        
    public List <Materia> obtenerMateriasCursadas(int id){ //idAlumno
        ArrayList<Materia>  materias = new ArrayList<>();
        String sql = "SELECT inscripcion.idMateria, nombre, anio FROM inscripcion,"
                    + "materia WHERE inscripcion.idMateria = materia.idMateria" +
                        " AND inscripcion.idAlumno = ?;";
    try {
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Materia materia= new Materia();
            materia.setIdMateria(rs.getInt("idMateria"));
            materia.setNombre(rs.getString("nombre"));
            materia.setAnioMateria(rs.getInt("anio"));
            materias.add(materia);

        }
        ps.close();
    } catch (SQLException ex) {
        System.out.println("Error al acceder a tabla inscripcion");

    }
        return materias;

    }
    
    
    public List <Materia> obtenerMateriasNoCursadas(int id){ //idAlumno
        ArrayList<Materia> materias = new ArrayList<>();
        String sql= "SELECT * FROM materia WHERE estado = 1 AND idMateria not in"
                +"(SELECT idMateria FROM inscripcion WHERE idAlumno =?);";

        try {PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Materia materia= new Materia();
            materia.setIdMateria(rs.getInt("idMateria"));
            materia.setNombre(rs.getString("nombre"));
            materia.setAnioMateria(rs.getInt("anio"));
            materias.add(materia);

        }
        ps.close();
    } catch (SQLException ex) {
        System.out.println("Error al acceder a tabla materia");

    }
        return materias;
    }
        
    
    void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria){

        String sql="DELETE FROM inscripcion WHERE idAlumno = ? and idMateria = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt( 1,idAlumno);
        ps.setInt(2,idMateria);
        int filas=ps.executeUpdate();
        if (filas>0){
            JOptionPane.showMessageDialog(null, "INSCRIPCION BORRADA");

        }
        ps.close();
    } catch (SQLException ex) {
        System.out.println("Error al acceder a tabla inscripcion");
    }

    }
    
    
   public List <Alumno> obtenerAlumnoXMateria(int idMateria){
        ArrayList<Alumno> alumnos= new ArrayList<>();
        String sql="SELECT a.idAlumno, dni, nombre, apellido, fechaNacimiento, estado"
                +" FROM inscripcion i, alumno a WHERE i.idAlumno = a.idAlumno AND idMateria = ? AND a.estado = 1";
    try {
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1, idMateria);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Alumno alumno=new Alumno();
            alumno.setIdAlumno(rs.getInt("idAlumno"));
            alumno.setApellido(rs.getString("apellido"));
            alumno.setNombre(rs.getString("nombre"));
            alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
            alumno.setActivo(rs.getBoolean("estado"));
            alumnos.add(alumno);

        }
        ps.close();
    } catch (SQLException ex) {
    System.out.println("Error al acceder a tabla inscripcion/alumno");
    }

    return alumnos;

    }
        
}


