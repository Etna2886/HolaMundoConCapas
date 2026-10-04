/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.holamundoconcapas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author CJ
 */
public class VentanaTrabajadorController implements Initializable {

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
    private PasswordField cargoField;
    @FXML
    private PasswordField contratoField;
    @FXML
    private PasswordField ibanField;
    @FXML
    private TableColumn<Usuario, String> colNom;
    @FXML
    private TableColumn<Usuario, String> colContra;
    @FXML
    private TableColumn<Usuario, String> colDNI;
    @FXML
    private TableColumn<Usuario, String> colEmail;
    @FXML
    private TableColumn<Usuario, String> colTelefono;
    @FXML
    private TableColumn<Usuario, String> colDir;
    @FXML
    private TableColumn<Usuario, String> colTarjeta;
    @FXML
    private TableColumn<Usuario, String> colCaducidad;
    @FXML
    private TableView<Usuario> tablaUsuarios;
    
    private Controlador controlador;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colNom.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colContra.setCellValueFactory(new PropertyValueFactory<>("contrasena"));
        colDNI.setCellValueFactory(new PropertyValueFactory<>("dni"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colDir.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colTarjeta.setCellValueFactory(new PropertyValueFactory<>("numTarjeta"));
        colCaducidad.setCellValueFactory(new PropertyValueFactory<>("caducidad"));

        tablaUsuarios.getItems().addAll(controlador.getAllUsuarios());//este método también debe estar en el controlador creo    }

    }
}
