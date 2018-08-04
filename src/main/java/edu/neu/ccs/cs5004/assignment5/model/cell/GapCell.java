package edu.neu.ccs.cs5004.assignment5.model.cell;

/**
 * Represent a gap cell which is a cell that has at least one adjacent ship cell in the Battleship
 * game.
 */

public class GapCell extends AbstractWaterCell {
  /**
   * Creates a new gap cell with the given information on whether it was hit.
   *
   * @param wasHit whether the cell was hit
   */
  public GapCell(Boolean wasHit) {
    super(wasHit);
  }

  @Override
  public Boolean canPlaceShip() {
    return false;
  }


  @Override
  public String toString() {
    return "GapCell{"
            + "wasHit=" + wasHit
            + '}';
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    if (!super.equals(other)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 29 * result + 29;
    return result;
  }
}
