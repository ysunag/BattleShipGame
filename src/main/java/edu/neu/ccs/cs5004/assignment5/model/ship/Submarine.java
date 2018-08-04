package edu.neu.ccs.cs5004.assignment5.model.ship;

/**
 * Represents a submarine ship in the Battleship game.
 */

public class Submarine extends AbstractShip {
  public static final Integer SUBMARINESIZE = 2;

  /**
   * Creates a new submarine which occupies 2 cells and has given number of cells that were hit.
   *
   * @param numberOfHitCells number of cells that were hit which is an Integer number greater than
   *                         0 and less or equal to 2
   */
  public Submarine(Integer numberOfHitCells) {
    super(SUBMARINESIZE, numberOfHitCells);
  }


  @Override
  public String toString() {
    return "Submarine{"
            + "size=" + size
            + ", numberOfHitCells=" + numberOfHitCells
            + '}';
  }

  @Override
  public boolean equals(Object othat) {
    if (this == othat) {
      return true;
    }
    if (othat == null || getClass() != othat.getClass()) {
      return false;
    }
    if (!super.equals(othat)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 67 * result + 67;
    return result;
  }
}
