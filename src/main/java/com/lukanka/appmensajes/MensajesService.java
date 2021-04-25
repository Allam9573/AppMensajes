/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lukanka.appmensajes;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author allam
 */
public class MensajesService {
    
    public static void crearMensaje() {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Escribe un mensaje: ");
        String mensaje = scan.nextLine();
        System.out.print("Nombre de autor: ");
        String autor = scan.nextLine();
        Mensaje nuevoMensaje = new Mensaje();
        nuevoMensaje.setMensaje(mensaje);
        nuevoMensaje.setAutor(autor);
        MensajesDAO.crearMensaje(nuevoMensaje);
        
    }
    
    public static void listarMensajes() {
        MensajesDAO.leerMensajes();
    }
    
    public static void borrarMensaje() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID de mensaje a borrar:"));
        MensajesDAO.borrarMensaje(id);
    }
    
    public static void editarMensaje() {
        String msg = JOptionPane.showInputDialog("Digite su nuevo mensaje:");
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del mensaje a editar:"));
        Mensaje actualizarMsg = new Mensaje();
        actualizarMsg.setId(id);
        actualizarMsg.setMensaje(msg);
        MensajesDAO.actualizarMensaje(actualizarMsg);
    }
    
}
