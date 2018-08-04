package edu.neu.ccs.cs5004.assignment5.model.game;

import java.util.Random;

public class RandomStrategy extends AbstractStrategy {
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
  public Position generateAttackPosn(MapI map) {
    boolean valid = false;
    Position posn = null;
    while (!valid) {
      Random random = new Random();
      Integer row = 1 + random.nextInt(Map.ROWNUMBER);
      Column col = Column.find(random.nextInt(Map.COLUMNNUMBER));
      posn = new Position(row, col);
      if (!map.getCell(posn).getWasHit()) {
        valid = true;
      }
    }
    return posn;
  }
}