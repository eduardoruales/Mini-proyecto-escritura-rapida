package miniproyectoescriturarapida.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for the game-over summary screen (summary-view.fxml). Shows
 * the game result, completed levels, and remaining time, and lets the
 * player restart or go back to the menu.
 */
public class SummaryController {

    /** Final game result message. */
    public static String lastResult = "Fin de la partida";
    /** Levels completed in the last game. */
    public static int lastLevels = 0;
    /** Time remaining on the last level (if applicable). */
    public static int lastRemaining = 0;

    @FXML private Label resultLabel;
    @FXML private Label levelsLabel;
    @FXML private Label timeLabel;
    @FXML private Button restartButton;

    /**
     * Initializes the summary labels with the last game's data.
     */
    @FXML
    public void initialize() {
        resultLabel.setText(lastResult);                          // Resultado final
        levelsLabel.setText("Niveles completados: " + lastLevels); // Niveles superados
        timeLabel.setText("Tiempo restante: " + lastRemaining + " s"); // Tiempo que quedó
    }

    /**
     * Restarts the game by loading the main game view.
     */
    @FXML
    protected void onRestartButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/miniproyectoescriturarapida/view/game-view.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) restartButton.getScene().getWindow();
        stage.setScene(new Scene(root, 800, 600)); // Volver a la escena del juego
    }

    /**
     * Returns to the game start screen.
     */
    @FXML
    protected void onMenuButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/miniproyectoescriturarapida/view/start-view.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) restartButton.getScene().getWindow();
        stage.setScene(new Scene(root, 800, 600)); // Volver a la escena del menú
    }
}
