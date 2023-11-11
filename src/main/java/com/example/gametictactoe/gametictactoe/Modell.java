package com.example.gametictactoe.gametictactoe;

public class Modell {
    private char[][] board;
    private char player1;
    private int playerScore;
    private int computerScore;

    public Modell() {
        board = new char[3][3];
        player1 = 'X';
        playerScore = 0;
        computerScore = 0;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }

    }
    public boolean makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
            return false;
        }
        board[row][col] = player1;

        if (checkForWinner(row, col)) {
            if (player1 == 'X') {
                playerScore++;
            } else {
                computerScore++;
            }
            return true;
        }


        player1 = (player1 == 'X') ? 'O' : 'X';
        return true;
    }


    public boolean checkForWinner(int row, int col) {
        char currentPlayer = board[row][col];

        if (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer) {
            return true; //row
        }
        if (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer) {
            return true; //column
        }
        if (row == col) {
            if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
                return true; // diagonal
            }
        }

        if (row + col == 2) {
            return board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer; // diagonal2
        }

        return false;
    }

    public char getPlayer1() {
        return player1;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public char[][] getBoard() {
        return board;
    }


    public boolean isGameOver() {
        return checkForWinner(0, 0) || isBoardFull();
        }
    public boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public char checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0]; // Row
            }
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return board[0][i]; // Column
            }
        }

        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0]; // Diagonal
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2]; // Diagonal
        }


        return ' '; // no winner
    }

    public void switchPlayer() {
        if (player1 == 'X') {
            player1 = 'O';
        } else {
            player1 = 'X';
        }
    }


    public void resetGame() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
        playerScore = 0;
        computerScore = 0;
        player1 = 'X';
    }

    public void startNewGame() {
        resetGame();
    }
}
