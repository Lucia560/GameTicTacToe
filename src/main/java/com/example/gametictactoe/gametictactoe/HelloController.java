package com.example.gametictactoe.gametictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HelloController {

    @FXML
    private Label playerLabel;

    @FXML
    private Label scoreLabel;

    @FXML
    private Button[][] buttons;

    private Modell modell;

    public void initialize() {
        modell = new Modell();
        updateScoreLabels();
    }
    public void cellClicked(ActionEvent actionEvent) {
        Button clickedButton = (Button) actionEvent.getSource();
        int row = GridPane.getRowIndex(clickedButton);
        int col = GridPane.getColumnIndex(clickedButton);

        if (modell.makeMove(row, col)) {
            clickedButton.setText(Character.toString(modell.getPlayer1()));

            Font font = Font.font("System", FontWeight.BOLD, 24);
            clickedButton.setFont(font);

            if (modell.checkForWinner(row, col)) {
                if (modell.getPlayer1() == 'X') {
                    int playerScore = modell.getPlayerScore();
                    scoreLabel.setText("Score: " + playerScore + " - " + modell.getComputerScore());
                } else {
                    int computerScore = modell.getComputerScore();
                    scoreLabel.setText("Score: " + modell.getPlayerScore() + " - " + computerScore);
                }
            } else {
                modell.switchPlayer();
            }
        }
    }


    private void updateScoreLabels() {
        playerLabel.setText("Player vs Computer");
        scoreLabel.setText("Score: " + modell.getPlayerScore() + " - " + modell.getComputerScore());
    }

    public void restartGame(ActionEvent actionEvent) {
        modell.resetGame();
        updateScoreLabels();
    }

    public void newGame(ActionEvent actionEvent) {
        modell.startNewGame();
        updateScoreLabels();
    }

    public void deleteGame(ActionEvent actionEvent) {
        for (Button[] rowButtons : buttons) {
            for (Button button : rowButtons) {
                button.setText("");
            }
        }
    }


}
