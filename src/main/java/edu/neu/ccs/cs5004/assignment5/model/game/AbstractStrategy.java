package edu.neu.ccs.cs5004.assignment5.model.game;


public abstract class AbstractStrategy implements Strategy {
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

  /**
   * Randomly choose a cell which was not hit on a given map.
   *
   * @param map the map on which to choose the cell to attack
   * @return the chosen position to attack
   */


}
