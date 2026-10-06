module miniproyectoescriturarapida {
    requires javafx.controls; // Necesita los controles básicos de JavaFX (botones, etiquetas...)
    requires javafx.fxml;     // Necesita el cargador de archivos FXML

    // Paquetes que FXML puede acceder vía reflexión (controladores y vistas)
    opens miniproyectoescriturarapida to javafx.fxml;
    opens miniproyectoescriturarapida.view to javafx.fxml;
    opens miniproyectoescriturarapida.controller to javafx.fxml;
    // Paquetes públicos para el resto de módulos
    exports miniproyectoescriturarapida;
    exports miniproyectoescriturarapida.controller;
    exports miniproyectoescriturarapida.model;
    exports miniproyectoescriturarapida.view;
}