/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.holamundoconcapas;

import com.mycompany.model.*;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author oihan
 */
public class VentanaClienteController implements Initializable {

    UsuarioDAO usuarioDao = new ImplementacionUsuario();
    
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
    
    ArrayList<Cliente> aClientes;
    ArrayList<Trabajador> aTrabajadores;

    /**
     * Initializes the controller class.
     */
    public void iniciar(Stage stage, VentanaLoginController controller,  ArrayList<Trabajador> trabajadores, ArrayList<Cliente> clientes, String dni) {
        aClientes = clientes;
        aTrabajadores = trabajadores;
        Cliente c = usuarioDao.buscarClienteDni(aClientes, "12345678A");
        
        nomField.setText(c.getNombre());
        contraField.setText(c.getContrasena());
        dniField.setText(c.getDni());
        emailField.setText(c.getCorreo());
        telField.setText(String.valueOf(c.getNumTelefono()));
        dirField.setText(c.getDireccion());
        numField.setText(String.valueOf(c.getNumTarjeta()));
        cadField.setText(String.valueOf(c.getCaducidadTarjeta()));
    }
    
    public void editarCampos() {
        boolean ok = true;
        boolean encontrado = false;
        
        if (!emailField.getText().matches("^\\w+(?:\\.\\w+)*@[\\w-]+(?:\\.[\\w-]+)*\\.[A-Za-z]{2,4}$")) {
            System.out.println("Email no válido.");
            ok = false;
        } else {
            ok = usuarioDao.comprobarEmail(aClientes, aTrabajadores, emailField.getText(), dniField.getText());
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
            for (int i=0; i<aClientes.size() && !encontrado; i++) {
                if (aClientes.get(i).getDni().equalsIgnoreCase(dniField.getText())) {
                    Cliente c = new Cliente();
                    c.setNombre(nomField.getText());
                    c.setDni(aClientes.get(i).getDni());
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Nada
    }
}
