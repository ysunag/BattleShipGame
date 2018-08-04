package edu.neu.ccs.cs5004.assignment5.model.game;

/**
 * Represents the debug mode of the battle ship game.
 */
public class DebugMode extends AbstractGame {

  /**
   * Creates a new debug game.
   */
  public DebugMode() {
    super();
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
