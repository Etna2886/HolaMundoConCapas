package com.mycompany.holamundoconcapas;

import com.mycompany.model.Cliente;
import com.mycompany.model.Trabajador;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.beans.property.SimpleStringProperty;
import javafx.stage.Stage;

public class VentanaTrabajadorController implements Initializable {

    // CAMPOS DEL TRABAJADOR
    @FXML private PasswordField contraField;
    @FXML private TextField nomField;
    @FXML private TextField dniField;
    @FXML private TextField emailField;
    @FXML private TextField telField;
    @FXML private TextField dirField;

    // TABLA DE CLIENTES
    @FXML private TableColumn<Cliente, String> colNom;
    @FXML private TableColumn<Cliente, String> colContra;
    @FXML private TableColumn<Cliente, String> colDNI;
    @FXML private TableColumn<Cliente, String> colEmail;
    @FXML private TableColumn<Cliente, String> colTelefono;
    @FXML private TableColumn<Cliente, String> colDir;
    @FXML private TableView<Cliente> tablaUsuarios;

    // Trabajador logueado
    private Trabajador trabajadorLogueado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // CONFIGURAR COLUMNAS DE LA TABLA
        colNom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colContra.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContrasena()));
        colDNI.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDni()));
        colEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        colTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNumTelefono())));
        colDir.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
    }

    /**
     * Método llamado desde VentanaLoginController
     */
    public void iniciar(Stage stage, VentanaLoginController controller, ArrayList<Trabajador> trabajadores, ArrayList<Cliente> clientes, String dni) {

        // Buscar el trabajador logueado por DNI
        for (Trabajador t : trabajadores) {
            if (t.getDni().equals(dni)) {
                this.trabajadorLogueado = t;
                mostrarDatosTrabajador();
                break;
            }
        }

        // Cargar clientes en la tabla
        tablaUsuarios.getItems().setAll(clientes);
    }

    /**
     * Mostrar los datos del trabajador en la vista
     */
    private void mostrarDatosTrabajador() {
        if (trabajadorLogueado == null) return;

        nomField.setText(trabajadorLogueado.getNombre());
        contraField.setText(trabajadorLogueado.getContrasena());
        dniField.setText(trabajadorLogueado.getDni());
        emailField.setText(trabajadorLogueado.getCorreo());
        telField.setText(String.valueOf(trabajadorLogueado.getNumTelefono()));
        dirField.setText(trabajadorLogueado.getDireccion());
    }
}