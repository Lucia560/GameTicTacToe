package com.example.gametictactoe.gametictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void restartGame(ActionEvent actionEvent) {
    }

    public void newGame(ActionEvent actionEvent) {
    }

    public void deleteGame(ActionEvent actionEvent) {
    }

    public void cellClicked(ActionEvent actionEvent) {
    }
}