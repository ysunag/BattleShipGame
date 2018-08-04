package edu.neu.ccs.cs5004.assignment5.model.game;

/**
 * Represents a game mode of the battle ship game.
 */
public class GameMode extends AbstractGame {
  private static final Integer BATTLESHIPNUM = 1;
  private static final Integer CRUISERNUM = 2;
  private static final Integer SUBMARINENUM = 3;
  private static final Integer DESTROYERNUM = 4;
  private static final Integer FLEETSIZE = 10;
  private static final Integer[] SHIPNUMBER
          = {BATTLESHIPNUM, CRUISERNUM, SUBMARINENUM, DESTROYERNUM};

  /**
   * Creates a new game mode.
   */
  public GameMode() {
    super();
    shipNumber = SHIPNUMBER;
    fleetSize = FLEETSIZE;
  }

  /**
   * Method equals.
   *
   * @param other another object.
   * @return if two objects have same properties, return true, else false.
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    if (!super.equals(other)) {
      return false;
    }
    return true;
  }

  /**
   * The method hashcode.
   *
   * @return the hashcode of an object.
   */
  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 101 * result + 101;
    return result;
  }
}

