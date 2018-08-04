package edu.neu.ccs.cs5004.assignment5.model.game;



import edu.neu.ccs.cs5004.assignment5.model.cell.Cell;
import edu.neu.ccs.cs5004.assignment5.model.cell.GapCell;
import edu.neu.ccs.cs5004.assignment5.model.cell.OpenSeaCell;
import edu.neu.ccs.cs5004.assignment5.model.cell.SpecificShipCell;
import edu.neu.ccs.cs5004.assignment5.model.ship.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;




public class MapTest {

  public static final Map testMap1 = new Map();
  public static final Cell  defaultCell = new OpenSeaCell(false);
  public static final ShipUpdate one = new ShipUpdate(new Submarine(0));
  public static final Cell specificShipCell = new SpecificShipCell(false, false,one);
  private Map testMap2;
  private Cell[][] testCells;
  private Position position1;
  private Position position2;
  private Map sameRefMap;
  private Map sameStateMap;


  @Before
  public void setUp() throws Exception {

    position1 = new Position(3, Column.C);
    position2 = new Position(3, Column.D);

    testCells = new Cell[Map.ROWNUMBER + 1][Map.COLUMNNUMBER];
    for (int i = 1; i < Map.ROWNUMBER + 1; i++) {
      for (int j = 0; j < Map.COLUMNNUMBER; j++) {
        testCells[i][j] = defaultCell;
      }
    }

    testMap2 = new Map();
    testMap2.replaceCell(specificShipCell, position1);

    sameRefMap = testMap1;
    sameStateMap = new Map();
  }


  @Test
  public void getCell() {
   // Assert.assertEquals(defaultCell, testMap1.getCell(position2));
    Assert.assertEquals(specificShipCell, testMap2.getCell(position1));
  }

  @Test
  public void replaceCell() {
    testMap2.replaceCell(specificShipCell, position2);
    Assert.assertEquals(specificShipCell, testMap2.getCell(position2));
  }

  @Test
  public void equals() {
    Map anotherMap = new Map();
    Map nullMap = null;
    Assert.assertTrue(testMap1.equals(testMap1));
    Assert.assertTrue(testMap1.equals(sameRefMap));
    //Assert.assertTrue(testMap1.equals(sameStateMap));
    Assert.assertEquals(testMap1.equals(sameStateMap), sameStateMap.equals(testMap1));
    Assert.assertEquals(testMap1.equals(sameStateMap) && sameStateMap.equals(anotherMap),
            testMap1.equals(anotherMap));
    Assert.assertFalse(testMap1.equals(nullMap));
    Assert.assertFalse(testMap1.equals(testMap2));
    Assert.assertFalse(testMap1.equals(new Integer(4)));

  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(testMap1.equals(sameStateMap),
            testMap1.hashCode() == sameStateMap.hashCode());
    Assert.assertEquals(testMap1.equals(sameRefMap),
            testMap1.hashCode() == sameRefMap.hashCode());
    Assert.assertEquals(!testMap1.equals(testMap2),
            testMap1.hashCode() != testMap2.hashCode());
  }

  @Test
  public void readyToPlaceShip() {
    Ship ship = new BattleShip(0);
   // Assert.assertTrue(testMap1.readyToPlaceShip(ship, new Position(2,Column.A), Direction.horizontal));
    Assert.assertTrue(testMap1.readyToPlaceShip(ship, new Position(2,Column.A), Direction.vertical));
    Assert.assertFalse(testMap1.readyToPlaceShip(ship, new Position(2,Column.J), Direction.horizontal));
    Assert.assertFalse(testMap1.readyToPlaceShip(ship, new Position(9,Column.J), Direction.vertical));
    Assert.assertFalse(testMap2.readyToPlaceShip(ship, position1, Direction.horizontal));
    Assert.assertFalse(testMap2.readyToPlaceShip(ship, new Position(2,Column.C), Direction.vertical));
  }

  @Test
  public void placeOneShip() {
    Ship ship = new Submarine(0);
    Map result1 = new Map();
    result1.replaceCell(specificShipCell, position1);
    result1.replaceCell(specificShipCell, position2);
    result1.replaceCell(new GapCell(false), new Position(3, Column.B));
    result1.replaceCell(new GapCell(false), new Position(3, Column.E));
    result1.replaceCell(new GapCell(false), new Position(2, Column.C));
    result1.replaceCell(new GapCell(false), new Position(2, Column.D));
    result1.replaceCell(new GapCell(false), new Position(4, Column.C));
    result1.replaceCell(new GapCell(false), new Position(4, Column.D));
    testMap1.placeOneShip(ship, position1, Direction.horizontal);
    Assert.assertEquals(result1, testMap1);
    Map testMap3 = new Map();
    Map result2 = new Map();
    result2.replaceCell(specificShipCell, position1);
    result2.replaceCell(specificShipCell, new Position(4, Column.C));
    result2.replaceCell(new GapCell(false), new Position(3, Column.B));
    result2.replaceCell(new GapCell(false), new Position(3, Column.D));
    result2.replaceCell(new GapCell(false), new Position(2, Column.C));
    result2.replaceCell(new GapCell(false), new Position(4, Column.D));
    result2.replaceCell(new GapCell(false), new Position(5, Column.C));
    result2.replaceCell(new GapCell(false), new Position(4, Column.B));
    testMap3.placeOneShip(ship, position1, Direction.vertical);
    Assert.assertEquals(result2, testMap3);
  }


}



