module com.mycompany.holamundoconcapas {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.holamundoconcapas to javafx.fxml;
    exports com.mycompany.holamundoconcapas;
}
