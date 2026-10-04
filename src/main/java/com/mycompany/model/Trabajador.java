/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 * Representa los datos personales y de pago de un trabajador.
 *
 * @author ivan
 */
public class Trabajador {

    private String nombre;
    private String contrasena;
    private String dni;
    private String correo;
    private int numTelefono;
    private String direccion;
    private int numTarjeta;
    private String caducidadTarjeta;

    /**
     * Crea un trabajador e inicializa todos sus datos personales y de pago.
     *
     * @param nombre nombre completo del trabajador
     * @param contrasena contraseña utilizada para iniciar sesión
     * @param dni documento de identidad del trabajador
     * @param correo dirección de correo electrónico
     * @param numTelefono número de teléfono
     * @param direccion dirección postal
     * @param numTarjeta número de tarjeta de pago
     * @param caducidadTarjeta fecha de caducidad de la tarjeta
     */
    public Trabajador(String nombre, String contrasena, String dni, String correo, int numTelefono, String direccion, int numTarjeta, String caducidadTarjeta) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.dni = dni;
        this.correo = correo;
        this.numTelefono = numTelefono;
        this.direccion = direccion;
        this.numTarjeta = numTarjeta;
        this.caducidadTarjeta = caducidadTarjeta;
    }

    /** @return nombre completo del trabajador */
    public String getNombre() {
        return nombre;
    }

    /** @return contraseña utilizada para iniciar sesión */
    public String getContrasena() {
        return contrasena;
    }

    /** @return documento de identidad del trabajador */
    public String getDni() {
        return dni;
    }

    /** @return dirección de correo electrónico del trabajador */
    public String getCorreo() {
        return correo;
    }

    /** @return número de teléfono del trabajador */
    public int getNumTelefono() {
        return numTelefono;
    }

    /** @return dirección postal del trabajador */
    public String getDireccion() {
        return direccion;
    }

    /** @return número de la tarjeta de pago */
    public int getNumTarjeta() {
        return numTarjeta;
    }

    /** @return fecha de caducidad de la tarjeta */
    public String getCaducidadTarjeta() {
        return caducidadTarjeta;
    }

    /** @param nombre nuevo nombre completo del trabajador */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** @param contrasena nueva contraseña de acceso */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /** @param dni nuevo documento de identidad del trabajador */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /** @param correo nueva dirección de correo electrónico */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /** @param numTelefono nuevo número de teléfono */
    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }

    /** @param direccion nueva dirección postal */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /** @param numTarjeta nuevo número de la tarjeta de pago */
    public void setNumTarjeta(int numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    /** @param caducidadTarjeta nueva fecha de caducidad de la tarjeta */
    public void setCaducidadTarjeta(String caducidadTarjeta) {
        this.caducidadTarjeta = caducidadTarjeta;
    }

    /**
     * Genera una representación textual con todos los datos del trabajador.
     *
     * @return texto con los valores actuales de los campos
     */
    @Override
    public String toString() {
        return "Trabajador{" + "nombre=" + nombre + ", contrasena=" + contrasena + ", dni=" + 
                dni + ", correo=" + correo + ", numTelefono=" + numTelefono + ", direccion=" + 
                direccion + ", numTarjeta=" + numTarjeta + ", caducidadTarjeta=" + caducidadTarjeta + '}';
    }

}
