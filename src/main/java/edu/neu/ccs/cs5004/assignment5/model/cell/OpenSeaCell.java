package edu.neu.ccs.cs5004.assignment5.model.cell;

/**
 * Represent an open sea cell which is a cell that has NO adjacent ship cells in the Battleship
 * game.
 */
public class OpenSeaCell extends AbstractWaterCell {
  /**
   * Creates a new open sea cell with the given information on whether it was hit.
   *
   * @param wasHit whether the cell was hit
   */
  public OpenSeaCell(Boolean wasHit) {
    super(wasHit);
  }

  @Override
  public Boolean canPlaceShip() {
    return true;
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
  public String toString() {
    return "OpenSeaCell{"
            + "wasHit=" + wasHit
            + '}';
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 53 * result + 53;
    return result;


  }
}
