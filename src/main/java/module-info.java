module miniproyectoescriturarapida {
    requires javafx.controls;
    requires javafx.fxml;


    opens miniproyectoescriturarapida to javafx.fxml;
    opens miniproyectoescriturarapida.view to javafx.fxml;
    opens miniproyectoescriturarapida.controller to javafx.fxml;
    exports miniproyectoescriturarapida;
    exports miniproyectoescriturarapida.controller;
    exports miniproyectoescriturarapida.model;
    exports miniproyectoescriturarapida.view;
}