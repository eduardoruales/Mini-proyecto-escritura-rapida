package miniproyectoescriturarapida.controller;

import miniproyectoescriturarapida.model.GameLogic;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

/**
 * Controller for the game view (game-view.fxml).
 * <p>
 * Coordinates the {@link GameLogic} model, the countdown ({@link Timeline}),
 * keyboard/mouse handlers, and game events ({@link GameEventListener}).
 * </p>
 */
public class GameController {

    @FXML private Label timerLabel;     // Etiqueta del cronómetro
    @FXML private Label wordLabel;      // Etiqueta de la palabra actual
    @FXML private Label feedbackLabel;  // Etiqueta de mensajes de acierto/error
    @FXML private TextField answerField; // Campo donde el jugador escribe
    @FXML private Button submitButton;   // Botón de validación
    @FXML private Label levelLabel;      // Etiqueta del nivel
    @FXML private Label livesLabel;      // Etiqueta de vidas restantes

    private GameLogic gameLogic = new GameLogic(); // Modelo con la lógica del juego
    private int timeLeft;                          // Segundos restantes del nivel actual
    private Timeline timer;                        // Bucle que descuenta el tiempo

    /**
     * Game event listener; updates the UI.
     */
    private final GameEventListener eventListener = new GameEventAdapter() {
        @Override
        public void onCorrectAnswer(int newLevel) {
            feedbackLabel.setText("¡Correcto! / ¡Nivel superado!"); // Mensaje positivo
            feedbackLabel.getStyleClass().add("correct");           // Color verde
        }

        @Override
        public void onIncorrectAnswer() {
            feedbackLabel.setText("Incorrecto. Vidas restantes: " + gameLogic.getLives()); // Mensaje de error
            feedbackLabel.getStyleClass().add("incorrect"); // Color rojo
        }

        @Override
        public void onTimeOut() {
            feedbackLabel.setText("¡Tiempo agotado! -1 vida. Vidas restantes: " + gameLogic.getLives()); // Aviso de tiempo
            feedbackLabel.getStyleClass().add("incorrect");
        }

        @Override
        public void onLevelUp(int level) {
            levelLabel.setText("Nivel " + level); // Actualizar etiqueta de nivel
        }

        @Override
        public void onGameOver(int levelsCompleted, int remainingSeconds) {
            goToSummary("Partida terminada", levelsCompleted, remainingSeconds); // Ir al resumen
        }
    };

    /**
     * Initialization method called automatically after loading the FXML.
     */
    @FXML
    public void initialize() {
        // Manejador de teclado: Enter en el campo de texto valida la respuesta.
        answerField.setOnAction(e -> handleSubmit());
        // Manejadores de ratón: resaltan el botón al pasar el cursor.
        submitButton.setOnMouseEntered(e -> submitButton.setOpacity(0.8));
        submitButton.setOnMouseExited(e -> submitButton.setOpacity(1.0));
        startRound(); // Arranca la primera ronda
    }

    /**
     * Starts (or restarts) the current round/level with its countdown.
     */
    private void startRound() {
        timeLeft = gameLogic.getTimeForCurrentLevel();      // Tiempo según el nivel actual
        wordLabel.setText(gameLogic.getCurrentWord());      // Mostrar la palabra a escribir
        levelLabel.setText("Nivel " + gameLogic.getCurrentLevel()); // Mostrar el nivel
        livesLabel.setText("Vidas: " + gameLogic.getLives());       // Mostrar las vidas
        updateTimerLabel();                                 // Refrescar el cronómetro
        answerField.getStyleClass().removeAll("correct", "incorrect"); // Limpiar colores previos
        answerField.setText("");                            // Vaciar el campo de respuesta
        if (timer != null) {
            timer.stop(); // Detener el temporizador anterior si existía
        }
        // Crear un Timeline que ejecuta tick() cada segundo, indefinidamente
        timer = new Timeline(new KeyFrame(Duration.seconds(1), e -> tick()));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    /**
     * Method called every second by the {@link Timeline}.
     */
    private void tick() {
        timeLeft--;          // Descontar un segundo
        updateTimerLabel();  // Actualizar la etiqueta del tiempo
        if (timeLeft <= 0) { // Si se acabó el tiempo
            timer.stop();    // Detener el cronómetro
            gameLogic.perderVida(); // El jugador pierde una vida
            eventListener.onTimeOut(); // Mostrar mensaje "¡Tiempo agotado!"
            if (gameLogic.isGameOver()) { // Si ya no quedan vidas
                eventListener.onGameOver(gameLogic.getCurrentLevel() - 1, 0); // Terminar partida
            } else {
                gameLogic.avanzarPalabra(); // Nueva palabra
                startRound();               // Reiniciar la ronda
            }
        }
    }

    /**
     * Updates the timer label in mm:ss format.
     */
    private void updateTimerLabel() {
        timerLabel.setText(String.format("%02d:%02d", timeLeft / 60, timeLeft % 60)); // Formato mm:ss
    }

    /**
     * Handler for the "Validar" button (onAction in the FXML).
     */
    @FXML
    protected void onSubmitButtonClick() {
        handleSubmit();
    }

    /**
     * Validates the word typed by the player.
     */
    private void handleSubmit() {
        String answer = answerField.getText().trim(); // Respuesta del jugador sin espacios extra
        answerField.getStyleClass().removeAll("correct", "incorrect"); // Quitar estilos anteriores
        feedbackLabel.getStyleClass().removeAll("correct", "incorrect");

        if (gameLogic.esRespuestaCorrecta(answer)) { // Si la respuesta es correcta
            gameLogic.advanceLevel();                // Subir de nivel
            gameLogic.avanzarPalabra();              // Pasar a la siguiente palabra
            eventListener.onCorrectAnswer(gameLogic.getCurrentLevel()); // Mensaje positivo
            eventListener.onLevelUp(gameLogic.getCurrentLevel());       // Actualizar nivel en pantalla
            startRound();                            // Iniciar la nueva ronda
        } else {                                     // Si la respuesta es incorrecta
            gameLogic.perderVida();                  // Restar una vida
            answerField.getStyleClass().add("incorrect"); // Pintar el campo en rojo
            answerField.setText("");                 // Limpiar el campo
            eventListener.onIncorrectAnswer();       // Mostrar mensaje de error
            if (gameLogic.isGameOver()) {            // Si se acabaron las vidas
                timer.stop();
                eventListener.onGameOver(gameLogic.getCurrentLevel() - 1, Math.max(0, timeLeft));
            }
        }
    }

    /**
     * Switches to the game-over summary screen.
     */
    private void goToSummary(String result, int levelsCompleted, int remainingSeconds) {
        try {
            SummaryController.lastResult = result;      // Resultado final
            SummaryController.lastLevels = levelsCompleted; // Niveles superados
            SummaryController.lastRemaining = remainingSeconds; // Tiempo restante
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/miniproyectoescriturarapida/view/summary-view.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) submitButton.getScene().getWindow(); // Ventana actual
            stage.setScene(new Scene(root, 800, 600)); // Cambiar a la escena de resumen
        } catch (IOException e) {
            throw new RuntimeException(e); // Error al cargar la vista
        }
    }
}
