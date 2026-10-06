package miniproyectoescriturarapida.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Main menu window (start-view.fxml).
 * <p>
 * Classes in the {@code view} package encapsulate the creation of each game
 * window: they load their FXML file with an {@link FXMLLoader}, set up the
 * {@link Scene}, and configure the window title. Their associated FXML
 * controllers live in the {@code controller} package.</p>
 */
public class StartView extends Stage {

    /**
     * Creates the main game window showing the start view.
     *
     * @throws IOException if the FXML file cannot be loaded
     */
    public StartView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/miniproyectoescriturarapida/view/start-view.fxml"));
        Scene scene = new Scene(loader.load()); // Cargar el FXML y crear la escena
        this.setScene(scene);   // Asignar la escena a esta ventana
        this.setTitle("Escritura Rápida"); // Título de la ventana
    }
}
