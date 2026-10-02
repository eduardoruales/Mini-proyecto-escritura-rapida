package miniproyectoescriturarapida;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Punto de entrada de la aplicación JavaFX del juego de escritura rápida.
 * Carga la vista del menú principal.
 */
public class HelloApplication extends Application {
    /**
     * Inicia la interfaz gráfica principal.
     *
     * @param stage ventana principal de la aplicación
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/start-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Escritura Rápida");
        stage.setScene(scene);
        stage.show();
    }
}
