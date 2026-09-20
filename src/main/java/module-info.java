module com.example.miniproyectoescriturarapida {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.miniproyectoescriturarapida to javafx.fxml;
    exports com.example.miniproyectoescriturarapida;
}