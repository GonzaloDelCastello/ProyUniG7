/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import java.sql.Connection;
import Entidades.Alumno;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

//import java.time.LocalDate;
//import java.util.logging.Level;
//import java.util.logging.Logger;

//import org.mariadb.jdbc.export.Prepare;


/**
 *
 * @author matiSqui
 */
public class AlumnoData {

    private Connection con = null; //declaración de "con" tipo conexion

    public AlumnoData() {
        con = Conexion.getConexion();
    }

    public void guardarAlumno(Alumno alumno) {
        /*String sql = "INSERT INTO `alumno`(`idAlumno`, `dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado`)"
                + "VALUES ('[value-1]','3341','Castello','Donzalo','26-02-2024','TRUE')";*/
        String sql = "INSERT INTO alumno(dni, apellido, nombre, fechaNacimiento, activo)"
                + "VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement ps =con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3,alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isActivo());
            ps.executeUpdate();
            
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno Guardado");
            }
            ps.close();
            
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"Error al acceder a la tabla alumno");
            
        }

        
    }
    public void modificarAlumno(Alumno alumno){
        String sql= "UPDATE alumno SET dni= ?, apellido = ? , nombre = ?, fechaNacimiento = ?"
                + "WHERE idAlumno = ?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1,alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3,alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setInt(5, alumno.getIdAlumno());
            int exito = ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Alumno modificado");
            }
                
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al accedera a la tabla alumno");
        }
        
    }
    public void eliminarAlumno(int id) {
        String sql = "UPDATE alumno SET activo = 0 WHERE idAlumno = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if(exito ==1){
                JOptionPane.showMessageDialog(null, "Alumno eliminado");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al accedera a la tabla alumno");
        }
        
    }
    public Alumno buscarAlumno(int id){
        String sql="SELECT dni,apellido,nombre,fechaNacimiento FROM alumno WHERE idAlumno=? AND activo =1 ";
        Alumno alumno = null;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                alumno=new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(true);
                
            }else{
                JOptionPane.showMessageDialog(null, "No eiste el alumno ese ");
            }
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al accedera a la tabla alumno");
        }
       return alumno;
    }
    public Alumno buscarAlumnoPorDni(int dni){
        String sql="SELECT idAlumno ,dni,apellido,nombre,fechaNacimiento FROM alumno WHERE dni=? AND activo =1 ";
        Alumno alumno = null;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                alumno=new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(true);
                
            }else{
                JOptionPane.showMessageDialog(null, "No eiste el alumno ese ");
            }
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al accedera a la tabla alumno");
        }
       return alumno;
    }
     
    
    public List<Alumno>  listaAlumnos(){
        String sql="SELECT dni,apellido,nombre,fechaNacimiento FROM alumno WHERE activo =1 ";
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try {
            PreparedStatement ps=con.prepareStatement(sql);
         
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Alumno alumno=new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(true);
                
                alumnos.add(alumno);
            }
            ps.close();
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error hacer la lista");
        }
       return alumnos;
    }

}



