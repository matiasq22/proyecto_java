/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Justino
 */
public class vproveedor {
    private int id;
    private String descripcion;
    private String ruc;
    private String telefono;

    public vproveedor(int idr, String descripcion, String ruc, String telefono){
        this.id = id;
        this.descripcion = descripcion;
        this.ruc = ruc;
        this.telefono = telefono;
       }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }



    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }


}


