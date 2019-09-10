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
    private int idproveedor;
    private String nomproveedor;
    private String ruc;
    private int idpersona;


public vproveedor(int idproveedror, String nomproveedor, String ruc, int idpersona){
        this.idpersona = idpersona;
        this.nomproveedor = nomproveedor;
        this.ruc = ruc;
        this.idproveedor = idproveedor;
       }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getNomproveedor() {
        return nomproveedor;
    }

    public void setNomproveedor(String nomproveedor) {
        this.nomproveedor = nomproveedor;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }
      
    public String toString(){
         return this.nomproveedor;
    }
}


