/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import Entidades.Alumno;
import java.sql.*;
import java.time.LocalDate;
//import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        String sql = "INSERT INTO `alumno`(`dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado`)"
                + "VALUES ('[value-1]','3341','Castello','Donzalo','26-02-2024','TRUE')";
        PreparedStatement ps = null;
        //ResultSet rs = null;

        try {
            ps = con.prepareStatement(sql);
            //ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            /*ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(LocalDate.MAX));
            ps.setBoolean(5, alumno.isActivo());*/
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error de conección.");
        }
    }

}


