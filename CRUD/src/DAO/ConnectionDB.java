/*

* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wuser
 */
public class ConnectionDB {
     // Propiedades
    private static Connection conn;
    private static ConnectionDB coneccion;
    private String driver;
    private String url;
    private String usuario;
    private String password;
 
    // Constructor
    private ConnectionDB(){
        String url = "jdbc:postgresql://localhost:5432/EmpleadoEjemplo?user=postgres&password=2408";
        String driver = "org.postgresql.Driver";
        String usuario = "postgres";
        String password = "2408";

        conn = null;
        
        try{
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    } // Fin constructor
 
    // Métodos
    public static Connection getConnection(){
        if (conn == null){
            coneccion= new ConnectionDB();
        }
        return coneccion.getConection();
    }
    
    private Connection getConection(){
        return conn;
    }
}
