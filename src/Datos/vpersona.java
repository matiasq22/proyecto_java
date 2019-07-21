/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;

/**
 *
 * @author Justino
 */
public class vpersona {
    private int idpersona;
    private String nombre;
    private String apellido;
    private String cedula;
    private String celular;
   
public vpersona() {
}
 
public vpersona(int idpersona, String nombre, String apellido, String cedula, String celular) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.celular = celular;
}

    
public int getidpersona() {
        return idpersona;
    }

    public void setidpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getnombre() {
        return nombre;
    }
//
    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getapellido() {
        return apellido;
    }

    public void setapellido(String apellido) {
        this.apellido = apellido;
    }

    public String getcedula() {
        return cedula;
    }

    public void setcedula(String cedula) {
        this.cedula = cedula;
    }

    public String getcelular() {
        return celular;
    }

    public void setcelular(String celular) {
        this.celular = celular;
    }
  
    //Funcion para mostrar el nombre en el jcombobox  – vpersona 

    public String toString(){
        return this.nombre;
    }

    
    
    
}

