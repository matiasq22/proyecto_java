/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;
import Modelo.vmarca;
import Modelo.vpersona;
import Modelo.vproducto;
import Modelo.vusuario;
import vistas.frmusuarios;
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
public class ftproductos {
    
private conexion mysql = new conexion();
private Connection cn = mysql.conectar();
private String sSQL = "";
public Integer totalregistros;
    
public DefaultTableModel mostrar(String buscar) {
DefaultTableModel modelo;
String[] titulos = {"Codigo","Producto", "Modelo", "cantidad", "precio", "Marca"};
String[] registros = new String[6];
totalregistros = 0;
modelo = new DefaultTableModel(null, titulos);
sSQL = "select * from producto p join marca m on p.marca_idmarca=m.idmarca where p.nombre like '%" + buscar + "%' order by idproducto";
    System.out.println("sSQL = " + sSQL);
try {
Statement st = cn.createStatement();
ResultSet rs = st.executeQuery(sSQL);
while (rs.next()) {
registros[0] = rs.getString("idproducto");
registros[1] = rs.getString("Nombre");
registros[2] = rs.getString("modelo");
registros[3] = rs.getString("cantidad");
registros[4] = rs.getString("precio");
registros[5] = rs.getString("marca");

totalregistros = totalregistros + 1;
modelo.addRow(registros);
}
return modelo;
} catch (Exception e) {
JOptionPane.showConfirmDialog(null, e);
    System.out.println("e = " + e.getMessage());
return null;
}
}
    
public boolean insertar(vproducto dts) {
        sSQL = "insert into producto (Nombre,modelo,cantidad,precio,marca_idmarca)"
                + "values (?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getmodelo());
            pst.setString(3, dts.getcantidad());
            pst.setString(4, dts.getprecio());
            pst.setInt(5, dts.getidmarca());
            int n = pst.executeUpdate();
            return n != 0;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }





public ArrayList<vmarca> getmarca() {  //declaramos una funcion que retorna(devuelve) un array de strings definido en ArrayList<String>

        sSQL = "select * from marca ";  //sentencia sql
         ArrayList<vmarca> marcas = new ArrayList<>(); //declaramos variable para guardar los nombre de las personas 
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL); 
            while (rs.next()) {  
                vmarca marca = new vmarca();
                marca.setmarca(rs.getString("marca")); 
                marca.setidmarca(rs.getInt("idmarca"));
                marcas.add(marca);
            }
            if (marcas.isEmpty()) {
                System.out.println("Entro if no");
                return null; 
            }
            return marcas; 
        } catch (SQLException e) {
       return null; //en caso de error se devuelve nulo
        }
    }

public boolean eliminar(vproducto dts) {
sSQL = "delete from producto where idproducto=?";
try {
PreparedStatement pst = cn.prepareStatement(sSQL);
pst.setInt(1, dts.getidproducto());
int n = pst.executeUpdate();
if (n != 0) {
return true;
} else {
return false;
}
} catch (SQLException e) {
JOptionPane.showConfirmDialog(null, e);
return false;
}
}
    
public boolean editar(vproducto dts) {
sSQL = "update producto set nombre=?, modelo=? ,cantidad=? ,precio=? ,marca_idmarca=? "
+ " where idproducto= ? ";
try {
PreparedStatement pst = cn.prepareStatement(sSQL);
pst.setString(1, dts.getNombre());
pst.setString(2, dts.getmodelo());
pst.setString(3, dts.getcantidad());
pst.setString(4, dts.getprecio());
pst.setInt(5, dts.getidmarca());
pst.setInt(6, dts.getidproducto());
int n = pst.executeUpdate();
if (n != 0) {
return true;
} else {
return false;
}
} catch (SQLException e) {
JOptionPane.showConfirmDialog(null, e);
return false;
}
}

} 

