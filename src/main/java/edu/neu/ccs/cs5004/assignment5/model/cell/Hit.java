package edu.neu.ccs.cs5004.assignment5.model.cell;

/**
 * Represents the attacked result 'hit' when the cell is a part of the ship, but there are other
 * cells that have not been hit yet.
 */

public class Hit implements Attackable {

  @Override
  public String attackResult() {
    return "Hit!";
  }

  @Override
  public String toString() {
    return "Hit{}";
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

    return 37;
  }
}
