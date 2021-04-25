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
public class MainApp {

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        conexion.getConnection();
        Scanner scan = new Scanner(System.in);
        int response = 0;
        do {
            response = Integer.parseInt(JOptionPane.showInputDialog("Aplicacion de mensajeria:\n\n1. Crear mensaje."
                    + "\n2. Listar mensajes.\n3. Editar mensaje.\n4. Eliminar mensaje.\n5. Salir."));

            switch (response) {
                case 1:
                    MensajesService.crearMensaje();
                    break;
                case 2:
                    MensajesService.listarMensajes();
                    break;
                case 3:
                    MensajesService.editarMensaje();
                    break;
                case 4:
                    MensajesService.borrarMensaje();
                    break;
                case 5:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Seleccione una opcion valida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (response != 5);
    }

}
