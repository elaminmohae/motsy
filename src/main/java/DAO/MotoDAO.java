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

    public void insertData(Moto inputMoto) throws ClassNotFoundException {
        try {
            DbConnect.loadDriver();
            Connection con = new DbConnect().getConexion();
            String SQLQuery = "INSERT INTO motos" + " (`idmotos`, `modelo`, `marca`, `añoFabricacion`, `motor`, `estado`, `precio`, `matricula`) VALUES" + "(?,?,?,?,?,?,?,?);";
            PreparedStatement pt = con.prepareStatement(SQLQuery);
            pt.setInt(1, inputMoto.idmotos);
            pt.setString(2, inputMoto.modelo);
            pt.setString(3, inputMoto.marca);
            pt.setInt(4, inputMoto.añoFabricacion);
            pt.setString(5, inputMoto.motor);
            pt.setBoolean(6,inputMoto.estado);
            pt.setInt(7, inputMoto.precio);
            pt.setInt(8, inputMoto.matricula);
                    
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
                int id = rs.getInt("idmotos");
                String nombre = rs.getString("modelo");
                Moto moto = new Moto();
                Moto.add(motos);
            }
        } catch (SQLException ex) {
            System.out.println("Error en la adquisición de datos: " + ex.getMessage());
        }
        return motos;
    }


    public static void deleteData(Moto deleteMoto) throws ClassNotFoundException{
        try {
            DbConnect.loadDriver();
            Connection con = new DbConnect().getConexion();
            String SQLQuery = "DELETE FROM motos WHERE idmotos = ? AND modelo = ? AND marca = ? AND añoFabricacion = ? AND motor = ? AND estado = ? AND precio = ? AND matricula = ?";
            try (PreparedStatement pt = con.prepareStatement(SQLQuery)) {
                pt.setInt(1, deleteMoto.idmotos);
                pt.setString(2, deleteMoto.modelo);
                pt.setString(3, deleteMoto.marca);
                pt.setInt(4, deleteMoto.añoFabricacion);
                pt.setString(5, deleteMoto.motor);
                pt.setBoolean(6,deleteMoto.estado);
                pt.setInt(7, deleteMoto.precio);
                pt.setInt(8, deleteMoto.matricula);
                pt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error borrando los datos seleccionados: " + e.getMessage());
        }
    }
    public static void updateData(Moto updateMoto) throws ClassNotFoundException {
        try {
            DbConnect.loadDriver();
            Connection con = new DbConnect().getConexion();
            String query = "UPDATE motos SET modelo = ? WHERE idmotos = ? AND modelo = ? AND marca = ? AND añoFabricacion = ? AND motor = ? AND estado = ? AND precio = ? AND matricula = ?"; 
            try (PreparedStatement pt = con.prepareStatement(query)) {
                 pt.setInt(1, updateMoto.idmotos);
                 pt.setString(2, updateMoto.modelo);
                 pt.setString(3, updateMoto.marca);
                 pt.setInt(4, updateMoto.añoFabricacion);
                 pt.setString(5, updateMoto.motor);
                 pt.setBoolean(6,updateMoto.estado);
                 pt.setInt(7, updateMoto.precio);
                 pt.setInt(8, updateMoto.matricula);
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
