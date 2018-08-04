package edu.neu.ccs.cs5004.assignment5.model.ship;

import edu.neu.ccs.cs5004.assignment5.model.cell.ShipObserver;

/**
 * Defines the interface of observable Ship by ship observers.
 */
public interface ShipUpdateI {
  /**
   * Adds observer to a list of observers.
   *
   * @param observer to register to the observable.
   */
  void registerObserver(ShipObserver observer);

  /**
   * Removes observer from a list of observers.
   *
   * @param observer to remove.
   */
  void removeObserver(ShipObserver observer);

  /**
   * Notifies observer if a model was changed.
   */
  void notifyObservers();

}

