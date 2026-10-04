/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.holamundoconcapas;

import com.mycompany.model.*;
import com.mycompany.model.DBImplementationCliente;
import java.net.URL;
import java.util.ArrayList;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author oihan
 */
public class VentanaClienteController implements Initializable {

    ClienteDAO clienteDao = new DBImplementationCliente();
    ArrayList<Cliente> aClientes = fillData();
    
    @FXML
    private Button editButton;
    @FXML
    private PasswordField contraField;
    @FXML
    private TextField nomField;
    @FXML
    private TextField dniField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField telField;
    @FXML
    private TextField dirField;
    @FXML
    private PasswordField numField;
    @FXML
    private PasswordField cadField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Cliente c = clienteDao.buscarDni(aClientes, "12345678A");
        
        nomField.setText(c.getNombre());
        contraField.setText(c.getContrasena());
        dniField.setText(c.getDni());
        emailField.setText(c.getCorreo());
        telField.setText(String.valueOf(c.getNumTelefono()));
        dirField.setText(c.getDireccion());
        numField.setText(String.valueOf(c.getNumTarjeta()));
        cadField.setText(String.valueOf(c.getCaducidadTarjeta()));
    }
    
    @FXML
    public void editarCampos() {
        boolean ok = true;
        boolean encontrado = false;
        
        if (!emailField.getText().matches("[\\w.]+@[\\w-]+\\.[\\w]{2,4}")) {
            System.out.println("Email no válido.");
            ok = false;
        } else {
            for (int i=0; i<aClientes.size() && !encontrado; i++) {
                if (aClientes.get(i).getCorreo().equalsIgnoreCase(emailField.getText())) {
                    ok = false;
                    System.out.println("Correo ya existente.");
                }
            }
        }
        
        if (!telField.getText().matches("\\d{9}")) {
            System.out.println("Número de teléfono no válido.");
            ok = false;
        }
        
        if (!cadField.getText().matches("(0[1-9]|1[0-2])([\\d]{2})")) {
            System.out.println("Fecha de caducidad no válido.");
            ok = false;
        }
        
        if (ok) {
            Cliente c = clienteDao.buscarDni(aClientes, dniField.getText());

            for (int i=0; i<aClientes.size() && !encontrado; i++) {
                if (aClientes.get(i).getDni().equalsIgnoreCase(dniField.getText())) {
                    c.setNombre(nomField.getText());
                    c.setContrasena(contraField.getText());
                    c.setCorreo(emailField.getText());
                    c.setNumTelefono(Integer.parseInt(telField.getText()));
                    c.setDireccion(dirField.getText());
                    c.setNumTarjeta(Integer.parseInt(numField.getText()));
                    c.setCaducidadTarjeta(cadField.getText());

                    aClientes.set(i, c);
                    encontrado = true;

                    System.out.println("Campos editados correctamente.");
                }
            } 
        }  
    }

    public ArrayList<Cliente> fillData() {
        ArrayList<Cliente> aClientes = new ArrayList<Cliente>();
        
        aClientes.add(new Cliente("Carlos García", "Carlos123", "12345678A", "carlos.garcia@email.com", 612345678, "Calle Mayor 12, Bilbao", 12345678, fecha(10,28)));
        aClientes.add(new Cliente("Laura Martínez", "Laura456", "23456789B", "laura.martinez@email.com", 623456789, "Calle Euskadi 25, Galdakao", 23456789, fecha(6, 2028)));
        aClientes.add(new Cliente("Javier López", "Javier789", "34567890C", "javier.lopez@email.com", 634567890, "Calle San Juan 8, Barakaldo", 34567890, fecha(9, 2027)));
        aClientes.add(new Cliente("Marta Sánchez", "Marta321", "45678901D", "marta.sanchez@email.com", 645678901, "Avenida Bilbao 34, Basauri", 45678901, fecha(11, 2028)));
        aClientes.add(new Cliente("David Fernández", "David654", "56789012E", "david.fernandez@email.com", 656789012, "Calle Urkiola 17, Durango", 56789012, fecha(3, 2029)));
        aClientes.add(new Cliente("Ana Gómez", "Ana987", "67890123F", "ana.gomez@email.com", 667890123, "Calle Arenal 5, Bilbao", 67890123, fecha(7, 2027)));
        aClientes.add(new Cliente("Pablo Díaz", "Pablo147", "78901234G", "pablo.diaz@email.com", 678901234, "Calle Navarra 21, Getxo", 78901234, fecha(10, 2028)));
        aClientes.add(new Cliente("Lucía Moreno", "Lucia258", "89012345H", "lucia.moreno@email.com", 689012345, "Calle Ibaizabal 42, Galdakao", 89012345, fecha(1, 2029)));
        aClientes.add(new Cliente("Álvaro Muñoz", "Alvaro369", "90123456J", "alvaro.munoz@email.com", 690123456, "Calle Bidearte 9, Leioa", 90123456, fecha(5, 2028)));
        aClientes.add(new Cliente("Sara Romero", "Sara741", "01234567K", "sara.romero@email.com", 601234567, "Calle San Pedro 16, Amorebieta", 11234567, fecha(8, 2027)));

        aClientes.add(new Cliente("Miguel Navarro", "Miguel852", "11223344L", "miguel.navarro@email.com", 612233445, "Calle Euskadi 10, Bilbao", 22345678, fecha(2, 2029)));
        aClientes.add(new Cliente("Elena Torres", "Elena963", "22334455M", "elena.torres@email.com", 623344556, "Calle Araba 28, Vitoria", 33456789, fecha(4, 2028)));
        aClientes.add(new Cliente("Sergio Vázquez", "Sergio159", "33445566N", "sergio.vazquez@email.com", 634455667, "Calle Gipuzkoa 7, Eibar", 44567890, fecha(9, 2029)));
        aClientes.add(new Cliente("Irene Ramos", "Irene357", "44556677P", "irene.ramos@email.com", 645566778, "Calle Iturribide 19, Bilbao", 55678901, fecha(12, 2028)));
        aClientes.add(new Cliente("Diego Ortega", "Diego753", "55667788Q", "diego.ortega@email.com", 656677889, "Calle Bizkaia 31, Sestao", 66789012, fecha(6, 2029)));
        aClientes.add(new Cliente("Nerea Castro", "Nerea951", "66778899R", "nerea.castro@email.com", 667788990, "Calle Sollube 4, Mungia", 77890123, fecha(11, 2027)));
        aClientes.add(new Cliente("Adrián Molina", "Adrian246", "77889900S", "adrian.molina@email.com", 678899001, "Calle Artxanda 15, Bilbao", 88901234, fecha(3, 2028)));
        aClientes.add(new Cliente("Paula Suárez", "Paula468", "88990011T", "paula.suarez@email.com", 689900112, "Calle Lehendakari 23, Galdakao", 99012345, fecha(7, 2029)));
        aClientes.add(new Cliente("Ander Iglesias", "Ander579", "99001122V", "ander.iglesias@email.com", 690011223, "Calle Usansolo 6, Galdakao", 10123456, fecha(10, 2027)));
        aClientes.add(new Cliente("Claudia Martín", "Claudia680", "10112233W", "claudia.martin@email.com", 601122334, "Calle Gran Vía 40, Bilbao", 21234567, fecha(1, 2028)));

        return aClientes;
    }
    
    private String fecha(int mes, int anio) {
        YearMonth fecha = YearMonth.of(anio, mes);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("MMyy");
        return fecha.format(formato);
    }
    
}
