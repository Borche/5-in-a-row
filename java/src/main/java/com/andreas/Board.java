/* (C)2022 */
package com.andreas;

public class Board {

  private static final int NUM_COL = 10;
  private static final int NUM_ROW = 10;

  private static final int EMPTY_MARKER = -1;

  private int[][] board;
  private final int quantityToWin;

  public Board(int quantityToWin) {
    this.quantityToWin = quantityToWin;
    initBoard();
  }

  private void initBoard() {
    board = new int[NUM_ROW][NUM_COL];

    for (int row = 0; row < NUM_ROW; row++) {
      for (int col = 0; col < NUM_COL; col++) {
        board[row][col] = EMPTY_MARKER;
      }
    }
  }

  public void print() {
    System.out.println("== Game board == ");
    for (int row = 0; row < NUM_ROW; row++) {
      for (int col = 0; col < NUM_COL; col++) {
        System.out.print(getMarker(row, col));
      }
      System.out.print("\n");
    }
  }

  private String getMarker(int row, int col) {
    return switch (board[row][col]) {
      case 0 -> "[X]";
      case 1 -> "[O]";
      default -> "[ ]";
    };
  }

  public boolean placeMarker(int markerId, Position pos) {
    board[pos.row()][pos.col()] = markerId;

    return checkWestEast(markerId, pos)
        || checkNorthSouth(markerId, pos)
        || checkNorthWestSouthEast(markerId, pos)
        || checkNorthEastSouthWest(markerId, pos);
  }

  private boolean checkNorthEastSouthWest(int markerId, Position pos) {
    int count = 1;
    for (int row = pos.row() - 1, col = pos.col() + 1; row >= 0 && col < NUM_COL; row--, col++) {
      if (board[row][col] == markerId) count++;
    }
    for (int row = pos.row() - 1, col = pos.col() + 1; row >= 0 && col < NUM_COL; row--, col++) {
      if (board[row][col] == markerId) count++;
    }
    return count >= quantityToWin;
  }

  private boolean checkNorthWestSouthEast(int markerId, Position pos) {
    int count = 1;
    for (int row = pos.row() - 1, col = pos.col() - 1; row >= 0 && col >= 0; row--, col--) {
      if (board[row][col] == markerId) count++;
    }
    for (int row = pos.row() + 1, col = pos.col() + 1;
        row < NUM_ROW && col < NUM_COL;
        row++, col++) {
      if (board[row][col] == markerId) count++;
    }
    return count >= quantityToWin;
  }

  private boolean checkWestEast(int markerId, Position pos) {
    int count = 1;
    for (int col = pos.col() - 1; col >= 0; col--) {
      if (board[pos.row()][col] == markerId) count++;
    }
    for (int col = pos.col() + 1; col < NUM_COL; col++) {
      if (board[pos.row()][col] == markerId) count++;
    }
    return count >= quantityToWin;
  }

  private boolean checkNorthSouth(int markerId, Position pos) {
    int count = 1;
    for (int row = pos.row() + 1; row < NUM_ROW; row++) {
      if (board[row][pos.col()] == markerId) count++;
    }
    for (int row = pos.row() - 1; row >= 0; row--) {
      if (board[row][pos.col()] == markerId) count++;
    }
    return count >= quantityToWin;
  }
}
