module com.mycompany.proyectosegundoparcial {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.proyectosegundoparcial to javafx.fxml;
    exports com.mycompany.proyectosegundoparcial;
}
