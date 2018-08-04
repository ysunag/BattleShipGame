package edu.neu.ccs.cs5004.assignment5.model.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author linzisheng.
 * @Date 2018/3/1 2:41.
 */
public class DebugModeTest {
  private AbstractGame debug1;
  private AbstractGame sameDebug1;
  private AbstractGame sameStateDebug1;
  private AbstractGame debug2;
  private PlayerI player1;

  @Before
  public void setUp() throws Exception {
    debug1 = new DebugMode();
    sameDebug1 = debug1;
    sameStateDebug1 = new DebugMode();
    debug2 = new GameMode();
    player1 = new Player();
    player1.setStrategy(Strategy.RANDOMSTRATEGY);

  }

  @Test
  public void equals() {
    Assert.assertEquals(debug1,sameDebug1);
    Assert.assertEquals(debug1,sameStateDebug1);
    Assert.assertEquals(sameStateDebug1,debug1);
    Assert.assertEquals(debug1.equals(sameStateDebug1) && sameStateDebug1.equals(debug2), debug1.equals(debug2));
    Assert.assertFalse(debug1.equals(null));
    Assert.assertFalse(debug1.equals(player1));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(debug1.equals(sameStateDebug1), debug1.hashCode() == sameStateDebug1.hashCode());
  }
}