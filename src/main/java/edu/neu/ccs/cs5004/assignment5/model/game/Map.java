package edu.neu.ccs.cs5004.assignment5.model.game;

import edu.neu.ccs.cs5004.assignment5.model.cell.Cell;
import edu.neu.ccs.cs5004.assignment5.model.cell.GapCell;
import edu.neu.ccs.cs5004.assignment5.model.cell.OpenSeaCell;
import edu.neu.ccs.cs5004.assignment5.model.cell.SpecificShipCell;
import edu.neu.ccs.cs5004.assignment5.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.model.ship.ShipUpdate;

import java.util.Arrays;


/**
 * Represents a battle field in the BattleShip game with the cells.
 */

public class Map implements MapI {
  private Cell[][] cells;
  public static final Integer COLUMNNUMBER = 10;
  public static final Integer ROWNUMBER = 10;

  /**
   * Creates a new map and initialize all the cells as open sea cells.
   */
  public Map() {
    cells = new Cell[ROWNUMBER + 1][COLUMNNUMBER];
    for (int i = 1; i < ROWNUMBER + 1; i++) {
      for (int j = 0; j < COLUMNNUMBER; j++) {
        cells[i][j] = new OpenSeaCell(false);
      }
    }
  }


  @Override
  public Cell getCell(Position position) {
    return this.cells[position.getRow()][position.getColumn().getCol()];
  }


  @Override
  public void replaceCell(Cell cell, Position position) {
    this.cells[position.getRow()][position.getColumn().getCol()] = cell;
  }


  @Override
  public Boolean readyToPlaceShip(Ship ship, Position posn, Direction dir) {

    if (dir.equals(Direction.horizontal)) {
      if (posn.getColumn().getCol() + ship.getSize() > COLUMNNUMBER) {
        return false;
      }
      for (int i = 0; i < ship.getSize(); i++) {
        if (!cells[posn.getRow()][posn.getColumn().getCol() + i].canPlaceShip()) {
          return false;
        }
      }
    }

    if (dir.equals(Direction.vertical)) {
      if (posn.getRow() + ship.getSize() >= ROWNUMBER) {
        return false;
      }
      for (int i = 0; i < ship.getSize(); i++) {
        if (!cells[posn.getRow() + i][posn.getColumn().getCol()].canPlaceShip()) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public void placeOneShip(Ship ship, Position posn, Direction dir) {
    ShipUpdate updateShip = new ShipUpdate(ship);
    if (dir.equals(Direction.horizontal)) {
      if (posn.getColumn().getCol() >= 1) {
        cells[posn.getRow()][posn.getColumn().getCol() - 1] = new GapCell(false);
      }
      if (posn.getColumn().getCol() + ship.getSize() <= 8) {
        cells[posn.getRow()][posn.getColumn().getCol() + ship.getSize()] = new GapCell(false);
      }

      for (int i = 0; i < ship.getSize(); i++) {
        cells[posn.getRow()][posn.getColumn().getCol() + i] =
                new SpecificShipCell(false, false, updateShip);
        if (posn.getRow() - 1 >= 1) {
          cells[posn.getRow() - 1][posn.getColumn().getCol() + i] =
                  new GapCell(false);
        }
        if (posn.getRow() + 1 <= ROWNUMBER) {
          cells[posn.getRow() + 1][posn.getColumn().getCol() + i] =
                  new GapCell(false);
        }
      }
    }


    if (dir.equals(Direction.vertical)) {
      if (posn.getRow() >= 2) {
        cells[posn.getRow() - 1][posn.getColumn().getCol()] =
                new GapCell(false);
      }
      if (posn.getRow() + ship.getSize() <= 9) {
        cells[posn.getRow() + ship.getSize()][posn.getColumn().getCol()] =
                new GapCell(false);
      }
      for (int i = 0; i < ship.getSize(); i++) {
        cells[posn.getRow() + i][posn.getColumn().getCol()] =
                new SpecificShipCell(false, false, updateShip);
        if (posn.getColumn().getCol() - 1 >= 0) {
          cells[posn.getRow() + i][posn.getColumn().getCol() - 1] =
                  new GapCell(false);
        }
        if (posn.getColumn().getCol() + 1 <= 9) {
          cells[posn.getRow() + i][posn.getColumn().getCol() + 1] =
                  new GapCell(false);
        }
      }
    }

  }


  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    Map map = (Map) other;
    for (int row = 1; row <= ROWNUMBER; row++) {
      for (int column = 0; column < COLUMNNUMBER; column++) {
        if (!cells[row][column].equals(map.cells[row][column])) {
          return false;
        }
      }
    }
    return true;

  }

  @Override
  public int hashCode() {
    return Arrays.deepHashCode(cells);
  }
}
