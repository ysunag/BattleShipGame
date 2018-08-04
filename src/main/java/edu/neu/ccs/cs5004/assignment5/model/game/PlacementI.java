package edu.neu.ccs.cs5004.assignment5.model.game;

import edu.neu.ccs.cs5004.assignment5.model.ship.Ship;

/**
 * Represents the methods for placing fleet on the map.
 */

public interface PlacementI {

  /**
   * Randomly places the fleets of a player on the fleet map.
   *
   * @param player     the player whose fleet to be placed
   * @param shipNumber the number of cells for each kind of ship in the fleet to be placed
   */
  void randomFleetPlace(PlayerI player, Integer[] shipNumber);


  /**
   * Places a given ship on the human player's fleetMap
   * at the given row, given column and given direction.
   *
   * @param map  the map on which to place the ship
   * @param ship the ship to place
   * @param posn the posiotion at which to place the ship
   * @param dir  the direction at which to place the ship
   * @return true if the ship can be placed on the map, false
   *        is the given row, column and direction can not
   *        accommodate the given ship
   */
  boolean userPlaceShip(MapI map, Ship ship, Position posn, String dir);
}
