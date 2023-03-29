/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.*;
/**
 *
 * @author Yo
 */
public class Singleton {
    private static Connection conn = null;
    
    private Singleton() {
        String url = "jdbc:mysql://localhost:3306/spring_prev_riesgos";
        String driver = "com.mysql.cj.jdbc.Driver";
        String usuario = "root";
        String password = "123Gronorf321";
        
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection() {
        if (conn == null) {
            new Singleton();
        }
        return conn;
    }
}