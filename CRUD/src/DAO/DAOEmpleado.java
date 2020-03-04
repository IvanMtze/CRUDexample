/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author wuser
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOEmpleado {
    Connection coneccion;
    Statement sentencia;
    
    public DAOEmpleado(){
        coneccion = ConnectionDB.getConnection();
    }
    
    public boolean UpdateEmpleado (Empleado e) throws SQLException{
        sentencia = coneccion.createStatement();
        if(empleadoVacio(e)){
            String consulta = "UPDATE empleado SET nombre= '"+e.getNombre()+"',direccion='"+e.getDireccion()
                    +"', telefono='" + e.getTelefono()+ "' WHERE ID = "+e.getId();
            sentencia.executeUpdate(consulta);
            return true;
        }
        return false;
    }
    
    public boolean deleteEmpleado (Integer id) throws SQLException{
        sentencia = coneccion.createStatement();
        String consulta = "DELETE  FROM empleado WHERE ID = "+id;
        sentencia.executeUpdate(consulta);
        return true;
    }
    
    public boolean createEmpleado (Empleado e) throws SQLException{
        sentencia = coneccion.createStatement();
        if(empleadoVacio(e)){
            String consulta = "INSERT INTO empleado (nombre, direccion, telefono) VALUES(' " +e.getNombre() + "','" 
                    + e.getDireccion()+ "','" + e.getTelefono() + "')";
            sentencia.executeUpdate(consulta);
            return true;
        }
        return false;
    }
        
    public Empleado getEmpleado(Integer id) throws SQLException{
        sentencia = coneccion.createStatement();
        String consulta = "SELECT * FROM empleado WHERE ID = "+id;
        ResultSet rs = sentencia.executeQuery(consulta);
        if(rs.next()){
            return new Empleado(rs.getString(2),rs.getString(4), rs.getString(3), rs.getInt(1));    
        }
        return null;
    }
    
    private boolean empleadoVacio(Empleado e){
        return (e.getDireccion().compareTo("") != 0 || e.getNombre().compareTo("") != 0|| e.getTelefono().compareTo("") != 0);
    }
}
