package com.example.gametictactoe.gametictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModellTest {
   private Modell modell;

 @BeforeEach
  public void setUp() {
  modell = new Modell();
 }

 @Test
 @DisplayName("Click on an empty button should return true")
 public void testMakeValidMove() {
  assertTrue(modell.makeMove(0, 0), "true for empty cell");
 }

 @Test
 @DisplayName("Click on a occupied button should return false")
 public void testMakeInvalidMove() {
  modell.makeMove(0, 0); // Player1 move
  assertFalse(modell.makeMove(0, 0), "false for full cell");

 }
 @Test
 @DisplayName("Game should end after finding winner.")
 public void testGameEndsWithWinner() {

  modell.makeMove(0, 0); // X
  modell.makeMove(1, 0); // O
  modell.makeMove(0, 1); // X
  modell.makeMove(1, 1); // O
  modell.makeMove(0, 2); // X

  assertTrue(modell.checkForWinner(0, 2), "Player1 wins.");
  assertTrue(modell.isGameOver(), "game ended.");
 }

 @Test
 @DisplayName("Game should end when is a draw.")
 public void testGameEndsWithDraw() {

  modell.makeMove(0, 0); // X
  modell.getBoard()[0][1] = 'O'; // O
  modell.makeMove(0, 2); // X
  modell.getBoard()[1][0] = 'O'; // O
  modell.makeMove(1, 1); // X
  modell.getBoard()[1][2] = 'O'; // O
  modell.makeMove(2, 0); // X
  modell.getBoard()[2][1] = 'X'; // player move
  modell.getBoard()[2][2] = 'O'; // computer

  assertFalse(modell.checkForWinner(2, 2), "draw");
  assertTrue(modell.isBoardFull(), "full board");
  assertTrue(modell.isGameOver(), "game ended");
 }




}