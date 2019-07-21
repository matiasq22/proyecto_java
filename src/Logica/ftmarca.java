/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vmarca;
import Datos.vpersona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Justino
 */
public class ftmarca {
private conexion mysql = new conexion();
private Connection cn = mysql.conectar();
private String sSQL = "";
public Integer totalregistros;



public DefaultTableModel mostrar(String buscar) {
DefaultTableModel modelo;
String[] titulos = {"Idmarca", "Marca", "Descripcion"};
String[] registros = new String[3];
totalregistros = 0;
modelo = new DefaultTableModel(null, titulos);
sSQL = "select * from marca where idmarca like '%" + buscar + "%' order by idmarca";
try {
Statement st = cn.createStatement();
ResultSet rs = st.executeQuery(sSQL);
while (rs.next()) {
registros[0] = rs.getString("idmarca");
registros[1] = rs.getString("marca");
registros[2] = rs.getString("descripcion");
totalregistros = totalregistros + 1;
modelo.addRow(registros);
}   
return modelo;
} catch (Exception e) {
JOptionPane.showConfirmDialog(null, e);
return null;
}
}


public boolean insertar(vmarca dts) {
    sSQL = "insert into marca (marca,descripcion)" + "values (?,?)";
try {
PreparedStatement pst = cn.prepareStatement(sSQL);
pst.setString(1, dts.getmarca());
pst.setString(2, dts.getdescripcion());

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




public boolean eliminar(vmarca dts) {
sSQL = "delete from marca where idmarca=?";
try {
PreparedStatement pst = cn.prepareStatement(sSQL);
pst.setInt(1, dts.getidmarca());
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

public boolean editar(vmarca dts) {
sSQL = "update marca set marca=?,descripcion=?"
+ "where idmarca=?";
try {
PreparedStatement pst = cn.prepareStatement(sSQL);
pst.setString(1, dts.getmarca());
pst.setString(2, dts.getdescripcion());
pst.setInt(3, dts.getidmarca());
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
