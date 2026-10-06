package miniproyectoescriturarapida;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Entry point of the JavaFX typing game application. Loads the main menu
 * view.
 */
public class HelloApplication extends Application {
    /**
     * Starts the main graphical interface.
     *
     * @param stage main application window
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/start-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600); // Construir la escena del menú
        stage.setTitle("Escritura Rápida");
        stage.setScene(scene);
        stage.show(); // Mostrar la ventana
    }
}
