package miniproyectoescriturarapida;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controlador del menú principal (start-view.fxml).
 * Permite iniciar la partida, ver las instrucciones o salir.
 */
public class MenuController {

    @FXML
    private javafx.scene.control.Button startButton;

    /**
     * Carga la vista principal del juego al pulsar "Iniciar partida".
     */
    @FXML
    protected void onStartButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/game-view.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) startButton.getScene().getWindow();
        stage.setScene(new Scene(root, 800, 600));
    }

    /**
     * Muestra un diálogo con las instrucciones del juego.
     */
    @FXML
    protected void onInstructionsButtonClick() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Instrucciones");
        alert.setHeaderText(null);
        alert.setContentText("Escribe la palabra que aparece en pantalla y presiona Validar.\n" +
                "Tienes un tiempo límite que se reduce cada 5 niveles.\n" +
                "Si el tiempo se agota, la partida termina.");
        alert.showAndWait();
    }

    /**
     * Cierra la aplicación al pulsar "Salir".
     */
    @FXML
    protected void onExitButtonClick() {
        Platform.exit();
    }
}
