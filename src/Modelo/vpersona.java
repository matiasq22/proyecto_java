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
public class vpersona {
    private int idpersona;
    private String nombre;
    private String apellido;
    private String celular;
    private String barrio;
    private String ciudad;
    private String pais;
    private String documento;
    
public vpersona() {
}
 
public vpersona(int idpersona, String nombre, String apellido, String cedula, String celular) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
}

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
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

    public String getcelular() {
        return celular;
    }

    public void setcelular(String celular) {
        this.celular = celular;
    }
  
    
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
   
    
    //Funcion para mostrar el nombre en el jcombobox  – vpersona 

    public String toString(){
        return this.documento;
    }

    
    
    
}

