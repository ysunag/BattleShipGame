package edu.neu.ccs.cs5004.assignment5.model.cell;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SunkTest {

  private Sunk testSunk;
  private Sunk sameRefSunk;
  private Sunk sameStateSunk;
  private Attackable attackSunk;
  private Attackable attackMiss;


  @Before
  public void setUp() throws Exception {
    testSunk = new Sunk();
    sameStateSunk = new Sunk();
    sameRefSunk = testSunk;
    attackSunk = new Sunk();
    attackMiss = new Miss();
  }

  @Test
  public void attackResult() {
    Assert.assertEquals("Sunk!", testSunk.attackResult());
  }

  @Test
  public void testToString() {
    Assert.assertEquals("Sunk{}", testSunk.toString());
  }

  @Test
  public void equals() {
    Sunk nullSunk = null;
    Sunk anotherSunk = new Sunk();

    Assert.assertTrue(testSunk.equals(testSunk));
    Assert.assertTrue(testSunk.equals(sameRefSunk));
    Assert.assertTrue(testSunk.equals(sameStateSunk));
    Assert.assertEquals(testSunk.equals(sameStateSunk), sameStateSunk.equals(testSunk));
    Assert.assertEquals(testSunk.equals(sameStateSunk) &&
            sameStateSunk.equals(anotherSunk), testSunk.equals(anotherSunk));
    Assert.assertTrue(testSunk.equals(attackSunk));
    Assert.assertFalse(attackSunk.equals(attackMiss));
    Assert.assertFalse(testSunk.equals(nullSunk));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(testSunk.equals(sameRefSunk),
            testSunk.hashCode() == sameRefSunk.hashCode());
    Assert.assertEquals(testSunk.equals(sameStateSunk),
            testSunk.hashCode() == sameStateSunk.hashCode());
    Assert.assertEquals(testSunk.equals(attackSunk),
            testSunk.hashCode() == attackSunk.hashCode());
    Assert.assertEquals(!attackSunk.equals(attackMiss),
            attackSunk.hashCode() != attackMiss.hashCode());

  }
}