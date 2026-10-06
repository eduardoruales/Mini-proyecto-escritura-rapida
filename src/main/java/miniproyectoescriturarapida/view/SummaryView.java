package miniproyectoescriturarapida.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Game-over summary window (summary-view.fxml).
 * <p>
 * Part of the {@code view} package, which encapsulates the creation of each
 * game window.</p>
 */
public class SummaryView extends Stage {

    /**
     * Creates the summary window.
     *
     * @throws IOException if the FXML file cannot be loaded
     */
    public SummaryView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/miniproyectoescriturarapida/view/summary-view.fxml"));
        Scene scene = new Scene(loader.load()); // Cargar el FXML del resumen
        this.setScene(scene);   // Asignar la escena a esta ventana
        this.setTitle("Escritura Rápida"); // Título de la ventana
    }
}
