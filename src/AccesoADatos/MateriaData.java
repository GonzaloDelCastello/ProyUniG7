/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import Entidades.Materia;
import org.mariadb.jdbc.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pc
 */
public class MateriaData {
    
    private Connection con = null;
    
    public MateriaData(){
        con = (Connection) Conexion.getConexion();
    }
    
    public void guardarMateria(Materia materia) {
        String sql = "INSERT INTO materia(nombre, anio, estado) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isActivo());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "MATERIA CARGADA");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar materia");
        }
    }
    
    public Materia buscarMateria(int id){
        
        String sql = "SELECT * FROM materia WHERE idMateria=?";
        Materia materia = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,id); 
            

           ResultSet rs = ps.getGeneratedKeys();
           if (rs.next()) {
               materia = new Materia();
               materia.setIdMateria(rs.getInt("idMateria"));
               materia.setNombre(rs.getString("nombre"));
               materia.setAnioMateria(rs.getInt("anio"));
               materia.setActivo(rs.getBoolean("estado"));
            }
           

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar materia");
        }
        return materia;
    }
        
    public void modificarMateria(Materia materia) {
        String sql = "UPDATE materia SET nombre =?, anio = ?, estado = ? WHERE idMateria = ?"; 
        try(PreparedStatement ps = con.prepareStatement(sql)){
           ps.setString(1, materia.getNombre());
           ps.setInt(2, materia.getAnioMateria());
           ps.setBoolean(3, materia.isActivo());
           ps.setInt(4, materia.getIdMateria());
           
           ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Materia Modificada");

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al Modificar Materia");
        }
    }
    
    public void eliminarMateria(int id) {
        String sql = "UPDATE materia SET estado = 0 WHERE idMateria = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if(filas >0){
                JOptionPane.showMessageDialog(null, "Materia Eliminada con exito");               
                }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al eliminar la materia");
        }
            
             
        
    }
    
    
    public List<Materia> listarMaterias(){
        List<Materia> materias = new ArrayList<>();
        String sql = "SELECT * FROM materia";
          try (
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery()) {
        {
            while(rs.next()){
                Materia materia = new Materia(
                        rs.getInt("idMateria"),
                        rs.getString("nombre"),
                         rs.getInt("anio"),
                        rs.getBoolean("estado"));
            materias.add(materia);
            }
        }
    }   catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al listar las materias");
        }
          return materias;
    }
          }

