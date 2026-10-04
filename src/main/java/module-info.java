module com.mycompany.holamundoconcapas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.holamundoconcapas to javafx.fxml;
    exports com.mycompany.holamundoconcapas;
}
