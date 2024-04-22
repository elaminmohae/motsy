/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Reservas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author rolet
 */
public class ReservasDAO {
    
    private Reservas reserva;
    private Connection conexion;
    
    public ReservasDAO(){}
    public ReservasDAO(Reservas reserva, Connection conexion) {
        setReservas(reserva);
        setConexion(conexion);
    }
    public ReservasDAO(Reservas reserva) {
        setReservas(reserva);
    }

    public void insertData(Reservas inputReserva) throws ClassNotFoundException {
        try {
            DbConnect.loadDriver();
            Connection con = new DbConnect().getConexion();
            String SQLQuery = "INSERT INTO reservas" + " (`idreservas`, `reservaDate`, `estado`, `idMotos`, `idUsuario`) VALUES" + "(?,?,?,?,?);";
            PreparedStatement pt = con.prepareStatement(SQLQuery);
            pt.setInt(1, inputReserva.idreservas);
            pt.setString(2, inputReserva.reservaDate);
            pt.setBoolean(3, inputReserva.estado);
            pt.setInt(4, inputReserva.idMotos);
            pt.setInt(5, inputReserva.idUsuario);
            
                    
            pt.executeUpdate();
            System.out.println("Se ha insertado el registro correctamente");
            pt.close();
        } catch (SQLException e) {
            System.err.println("Error insertando los datos: " + e.getMessage());
        }
    }

    public ArrayList<Reservas> readData() throws ClassNotFoundException {
        ArrayList<Reservas> reservas = new ArrayList<>();
        try {
            DbConnect.loadDriver();
            Connection con = new DbConnect().getConexion();
            String SQLQuery = "SELECT * FROM reservas";
            PreparedStatement pt = con.prepareStatement(SQLQuery);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idreservas");
                Reservas reserva = new Reservas();
                Reservas.add(reservas);
            }
        } catch (SQLException ex) {
            System.out.println("Error en la adquisición de datos: " + ex.getMessage());
        }
        return reservas;
    }


    public static void deleteData(Reservas deleteReserva) throws ClassNotFoundException{
        try {
            DbConnect.loadDriver();
            Connection con = new DbConnect().getConexion();
            String SQLQuery = "DELETE FROM reservas WHERE idreservas = ? AND reservaDate = ? AND estado = ? AND idMotos = ? AND idUsuarios = ?";
            try (PreparedStatement pt = con.prepareStatement(SQLQuery)) {
                pt.setInt(1, deleteReserva.idreservas);
                pt.setString(2, deleteReserva.reservaDate);
                pt.setBoolean(3, deleteReserva.estado);
                pt.setInt(4, deleteReserva.idMotos);
                pt.setInt(5, deleteReserva.idUsuario);
                
                pt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error borrando los datos seleccionados: " + e.getMessage());
        }
    }
    public static void updateData(Reservas updateReserva) throws ClassNotFoundException {
        try {
            DbConnect.loadDriver();
            Connection con = new DbConnect().getConexion();
            String query = "UPDATE reservas SET reservadate = ? WHERE idreservas = ? AND reservaDate = ? AND estado = ? AND idMotos = ? AND idUsuarios = ?"; 
            try (PreparedStatement pt = con.prepareStatement(query)) {
                pt.setInt(1, updateReserva.idreservas);
                pt.setString(2, updateReserva.reservaDate);
                pt.setBoolean(3, updateReserva.estado);
                pt.setInt(4, updateReserva.idMotos);
                pt.setInt(5, updateReserva.idUsuario);
                pt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error actualizando los datos: " + e.getMessage());
        }
    }
  
    public Reservas getReservas() {
        return reserva;
    }

    public void setReservas(Reservas reserva) {
        this.reserva = reserva;
    }

    public Connection getCon(){
        return conexion;
    }
            
    public void setConexion(Connection conexion) {
        this.conexion =  conexion;
    }
} 
    

