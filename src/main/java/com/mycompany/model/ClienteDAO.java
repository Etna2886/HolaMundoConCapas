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
public interface ClienteDAO {
    
    public boolean contrasenaCorrecta(ArrayList<Cliente> aCliente, String correo, String contrasena);
    public Cliente buscarDni(ArrayList<Cliente> aCliente, String dni);
}
