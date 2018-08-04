package edu.neu.ccs.cs5004.assignment5;

import edu.neu.ccs.cs5004.assignment5.controller.Controller;

/**
 * Represents the running process of the battle ship game.
 */
public class Runner {
  /**
   * start game.
   * @param args get the user's input.
   */
  public static void main(String[] args) {
    Controller controller = Controller.generateGameController();
    controller.placeShip();
    controller.playGame();
  }
}


