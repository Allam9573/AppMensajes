/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lukanka.appmensajes;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author allam
 */
public class Conexion {

    private static String URL = "jdbc:mysql://localhost:3306/db_mensajes?serverTimezone=UTC";
    private static String USERNAME = "root";
    private static String PASSWORD = "";

    public Connection getConnection() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido un error al conectar a la base de dato: " + ex);
        }
        return conexion;
    }

}
