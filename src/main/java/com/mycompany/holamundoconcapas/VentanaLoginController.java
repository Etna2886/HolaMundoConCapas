/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.holamundoconcapas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

/**
 * FXML Controller class
 *
 * @author CJ
 */
public class VentanaLoginController implements Initializable {

    @FXML
    private PasswordField contraField;
    @FXML
    private Button loginButton;
    @FXML
    private PasswordField nameField;
    @FXML
    private Label errorLabel;

    private int intentos = 3;
    private Controlador controlador;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private boolean loginCorrecto() {
        String user = nameField.getText();
        String pass = contraField.getText();

        return controlador.checkUser(user, pass);  //esto hay que hacerlo en el controlador como siempre creo
    }

    public void validarLogin() {
        if (!loginCorrecto()) {
            intentos--;

            errorLabel.setText("Te quedan " + intentos + " intentos.");
            errorLabel.setOpacity(1);

            if (intentos == 0) {
                errorLabel.setText("Has agotado los intentos.");
            }
        }else{
             //App.setRoot(""); aquí hay que hacer una condición para que habra la de trabajador o la de usuario
        }
    }

}
