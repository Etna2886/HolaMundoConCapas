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
public class ImplementacionUsuario implements UsuarioDAO{
    
    public String contrasenaCorrecta(ArrayList<Cliente> aCliente, ArrayList<Trabajador> aTrabajador, String dni, String contrasena) {
        
        Cliente c = buscarClienteDni(aCliente, dni);
        Trabajador t = buscarTrabajadorDni(aTrabajador, dni);

        if (c != null) {
            if (c.getContrasena().equals(contrasena)) {
                System.out.println("Contraseña correcta.");
                return "Cliente";
            }

            System.out.println("Contraseña incorrecta.");
            return null;
        }

        if (t != null) {
            if (t.getContrasena().equals(contrasena)) {
                System.out.println("Contraseña correcta.");
                return "Trabajador";
            }

            System.out.println("Contraseña incorrecta.");
            return null;
        }
        
        System.out.println("DNI no encontrado.");
        return null;
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
    
    public Cliente buscarClienteDni(ArrayList<Cliente> aCliente, String dni) {
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
    
    public Trabajador buscarTrabajadorDni(ArrayList<Trabajador> aTrabajador, String dni) {
        boolean encontrado = false;
        Trabajador t = null;
        
        for (int i=0; i<aTrabajador.size() && !encontrado; i++) {
            if (aTrabajador.get(i).getDni().equals(dni)) {
                t = aTrabajador.get(i);
                encontrado = true;
            }
        }
        
        return t;
    }

    @Override
    public boolean comprobarEmail(ArrayList<Cliente> aClientes, ArrayList<Trabajador> aTrabajadores, String correo, String dni) {
        boolean ok = true;
        for (int i=0; i<aClientes.size() && ok; i++) {
            if (aClientes.get(i).getCorreo().equalsIgnoreCase(correo)) {
                if (!aClientes.get(i).getDni().equalsIgnoreCase(dni)) {
                    ok = false;
                    System.out.println("Correo ya existente.");
                }
            }
        }
        
        for (int i=0; i<aTrabajadores.size() && ok; i++) {
            if (aTrabajadores.get(i).getCorreo().equalsIgnoreCase(correo)) {
                if (!aTrabajadores.get(i).getDni().equalsIgnoreCase(dni)) {
                    ok = false;
                    System.out.println("Correo ya existente.");
                }
            }
        }
        return ok;
    }
}
