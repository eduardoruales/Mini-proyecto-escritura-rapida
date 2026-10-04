module miniproyectoescriturarapida {
    requires javafx.controls;
    requires javafx.fxml;


    opens miniproyectoescriturarapida to javafx.fxml;
    opens miniproyectoescriturarapida.view to javafx.fxml;
    exports miniproyectoescriturarapida;
}