package edu.neu.ccs.cs5004.assignment5.model.ship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SubmarineTest {
  private Submarine testSubmarine;
  private Submarine sameRefSubmarine;
  private Submarine sameStateSubmarine;


  @Before
  public void setUp() throws Exception {
    testSubmarine = new Submarine(0);
    sameStateSubmarine = new Submarine(0);
    sameRefSubmarine = testSubmarine;
  }



  @Test
  public void testToString() {
    Assert.assertEquals("Submarine{size=2, numberOfHitCells=0}",
            testSubmarine.toString());
  }

  @Test
  public void equals() {
    Submarine diffSubmarine = new Submarine(1);
    Submarine anotherSubmarine = new Submarine(0);
    Submarine nullSubmarine = null;


    Assert.assertTrue(testSubmarine.equals(testSubmarine));
    Assert.assertTrue(testSubmarine.equals(sameRefSubmarine));
    Assert.assertTrue(testSubmarine.equals(sameStateSubmarine));
    Assert.assertEquals(testSubmarine.equals(sameStateSubmarine),
            sameStateSubmarine.equals(testSubmarine));
    Assert.assertEquals(testSubmarine.equals(sameStateSubmarine) &&
            sameStateSubmarine.equals(anotherSubmarine), testSubmarine.equals(anotherSubmarine));
    Assert.assertFalse(testSubmarine.equals(diffSubmarine));
    Assert.assertFalse(testSubmarine.equals(nullSubmarine));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(testSubmarine.equals(sameRefSubmarine),
            testSubmarine.hashCode() == sameRefSubmarine.hashCode());
    Assert.assertEquals(testSubmarine.equals(sameStateSubmarine),
            testSubmarine.hashCode() == sameStateSubmarine.hashCode());
  }
}