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
public class Usuario {
    
    public static void add(ArrayList<Usuario> usuarios) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public int idusuarios;
    public String usuario;
    public String mail;
    public String password;
    public String nombre;
    public int telefono;
    public String regDate;
    public int datosPago;
    
    public Usuario(int idusuarios, String usuario, String mail, String password, String nombre, int telefono, String regDate, int datosPago) {
        this.idusuarios = idusuarios;
        this.usuario = usuario;
        this.mail = mail;
        this.password = password;
        this.nombre = nombre;
        this.telefono = telefono;
        this.regDate = regDate;
        this.datosPago = datosPago;
    }

    public Usuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(int idusuarios) {
        this.idusuarios = idusuarios;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public int getDatosPago() {
        return datosPago;
    }

    public void setDatosPago(int datosPago) {
        this.datosPago = datosPago;
    }
    
    
    

    
}
