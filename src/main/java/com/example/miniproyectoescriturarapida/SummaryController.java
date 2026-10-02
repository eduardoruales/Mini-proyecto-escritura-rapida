package com.example.miniproyectoescriturarapida;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class SummaryController {

    public static String lastResult = "Fin de la partida";
    public static int lastLevels = 0;
    public static int lastSeconds = 0;

    @FXML private Label resultLabel;
    @FXML private Label levelsLabel;
    @FXML private Label timeLabel;
    @FXML private Button restartButton;

    @FXML
    public void initialize() {
        resultLabel.setText(lastResult);
        levelsLabel.setText("Niveles completados: " + lastLevels);
        timeLabel.setText("Tiempo total: " + lastSeconds + " s");
    }

    @FXML
    protected void onRestartButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/game-view.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) restartButton.getScene().getWindow();
        stage.setScene(new Scene(root, 800, 600));
    }

    @FXML
    protected void onMenuButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/start-view.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) restartButton.getScene().getWindow();
        stage.setScene(new Scene(root, 800, 600));
    }
}
