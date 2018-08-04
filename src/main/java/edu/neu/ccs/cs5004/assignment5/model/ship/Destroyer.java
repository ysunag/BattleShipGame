package edu.neu.ccs.cs5004.assignment5.model.ship;

/**
 * Represents a destroyer ship in the Battleship game.
 */

public class Destroyer extends AbstractShip {
  public static final Integer DESTROYERSIZE = 1;

  /**
   * Creates a new destroyer which occupies 1 cell and has given number of cells that were hit.
   *
   * @param numberOfHitCells number of cell that were hit which is an Integer number 0 or 1
   */
  public Destroyer(Integer numberOfHitCells) {
    super(DESTROYERSIZE, numberOfHitCells);
  }


  @Override
  public String toString() {
    return "Destroyer{"
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
    result = 19 * result + 19;
    return result;
  }
}
