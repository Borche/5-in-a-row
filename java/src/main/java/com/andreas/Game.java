/* (C)2022 */
package com.andreas;

import java.util.Scanner;

public class Game {
  private final Board board;
  private int currentPlayer = -1;

  public Game() {
    this.board = new Board(5);
  }

  public void start() {
    System.out.println("Starting new game...");
    boolean isWin = false;

    while (!isWin) {
      updateCurrentPlayer();
      board.print();
      Position newPos = getPlayerInput();
      isWin = board.placeMarker(currentPlayer, newPos);
    }

    board.print();
    System.out.printf("Player %s wins!\n", currentPlayer);
  }

  private void updateCurrentPlayer() {
    currentPlayer = (currentPlayer + 1) % 2;
  }

  private Position getPlayerInput() {
    Scanner in = new Scanner(System.in);
    System.out.printf("Player %s: ", currentPlayer);
    String input = in.nextLine();
    String[] inputs = input.split(" ");
    return new Position(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
  }
}
