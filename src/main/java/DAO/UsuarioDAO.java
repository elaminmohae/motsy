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
import Modelo.Usuario;

/**
 *
 * @author rolet
 */
public class UsuarioDAO {
    private Usuario usuario;
    private Connection conexion;
    
    public UsuarioDAO(){}
    public UsuarioDAO(Usuario usuario, Connection conexion) {
        setUsuario(usuario);
        setConexion(conexion);
    }
    public UsuarioDAO(Usuario usuario) {
        setUsuario(usuario);
    }

    public void insertData(Usuario inputUsuario) throws ClassNotFoundException {
        try {
            DbConnect.loadDriver();
            Connection con = new DbConnect().getConexion();
            String SQLQuery = "INSERT INTO motos" + " (`idusuarios`, `usuario`, `mail`, `password`, `nombre`, `telefono`, `regDate`, `datosPago`) VALUES" + "(?,?,?,?,?,?,?,?);";
            PreparedStatement pt = con.prepareStatement(SQLQuery);
            pt.setInt(1, inputUsuario.idusuarios);
            pt.setString(2, inputUsuario.usuario);
            pt.setString(3, inputUsuario.mail);
            pt.setString(4, inputUsuario.password);
            pt.setString(5, inputUsuario.nombre);
            pt.setInt(6,inputUsuario.telefono);
            pt.setString(7, inputUsuario.regDate);
            pt.setInt(8, inputUsuario.datosPago);
                    
            pt.executeUpdate();
            System.out.println("Se ha insertado el registro correctamente");
            pt.close();
        } catch (SQLException e) {
            System.err.println("Error insertando los datos: " + e.getMessage());
        }
    }

    public ArrayList<Usuario> readData() throws ClassNotFoundException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            DbConnect.loadDriver();
            Connection con = new DbConnect().getConexion();
            String SQLQuery = "SELECT * FROM motos";
            PreparedStatement pt = con.prepareStatement(SQLQuery);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idmotos");
                String nombre = rs.getString("modelo");
                Usuario usuario = new Usuario();
                Usuario.add(usuarios);
            }
        } catch (SQLException ex) {
            System.out.println("Error en la adquisición de datos: " + ex.getMessage());
        }
        return usuarios;
    }


    public static void deleteData(Usuario deleteUsuario) throws ClassNotFoundException{
        try {
            DbConnect.loadDriver();
            Connection con = new DbConnect().getConexion();
            String SQLQuery = "DELETE FROM motos WHERE idusuarios = ? AND usuario = ? AND mail = ? AND password = ? AND nombre = ? AND telefono = ? AND regDate = ? AND datosPago = ?";
            try (PreparedStatement pt = con.prepareStatement(SQLQuery)) {
                pt.setInt(1, deleteUsuario.idusuarios);
                pt.setString(2, deleteUsuario.usuario);
                pt.setString(3, deleteUsuario.mail);
                pt.setString(4, deleteUsuario.password);
                pt.setString(5, deleteUsuario.nombre);
                pt.setInt(6,deleteUsuario.telefono);
                pt.setString(7, deleteUsuario.regDate);
                pt.setInt(8, deleteUsuario.datosPago);
                pt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error borrando los datos seleccionados: " + e.getMessage());
        }
    }
    public static void updateData(Usuario updateUsuario) throws ClassNotFoundException {
        try {
            DbConnect.loadDriver();
            Connection con = new DbConnect().getConexion();
            String query = "UPDATE usuarios SET usuario = ? WHERE idusuarios = ? AND usuario = ? AND mail = ? AND password = ? AND nombre = ? AND telefono = ? AND regDate = ? AND datosPago = ?"; 
            try (PreparedStatement pt = con.prepareStatement(query)) {
                pt.setInt(1, updateUsuario.idusuarios);
                pt.setString(2, updateUsuario.usuario);
                pt.setString(3, updateUsuario.mail);
                pt.setString(4, updateUsuario.password);
                pt.setString(5, updateUsuario.nombre);
                pt.setInt(6,updateUsuario.telefono);
                pt.setString(7, updateUsuario.regDate);
                pt.setInt(8, updateUsuario.datosPago);
                pt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error actualizando los datos: " + e.getMessage());
        }
    }
  
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Connection getCon(){
        return conexion;
    }
            
    public void setConexion(Connection conexion) {
        this.conexion =  conexion;
    }
} 

