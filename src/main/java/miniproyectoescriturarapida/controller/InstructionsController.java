package miniproyectoescriturarapida.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * Controlador de la ventana de instrucciones (instructions-view.fxml).
 * Muestra cómo jugar y permite cerrar la ventana.
 */
public class InstructionsController {

    /**
     * Cierra la ventana de instrucciones.
     */
    @FXML
    protected void onCloseButtonClick(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
