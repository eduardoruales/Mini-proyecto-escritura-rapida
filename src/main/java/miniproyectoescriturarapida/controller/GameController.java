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
 * Controlador de la vista del juego (game-view.fxml).
 * <p>
 * Coordina el modelo {@link GameLogic}, el temporizador ({@link Timeline}),
 * los manejadores de teclado/ratón y los eventos del juego
 * ({@link GameEventListener}).
 * </p>
 */
public class GameController {

    @FXML private Label timerLabel;
    @FXML private Label wordLabel;
    @FXML private Label feedbackLabel;
    @FXML private TextField answerField;
    @FXML private Button submitButton;
    @FXML private Label levelLabel;
    @FXML private Label livesLabel;

    private GameLogic gameLogic = new GameLogic();
    private int timeLeft;
    private Timeline timer;

    /**
     * Escucha de eventos del juego; actualiza la interfaz gráfica.
     */
    private final GameEventListener eventListener = new GameEventAdapter() {
        @Override
        public void onCorrectAnswer(int newLevel) {
            feedbackLabel.setText("¡Correcto! / ¡Nivel superado!");
            feedbackLabel.getStyleClass().add("correct");
        }

        @Override
        public void onIncorrectAnswer() {
            feedbackLabel.setText("Incorrecto. Vidas restantes: " + gameLogic.getLives());
            feedbackLabel.getStyleClass().add("incorrect");
        }

        @Override
        public void onTimeOut() {
            feedbackLabel.setText("¡Tiempo agotado! -1 vida. Vidas restantes: " + gameLogic.getLives());
            feedbackLabel.getStyleClass().add("incorrect");
        }

        @Override
        public void onLevelUp(int level) {
            levelLabel.setText("Nivel " + level);
        }

        @Override
        public void onGameOver(int levelsCompleted, int remainingSeconds) {
            goToSummary("Partida terminada", levelsCompleted, remainingSeconds);
        }
    };

    /**
     * Método de inicialización llamado automáticamente tras cargar el FXML.
     */
    @FXML
    public void initialize() {
        // Manejador de teclado: Enter en el campo de texto valida la respuesta.
        answerField.setOnAction(e -> handleSubmit());
        // Manejadores de ratón: realzan el botón al pasar el cursor.
        submitButton.setOnMouseEntered(e -> submitButton.setOpacity(0.8));
        submitButton.setOnMouseExited(e -> submitButton.setOpacity(1.0));
        startRound();
    }

    /**
     * Inicia (o reinicia) la ronda/nivel actual con su temporizador.
     */
    private void startRound() {
        timeLeft = gameLogic.getTimeForCurrentLevel();
        wordLabel.setText(gameLogic.getCurrentWord());
        levelLabel.setText("Nivel " + gameLogic.getCurrentLevel());
        livesLabel.setText("Vidas: " + gameLogic.getLives());
        updateTimerLabel();
        answerField.getStyleClass().removeAll("correct", "incorrect");
        answerField.setText("");
        if (timer != null) {
            timer.stop();
        }
        timer = new Timeline(new KeyFrame(Duration.seconds(1), e -> tick()));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    /**
     * Método llamado cada segundo por el {@link Timeline}.
     */
    private void tick() {
        timeLeft--;
        updateTimerLabel();
        if (timeLeft <= 0) {
            timer.stop();
            gameLogic.perderVida();
            eventListener.onTimeOut();
            if (gameLogic.isGameOver()) {
                eventListener.onGameOver(gameLogic.getCurrentLevel() - 1, 0);
            } else {
                gameLogic.avanzarPalabra();
                startRound();
            }
        }
    }

    /**
     * Actualiza la etiqueta del temporizador con formato mm:ss.
     */
    private void updateTimerLabel() {
        timerLabel.setText(String.format("%02d:%02d", timeLeft / 60, timeLeft % 60));
    }

    /**
     * Manejador del botón "Validar" (onAction en el FXML).
     */
    @FXML
    protected void onSubmitButtonClick() {
        handleSubmit();
    }

    /**
     * Valida la palabra escrita por el jugador.
     */
    private void handleSubmit() {
        String answer = answerField.getText().trim();
        answerField.getStyleClass().removeAll("correct", "incorrect");
        feedbackLabel.getStyleClass().removeAll("correct", "incorrect");

        if (gameLogic.esRespuestaCorrecta(answer)) {
            gameLogic.advanceLevel();
            gameLogic.avanzarPalabra();
            eventListener.onCorrectAnswer(gameLogic.getCurrentLevel());
            eventListener.onLevelUp(gameLogic.getCurrentLevel());
            startRound();
        } else {
            gameLogic.perderVida();
            answerField.getStyleClass().add("incorrect");
            answerField.setText("");
            eventListener.onIncorrectAnswer();
            if (gameLogic.isGameOver()) {
                timer.stop();
                eventListener.onGameOver(gameLogic.getCurrentLevel() - 1, Math.max(0, timeLeft));
            }
        }
    }

    /**
     * Cambia a la pantalla de resumen final.
     */
    private void goToSummary(String result, int levelsCompleted, int remainingSeconds) {
        try {
            SummaryController.lastResult = result;
            SummaryController.lastLevels = levelsCompleted;
            SummaryController.lastRemaining = remainingSeconds;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/summary-view.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) submitButton.getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
