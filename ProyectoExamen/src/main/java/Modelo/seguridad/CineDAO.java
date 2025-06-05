/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.seguridad;

import Controlador.seguridad.Cine; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import Modelo.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class CineDAO {

    private static final String SQL_SELECT = "SELECT idCines, Nombre, Dirección FROM cines";
    private static final String SQL_INSERT = "INSERT INTO cines(idCines, Nombre, Dirección) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE cines SET Nombre=?, Dirección=? WHERE idCines = ?";
    private static final String SQL_DELETE = "DELETE FROM cines WHERE idCines=?";
    private static final String SQL_QUERY = "SELECT idCines, Nombre, Dirección FROM cines WHERE idCines = ?";

    public List<Cine> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cine cine = null;
        List<Cine> cines = new ArrayList<Cine>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idCines = rs.getInt("idCines");
                String Nombre = rs.getString("Nombre");
                String Dirección = rs.getString("Dirección");
                
                cine = new Cine();
                cine.setIdCines(idCines);
                cine.setNombre(Nombre);
                cine.setDirección(Dirección);
                
                cines.add(cine);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return cines;
    }

    public int insert(Cine cine) { 
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, cine.getIdCines());
            stmt.setString(2, cine.getNombre());
            stmt.setString(3, cine.getDirección());

            System.out.println("ejecutando query: " + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Cine cine) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, cine.getNombre());
            stmt.setString(2, cine.getDirección());
            stmt.setInt(3, cine.getIdCines());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado: " + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Cine cine) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cine.getIdCines());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados: " + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public Cine query(Cine cine) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cine> cines = new ArrayList<Cine>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, cine.getIdCines());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idCines = rs.getInt("idCines");
                String Nombre = rs.getString("Nombre");
                String Dirección = rs.getString("Dirección");
                
                cine = new Cine();
                cine.setIdCines(idCines);
                cine.setNombre(Nombre);
                cine.setDirección(Dirección);

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return cine; 
    }

        
}
