/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vpersona;
import Datos.vusuario;
import Presentacion.frmusuarios;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Justino
 */
public class ftusuario {
private conexion mysql = new conexion();
private Connection cn = mysql.conectar();
private String sSQL = "";
public Integer totalregistros;

public DefaultTableModel mostrar(String buscar) {
DefaultTableModel modelo;
String[] titulos = {"Codigo","Login", "Password", "Acceso", "Estado", "Fecha_Ingreso","Persona","idpersona"};
String[] registros = new String[8];
totalregistros = 0;
modelo = new DefaultTableModel(null, titulos);
sSQL = "select * from usuario u join persona p on u.Persona_idpersona=p.idpersona where idusuario like '%" + buscar + "%' order by idusuario";
try {
Statement st = cn.createStatement();
ResultSet rs = st.executeQuery(sSQL);
while (rs.next()) {
registros[0] = rs.getString("idusuario");
registros[1] = rs.getString("login");
registros[2] = rs.getString("pass");
registros[3] = rs.getString("acceso");
registros[4] = rs.getString("estado");
registros[5] = rs.getString("fecha_ingreso");
registros[6] = rs.getString("nombre");
registros[7] = rs.getString("idpersona");

totalregistros = totalregistros + 1;
modelo.addRow(registros);
}
return modelo;
} catch (Exception e) {
JOptionPane.showConfirmDialog(null, e);
return null;
}
}

public boolean insertar(vusuario dts) {
        sSQL = "insert into usuario (login,pass,acceso,estado,Persona_idpersona,fecha_ingreso)"
                + "values (?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getlogin());
            pst.setString(2, dts.getpass());
            pst.setString(3, dts.getacceso());
            pst.setString(4, dts.getestado());
            pst.setInt(5, dts.getidpersona());
            pst.setDate(6, (Date) dts.getfecha_ingreso());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }


public boolean editar(vusuario dts) {
sSQL = "update usuario set login=?,pass=?,acceso=?,estado=?,fecha_ingreso=?"
+ "where idusuario=?";
try {
PreparedStatement pst = cn.prepareStatement(sSQL);
pst.setString(1, dts.getlogin());
pst.setString(2, dts.getpass());
pst.setString(3, dts.getacceso());
pst.setString(4, dts.getestado());
pst.setDate(5, dts.getfecha_ingreso());
pst.setInt(5, dts.getidusuario());
int n = pst.executeUpdate();
if (n != 0) {
return true;
} else {
return false;
}
} catch (Exception e) {
JOptionPane.showConfirmDialog(null, e);
return false;
}
}
public boolean eliminar(vusuario dts) {
sSQL = "delete from usuario where idusuario=?";
try {
PreparedStatement pst = cn.prepareStatement(sSQL);
pst.setInt(1, dts.getidusuario());
int n = pst.executeUpdate();
if (n != 0) {
return true;
} else {
return false;
}
} catch (Exception e) {
JOptionPane.showConfirmDialog(null, e);
return false;
}
}
public DefaultTableModel login(String login, String pass) {
DefaultTableModel modelo;
String[] titulos = {"idusuario", "Nombres", "Apellidos", "Login", "Password", "Acceso", "Estado"};
String[] registros = new String[7];
totalregistros = 0;
modelo = new DefaultTableModel(null, titulos);
vusuario user = new vusuario();
//String password = user.generatePass(pass);
sSQL = "select * from usuario u join persona p on u.Persona_idpersona=p.idpersona where login='" + login + "'and pass='" + pass + "' and estado='A'";
    System.out.println("sSQL = " + sSQL);
try {
Statement st = cn.createStatement();
ResultSet rs = st.executeQuery(sSQL);
while (rs.next()) {
registros[0] = rs.getString("idusuario");
registros[1] = rs.getString("nombre");
registros[2] = rs.getString("apellido");
registros[3] = rs.getString("login");
registros[4] = rs.getString("pass");
registros[5] = rs.getString("acceso");
registros[6] = rs.getString("estado");
totalregistros = totalregistros + 1;
modelo.addRow(registros);
}
return modelo;
} catch (Exception e) {
    JOptionPane.showConfirmDialog(null, e);
return null;
}
}

//Funcion para traer los datos de las personas  --- en clase ftusuario

 public ArrayList<vpersona> getPersonas() {  //declaramos una funcion que retorna(devuelve) un array de strings definido en ArrayList<String>

        sSQL = "select * from persona ";  //sentencia sql
         ArrayList<vpersona> personas = new ArrayList<>(); //declaramos variable para guardar los nombre de las personas 
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL); 
            while (rs.next()) {  
                vpersona persona = new vpersona();
                persona.setnombre(rs.getString("nombre")); 
                persona.setidpersona(rs.getInt("idpersona"));
                personas.add(persona);
            }
            if (personas.isEmpty()) {
                System.out.println("Entro if no");
                return null; 
            }
            return personas; 
        } catch (SQLException e) {
       return null; //en caso de error se devuelve nulo
        }
    }

}

