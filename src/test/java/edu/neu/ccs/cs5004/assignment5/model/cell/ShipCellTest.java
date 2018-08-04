package edu.neu.ccs.cs5004.assignment5.model.cell;

import edu.neu.ccs.cs5004.assignment5.model.ship.ShipUpdate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment5.model.ship.Cruiser;

public class ShipCellTest {

  private ShipCell testSpecificShipCell;

  @Before
  public void setUp() throws Exception {
    testSpecificShipCell = new SpecificShipCell(true, false,new ShipUpdate(new Cruiser(0)));
  }

  @Test
  public void getIsSunk() {
    Assert.assertEquals(false, testSpecificShipCell.getIsSunk());
  }

  @Test
  public void markSunk() {
    ShipCell expectShipCell = new SpecificShipCell(true, true, new ShipUpdate(new Cruiser(0)));
    testSpecificShipCell.markSunk();
    Assert.assertEquals(expectShipCell, testSpecificShipCell);
  }
}