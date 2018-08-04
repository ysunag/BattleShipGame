package edu.neu.ccs.cs5004.assignment5.model.game;

import edu.neu.ccs.cs5004.assignment5.model.cell.Cell;
import edu.neu.ccs.cs5004.assignment5.model.ship.Ship;

/**
 * Represents a battle field in the BattleShip game with the cells.
 */
public interface MapI {

  /**
   * Gets the cell type at the given position.
   *
   * @param position the position to check the cell type
   * @return the cell type at the given position
   */
  Cell getCell(Position position);

  /**
   * Replaces the cell at the given position with the given cell type.
   *
   * @param cell     the cell type to replace with at the given position.
   * @param position the position to replace the cell at.
   */
  void replaceCell(Cell cell, Position position);


  /**
   * To check whether the given ship can be place on the map at the given position and direction.
   *
   * @param ship the ship we want to place.
   * @param pos  the position we want to place the ship.
   * @param dir  direction we want to place the ship.
   * @return if we can place,then true, else false.
   */
  Boolean readyToPlaceShip(Ship ship, Position pos, Direction dir);

  /**
   * Places the given ship at the given position and given direction on the map.
   *
   * @param ship the ship to place
   * @param pos  the position at which to place the ship
   * @param dir  the direction at which to place the ship
   */
  void placeOneShip(Ship ship, Position pos, Direction dir);

}
