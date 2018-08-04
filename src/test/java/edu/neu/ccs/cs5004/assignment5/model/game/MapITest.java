package edu.neu.ccs.cs5004.assignment5.model.game;

import edu.neu.ccs.cs5004.assignment5.model.cell.GapCell;
import edu.neu.ccs.cs5004.assignment5.model.ship.BattleShip;
import edu.neu.ccs.cs5004.assignment5.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.model.ship.Submarine;
import edu.neu.ccs.cs5004.assignment5.view.GameConsolePrinter;
import edu.neu.ccs.cs5004.assignment5.view.Printer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapITest {
  private Map testMap2;
  private Position position1;
  private Position position2;

  @Before
  public void setUp() throws Exception {
    position1 = new Position(3, Column.C);
    position2 = new Position(3, Column.D);
    testMap2 = new Map();
    testMap2.replaceCell(MapTest.specificShipCell, position1);
  }

  @Test
  public void getCell() {
    Assert.assertEquals(MapTest.defaultCell, MapTest.testMap1.getCell(position2));
    Assert.assertEquals(MapTest.specificShipCell, testMap2.getCell(position1));
  }

  @Test
  public void replaceCell() {
    testMap2.replaceCell(MapTest.specificShipCell, position2);
    Assert.assertEquals(MapTest.specificShipCell, testMap2.getCell(position2));
  }

  @Test
  public void readyToPlaceShip() {
    Ship ship = new BattleShip(0);
    Assert.assertTrue(MapTest.testMap1.readyToPlaceShip(ship, new Position(2,Column.A), Direction.horizontal));
    Assert.assertTrue(MapTest.testMap1.readyToPlaceShip(ship, new Position(2,Column.A), Direction.vertical));
    Assert.assertFalse(MapTest.testMap1.readyToPlaceShip(ship, new Position(2,Column.J), Direction.horizontal));
    Assert.assertFalse(MapTest.testMap1.readyToPlaceShip(ship, new Position(9,Column.J), Direction.vertical));
    Assert.assertFalse(testMap2.readyToPlaceShip(ship, position1, Direction.horizontal));
    Assert.assertFalse(testMap2.readyToPlaceShip(ship, new Position(2,Column.C), Direction.vertical));
  }

  @Test
  public void placeOneShip() {
  //  Printer printer = new GameConsolePrinter();
    Ship ship = new Submarine(0);
    Map result1 = new Map();
    result1.replaceCell(MapTest.specificShipCell, position1);
    result1.replaceCell(MapTest.specificShipCell, position2);
    result1.replaceCell(new GapCell(false), new Position(3, Column.B));
    result1.replaceCell(new GapCell(false), new Position(3, Column.E));
    result1.replaceCell(new GapCell(false), new Position(2, Column.C));
    result1.replaceCell(new GapCell(false), new Position(2, Column.D));
    result1.replaceCell(new GapCell(false), new Position(4, Column.C));
    result1.replaceCell(new GapCell(false), new Position(4, Column.D));
    MapTest.testMap1.placeOneShip(ship, position1, Direction.horizontal);
    Assert.assertEquals(result1, MapTest.testMap1);
   // printer.show(result1);
  //  printer.show(MapTest.testMap1);
    Map testMap3 = new Map();
    Map result2 = new Map();
    result2.replaceCell(MapTest.specificShipCell, position1);
    result2.replaceCell(MapTest.specificShipCell, new Position(4, Column.C));
    result2.replaceCell(new GapCell(false), new Position(3, Column.B));
    result2.replaceCell(new GapCell(false), new Position(3, Column.D));
    result2.replaceCell(new GapCell(false), new Position(2, Column.C));
    result2.replaceCell(new GapCell(false), new Position(4, Column.D));
    result2.replaceCell(new GapCell(false), new Position(5, Column.C));
    result2.replaceCell(new GapCell(false), new Position(4, Column.B));
    testMap3.placeOneShip(ship, position1, Direction.vertical);
    Assert.assertEquals(result2, testMap3);
  //  printer.show(result2);
  //  printer.show(testMap3);
  }

}