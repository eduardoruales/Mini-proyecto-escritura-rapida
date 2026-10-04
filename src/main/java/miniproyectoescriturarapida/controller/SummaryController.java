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
 * Controlador de la pantalla de resumen final (summary-view.fxml).
 * Muestra el resultado de la partida, los niveles completados y el tiempo
 * restante, y permite reiniciar o volver al menú.
 */
public class SummaryController {

    /** Mensaje con el resultado final de la partida. */
    public static String lastResult = "Fin de la partida";
    /** Niveles completados en la última partida. */
    public static int lastLevels = 0;
    /** Tiempo restante del último nivel (si aplica). */
    public static int lastRemaining = 0;

    @FXML private Label resultLabel;
    @FXML private Label levelsLabel;
    @FXML private Label timeLabel;
    @FXML private Button restartButton;

    /**
     * Inicializa las etiquetas del resumen con los datos de la última partida.
     */
    @FXML
    public void initialize() {
        resultLabel.setText(lastResult);
        levelsLabel.setText("Niveles completados: " + lastLevels);
        timeLabel.setText("Tiempo restante: " + lastRemaining + " s");
    }

    /**
     * Reinicia el juego volviendo a la vista principal del juego.
     */
    @FXML
    protected void onRestartButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/miniproyectoescriturarapida/view/game-view.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) restartButton.getScene().getWindow();
        stage.setScene(new Scene(root, 800, 600));
    }

    /**
     * Regresa a la pantalla de inicio del juego.
     */
    @FXML
    protected void onMenuButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/miniproyectoescriturarapida/view/start-view.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) restartButton.getScene().getWindow();
        stage.setScene(new Scene(root, 800, 600));
    }
}
