/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author rolet
 */
public class Reservas {

    public static void add(ArrayList<Reservas> usuarios) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public int idreservas;
    public String reservaDate;
    public boolean estado;
    public int idMotos;
    public int idUsuario;

    public Reservas(int idreservas, String reservaDate, boolean estado, int idMotos, int idUsuario) {
        this.idreservas = idreservas;
        this.reservaDate = reservaDate;
        this.estado = estado;
        this.idMotos = idMotos;
        this.idUsuario = idUsuario;
    }
    
    
    public Reservas(){

    }

    public int getIdreservas() {
        return idreservas;
    }

    public void setIdreservas(int idreservas) {
        this.idreservas = idreservas;
    }

    public String getReservaDate() {
        return reservaDate;
    }

    public void setReservaDate(String reservaDate) {
        this.reservaDate = reservaDate;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getIdMotos() {
        return idMotos;
    }

    public void setIdMotos(int idMotos) {
        this.idMotos = idMotos;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    
    
}
