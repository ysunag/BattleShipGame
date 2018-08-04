package edu.neu.ccs.cs5004.assignment5.model.cell;

/**
 * Represents the attacked result 'sunk' when the cell is a part of the ship and all the other
 * cells of the ship were hit.
 */
public class Sunk implements Attackable {
  @Override
  public String attackResult() {
    return "Sunk!";
  }

  @Override
  public String toString() {
    return "Sunk{}";
  }

  @Override
  public boolean equals(Object othat) {
    if (this == othat) {
      return true;
    }
    if (othat == null || getClass() != othat.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return 73;
  }
}
