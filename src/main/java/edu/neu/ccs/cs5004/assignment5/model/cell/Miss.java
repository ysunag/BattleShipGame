package edu.neu.ccs.cs5004.assignment5.model.cell;

/**
 * Represents the attacked result 'miss' when the guessed cell does not contain a ship.
 */
public class Miss implements Attackable {
  @Override
  public String attackResult() {
    return "Miss!";
  }

  @Override
  public String toString() {
    return "Miss{}";
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return 47;
  }
}
