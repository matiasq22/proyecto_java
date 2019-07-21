/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vclientes;
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
public class ftclientes {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"IdCLiente", "Nombre", "Apellido", "RUC", "Cedula", "Celular","Email"};
        String[] registros = new String[7];
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select * from cliente where nombre like '%" + buscar + "%' order by idcliente desc";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registros[0] = rs.getString("idcliente");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("apellido");
                registros[3] = rs.getString("ruc");
                registros[4] = rs.getString("documento");
                registros[5] = rs.getString("celular");
                registros[6] = rs.getString("email");
                totalregistros = totalregistros + 1;
                modelo.addRow(registros);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(vclientes dts) {
        sSQL = "insert into cliente (nombre,apellido,documento,celular,ruc,email)" + "values (?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellido());
            pst.setString(3, dts.getDocumento());
            pst.setString(4, dts.getCelular());
            pst.setString(5, dts.getRuc());
            pst.setString(6, dts.getEmail());
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

    public boolean eliminar(vclientes dts) {
        sSQL = "delete from cliente where idcliente=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdcliente());
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

    public boolean editar(vclientes dts) {
        sSQL = "update cliente set nombre=? , apellido=?, documento=?, celular= ?, ruc=?,email=?"
                + "where idcliente=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellido());
            pst.setString(3, dts.getDocumento());
            pst.setString(4, dts.getCelular());
            pst.setString(5, dts.getRuc());
            pst.setString(6,dts.getEmail());
            pst.setInt(7, dts.getIdcliente());
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
