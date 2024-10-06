/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import Entidades.Inscripcion;
import Entidades.Materia;
import java.sql.*;
import java.sql.SQLException;
import org.mariadb.jdbc.Connection;


/**
 *
 * @author Pc
 */
public class InscripcionData {

    private Connection con = null;

    public InscripcionData() {
        con = (Connection) Conexion.getConexion();
    }

    public void guardarInscripcion(Inscripcion inscripcion) {
        String sql = "INSERT INTO `inscripcion`(`idInscripcion`, `nota`, `idAlumno`, `idMateria`)"
                + "VALUES ('[value-1]','9','1','2')";

        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error de coneccion");
        }

    }

}

