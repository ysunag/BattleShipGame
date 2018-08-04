package edu.neu.ccs.cs5004.assignment5.model.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MissTest {

  private Miss testMiss;
  private Miss sameRefMiss;
  private Miss sameStateMiss;
  private Attackable attackMiss;
  private Attackable attackSunk;


  @Before
  public void setUp() throws Exception {
    testMiss = new Miss();
    sameStateMiss = new Miss();
    sameRefMiss = testMiss;
    attackMiss = new Miss();
    attackSunk = new Sunk();
  }

  @Test
  public void attackResult() {
    Assert.assertEquals("Miss!", testMiss.attackResult());
  }

  @Test
  public void testToString() {
    Assert.assertEquals("Miss{}", testMiss.toString());
  }

  @Test
  public void equals() {
    Miss nullMiss = null;
    Miss anotherMiss = new Miss();

    Assert.assertTrue(testMiss.equals(testMiss));
    Assert.assertTrue(testMiss.equals(sameRefMiss));
    Assert.assertTrue(testMiss.equals(sameStateMiss));
    Assert.assertEquals(testMiss.equals(sameStateMiss), sameStateMiss.equals(testMiss));
    Assert.assertEquals(testMiss.equals(sameStateMiss) &&
            sameStateMiss.equals(anotherMiss), testMiss.equals(anotherMiss));
    Assert.assertTrue(testMiss.equals(attackMiss));
    Assert.assertFalse(attackMiss.equals(attackSunk));
    Assert.assertFalse(testMiss.equals(nullMiss));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(testMiss.equals(sameRefMiss),
            testMiss.hashCode() == sameRefMiss.hashCode());
    Assert.assertEquals(testMiss.equals(sameStateMiss),
            testMiss.hashCode() == sameStateMiss.hashCode());
    Assert.assertEquals(testMiss.equals(attackMiss),
            testMiss.hashCode() == attackMiss.hashCode());
    Assert.assertEquals(!attackMiss.equals(attackSunk),
            attackMiss.hashCode() != attackSunk.hashCode());

  }
}