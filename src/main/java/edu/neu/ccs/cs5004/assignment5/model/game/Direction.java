package edu.neu.ccs.cs5004.assignment5.model.game;

/**
 * Represents the direction of the ship.
 */
public enum Direction {
  horizontal(0), vertical(1);

  private final int dir;

  Direction(int dir) {
    this.dir = dir;
  }

  /**
   * Find the direction that match the given value dir.
   *
   * @param dir the given value to match
   * @return the direction that match the given value
   */
  public static Direction find(int dir) {
    if (dir == 0) {
      return horizontal;
    } else if (dir == 1) {
      return vertical;
    } else {
      return null;
    }
  }

  @Override
  public String toString() {
    return "Direction{"
            +
            "dir="
            + dir
            +
            '}';
  }


}

