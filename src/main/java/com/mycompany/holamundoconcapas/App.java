package com.mycompany.holamundoconcapas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Punto de entrada y configuración inicial de la aplicación JavaFX.
 */
public class App extends Application {

    private static Scene scene;

    /**
     * Crea la escena inicial con la ventana de inicio de sesión y la muestra.
     *
     * @param stage ventana principal proporcionada por JavaFX
     * @throws IOException si no se puede cargar el archivo FXML de inicio
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("ventanaLogin"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Sustituye el contenido de la escena actual por la vista indicada.
     *
     * @param fxml nombre del archivo FXML, sin la extensión
     * @throws IOException si no se puede cargar la vista solicitada
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Busca y carga una vista FXML del mismo paquete que esta clase.
     *
     * @param fxml nombre del archivo FXML, sin la extensión
     * @return elemento raíz de la vista cargada
     * @throws IOException si el archivo no existe o no se puede interpretar
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * Inicia el ciclo de vida de JavaFX.
     *
     * @param args argumentos recibidos al ejecutar el programa
     */
    public static void main(String[] args) {
        launch();
    }

}