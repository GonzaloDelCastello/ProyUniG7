/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import Entidades.Materia;
import org.mariadb.jdbc.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pc
 */
public class MateriaData {
    
    private Connection con = null;
    
    public MateriaData(){
        con = (Connection) Conexion.getConexion();
    }
    
    public void guardarMateria(Materia materia){
        String sql = "INSERT INTO `materia`(`idMateria`, `nombre`, `anio`, `estado`)" 
                + "VALUES ('[value-1]','Lengua','2024','TRUE')";
        
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error de coneccion");
        }
        
    }
}

