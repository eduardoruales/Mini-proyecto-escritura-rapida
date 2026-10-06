package miniproyectoescriturarapida.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Game window (game-view.fxml).
 * <p>
 * Part of the {@code view} package, which encapsulates the creation of each
 * game window. See {@link StartView} for details.</p>
 */
public class GameView extends Stage {

    /**
     * Creates the game window.
     *
     * @throws IOException if the FXML file cannot be loaded
     */
    public GameView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/miniproyectoescriturarapida/view/game-view.fxml"));
        Scene scene = new Scene(loader.load()); // Cargar el FXML del juego
        this.setScene(scene);   // Asignar la escena a esta ventana
        this.setTitle("Escritura Rápida"); // Título de la ventana
    }
}
