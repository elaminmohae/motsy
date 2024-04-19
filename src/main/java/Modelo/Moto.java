/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Mati
 */

public class Moto{

    public static void add(ArrayList<Moto> motos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String modelo;
    private int id;
    private String marca;
    private int añoFabricacion;
    private boolean estado;
    private int precio;
    private int matricula;

    public String getMarca() {
        return marca;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setAñoFabricacion(int añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public boolean isEstado() {
        return estado;
    }

    public int getMatricula() {
        return matricula;
    }
    
    
    public Moto(){
    }
    public Moto (String nombrep){
        this.modelo = nombrep;
    }
    
    
    public Moto(int idp, String nombrep){
        setId(idp);
        setModelo(nombrep);

    }
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
      this.modelo = modelo;
    }
    
    

    public int getId() {
       return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

