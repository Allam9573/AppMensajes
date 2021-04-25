/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lukanka.appmensajes;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author allam
 */
public class MensajesDAO {
    
    public static void crearMensaje(Mensaje mensaje) {
        Conexion db_connect = new Conexion();
        try ( Connection conexion = db_connect.getConnection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO mensajes(mensaje,autor_mensaje) VALUES(?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Mensaje creado");
            } catch (SQLException ex) {
                System.out.println("Error al crear mensaje: " + ex);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        
    }
    
    public static void leerMensajes() {
        
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try ( Connection conexion = db_connect.getConnection()) {
            String query = "SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
            }
            
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        
    }
    
    public static void borrarMensaje(int id_mensaje) {
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        try ( Connection conexion = db_connect.getConnection()) {
            
            try {
                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Mensaje borrado.");
                
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }
    
    public static void actualizarMensaje(Mensaje mensaje) {
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        
        try ( Connection conexion = db_connect.getConnection()) {
            String query = "UPDATE mensajes set mensaje = ? WHERE id_mensaje = ?";
            ps = conexion.prepareStatement(query);
            ps.setString(1, mensaje.getMensaje());
            ps.setInt(2, mensaje.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Mensaje Actualizado.");
            
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }
    
}
