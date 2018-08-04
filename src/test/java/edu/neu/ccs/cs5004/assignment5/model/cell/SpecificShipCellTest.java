package edu.neu.ccs.cs5004.assignment5.model.cell;

import edu.neu.ccs.cs5004.assignment5.model.ship.ShipUpdate;
import edu.neu.ccs.cs5004.assignment5.view.DebugConsolePrinter;
import edu.neu.ccs.cs5004.assignment5.view.Printer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment5.model.ship.Cruiser;

public class SpecificShipCellTest {
  private SpecificShipCell testSpecificShipCell;
  private SpecificShipCell sameRefSpecificShipCell;
  private SpecificShipCell sameStateSpecificShipCell;
  private SpecificShipCell sunkSpecificShipCell;

  @Before
  public void setUp() throws Exception {
    testSpecificShipCell = new SpecificShipCell(false, false, new ShipUpdate(new Cruiser(0)));
    sameStateSpecificShipCell = new SpecificShipCell(false, false, new ShipUpdate(new Cruiser(0)));
    sameRefSpecificShipCell = testSpecificShipCell;
    sunkSpecificShipCell = new SpecificShipCell(true, true,
            new ShipUpdate(new Cruiser(3)));
  }

  @Test
  public void markSunk() {
    SpecificShipCell expectEnemyCell =
            new SpecificShipCell(true, true, new ShipUpdate(new Cruiser(0)));
    testSpecificShipCell.markSunk();
    Assert.assertEquals(expectEnemyCell, testSpecificShipCell);
  }


  @Test
  public void equals() {
    SpecificShipCell diffSpecificShipCell =
            new SpecificShipCell(true, true, new ShipUpdate(new Cruiser(0)));
    SpecificShipCell anotherSpecificShipCell =
            new SpecificShipCell(false, false, new ShipUpdate(new Cruiser(0)));
    SpecificShipCell nullSpecificShipCell = null;


    Assert.assertTrue(testSpecificShipCell.equals(testSpecificShipCell));
    Assert.assertTrue(testSpecificShipCell.equals(sameRefSpecificShipCell));
    Assert.assertTrue(testSpecificShipCell.equals(sameStateSpecificShipCell));
    Assert.assertEquals(testSpecificShipCell.equals(sameStateSpecificShipCell),
            sameStateSpecificShipCell.equals(testSpecificShipCell));
    Assert.assertEquals(testSpecificShipCell.equals(sameStateSpecificShipCell) &&
            sameStateSpecificShipCell.equals(anotherSpecificShipCell), testSpecificShipCell.equals(anotherSpecificShipCell));
    Assert.assertFalse(testSpecificShipCell.equals(diffSpecificShipCell));
    Assert.assertFalse(testSpecificShipCell.equals(nullSpecificShipCell));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(testSpecificShipCell.equals(sameRefSpecificShipCell),
            testSpecificShipCell.hashCode() == sameRefSpecificShipCell.hashCode());
    Assert.assertEquals(testSpecificShipCell.equals(sameStateSpecificShipCell),
            testSpecificShipCell.hashCode() == sameStateSpecificShipCell.hashCode());
  }


  @Test
  public void getIsSunk() {
    Assert.assertEquals(false, testSpecificShipCell.getIsSunk());
  }

  @Test
  public void getShipUpdate() {
    Assert.assertEquals(new ShipUpdate(new Cruiser(0)), testSpecificShipCell.getShipUpdate());
  }

  @Test
  public void attackResult() {
    Assert.assertEquals(new Sunk(), sunkSpecificShipCell.attackResult());
    Assert.assertEquals(new Hit(), testSpecificShipCell.attackResult());
  }

  @Test
  public void attackCell() {
    sunkSpecificShipCell.attackCell();
    Assert.assertEquals(new SpecificShipCell(true, true,
            new ShipUpdate(new Cruiser(3))), sunkSpecificShipCell);
    testSpecificShipCell.attackCell();
    Assert.assertEquals(new SpecificShipCell(true,false, new ShipUpdate(new Cruiser(1))),
            testSpecificShipCell);
  }

  @Test
  public void prettyPrint() {
    Printer printer = new DebugConsolePrinter();
    testSpecificShipCell.prettyPrint(printer);
  }
}