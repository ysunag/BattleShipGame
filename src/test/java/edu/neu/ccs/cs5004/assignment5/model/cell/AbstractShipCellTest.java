package edu.neu.ccs.cs5004.assignment5.model.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractShipCellTest {
  private AbstractShipCell testEnemyShipCell;
  private AbstractShipCell sameRefEnemyShipCell;
  private AbstractShipCell sameStateEnemyShipCell;

  @Before
  public void setUp() throws Exception {
    testEnemyShipCell = new EnemyShipCell(false, false, false);
    sameStateEnemyShipCell = new EnemyShipCell(false, false, false);
    sameRefEnemyShipCell = testEnemyShipCell;
  }


  @Test
  public void canPlaceShip() {
    Assert.assertEquals(false, testEnemyShipCell.canPlaceShip());
  }


  @Test
  public void equals() {
    AbstractShipCell diffEnemyShipCell =
            new EnemyShipCell(true, false, false);
    AbstractShipCell anotherEnemyShipCell =
            new EnemyShipCell(false, false, false);
    AbstractShipCell nullEnemyShipCell = null;


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
}