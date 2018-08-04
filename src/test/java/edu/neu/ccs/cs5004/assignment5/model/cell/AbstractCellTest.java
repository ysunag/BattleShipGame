package edu.neu.ccs.cs5004.assignment5.model.cell;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractCellTest {
  private AbstractCell testGapCell;
  private AbstractCell sameRefGapCell;
  private AbstractCell sameStateGapCell;


  @Before
  public void setUp() throws Exception {
    testGapCell = new GapCell(false);
    sameStateGapCell = new GapCell(false);
    sameRefGapCell = testGapCell;
  }

  @Test
  public void getWasHit() {
    Assert.assertEquals(false, testGapCell.getWasHit());
  }


  @Test
  public void equals() {
    AbstractCell diffGapCell = new GapCell(true);
    AbstractCell anotherGapCell = new GapCell(false);
    AbstractCell nullGapCell = null;


    Assert.assertTrue(testGapCell.equals(testGapCell));
    Assert.assertTrue(testGapCell.equals(sameRefGapCell));
    Assert.assertTrue(testGapCell.equals(sameStateGapCell));
    Assert.assertEquals(testGapCell.equals(sameStateGapCell),
            sameStateGapCell.equals(testGapCell));
    Assert.assertEquals(testGapCell.equals(sameStateGapCell) &&
            sameStateGapCell.equals(anotherGapCell), testGapCell.equals(anotherGapCell));
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