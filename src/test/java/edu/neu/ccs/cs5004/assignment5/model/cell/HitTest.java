package edu.neu.ccs.cs5004.assignment5.model.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HitTest {

  private Hit testHit;
  private Hit sameRefHit;
  private Hit sameStateHit;
  private Attackable attackHit;
  private Attackable attackSunk;


  @Before
  public void setUp() throws Exception {
    testHit = new Hit();
    sameStateHit = new Hit();
    sameRefHit = testHit;
    attackHit = new Hit();
    attackSunk = new Sunk();
  }

  @Test
  public void attackResult() {
    Assert.assertEquals("Hit!", testHit.attackResult());
  }

  @Test
  public void testToString() {
    Assert.assertEquals("Hit{}", testHit.toString());
  }

  @Test
  public void equals() {
    Hit nullHit = null;
    Hit anotherHit = new Hit();

    Assert.assertTrue(testHit.equals(testHit));
    Assert.assertTrue(testHit.equals(sameRefHit));
    Assert.assertTrue(testHit.equals(sameStateHit));
    Assert.assertEquals(testHit.equals(sameStateHit), sameStateHit.equals(testHit));
    Assert.assertEquals(testHit.equals(sameStateHit) &&
            sameStateHit.equals(anotherHit), testHit.equals(anotherHit));
    Assert.assertTrue(testHit.equals(attackHit));
    Assert.assertFalse(attackHit.equals(attackSunk));
    Assert.assertFalse(testHit.equals(nullHit));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(testHit.equals(sameRefHit),
            testHit.hashCode() == sameRefHit.hashCode());
    Assert.assertEquals(testHit.equals(sameStateHit),
            testHit.hashCode() == sameStateHit.hashCode());
    Assert.assertEquals(testHit.equals(attackHit),
            testHit.hashCode() == attackHit.hashCode());
    Assert.assertEquals(!attackHit.equals(attackSunk),
            attackHit.hashCode() != attackSunk.hashCode());

  }
}