package edu.neu.ccs.cs5004.assignment5.model.ship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CruiserTest {
  private Cruiser testCruiser;
  private Cruiser sameRefCruiser;
  private Cruiser sameStateCruiser;


  @Before
  public void setUp() throws Exception {
    testCruiser = new Cruiser(0);
    sameStateCruiser = new Cruiser(0);
    sameRefCruiser = testCruiser;
  }



  @Test
  public void testToString() {
    Assert.assertEquals("Cruiser{size=3, numberOfHitCells=0}",
            testCruiser.toString());
  }

  @Test
  public void equals() {
    Cruiser diffCruiser = new Cruiser(1);
    Cruiser anotherCruiser = new Cruiser(0);
    Cruiser nullCruiser = null;


    Assert.assertTrue(testCruiser.equals(testCruiser));
    Assert.assertTrue(testCruiser.equals(sameRefCruiser));
    Assert.assertTrue(testCruiser.equals(sameStateCruiser));
    Assert.assertEquals(testCruiser.equals(sameStateCruiser),
            sameStateCruiser.equals(testCruiser));
    Assert.assertEquals(testCruiser.equals(sameStateCruiser) &&
            sameStateCruiser.equals(anotherCruiser), testCruiser.equals(anotherCruiser));
    Assert.assertFalse(testCruiser.equals(diffCruiser));
    Assert.assertFalse(testCruiser.equals(nullCruiser));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(testCruiser.equals(sameRefCruiser),
            testCruiser.hashCode() == sameRefCruiser.hashCode());
    Assert.assertEquals(testCruiser.equals(sameStateCruiser),
            testCruiser.hashCode() == sameStateCruiser.hashCode());
  }
}