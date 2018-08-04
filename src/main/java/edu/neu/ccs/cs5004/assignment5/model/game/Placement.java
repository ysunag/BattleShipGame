package edu.neu.ccs.cs5004.assignment5.model.game;

import edu.neu.ccs.cs5004.assignment5.model.ship.Ship;

import java.util.Random;


/**
 * Represents the methods for placing fleet on the map.
 */
public class Placement implements PlacementI {

  @Override
  public void randomFleetPlace(PlayerI player, Integer[] shipNumber) {
    for (int j = 0; j < shipNumber.length; j++) {
      for (int i = 0; i < shipNumber[j]; i++) {
        Ship currentShip = Ship.getShip(j);
        randomPlaceOneShip(player.getFleetMap(), currentShip);
      }
    }
  }

  @Override
  public boolean userPlaceShip(MapI map, Ship ship, Position posn, String dir) {
    Direction newDir = Direction.find(Integer.parseInt(dir));
    if (map.readyToPlaceShip(ship, posn, newDir)) {
      map.placeOneShip(ship, posn, newDir);
      return true;
    } else {
      return false;
    }
  }


  /**
   * Randomly place one ship on a given map.
   *
   * @param map  the map to place the ship on
   * @param ship the ship to be placed on the map
   */
  protected void randomPlaceOneShip(MapI map, Ship ship) {
    Direction randomInputDir;
    Position randomPosition;
    Random random = new Random();
    do {
      randomPosition = randomMapPosition();
      randomInputDir = Direction.find(random.nextInt(2));
    } while (!map.readyToPlaceShip(ship, randomPosition, randomInputDir));
    map.placeOneShip(ship, randomPosition, randomInputDir);
  }


  /**
   * Generate a random position on the map.
   *
   * @return the random position on the map
   */
  protected Position randomMapPosition() {
    Random random = new Random();
    Integer row = 1 + random.nextInt(Map.ROWNUMBER);
    Column col = Column.find(random.nextInt(Map.COLUMNNUMBER));
    return new Position(row, col);
  }

  /**
   * Method hashCode().
   *
   * @return return the hashCode of an object.
   */
  @Override
  public int hashCode() {
    return 33;
  }

  /**
   * The method equals.
   *
   * @param obj another object.
   * @return if two objects are same type, return true, else false.
   */

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    return true;
  }


}
