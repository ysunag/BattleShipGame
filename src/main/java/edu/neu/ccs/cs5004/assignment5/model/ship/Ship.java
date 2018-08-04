package edu.neu.ccs.cs5004.assignment5.model.ship;

/**
 * Represents a ship in the Battleship game.
 */

public interface Ship {
  /**
   * Getter for property 'size'.
   *
   * @return Value for property 'size'
   */
  Integer getSize();

  /**
   * Getter for property 'numberOfHitCells'.
   *
   * @return Value for property 'numberOfHitCells'
   */
  Integer getNumberOfHitCells();

  /**
   * Gets a new ship according to the given ship type.
   *
   * @param shipType the ship type represented by an int.
   * @return a new battleship if given 0, a new cruiser if given 1,
   *       a new submarine if given 2, a destroyer if given 3
   */
  static Ship getShip(int shipType) {
    switch (shipType) {
      case 0:
        return new BattleShip(0);
      case 1:
        return new Cruiser(0);
      case 2:
        return new Submarine(0);
      case 3:
        return new Destroyer(0);
      default:
        return null;
    }
  }


  /**
   * Returns whether this ship has been sunk.
   *
   * @return true if this ship has been sunk, false otherwise
   */
  Boolean isSunk();

  /**
   * Increases the number of hit cells by 1.
   */
  void increaseNumberOfHitCells();
}
