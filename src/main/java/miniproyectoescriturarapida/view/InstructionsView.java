package miniproyectoescriturarapida.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Instructions window (instructions-view.fxml).
 * <p>
 * Displayed as a modal application window. Part of the {@code view} package,
 * which encapsulates the creation of each game window.</p>
 */
public class InstructionsView extends Stage {

    /**
     * Creates the modal instructions window.
     *
     * @throws IOException if the FXML file cannot be loaded
     */
    public InstructionsView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/miniproyectoescriturarapida/view/instructions-view.fxml"));
        Scene scene = new Scene(loader.load()); // Cargar el FXML de instrucciones
        this.setTitle("Instrucciones");        // Título de la ventana
        this.initModality(Modality.APPLICATION_MODAL); // Bloquea la ventana principal
        this.setScene(scene);                  // Asignar la escena a esta ventana
    }
}
