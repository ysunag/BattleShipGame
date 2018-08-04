package edu.neu.ccs.cs5004.assignment5.model.cell;

import edu.neu.ccs.cs5004.assignment5.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.model.ship.ShipUpdate;
import edu.neu.ccs.cs5004.assignment5.view.Printer;

import java.util.Objects;


/**
 * Represent an enemy ship cell which has NO explicit ship in the Battleship game.
 */

public class EnemyShipCell extends AbstractShipCell implements ShipObserver {
  private Boolean belongToSunkShip;

  /**
   * Creates a new enemy ship cell with given information on whether it was hit, the result if it
   * is attacked, whether it belongs to a sunk ship and whether it is sunk.
   *
   * @param wasHit           whether the cell was hit
   * @param belongToSunkShip whether it belongs to a sunk ship
   * @param isSunk           whether it is sunk
   */
  public EnemyShipCell(Boolean wasHit, Boolean belongToSunkShip,
                       Boolean isSunk) {
    super(wasHit, isSunk);
    this.belongToSunkShip = belongToSunkShip;
  }

  @Override
  public ShipUpdate getShipUpdate() {
    return null;
  }

  @Override
  public Boolean getIsSunk() {
    return belongToSunkShip;
  }

  /**
   * Getter for property 'belongToSunkShip'.
   *
   * @return Value for property 'belongToSunkShip'
   */
  public Boolean getBelongToSunkShip() {
    return belongToSunkShip;
  }

  @Override
  public Attackable attackResult() {
    if (belongToSunkShip) {
      return new Sunk();
    } else {
      return new Hit();
    }
  }

  @Override
  public void attackCell() {
    this.wasHit = true;
  }

  @Override
  public void markSunk() {
    this.belongToSunkShip = true;
    this.isSunk = true;
    this.wasHit = true;
  }


  @Override
  public void prettyPrint(Printer printer) {
    printer.show(this);
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
    EnemyShipCell that = (EnemyShipCell) other;
    return Objects.equals(getBelongToSunkShip(), that.getBelongToSunkShip());
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), getBelongToSunkShip());
  }

  @Override
  public String toString() {
    return "EnemyShipCell{"
            + "belongToSunkShip=" + belongToSunkShip
            + ", isSunk=" + isSunk
            + ", wasHit=" + wasHit
            + '}';
  }

  @Override
  public void update(Ship observable) {
    if (observable.isSunk()) {
      this.belongToSunkShip = true;
      this.wasHit = true;
      this.isSunk = true;
    }
  }
}
