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
    private final String URL = "jdbc:mysql://localhost:3306/SPRINT_PREV_RIESGOS";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String USER = "root";
    private final String PASS = "123Gronorf321";

    private Singleton() throws Exception {

        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            throw e;
        }

    }

    public static Connection conectar() throws Exception {
        if (conn == null || conn.isClosed()) {
            new Singleton();
        }
        return conn;
    }

    public static void cerrar() throws Exception {
        if (conn != null) {
            if (!conn.isClosed()) {
                conn.close();
            }
        }
    }
}
