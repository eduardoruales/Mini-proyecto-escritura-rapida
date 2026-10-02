module miniproyectoescriturarapida {
    requires javafx.controls;
    requires javafx.fxml;


    opens miniproyectoescriturarapida to javafx.fxml;
    exports miniproyectoescriturarapida;
}