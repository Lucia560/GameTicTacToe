package com.example.gametictactoe.gametictactoe;

public class Modell {
    private char[][] board;      // The game board
    private char player1;  // Current player ('X' or 'O')
    private int playerScore;     // Player's score
    private int computerScore;   // Computer's score

    public Modell() {
        // Initialize the game board, player1, playerScore, and computerScore
    }

    public boolean makeMove(int row, int col) {
        // Make a move on the board for the current player
        // Update currentPlayer and check for a winner
        return false; // Return true if the move is valid, false otherwise
    }

    public char getPlayer1layer1() {
        // Get the current player ('X' or 'O')
        return player1;
    }

    public int getPlayerScore() {
        // Get the player's score
        return playerScore;
    }

    public int getComputerScore() {
        // Get the computer's score
        return computerScore;
    }

    public char[][] getBoard() {
        // Get the current state of the game board
        return board;
    }

    public boolean isGameOver() {
        // Check if the game is over (someone won or it's a draw)
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
}
