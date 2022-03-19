/* (C)2022 */
package com.andreas;

import java.util.Scanner;

public class Game {
  private final Board board;
  private int currentPlayer;

  public Game() {
    this.board = new Board();
  }

  public void start() {
    while (true) {
      board.print();
      Position newPos = getPlayerInput();
      boolean isWin = board.placeMarker(currentPlayer, newPos);

      if (isWin) {
        board.print();
        System.out.printf("Player %s wins!", currentPlayer);
        System.exit(0);
      }

      updateCurrentPlayer();
    }
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
