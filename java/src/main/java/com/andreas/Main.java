/* (C)2022 */
package com.andreas;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    boolean keepPlaying;
    do {
      Game game = new Game();
      game.start();
      printOptions();
      Scanner in = new Scanner(System.in);
      String input = in.nextLine();
      keepPlaying = !"Q".equalsIgnoreCase(input);
    } while (keepPlaying);
  }

  private static void printOptions() {
    System.out.println("Enter Q to exit, or any other key to play again.");
  }
}
