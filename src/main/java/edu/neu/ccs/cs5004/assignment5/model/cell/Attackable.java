package edu.neu.ccs.cs5004.assignment5.model.cell;

/**
 * Represents the result when a cell being attacked.
 */

public interface Attackable {
  /**
   * Returns a statement of the attack result on this cell.
   *
   * @return String "Missed!" if the guessed cell does not contain a ship; "Hit!" if the cell is a
   *       part of the ship, but there are other cells that have not been hit yet; "Sunk!" if the
   *       cell isa part of the ship and all the other cells of the ship were hit
   */
  String attackResult();
}
