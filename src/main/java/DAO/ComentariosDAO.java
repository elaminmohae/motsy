/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Comentarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author rolet
 */
public class ComentariosDAO {
    
    private Comentarios comentario;
    private Connection conexion;
    
    public ComentariosDAO(){}
    public ComentariosDAO(Comentarios comentario, Connection conexion) {
        setComentarios(comentario);
        setConexion(conexion);
    }
    public ComentariosDAO(Comentarios comentario) {
        setComentarios(comentario);
    }

    public void insertData(Comentarios inputComentario) throws ClassNotFoundException {
        try {
            DbConnect.loadDriver();
            Connection con = new DbConnect().getConexion();
            String SQLQuery = "INSERT INTO comentarios" + " (`idcomentarios`, `TextoComentario`, `valoracion`, `fecha`) VALUES" + "(?,?,?,?);";
            PreparedStatement pt = con.prepareStatement(SQLQuery);
            pt.setInt(1, inputComentario.idcomentarios);
            pt.setString(2, inputComentario.TextoComentario);
            pt.setInt(3, inputComentario.valoracion);
            pt.setString(4, inputComentario.fecha);
            pt.executeUpdate();
            System.out.println("Se ha insertado el registro correctamente");
            pt.close();
        } catch (SQLException e) {
            System.err.println("Error insertando los datos: " + e.getMessage());
        }
    }

    public ArrayList<Comentarios> readData() throws ClassNotFoundException {
        ArrayList<Comentarios> comentario = new ArrayList<>();
        try {
            DbConnect.loadDriver();
            Connection con = new DbConnect().getConexion();
            String SQLQuery = "SELECT * FROM comentarios";
            PreparedStatement pt = con.prepareStatement(SQLQuery);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idcomentarios");
                //Comentarios comentario = new Comentarios();
                //Comentarios.add(comentario);
            }
        } catch (SQLException ex) {
            System.out.println("Error en la adquisición de datos: " + ex.getMessage());
        }
        return comentario;
    }


    public static void deleteData(Comentarios deleteComentario) throws ClassNotFoundException{
        try {
            DbConnect.loadDriver();
            Connection con = new DbConnect().getConexion();
            String SQLQuery = "DELETE FROM comentarios WHERE idcomentarios = ? AND TextoComentario = ? AND valoracion = ? AND fecha = ?";
            try (PreparedStatement pt = con.prepareStatement(SQLQuery)) {
            pt.setInt(1, deleteComentario.idcomentarios);
            pt.setString(2, deleteComentario.TextoComentario);
            pt.setInt(3, deleteComentario.valoracion);
            pt.setString(4, deleteComentario.fecha);
                
                pt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error borrando los datos seleccionados: " + e.getMessage());
        }
    }
    
  
    public Comentarios getComentario() {
        return comentario;
    }

    public void setComentarios(Comentarios comentario) {
        this.comentario = comentario;
    }

    public Connection getCon(){
        return conexion;
    }
            
    public void setConexion(Connection conexion) {
        this.conexion =  conexion;
    }
    
}
