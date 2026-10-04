/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.model;

import java.util.ArrayList;

/**
 *
 * @author oihan
 */
public interface UsuarioDAO {
    
    public String contrasenaCorrecta(ArrayList<Cliente> aCliente, ArrayList<Trabajador> aTrabajador, String correo, String contrasena);
    public boolean comprobarEmail(ArrayList<Cliente> aCliente, ArrayList<Trabajador> aTrabajador, String correo, String dni);
    public Cliente buscarClienteDni(ArrayList<Cliente> aCliente, String dni);
}
