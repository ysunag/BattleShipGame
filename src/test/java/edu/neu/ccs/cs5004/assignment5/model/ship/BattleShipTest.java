package edu.neu.ccs.cs5004.assignment5.model.ship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BattleShipTest {
  private BattleShip testBattleShip;
  private BattleShip sameRefBattleShip;
  private BattleShip sameStateBattleShip;


  @Before
  public void setUp() throws Exception {
    testBattleShip = new BattleShip(2);
    sameStateBattleShip = new BattleShip(2);
    sameRefBattleShip = testBattleShip;
  }


  @Test
  public void testToString() {
    Assert.assertEquals("BattleShip{size=4, numberOfHitCells=2}",
            testBattleShip.toString());
  }

  @Test
  public void equals() {
    BattleShip diffBattleShip = new BattleShip(1);
    BattleShip anotherBattleShip = new BattleShip(2);
    BattleShip nullBattleShip = null;


    Assert.assertTrue(testBattleShip.equals(testBattleShip));
    Assert.assertTrue(testBattleShip.equals(sameRefBattleShip));
    Assert.assertTrue(testBattleShip.equals(sameStateBattleShip));
    Assert.assertEquals(testBattleShip.equals(sameStateBattleShip),
            sameStateBattleShip.equals(testBattleShip));
    Assert.assertEquals(testBattleShip.equals(sameStateBattleShip) &&
            sameStateBattleShip.equals(anotherBattleShip), testBattleShip.equals(anotherBattleShip));
    Assert.assertFalse(testBattleShip.equals(diffBattleShip));
    Assert.assertFalse(testBattleShip.equals(nullBattleShip));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(testBattleShip.equals(sameRefBattleShip),
            testBattleShip.hashCode() == sameRefBattleShip.hashCode());
    Assert.assertEquals(testBattleShip.equals(sameStateBattleShip),
            testBattleShip.hashCode() == sameStateBattleShip.hashCode());
  }
}