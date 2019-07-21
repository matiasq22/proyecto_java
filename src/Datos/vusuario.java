/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;
import Logica.md5;
/**
 *
 * @author Justino
 */
public class vusuario {
    private int idusuario;
    private String login;
    private String pass;
    private String acceso;
    private int idpersona;// este es para cbopersona locooo!!
    private String estado;    
    private Date fecha_ingreso;
public vusuario() {
}
    
public vusuario(int idusuario, int idpersona,String login, String pass, String acceso, String estado, Date fecha_ingreso) {
        this.idusuario = idusuario;
        this.login = login;
        this.pass = pass;
        this.acceso = acceso;
        this.estado = estado;
        this.fecha_ingreso = fecha_ingreso;
}

    
public int getidusuario() {
        return idusuario;
    }

    public void setidusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getlogin() {
        return login;
    }

    public void setlogin(String login) {
        this.login = login;
    }

    public String getpass() {
        return pass;
    }

    public void setpass(String pass) {
        this.pass= pass;
    }

    public String getacceso() {
        return acceso;
    }

    public void setacceso(String acceso) {
        this.acceso = acceso;
    }

    public String getestado() {
        return estado;
    }

    public void setestado(String estado) {
        this.estado = estado;
    }

    public int getidpersona() {
        return idpersona;
    }

    public void setidpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public Date getfecha_ingreso() {
        return fecha_ingreso;
    }

    public void setfecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    } 

    public String generatePass(String pass){
        md5 hash = new md5();
        return hash.getMd5(pass);
    }
}

