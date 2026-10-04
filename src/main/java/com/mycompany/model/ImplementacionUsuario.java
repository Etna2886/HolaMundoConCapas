/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

import java.util.ArrayList;

/**
 * Implementa las búsquedas y comprobaciones de usuarios definidas por
 * {@link UsuarioDAO}.
 *
 * @author oihan
 */
public class ImplementacionUsuario implements UsuarioDAO{
    
    /**
     * Busca al usuario por DNI y compara su contraseña con la recibida.
     *
     * @param aCliente lista de clientes donde buscar primero
     * @param aTrabajador lista de trabajadores donde buscar si no es cliente
     * @param dni documento de identidad del usuario
     * @param contrasena contraseña que se quiere validar
     * @return tipo de usuario ({@code "Cliente"} o {@code "Trabajador"}) si la
     * contraseña coincide; {@code null} si no existe o no es correcta
     */
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
    
    /**
     * Busca en la lista el primer cliente con la dirección de correo indicada.
     *
     * @param aCliente lista de clientes donde realizar la búsqueda
     * @param correo correo que se quiere localizar
     * @return cliente encontrado o {@code null} si no hay coincidencia
     */
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
    
    /**
     * Busca en la lista el primer cliente cuyo DNI coincida con el indicado.
     *
     * @param aCliente lista de clientes donde realizar la búsqueda
     * @param dni documento de identidad que se quiere localizar
     * @return cliente encontrado o {@code null} si no hay coincidencia
     */
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
    
    /**
     * Busca en la lista el primer trabajador cuyo DNI coincida con el indicado.
     *
     * @param aTrabajador lista de trabajadores donde realizar la búsqueda
     * @param dni documento de identidad que se quiere localizar
     * @return trabajador encontrado o {@code null} si no hay coincidencia
     */
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

    /**
     * Revisa los correos de clientes y trabajadores para evitar duplicados.
     * La comparación no distingue entre mayúsculas y minúsculas y permite que
     * el usuario indicado conserve su propio correo.
     *
     * @param aClientes lista de clientes que se debe revisar
     * @param aTrabajadores lista de trabajadores que se debe revisar
     * @param correo dirección de correo que se quiere comprobar
     * @param dni DNI del usuario propietario, si ya tiene ese correo
     * @return {@code true} si no existe otra persona con ese correo;
     * {@code false} en caso contrario
     */
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
