package com.example.miniproyectoescriturarapida;

import com.example.miniproyectoescriturarapida.model.GameLogic;
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

public class GameController {

    private static final int WORDS_PER_LEVEL = 5;

    @FXML private Label timerLabel;
    @FXML private Label wordLabel;
    @FXML private Label feedbackLabel;
    @FXML private TextField answerField;
    @FXML private Button submitButton;
    @FXML private Label levelLabel;

    private GameLogic gameLogic = new GameLogic();
    private int timeLeft;
    private int correctInLevel;
    private int elapsedSeconds;
    private Timeline timer;

    @FXML
    public void initialize() {
        startRound();
    }

    private void startRound() {
        timeLeft = gameLogic.getTimeForCurrentLevel();
        wordLabel.setText(gameLogic.getCurrentWord());
        levelLabel.setText("Nivel " + getLevel());
        updateTimerLabel();
        feedbackLabel.setText("");
        answerField.setText("");
        answerField.getStyleClass().removeAll("correct", "incorrect");

        if (timer != null) {
            timer.stop();
        }
        timer = new Timeline(new KeyFrame(Duration.seconds(1), e -> tick()));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    private int getLevel() {
        return gameLogic.getCurrentLevel();
    }

    private void tick() {
        timeLeft--;
        elapsedSeconds++;
        updateTimerLabel();
        if (timeLeft <= 0) {
            endGame();
        }
    }

    private void updateTimerLabel() {
        int min = timeLeft / 60;
        int sec = timeLeft % 60;
        timerLabel.setText(String.format("%02d:%02d", min, sec));
    }

    @FXML
    protected void onSubmitButtonClick() throws IOException {
        String answer = answerField.getText().trim();
        answerField.getStyleClass().removeAll("correct", "incorrect");
        feedbackLabel.getStyleClass().removeAll("correct", "incorrect");

        if (gameLogic.esRespuestaCorrecta(answer)) {
            feedbackLabel.setText("¡Correcto!");
            feedbackLabel.getStyleClass().add("correct");
            answerField.getStyleClass().add("correct");
            correctInLevel++;
            gameLogic.avanzarPalabra();
            if (correctInLevel >= WORDS_PER_LEVEL) {
                correctInLevel = 0;
                gameLogic.advanceLevel();
            }
            startRound();
        } else {
            feedbackLabel.setText("Incorrecto, intenta de nuevo");
            feedbackLabel.getStyleClass().add("incorrect");
            answerField.getStyleClass().add("incorrect");
            answerField.setText("");
        }
    }

    private void endGame() {
        timer.stop();
        try {
            SummaryController.lastResult = "¡Tiempo agotado!";
            SummaryController.lastLevels = Math.max(0, getLevel() - 1);
            SummaryController.lastSeconds = elapsedSeconds;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/summary-view.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) submitButton.getScene().getWindow();
            stage.setScene(new Scene(root, 800, 600));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
