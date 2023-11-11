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
                makeComputerMove();
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
        for (Button[] rowButtons : buttons) {
            for (Button button : rowButtons) {
                button.setText("");
            }
        }
        if (modell.getPlayer1() == 'O') {
            makeComputerMove();
        }
    }

    public void deleteGame(ActionEvent actionEvent) {
        for (Button[] rowButtons : buttons) {
            for (Button button : rowButtons) {
                button.setText("");
            }
        }
    }

    private void makeComputerMove() {
        if (!modell.isGameOver()) {
            boolean computerMoved = false;
            while (!computerMoved) {
                int row = (int) (Math.random() * 3);
                int col = (int) (Math.random() * 3);
                if (modell.makeMove(row, col)) {
                    buttons[row][col].setText(Character.toString(modell.getPlayer1()));
                    buttons[row][col].setFont(Font.font("System", FontWeight.BOLD, 24));
                    computerMoved = true;
                    if (modell.checkForWinner(row, col)) {
                        updateScoreLabels();
                    }
                    modell.switchPlayer();
                }
            }
        }
    }

    public void notifyComputerMove(int row, int col) {

    }
}

