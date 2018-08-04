package edu.neu.ccs.cs5004.assignment5.model.cell;

import java.util.Objects;


/**
 * Represents ship cell in the Battleship game.
 */

public abstract class AbstractShipCell extends AbstractCell implements ShipCell {
  protected Boolean isSunk;


  /**
   * Creates a new abstract ship cell with given information on whether it was hit,
   * and whether it is sunk.
   *
   * @param wasHit whether the cell was hit
   * @param isSunk whether the cell is sunk
   */
  public AbstractShipCell(Boolean wasHit, Boolean isSunk) {
    super(wasHit);
    this.isSunk = isSunk;
  }


  @Override
  public Boolean canPlaceShip() {
    return false;
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
    AbstractShipCell that = (AbstractShipCell) other;
    return Objects.equals(getIsSunk(), that.getIsSunk());
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), getIsSunk());
  }
}
