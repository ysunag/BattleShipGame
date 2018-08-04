package edu.neu.ccs.cs5004.assignment5.model.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GapCellTest {
  private GapCell testGapCell;
  private GapCell sameRefGapCell;
  private GapCell sameStateGapCell;

  @Before
  public void setUp() throws Exception {
    testGapCell = new GapCell(false);
    sameStateGapCell = new GapCell(false);
    sameRefGapCell = testGapCell;
  }

  @Test
  public void canPlaceShip() {
    Assert.assertEquals(false, testGapCell.canPlaceShip());
  }




  @Test
  public void testToString() {
    Assert.assertEquals("GapCell{wasHit=false}", testGapCell.toString());
  }

  @Test
  public void equals() {
    GapCell diffGapCell = new GapCell(true);
    GapCell anotherGapCell = new GapCell(false);
    GapCell nullGapCell = null;


    Assert.assertTrue(testGapCell.equals(testGapCell));
    Assert.assertTrue(testGapCell.equals(sameRefGapCell));
    Assert.assertTrue(testGapCell.equals(sameStateGapCell));
    Assert.assertEquals(testGapCell.equals(sameStateGapCell),
            sameStateGapCell.equals(testGapCell));
    Assert.assertEquals(testGapCell.equals(sameStateGapCell) &&
            sameStateGapCell.equals(anotherGapCell),testGapCell.equals(anotherGapCell));
    Assert.assertFalse(testGapCell.equals(diffGapCell));
    Assert.assertFalse(testGapCell.equals(nullGapCell));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(testGapCell.equals(sameRefGapCell),
            testGapCell.hashCode() == sameRefGapCell.hashCode());
    Assert.assertEquals(testGapCell.equals(sameStateGapCell),
            testGapCell.hashCode() == sameStateGapCell.hashCode());
  }
}