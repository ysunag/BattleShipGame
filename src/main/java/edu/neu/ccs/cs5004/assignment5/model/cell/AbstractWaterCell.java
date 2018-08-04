package edu.neu.ccs.cs5004.assignment5.model.cell;


import edu.neu.ccs.cs5004.assignment5.model.ship.ShipUpdate;
import edu.neu.ccs.cs5004.assignment5.view.Printer;

/**
 * Represents water cell in the Battleship game.
 */

public abstract class AbstractWaterCell extends AbstractCell implements WaterCell {
  /**
   * Creates a new abstract water cell with the given information on whether it was hit.
   *
   * @param wasHit whether the cell was hit
   */
  public AbstractWaterCell(Boolean wasHit) {
    super(wasHit);
  }

  @Override
  public Attackable attackResult() {
    return new Miss();
  }

  @Override
  public void attackCell() {
    this.wasHit = true;
  }


  @Override
  public void prettyPrint(Printer printer) {
    printer.show(this);
  }

  @Override
  public ShipUpdate getShipUpdate() {
    return null;
  }
}
