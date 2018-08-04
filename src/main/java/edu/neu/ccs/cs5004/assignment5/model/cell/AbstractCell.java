package edu.neu.ccs.cs5004.assignment5.model.cell;

import java.util.Objects;

/**
 * Represents cell in the Battleship game.
 */

public abstract class AbstractCell implements Cell {
  protected Boolean wasHit;


  /**
   * Creates a new abstract cell with given information on whether it was hit and the result if it
   * is attacked.
   *
   * @param wasHit whether the cell was hit
   */
  public AbstractCell(Boolean wasHit) {
    this.wasHit = wasHit;
  }


  @Override
  public Boolean getWasHit() {
    return wasHit;
  }


  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    AbstractCell that = (AbstractCell) other;
    return Objects.equals(getWasHit(), that.getWasHit());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getWasHit());
  }
}
