/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Modelo.Moto;

/**
 *
 * @author rolet
 */
public class MotoDAO {
    
private Moto moto;
private Connection conexion;
    
    public MotoDAO(){}
    public MotoDAO(Moto moto, Connection conexion) {
        setMoto(moto);
        setConexion(conexion);
    }
    public MotoDAO(Moto moto) {
        setMoto(moto);
    }

    public void insertData(String inputCarrera) throws ClassNotFoundException {
        try {
            DbConnect.loadDriver();
            Connection con = new DbConnect().getConexion();
            String SQLQuery = "INSERT INTO motos" + " (nombre) VALUES" + "(?);";
            PreparedStatement pt = con.prepareStatement(SQLQuery);
            pt.setString(1, inputCarrera);
            pt.executeUpdate();
            System.out.println("Se ha insertado el registro correctamente");
            pt.close();
        } catch (SQLException e) {
            System.err.println("Error insertando los datos: " + e.getMessage());
        }
    }

    public ArrayList<Moto> readData() throws ClassNotFoundException {
        ArrayList<Moto> motos = new ArrayList<>();
        try {
            DbConnect.loadDriver();
            Connection con = new DbConnect().getConexion();
            String SQLQuery = "SELECT * FROM motos";
            PreparedStatement pt = con.prepareStatement(SQLQuery);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                Moto moto = new Moto(id, nombre);
                Moto.add(motos);
            }
        } catch (SQLException ex) {
            System.out.println("Error en la adquisición de datos: " + ex.getMessage());
        }
        return motos;
    }


    public static void deleteData(int id) throws ClassNotFoundException{
        try {
            DbConnect.loadDriver();
            Connection con = new DbConnect().getConexion();
            String SQLQuery = "DELETE FROM " + "motos" + " WHERE id = ?;";
            try (PreparedStatement pt = con.prepareStatement(SQLQuery)) {
                pt.setInt(1, id);
                pt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error borrando los datos seleccionados: " + e.getMessage());
        }
    }
    public static void updateData(int id, String nombreNuevo) throws ClassNotFoundException {
        try {
            DbConnect.loadDriver();
            Connection con = new DbConnect().getConexion();
            String query = "UPDATE motos SET nombre = ? WHERE id = ? "; 
            try (PreparedStatement pt = con.prepareStatement(query)) {
                pt.setString(1, nombreNuevo);
                pt.setInt(2, id);
                pt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error actualizando los datos: " + e.getMessage());
        }
    }
  
    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    public Connection getCon(){
        return conexion;
    }
            
    public void setConexion(Connection conexion) {
        this.conexion =  conexion;
    }
}
