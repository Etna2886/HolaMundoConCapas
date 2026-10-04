/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
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

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getDni() {
        return dni;
    }

    public String getCorreo() {
        return correo;
    }

    public int getNumTelefono() {
        return numTelefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getNumTarjeta() {
        return numTarjeta;
    }

    public String getCaducidadTarjeta() {
        return caducidadTarjeta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNumTarjeta(int numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public void setCaducidadTarjeta(String caducidadTarjeta) {
        this.caducidadTarjeta = caducidadTarjeta;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "nombre=" + nombre + ", contrasena=" + contrasena + ", dni=" + 
                dni + ", correo=" + correo + ", numTelefono=" + numTelefono + ", direccion=" + 
                direccion + ", numTarjeta=" + numTarjeta + ", caducidadTarjeta=" + caducidadTarjeta + '}';
    }

}
