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
public class vmarca {
    private int idmarca;
    private String marca;
    private String descripcion;
    
public vmarca() {
}
public vmarca(int idmarca,String marca, String descripcion) {
        this.idmarca = idmarca;
        this.marca = marca;
        this.descripcion = descripcion;
}

public int getidmarca() {
        return idmarca;
    }

    public void setidmarca(int idmarca) {
        this.idmarca = idmarca;
    }

    public String getmarca() {
        return marca;
    }

    public void setmarca(String marca) {
        this.marca = marca;
    }
    
    
    public String getdescripcion() {
        return descripcion;
    }

    public void setdescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
     public String toString(){
        return this.marca;
    }
}
  
