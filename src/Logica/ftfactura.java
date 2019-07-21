/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.ResultSet;
import java.sql.Statement;
import Logica.conexion;
import java.sql.Connection;
import java.sql.SQLException;

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
    
    
}
