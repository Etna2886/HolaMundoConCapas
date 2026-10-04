/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.model;

import java.util.ArrayList;

/**
 * Define las operaciones para autenticar usuarios y localizar sus datos.
 *
 * @author oihan
 */
public interface UsuarioDAO {
    
    /**
     * Comprueba si las credenciales pertenecen a un cliente o a un trabajador.
     *
     * @param aCliente lista de clientes donde buscar
     * @param aTrabajador lista de trabajadores donde buscar
     * @param dni documento de identidad del usuario
     * @param contrasena contraseña que se quiere comprobar
     * @return {@code "Cliente"} o {@code "Trabajador"} si las credenciales son
     * correctas; {@code null} si no se encuentra una coincidencia
     */
    public String contrasenaCorrecta(ArrayList<Cliente> aCliente, ArrayList<Trabajador> aTrabajador, String dni, String contrasena);

    /**
     * Busca un cliente cuyo documento de identidad coincida con el indicado.
     *
     * @param aCliente lista de clientes donde realizar la búsqueda
     * @param dni documento de identidad que se quiere localizar
     * @return cliente encontrado o {@code null} si no hay coincidencia
     */
    public Cliente buscarClienteDni(ArrayList<Cliente> aCliente, String dni);

    /**
     * Busca un trabajador cuyo documento de identidad coincida con el indicado.
     *
     * @param aTrabajador lista de trabajadores donde realizar la búsqueda
     * @param dni documento de identidad que se quiere localizar
     * @return trabajador encontrado o {@code null} si no hay coincidencia
     */
    public Trabajador buscarTrabajadorDni(ArrayList<Trabajador> aTrabajador, String dni);

    /**
     * Comprueba que un correo no esté asignado a otra persona distinta del
     * usuario identificado por el documento indicado.
     *
     * @param aCliente lista de clientes que se debe revisar
     * @param aTrabajador lista de trabajadores que se debe revisar
     * @param correo dirección de correo que se quiere comprobar
     * @param dni documento de identidad del usuario que conserva ese correo
     * @return {@code true} si el correo está disponible para ese usuario;
     * {@code false} si ya pertenece a otra persona
     */
    public boolean comprobarEmail(ArrayList<Cliente> aCliente, ArrayList<Trabajador> aTrabajador, String correo, String dni);
}
