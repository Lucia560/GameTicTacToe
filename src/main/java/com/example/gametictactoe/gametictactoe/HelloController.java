package com.example.gametictactoe.gametictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HelloController {

    public Button button00;
    public Button button01;
    public Button button02;
    public Button button10;
    public Button button11;
    public Button button12;
    public Button button20;
    public Button button22;
    public Button button21;
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
        buttons = new Button[3][3];
        buttons[0][0] = button00;
        buttons[0][1] = button01;
        buttons[0][2] = button02;
        buttons[1][0] = button10;
        buttons[1][1] = button11;
        buttons[1][2] = button12;
        buttons[2][0] = button20;
        buttons[2][1] = button21;
        buttons[2][2] = button22;

    }

    public void cellClicked(ActionEvent actionEvent) {
        Button clickedButton = (Button) actionEvent.getSource();
        int row = GridPane.getRowIndex(clickedButton);
        int col = GridPane.getColumnIndex(clickedButton);

        if (modell.makeMove(row, col)) {
            clickedButton.setText("X");
            clickedButton.setFont(Font.font("System", FontWeight.BOLD, 24));

            if (modell.checkForWinner(row, col) || modell.isBoardFull()) {
                endGame();
            } else {
                makeComputerMove();
            }
        }
    }

    private void endGame() {
        for (Button[] row : buttons) {
            for (Button btn : row) {
                btn.setDisable(true); // freeze game
            }
        }updateScoreLabels();
    }

    private void updateScoreLabels() {
        playerLabel.setText("Player vs Computer");
        scoreLabel.setText("Score: " + modell.getPlayerScore() + " - " + modell.getComputerScore());
    }

    public void restartGame() {
        modell.resetGame();
        modell.resetScores();
        updateScoreLabels();
        resetBoardOnUI();
    }

    private void resetBoardOnUI() {
        for (Button[] rowButtons : buttons) {
            for (Button button : rowButtons) {
                button.setText("");
                button.setDisable(false); // reactivate game
            }
        }
    }


   public void newGame() {
       modell.resetGame(); // Resets the board only
       resetBoardOnUI(); // Update the UI
   }

    public void deleteGame() {
        for (Button[] rowButtons : buttons) {
            for (Button button : rowButtons) {
                button.setText("");
            }
        }
    }

    private void makeComputerMove() {

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (modell.getBoard()[row][col] == ' ') {
                    modell.getBoard()[row][col] = 'O'; // Computer plays 'O'
                    Button btn = buttons[row][col];
                    btn.setText("O");
                    btn.setFont(Font.font("System", FontWeight.BOLD, 24));

                    if (modell.checkForWinner(row, col)) {
                        modell.setComputerScore(modell.getComputerScore() + 1); // Update computer score
                        updateScoreLabels(); // Update the score label
                        endGame(); // End the game after founding  winner
                        return;
                    }

                    if (modell.isBoardFull()) {
                        updateScoreLabels();
                        endGame();
                        return;
                    }
                    modell.switchPlayer();
                    return; // Exit after making one move
                }
            }
        }
    }

}

