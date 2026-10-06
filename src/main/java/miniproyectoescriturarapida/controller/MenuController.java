package miniproyectoescriturarapida.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for the main menu (start-view.fxml). Lets the user start a
 * game, view the instructions, or exit.
 */
public class MenuController {

    @FXML
    private javafx.scene.control.Button startButton;

    /**
     * Loads the main game view when "Iniciar partida" is clicked.
     */
    @FXML
    protected void onStartButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/miniproyectoescriturarapida/view/game-view.fxml"));
        Parent root = loader.load(); // Cargar la vista del juego
        Stage stage = (Stage) startButton.getScene().getWindow(); // Ventana actual
        stage.setScene(new Scene(root, 800, 600)); // Reemplazar el contenido por el juego
    }

    /**
     * Opens the instructions window.
     */
    @FXML
    protected void onInstructionsButtonClick() throws IOException {
        new miniproyectoescriturarapida.view.InstructionsView().show(); // Abrir ventana modal de instrucciones
    }

    /**
     * Closes the application when "Salir" is clicked.
     */
    @FXML
    protected void onExitButtonClick() {
        Platform.exit(); // Finalizar la aplicación por completo
    }
}
