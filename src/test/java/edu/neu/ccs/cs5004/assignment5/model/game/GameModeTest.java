package edu.neu.ccs.cs5004.assignment5.model.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author linzisheng.
 * @Date 2018/3/1 2:30.
 */
public class GameModeTest {
  private AbstractGame game1;
  private AbstractGame sameGame1;
  private AbstractGame sameStateGame1;
  private AbstractGame game2;
  private PlayerI player1;

  @Before
  public void setUp() throws Exception {
    game1 = new GameMode();
    sameGame1 = game1;
    sameStateGame1 = new GameMode();
    game2 = new DebugMode();
    player1 = new Player();
    player1.setStrategy(Strategy.RANDOMSTRATEGY);

  }

  @Test
  public void equals() {
    Assert.assertEquals(game1,sameGame1);
    Assert.assertEquals(game1,sameStateGame1);
    Assert.assertEquals(sameStateGame1,game1);
    Assert.assertEquals(game1.equals(sameStateGame1) && sameStateGame1.equals(game2), game1.equals(game2));
    Assert.assertFalse(game1.equals(null));
    Assert.assertFalse(game1.equals(game2));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(game1.equals(sameStateGame1), game1.hashCode() == sameStateGame1.hashCode());
  }
}