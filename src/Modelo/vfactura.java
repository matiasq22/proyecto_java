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
public class vfactura {

    private int idfactura;
    private int idusuario;
    private int idcliente;
    private String numero_fac;
    private String estado;
    private String fecha;
    private String subtotal;
    private String iva;
    private String totalfactura;

    public vfactura() {

    }

    public vfactura(int idfactura, int idusuario, int idcliente, String numero_fac, String estado, String fecha, String subtotal, String iva, String totalfactura) {
        this.idfactura = idfactura;
        this.idusuario = idusuario;
        this.idcliente = idcliente;
        this.numero_fac = numero_fac;
        this.estado = estado;
        this.fecha = fecha;
        this.iva = iva;
        this.subtotal = subtotal;
        this.totalfactura = totalfactura;
    }

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNumero_fac() {
        return numero_fac;
    }

    public void setNumero_fac(String numero_fac) {
        this.numero_fac = numero_fac;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getTotalfactura() {
        return totalfactura;
    }

    public void setTotalfactura(String totalfactura) {
        this.totalfactura = totalfactura;
    }
    
    

}
