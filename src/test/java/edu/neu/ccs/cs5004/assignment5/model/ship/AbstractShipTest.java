package edu.neu.ccs.cs5004.assignment5.model.ship;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractShipTest {

  private AbstractShip testCruiser;
  private AbstractShip sameRefCruiser;
  private AbstractShip sameStateCruiser;
  private AbstractShip expectShip;
  private AbstractShip testCruiser2;

  @Before
  public void setUp() throws Exception {
    testCruiser = new Cruiser(0);
    sameStateCruiser = new Cruiser(0);
    sameRefCruiser = testCruiser;
    expectShip = new Cruiser(1);
    testCruiser2 = new Cruiser(3);
  }

  @Test
  public void getSize() {
    Assert.assertEquals(new Integer(3), testCruiser.getSize());
  }

  @Test
  public void getNumberOfHitCells() {
    Assert.assertEquals(new Integer(0), testCruiser.getNumberOfHitCells());
  }


  @Test
  public void isSunk() {
    Assert.assertEquals(false, testCruiser.isSunk());
    Assert.assertEquals(true, testCruiser2.isSunk());
  }

  @Test
  public void equals() {
    AbstractShip anotherCruiser = new Cruiser(0);
    AbstractShip nullCruiser = null;

    Assert.assertTrue(testCruiser.equals(testCruiser));
    Assert.assertTrue(testCruiser.equals(sameRefCruiser));
    Assert.assertTrue(testCruiser.equals(sameStateCruiser));
    Assert.assertEquals(testCruiser.equals(sameStateCruiser),
            sameStateCruiser.equals(testCruiser));
    Assert.assertEquals(testCruiser.equals(sameStateCruiser) &&
            sameStateCruiser.equals(anotherCruiser), testCruiser.equals(anotherCruiser));
    Assert.assertFalse(testCruiser.equals(testCruiser2));
    Assert.assertFalse(testCruiser.equals(nullCruiser));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(testCruiser.equals(sameRefCruiser),
            testCruiser.hashCode() == sameRefCruiser.hashCode());
    Assert.assertEquals(testCruiser.equals(sameStateCruiser),
            testCruiser.hashCode() == sameStateCruiser.hashCode());
  }


  @Test
  public void increaseNumberOfHitCells() {
    testCruiser.increaseNumberOfHitCells();
    Assert.assertEquals(expectShip, testCruiser);
  }
}