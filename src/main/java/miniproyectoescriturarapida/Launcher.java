package miniproyectoescriturarapida;

import javafx.application.Application;

/**
 * Main application launcher. Starts {@link HelloApplication} as a JavaFX
 * application.
 */
public class Launcher {
    /**
     * Application entry point.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Application.launch(HelloApplication.class, args); // Arrancar la app JavaFX
    }
}
