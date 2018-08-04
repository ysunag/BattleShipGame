package edu.neu.ccs.cs5004.assignment5.model.game;

/**
 * Represents the columns on the map.
 */
public enum Column {
  A(0), B(1), C(2), D(3), E(4), F(5), G(6), H(7), I(8), J(9);

  private final int col;

  /**
   * Creates the constants with the given value.
   *
   * @param col the given value to be assigned to the constant
   */
  Column(int col) {
    this.col = col;
  }

  /**
   * Getter for the value of the constant.
   *
   * @return the value of the constant
   */
  public int getCol() {
    return this.col;
  }

  /**
   * Get the next column.
   *
   * @return the next column
   */
  public Column next() {
    if (ordinal() == values().length - 1) {
      return null;
    }
    return values()[ordinal() + 1];
  }

  /**
   * Find the column of which the value matches the given value.
   *
   * @param value the value to match
   * @return the column of which the value matches the given value
   */
  public static Column find(int value) {
    Column res = A;
    for (int i = 0; i < value; i++) {
      res = res.next();
    }
    return res;
  }

  @Override
  public String toString() {
    return "Column{"
            + "col=" + col
            + '}';
  }

}
