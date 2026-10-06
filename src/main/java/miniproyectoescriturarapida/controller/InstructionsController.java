package miniproyectoescriturarapida.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * Controller for the instructions window (instructions-view.fxml). Shows
 * how to play and lets the user close the window.
 */
public class InstructionsController {

    /**
     * Closes the instructions window.
     */
    @FXML
    protected void onCloseButtonClick(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Ventana del botón
        stage.close(); // Cerrarla
    }
}
