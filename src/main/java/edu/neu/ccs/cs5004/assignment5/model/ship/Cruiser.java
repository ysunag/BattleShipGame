package edu.neu.ccs.cs5004.assignment5.model.ship;

/**
 * Represents a cruiser in the Battleship game.
 */

public class Cruiser extends AbstractShip {
  public static final Integer CRUISERSIZE = 3;

  /**
   * Creates a new cruiser which occupies 3 cells and has given number of cells that were hit.
   *
   * @param numberOfHitCells number of cells that were hit which is an Integer number greater than
   *                         0 and less or equal to 3
   */
  public Cruiser(Integer numberOfHitCells) {
    super(CRUISERSIZE, numberOfHitCells);
  }


  @Override
  public String toString() {
    return "Cruiser{"
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
    result = 23 * result + 23;
    return result;
  }
}
