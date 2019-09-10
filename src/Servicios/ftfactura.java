/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Modelo.vfactura;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Justino
 */
public class ftfactura {
     private conexion mysql = new conexion();
private Connection cn = mysql.conectar();
private String sSQL = "";
    
    public String getLastFactura(){
        sSQL = "select idfactura from factura order by idfactura desc limit 1";  //sentencia sql
        String id = "";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL); 
        
            while(rs.next()){
                id = rs.getString(1);
}
            System.out.println("id = " + id);
        return id;
        }catch(SQLException e){
            System.out.println("error = " + e.getMessage());
        }
         return null;
    }
    
    
    public String[] facturaReporte(){
          sSQL = "select f.numero_fac,f.fecha, f.subtotal, f.iva, f.totalfactura, d.cantidad, p.nombre, c.nombre as cliente, c.ruc from factura f"
                  + " join detalle d on d.Factura_idfactura = f.idfactura "
                  + "join cliente c on f.Cliente_idcliente = c.idcliente join producto p on d.Producto_idproducto = p.idproducto"
                  + " order by f.idfactura desc order by idfactura desc limit 1";  //sentencia sql
            String[] factura = new String[9];
            try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL); 
            while(rs.next()){
                factura[0] = rs.getString("numero_fac");
                factura[1] = rs.getString("cliente");
                factura[2] = rs.getString("ruc");
                factura[3] = rs.getString("nombre");
                factura[4] = rs.getString("cantidad");
                factura[5] = rs.getString("precio");
                factura[6] = rs.getString("subtotal");
                factura[7] = rs.getString("totalfactura");
                factura[8] = rs.getString("fecha");
}
            System.out.println("factura = " + factura);
        return factura;
        }catch(SQLException e){
            System.out.println("error = " + e.getMessage());
        }
        
        
        
        return null;
        
    }
    
}
