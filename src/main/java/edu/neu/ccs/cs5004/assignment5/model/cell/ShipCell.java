package edu.neu.ccs.cs5004.assignment5.model.cell;


/**
 * Represents a ship cell in the Battleship game.
 */

public interface ShipCell extends Cell {
  /**
   * Getter for property 'isSunk'.
   *
   * @return Value for property 'isSunk'
   */
  Boolean getIsSunk();

  /**
   * Marks the ship cell as sunk.
   */
  void markSunk();

}
