package edu.neu.ccs.cs5004.assignment5.model.cell;


import edu.neu.ccs.cs5004.assignment5.model.ship.ShipUpdate;
import edu.neu.ccs.cs5004.assignment5.view.Printer;

/**
 * Represent a cell in the Battleship game.
 */

public interface Cell {

  /**
   * Getter for property 'wasHit'.
   *
   * @return Value for property 'wasHit'
   */
  Boolean getWasHit();

  /**
   * Returns whether a ship can be placed on the cell.
   *
   * @return true if the cell is an open sea cell, false otherwise
   */
  Boolean canPlaceShip();

  /**
   * Returns result when a cell gets attacked.
   *
   * @return Miss if the guessed cell does not contain a ship. Hit if the cell is a part of the
   *        ship, but there are other cells that have not been hit yet. Sunk if the cell is a part
   *        of the ship and all the other cells of the ship were hit
   */
  Attackable attackResult();

  /**
   * The cell and its ship being hit if a cell is successfully attacked.
   */
  void attackCell();

  /**
   * Prints the cell according to its cell type.
   *
   * @param printer the printer used to print the cell
   */
  void prettyPrint(Printer printer);

  /**
   * Getter for shipUpdate.
   *
   * @return Value for shipUpdate
   */
  ShipUpdate getShipUpdate();

}
