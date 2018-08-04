package edu.neu.ccs.cs5004.assignment5.model.cell;

import edu.neu.ccs.cs5004.assignment5.model.ship.Ship;

/**
 * defines interface for loan observer.
 */
public interface ShipObserver {

  /**
   * Updates the ship observer state according to the state of the observable ship.
   *
   * @param observable the ship the observer is observing.
   */
  void update(Ship observable);
}
