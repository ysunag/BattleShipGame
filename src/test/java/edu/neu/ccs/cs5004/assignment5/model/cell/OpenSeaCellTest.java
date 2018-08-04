package edu.neu.ccs.cs5004.assignment5.model.cell;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OpenSeaCellTest {
  private OpenSeaCell testOpenSeaCell;
  private OpenSeaCell sameRefOpenSeaCell;
  private OpenSeaCell sameStateOpenSeaCell;

  @Before
  public void setUp() throws Exception {
    testOpenSeaCell = new OpenSeaCell(false);
    sameStateOpenSeaCell = new OpenSeaCell(false);
    sameRefOpenSeaCell = testOpenSeaCell;
  }

  @Test
  public void canPlaceShip() {
    Assert.assertEquals(true, testOpenSeaCell.canPlaceShip());
  }



  @Test
  public void testToString() {
    Assert.assertEquals("OpenSeaCell{wasHit=false}", testOpenSeaCell.toString());
  }

  @Test
  public void equals() {
    OpenSeaCell diffOpenSeaCell = new OpenSeaCell(true);
    OpenSeaCell anotherOpenSeaCell = new OpenSeaCell(false);
    OpenSeaCell nullOpenSeaCell = null;


    Assert.assertTrue(testOpenSeaCell.equals(testOpenSeaCell));
    Assert.assertTrue(testOpenSeaCell.equals(sameRefOpenSeaCell));
    Assert.assertTrue(testOpenSeaCell.equals(sameStateOpenSeaCell));
    Assert.assertEquals(testOpenSeaCell.equals(sameStateOpenSeaCell),
            sameStateOpenSeaCell.equals(testOpenSeaCell));
    Assert.assertEquals(testOpenSeaCell.equals(sameStateOpenSeaCell) &&
            sameStateOpenSeaCell.equals(anotherOpenSeaCell), testOpenSeaCell.equals(anotherOpenSeaCell));
    Assert.assertFalse(testOpenSeaCell.equals(diffOpenSeaCell));
    Assert.assertFalse(testOpenSeaCell.equals(nullOpenSeaCell));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(testOpenSeaCell.equals(sameRefOpenSeaCell),
            testOpenSeaCell.hashCode() == sameRefOpenSeaCell.hashCode());
    Assert.assertEquals(testOpenSeaCell.equals(sameStateOpenSeaCell),
            testOpenSeaCell.hashCode() == sameStateOpenSeaCell.hashCode());
  }
}