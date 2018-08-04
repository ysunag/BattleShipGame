package edu.neu.ccs.cs5004.assignment5.model.ship;

/**
 * Represents a battle ship in the Battleship game.
 */
public class BattleShip extends AbstractShip {
  public static final Integer BATTLESHIPSIZE = 4;

  /**
   * Creates a new battle ship which occupies 4 cells and has given number of cells that were hit.
   *
   * @param numberOfHitCells number of cells that were hit which is an Integer number greater than
   *                         0 and less or equal to 4
   */
  public BattleShip(Integer numberOfHitCells) {
    super(BATTLESHIPSIZE, numberOfHitCells);
  }


  @Override
  public String toString() {
    return "BattleShip{"
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
    result = 17 * result + 17;
    return result;
  }
}
