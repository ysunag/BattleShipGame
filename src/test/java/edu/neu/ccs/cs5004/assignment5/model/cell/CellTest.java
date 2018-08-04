package edu.neu.ccs.cs5004.assignment5.model.cell;

import edu.neu.ccs.cs5004.assignment5.model.ship.ShipUpdate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment5.model.ship.Cruiser;
import edu.neu.ccs.cs5004.assignment5.model.ship.Ship;

public class CellTest {
  private Cell testGapCell;


  @Before
  public void setUp() throws Exception {
    testGapCell = new GapCell(false);
  }

  @Test
  public void getWasHit() {
    Assert.assertEquals(false, testGapCell.getWasHit());
  }

  @Test
  public void canPlaceShip() {
    Cell testOpenSeaCell = new OpenSeaCell(false);
    Assert.assertEquals(false, testGapCell.canPlaceShip());
    Assert.assertEquals(true, testOpenSeaCell.canPlaceShip());
  }

  @Test
  public void attackResult() {
    Cell testEnemyShipCell = new EnemyShipCell(true,true,true);
    Cell testSpecificShipCell = new SpecificShipCell(true, false, new ShipUpdate(new Cruiser(0)));
    Assert.assertEquals(new Sunk(),testEnemyShipCell.attackResult());
    Assert.assertEquals(new Miss(), testGapCell.attackResult());
    Assert.assertEquals(new Hit(), testSpecificShipCell.attackResult());
  }

  @Test
  public void attackCell() {
    Cell expectGapCell = new GapCell(true);
    testGapCell.attackCell();
    Assert.assertEquals(expectGapCell, testGapCell);
  }
}