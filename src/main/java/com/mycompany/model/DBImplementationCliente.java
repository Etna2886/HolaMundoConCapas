/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import java.util.ArrayList;

/**
 *
 * @author oihan
 */
public class DBImplementationCliente implements ClienteDAO{
    
    public boolean contrasenaCorrecta(ArrayList<Cliente> aCliente, String correo, String contrasena) {
        Cliente c = buscarCorreo(aCliente, correo);
        
        if (c == null) {
            System.out.println("El correo introducido no existe.");
            return false;
        }
        
        if (c.getContrasena().equals(contrasena)) {
            System.out.println("Contraseña correcta.");
            return true;
        }
        
        System.out.println("Contraseña incorrecta.");
        return false;
    }
    
    public Cliente buscarCorreo(ArrayList<Cliente> aCliente, String correo) {
        boolean encontrado = false;
        Cliente c = null;
        
        for (int i=0; i<aCliente.size() && !encontrado; i++) {
            if (aCliente.get(i).getCorreo().equals(correo)) {
                c = aCliente.get(i);
                encontrado = true;
            }
        }
        
        return c;
    }
    
    public Cliente buscarDni(ArrayList<Cliente> aCliente, String dni) {
        boolean encontrado = false;
        Cliente c = null;
        
        for (int i=0; i<aCliente.size() && !encontrado; i++) {
            if (aCliente.get(i).getDni().equals(dni)) {
                c = aCliente.get(i);
                encontrado = true;
            }
        }
        
        return c;
    }
}
