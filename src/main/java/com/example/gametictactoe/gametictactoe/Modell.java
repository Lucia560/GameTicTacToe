package com.example.gametictactoe.gametictactoe;


public class Modell {
    private  char[][] board;
    private char player1;
    private char computerPlayer;
    private int playerScore;
    private int computerScore;

    private HelloController controller;

    public Modell() {
        board = new char[3][3];
        player1 = 'X';
        computerPlayer = 'O';
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
        board[row][col] = 'X'; //  player always plays 'X'

        if (checkForWinner(row, col)) {
            playerScore++;
            return true;
        }
        return true;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public void setComputerScore(int newScore) {
        this.computerScore = newScore;
    }

    public char[][] getBoard() {
        return board;
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


   public boolean checkForWinner(int row, int col) {
       char currentPlayer = board[row][col];

       boolean rowWin = true, colWin = true, diag1Win = true, diag2Win = true;
       for (int i = 0; i < 3; i++) {
           if (board[row][i] != currentPlayer) rowWin = false;
           if (board[i][col] != currentPlayer) colWin = false;
           if (board[i][i] != currentPlayer) diag1Win = false;
           if (board[i][2-i] != currentPlayer) diag2Win = false;
       }

       return rowWin || colWin || (row == col && diag1Win) || (row + col == 2 && diag2Win);
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
        player1 = 'X'; // Reset the starting player
    }

    public void resetScores() {
        playerScore = 0;
        computerScore = 0;
    }


}



