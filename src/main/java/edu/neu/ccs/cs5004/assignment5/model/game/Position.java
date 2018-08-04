package edu.neu.ccs.cs5004.assignment5.model.game;


import java.util.Objects;

/**
 * Represents the position on thr map.
 */

public class Position {
  private Integer row;
  private Column column;

  public Position(String row, String col) {
    this.row = Integer.parseInt(row);
    this.column = Column.valueOf(col);
  }

  /**
   * Getter for the property 'row'.
   *
   * @return Value for the property 'row'
   */
  public Integer getRow() {
    return row;
  }

  /**
   * Getter for the property 'column'.
   *
   * @return Value for the property 'column'
   */
  public Column getColumn() {
    return column;
  }

  /**
   * Creates a new position with given row and column.
   *
   * @param row    the row of the position
   * @param column the column of the position
   */
  public Position(Integer row, Column column) {
    this.row = row;
    this.column = column;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    Position position = (Position) other;
    return Objects.equals(getRow(), position.getRow())
            && getColumn() == position.getColumn();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getRow(), getColumn());
  }

  @Override
  public String toString() {
    return "Position{"
            + "row=" + row
            + ", column=" + column
            + '}';
  }
}
