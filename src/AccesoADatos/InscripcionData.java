/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import Entidades.Inscripcion;
import Entidades.Materia;
import java.sql.*;
import java.sql.SQLException;
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
                JOptionPane.showMessageDialog(null, "Inscripcion realizada");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo realizar la inscripcion");
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
                JOptionPane.showMessageDialog(null, "NOTA ACTUALIZADA");
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }
    
    }
}

