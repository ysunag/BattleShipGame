package edu.neu.ccs.cs5004.assignment5.model.ship;


import edu.neu.ccs.cs5004.assignment5.model.cell.EnemyShipCell;
import edu.neu.ccs.cs5004.assignment5.model.cell.ShipObserver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ShipUpdateTest {
  private Ship testCruiser;
  private ShipObserver testEnemyShipCell;
  private ShipUpdate testShipUpdate;
  private ShipUpdate expectedShipUpdate;
  private ShipUpdate sameStateShipUpdate;
  private ShipUpdate diffShipUpdate;
  private Ship testCruiser2;
  private ShipUpdate newone;

  @Before
  public void setUp() throws Exception {
    testCruiser = new Cruiser(0);

    testEnemyShipCell = new EnemyShipCell(false, false, false);
    testShipUpdate = new ShipUpdate(testCruiser);
    expectedShipUpdate = new ShipUpdate(testCruiser);
    expectedShipUpdate.registerObserver(testEnemyShipCell);
    sameStateShipUpdate = new ShipUpdate(testCruiser);
    diffShipUpdate = new ShipUpdate(new BattleShip(0));
    testCruiser2 = new Cruiser(0);
    newone = new ShipUpdate(testCruiser2);

  }

  @Test
  public void getShip() {
    Assert.assertEquals(testCruiser, testShipUpdate.getShip());
  }

  @Test
  public void registerObserver() {
    testShipUpdate.registerObserver(testEnemyShipCell);
    Assert.assertEquals(expectedShipUpdate, testShipUpdate);
  }

  @Test
  public void notifyObservers() {
    Ship sunkShip = new Cruiser(3);
    ShipUpdate sunkShipupdate = new ShipUpdate(sunkShip);
    sunkShipupdate.registerObserver(new EnemyShipCell(true, false, false));
    EnemyShipCell sunkCell = new EnemyShipCell(true, true, true);
    ShipUpdate resultShipUpdate = new ShipUpdate(sunkShip);
    resultShipUpdate.registerObserver(sunkCell);
    sunkShipupdate.notifyObservers();
    Assert.assertEquals(resultShipUpdate, sunkShipupdate);
  }

  @Test
  public void removeObserver() {
    expectedShipUpdate.removeObserver(testEnemyShipCell);
    Assert.assertEquals(testShipUpdate, expectedShipUpdate);
  }

  @Test
  public void equals() {
    ShipUpdate sameRefShipUpdate = testShipUpdate;
    ShipUpdate anotherShipupdate = new ShipUpdate(testCruiser);

    ShipUpdate nullShipupdate = null;
    Assert.assertTrue(testShipUpdate.equals(sameRefShipUpdate));
    Assert.assertTrue(testShipUpdate.equals(sameStateShipUpdate));
    Assert.assertEquals(testShipUpdate.equals(sameStateShipUpdate), sameStateShipUpdate.equals(testShipUpdate));
    Assert.assertEquals(testShipUpdate.equals(sameStateShipUpdate)
            && sameStateShipUpdate.equals(anotherShipupdate), testShipUpdate.equals(anotherShipupdate));
    Assert.assertFalse(testShipUpdate.equals(new Integer(0)));
    Assert.assertFalse(testShipUpdate.equals(nullShipupdate));
    Assert.assertFalse(testShipUpdate.equals(diffShipUpdate));
    Assert.assertFalse(testShipUpdate.equals(expectedShipUpdate));
    Assert.assertEquals(newone, testShipUpdate);


  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(!testShipUpdate.equals(diffShipUpdate),
            testShipUpdate.hashCode() != diffShipUpdate.hashCode());
    Assert.assertEquals(testShipUpdate.equals(sameStateShipUpdate),
            testShipUpdate.hashCode() == sameStateShipUpdate.hashCode());
  }
}