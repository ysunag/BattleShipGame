package edu.neu.ccs.cs5004.assignment5.model.cell;

import edu.neu.ccs.cs5004.assignment5.model.ship.BattleShip;
import edu.neu.ccs.cs5004.assignment5.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.view.DebugConsolePrinter;
import edu.neu.ccs.cs5004.assignment5.view.Printer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EnemyShipCellTest {
  private EnemyShipCell testEnemyShipCell;
  private EnemyShipCell sameRefEnemyShipCell;
  private EnemyShipCell sameStateEnemyShipCell;
  private EnemyShipCell sunkEnemyShipCell;


  @Before
  public void setUp() throws Exception {
    testEnemyShipCell = new EnemyShipCell(false, false, false);
    sameStateEnemyShipCell = new EnemyShipCell(false, false, false);
    sameRefEnemyShipCell = testEnemyShipCell;
    sunkEnemyShipCell = new EnemyShipCell(true, true, true);
  }

  @Test
  public void getBelongToSunkShip() {
    Assert.assertEquals(false, testEnemyShipCell.getBelongToSunkShip());
  }

  @Test
  public void markSunk() {
    EnemyShipCell expectEnemyCell =
            new EnemyShipCell(true, true, true);
    testEnemyShipCell.markSunk();
    Assert.assertEquals(expectEnemyCell, testEnemyShipCell);
  }



  @Test
  public void equals() {
    EnemyShipCell diffEnemyShipCell =
            new EnemyShipCell(true, false, false);
    EnemyShipCell anotherEnemyShipCell =
            new EnemyShipCell(false, false, false);
    EnemyShipCell nullEnemyShipCell = null;


    Assert.assertTrue(testEnemyShipCell.equals(testEnemyShipCell));
    Assert.assertTrue(testEnemyShipCell.equals(sameRefEnemyShipCell));
    Assert.assertTrue(testEnemyShipCell.equals(sameStateEnemyShipCell));
    Assert.assertEquals(testEnemyShipCell.equals(sameStateEnemyShipCell),
            sameStateEnemyShipCell.equals(testEnemyShipCell));
    Assert.assertEquals(testEnemyShipCell.equals(sameStateEnemyShipCell) &&
            sameStateEnemyShipCell.equals(anotherEnemyShipCell), testEnemyShipCell.equals(anotherEnemyShipCell));
    Assert.assertFalse(testEnemyShipCell.equals(diffEnemyShipCell));
    Assert.assertFalse(testEnemyShipCell.equals(nullEnemyShipCell));
  }


  @Test
  public void testHashCode() {
    Assert.assertEquals(testEnemyShipCell.equals(sameRefEnemyShipCell),
            testEnemyShipCell.hashCode() == sameRefEnemyShipCell.hashCode());
    Assert.assertEquals(testEnemyShipCell.equals(sameStateEnemyShipCell),
            testEnemyShipCell.hashCode() == sameStateEnemyShipCell.hashCode());
  }

  @Test
  public void testToString() {
    Assert.assertEquals("EnemyShipCell{belongToSunkShip=false, isSunk=false, " +
            "wasHit=false}", testEnemyShipCell.toString());
  }

  @Test
  public void getShipUpdate() {
    Assert.assertEquals(null, testEnemyShipCell.getShipUpdate() );
  }

  @Test
  public void getIsSunk() {
    Assert.assertEquals(false, testEnemyShipCell.getIsSunk());
  }

  @Test
  public void attackResult() {

    Assert.assertEquals(new Sunk(), sunkEnemyShipCell.attackResult());
    Assert.assertEquals(new Hit(), testEnemyShipCell.attackResult());
  }

  @Test
  public void attackCell() {
    testEnemyShipCell.attackCell();
    Assert.assertEquals(new EnemyShipCell(true, false,false), testEnemyShipCell);
  }

  @Test
  public void prettyPrint() {
    Printer printer = new DebugConsolePrinter();
    testEnemyShipCell.prettyPrint(printer);
  }


  @Test
  public void update() {
    Ship ship1 = new BattleShip(4);
    Ship ship2 = new BattleShip(0);
    testEnemyShipCell.update(ship1);
    sameStateEnemyShipCell.update(ship2);
    Assert.assertEquals(sunkEnemyShipCell, testEnemyShipCell);
    Assert.assertEquals(sameStateEnemyShipCell, sameStateEnemyShipCell);
  }
}