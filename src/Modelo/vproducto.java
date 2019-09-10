/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Justino
 */
public class vproducto {
 
    
    private int idproducto;
    private String nombre;
    private String modelo;
    private String cantidad;
    private String precio;  
    private int idmarca;// este es para cbopersona locooo!!
   
public vproducto() {
}
    
public vproducto(int idproducto, int idmarca,String nombre, String modelo, String cantidad, String precio) {
        this.idproducto = idproducto;
        this.nombre=nombre;
        this.modelo = modelo;
        this.cantidad = cantidad;
        this.precio = precio;
       
}

    
public int getidproducto() {
        return idproducto;
    }

    public void setidproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


     public String getmodelo() {
        return modelo;
    }

    public void setmodelo(String modelo) {
        this.modelo = modelo;
    }

    public String getcantidad() {
        return cantidad;
    }

    public void setcantidad(String cantidad) {
        this.cantidad = cantidad;
    }

     public String getprecio() {
        return precio;
    }

    public void setprecio(String precio) {
        this.precio = precio;
    }
    
    public int getidmarca() {
        return idmarca;
    }

    public void setidmarca (int idmarca) {
        this.idmarca = idmarca;
    }
    
}
