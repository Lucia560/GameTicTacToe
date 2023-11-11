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
            if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
                return true; // diagonal2
            }
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

        return false;
    }

    public boolean isBoardFull() {
        // Check if the game board is full (a draw)
        return false;
    }

    public char checkWinner() {
        // Check if there's a winner ('X', 'O', or ' ')
        return ' '; // Return 'X', 'O', or ' ' based on the game state
    }

    public void switchPlayer() {
    }

    public void resetGame() {
    }

    public void startNewGame() {
    }
}
