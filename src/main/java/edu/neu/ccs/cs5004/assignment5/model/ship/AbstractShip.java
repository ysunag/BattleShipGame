package edu.neu.ccs.cs5004.assignment5.model.ship;


import java.util.Objects;

/**
 * Represents ship in the Battleship game.
 */
public abstract class AbstractShip implements Ship {
  protected Integer size;
  protected Integer numberOfHitCells;


  /**
   * Creates a new ship with given size and number of cells that were hit.
   *
   * @param size             the number of cells which is an Integer number greater than 0 and less
   *                         or equal to 4
   * @param numberOfHitCells number of cells that were hit which is an Integer number greater than
   *                         0 and less or equal to ship size
   */
  public AbstractShip(Integer size, Integer numberOfHitCells) {
    this.size = size;
    this.numberOfHitCells = numberOfHitCells;
  }


  @Override
  public Integer getSize() {
    return size;
  }

  @Override
  public Integer getNumberOfHitCells() {
    return numberOfHitCells;
  }


  @Override
  public Boolean isSunk() {
    return size.equals(numberOfHitCells);
  }


  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    AbstractShip that = (AbstractShip) other;
    return Objects.equals(getSize(), that.getSize())
            && Objects.equals(getNumberOfHitCells(), that.getNumberOfHitCells());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getSize(), getNumberOfHitCells());
  }


  @Override
  public void increaseNumberOfHitCells() {
    this.numberOfHitCells = this.numberOfHitCells + 1;
  }
}
