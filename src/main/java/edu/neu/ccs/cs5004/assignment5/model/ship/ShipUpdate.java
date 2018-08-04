package edu.neu.ccs.cs5004.assignment5.model.ship;

import edu.neu.ccs.cs5004.assignment5.model.cell.ShipObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a observable ship.
 */
public class ShipUpdate implements ShipUpdateI {
  private Ship ship;
  private List<ShipObserver> observers;

  /**
   * Constructs the observable Ship with provided Ship and an empty list of observers.
   *
   * @param ship the ship to be observed
   */
  public ShipUpdate(Ship ship) {
    this.ship = ship;
    observers = new ArrayList<>();
  }

  /**
   * Getter for property 'ship'.
   *
   * @return ship value
   */
  public Ship getShip() {
    return ship;
  }


  @Override
  public void registerObserver(ShipObserver observer) {
    observers.add(observer);
    observer.update(ship);
  }


  @Override
  public void notifyObservers() {
    for (ShipObserver obs : observers) {
      obs.update(ship);
    }
  }

  @Override
  public void removeObserver(ShipObserver observer) {
    observers.remove(observer);
  }


  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    ShipUpdate that = (ShipUpdate) other;
    return ship.equals(that.ship)
            && Objects.equals(observers, that.observers);

  }

  @Override
  public int hashCode() {

    return Objects.hash(ship, observers);
  }
}
