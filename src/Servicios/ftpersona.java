/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelo.vpersona;
import java.sql.SQLException;


/**
 *
 * @author Justino
 */
public class ftpersona {
 private conexion mysql = new conexion();
private Connection cn = mysql.conectar();
private String sSQL = "";
public Integer totalregistros;


public DefaultTableModel mostrar(String buscar) {
DefaultTableModel modelo;
String[] titulos = {"Idpersona", "Nombre", "Apellido", "Cedula", "Celular","Pais","Ciudad","Barrio"};
String[] registros = new String[8];
totalregistros = 0;
modelo = new DefaultTableModel(null, titulos);
sSQL = "select * from persona where idpersona like '%" + buscar + "%' order by idpersona";
try {
Statement st = cn.createStatement();
ResultSet rs = st.executeQuery(sSQL);
while (rs.next()) {
registros[0] = rs.getString("idpersona");
registros[1] = rs.getString("nombre");
registros[2] = rs.getString("apellido");
registros[3] = rs.getString("documento");
registros[4] = rs.getString("celular");
registros[5] = rs.getString("Pais");
registros[6] = rs.getString("Ciudad");
registros[7] = rs.getString("Barrio");


totalregistros = totalregistros + 1;
modelo.addRow(registros);
}   
return modelo;
} catch (Exception e) {
JOptionPane.showConfirmDialog(null, e);
return null;
}
}
  
public boolean insertar(vpersona dts) {
    sSQL = "insert into persona (nombre,apellido,documento,celular,Barrio_idBarrio,Ciudad_idciudad,Pais_idPais,barrio,ciudad,pais)" + "values (?,?,?,?,?,?,?,?,?,?)";
try {
PreparedStatement pst = cn.prepareStatement(sSQL);
pst.setString(1, dts.getnombre());
pst.setString(2, dts.getapellido());
pst.setString(3, dts.getDocumento());
pst.setString(4, dts.getcelular());
pst.setInt(5, 1);
pst.setInt(6, 1);
pst.setInt(7, 1);
pst.setString(8, dts.getBarrio());
pst.setString(9, dts.getCiudad());
pst.setString(10, dts.getPais());
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
public boolean eliminar(vpersona dts) {
sSQL = "delete from persona where idpersona=?";
try {
PreparedStatement pst = cn.prepareStatement(sSQL);
pst.setInt(1, dts.getidpersona());
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


public boolean editar(vpersona dts) {
sSQL = "update persona set nombre=?,apellido=?,documento=?,celular=?,pais=?,ciudad=?,barrio=? "
+ "where idpersona=?";
try {
PreparedStatement pst = cn.prepareStatement(sSQL);
pst.setString(1, dts.getnombre());
pst.setString(2, dts.getapellido());
pst.setString(3, dts.getDocumento());
pst.setString(4, dts.getcelular());
pst.setString(5, dts.getPais());
pst.setString(6, dts.getCiudad());
pst.setString(7, dts.getBarrio());
pst.setInt(8, dts.getidpersona());
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



}
