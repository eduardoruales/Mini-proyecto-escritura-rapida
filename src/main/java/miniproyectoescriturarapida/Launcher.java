package miniproyectoescriturarapida;

import javafx.application.Application;

/**
 * Lanzador principal de la aplicación. Permite arrancar la
 * {@link HelloApplication} como una aplicación JavaFX.
 */
public class Launcher {
    /**
     * Punto de entrada de la aplicación.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        Application.launch(HelloApplication.class, args);
    }
}
