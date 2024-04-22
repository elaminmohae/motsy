/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author rolet
 */
public class Comentarios {

    public static void add(Comentarios comentario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public int idcomentarios;
    public String TextoComentario;
    public int valoracion;
    public String fecha;
    
    public Comentarios(int idcomentarios, String TextoComentario, int valoracion, String fecha) {
        this.idcomentarios = idcomentarios;
        this.TextoComentario = TextoComentario;
        this.valoracion = valoracion;
        this.fecha = fecha;
    }
    
    public Comentarios(){
        
    }

    public int getIdcomentarios() {
        return idcomentarios;
    }

    public void setIdcomentarios(int idcomentarios) {
        this.idcomentarios = idcomentarios;
    }

    public String getTextoComentario() {
        return TextoComentario;
    }

    public void setTextoComentario(String TextoComentario) {
        this.TextoComentario = TextoComentario;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
    
    
    
}
