package edu.neu.ccs.cs5004.assignment5.model.cell;


import edu.neu.ccs.cs5004.assignment5.model.ship.ShipUpdate;
import edu.neu.ccs.cs5004.assignment5.view.Printer;

import java.util.Objects;

/**
 * Represents a specific ship cell which has a ship that occupies this cell in the Battleship game.
 */

public class SpecificShipCell extends AbstractShipCell {

  private ShipUpdate ship;

  /**
   * Creates a new specific ship cell with given information on whether it was hit,
   * and whether it is sunk.
   *
   * @param wasHit whether the cell was hit
   * @param isSunk whether it is sunk
   */
  public SpecificShipCell(Boolean wasHit, Boolean isSunk, ShipUpdate ship) {
    super(wasHit, isSunk);
    this.ship = ship;
  }

  @Override
  public Boolean getIsSunk() {
    return ship.getShip().isSunk();
  }

  @Override
  public ShipUpdate getShipUpdate() {
    return ship;
  }

  @Override
  public Attackable attackResult() {
    if (wasHit && isSunk) {
      return new Sunk();
    } else {
      return new Hit();
    }
  }

  @Override
  public void markSunk() {
    this.wasHit = true;
    this.isSunk = true;
  }

  @Override
  public void attackCell() {
    if (!this.wasHit) {
      this.ship.getShip().increaseNumberOfHitCells();
    }
    this.isSunk = ship.getShip().isSunk();
    this.wasHit = true;
  }

  @Override
  public void prettyPrint(Printer printer) {
    printer.show(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    if (!super.equals(obj)) {
      return false;
    }
    SpecificShipCell that = (SpecificShipCell) obj;
    return Objects.equals(ship, that.ship);

  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), ship);
  }
}
