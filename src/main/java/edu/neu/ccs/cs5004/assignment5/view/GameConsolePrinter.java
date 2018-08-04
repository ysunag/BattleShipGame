package edu.neu.ccs.cs5004.assignment5.view;

import edu.neu.ccs.cs5004.assignment5.model.game.GameI;

/**
 * Represents the printer used for display in the game mode.
 */

public class GameConsolePrinter extends ConsolePrinter {
  @Override
  public void display(GameI game) {
    humanFleet();
    show(game.getHumanPlayer().getFleetMap());
    humanBattleFleet();
    show(game.getHumanPlayer().getBattleMap());
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return 97;
  }
}
