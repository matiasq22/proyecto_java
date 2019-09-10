/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Modelo.vproveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Justino
 */
public class ftproveedor {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"idproveedor", "Denominacion", "Ruc", "Contacto", "Celular"};
        String[] registros = new String[5];
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select * from proveedor p join persona pe on p.Persona_idpersona = pe.idpersona where nomproveedor like '%" + buscar + "%' order by idproveedor";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registros[0] = rs.getString("idproveedor");
                registros[1] = rs.getString("nomproveedor");
                registros[2] = rs.getString("ruc");
                registros[3] = rs.getString("nombre");
                registros[4] = rs.getString("celular");
                
                totalregistros = totalregistros + 1;
                modelo.addRow(registros);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public boolean insertar(vproveedor dts) {
        sSQL = "insert into proveedor (nomproveedor,ruc,Persona_idpersona)" + "values (?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNomproveedor());
            pst.setString(2, dts.getRuc());
            pst.setInt(3, dts.getIdpersona());
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

    public boolean eliminar(vproveedor dts) {
        sSQL = "delete from proveedor where idproveedor=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdproveedor());
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

    public boolean editar(vproveedor dts) {
        sSQL = "update proveedor set nomproveedor=?,ruc=?,Persona_idpersona=?"
                + "where idproveedor=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNomproveedor());
            pst.setString(2, dts.getRuc());
            pst.setInt(3, dts.getIdpersona());
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