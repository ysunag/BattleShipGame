package edu.neu.ccs.cs5004.assignment5.model.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author linzisheng.
 * @Date 2018/2/28 22:21.
 */
public class AbstractGameTest {
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
  public void getHumanPlayer() {
    Assert.assertEquals(new Player(), game1.getHumanPlayer());
    Assert.assertEquals(new Player(), game2.getHumanPlayer());
  }

  @Test
  public void getComputerPlayer() {

    Assert.assertEquals(player1, game1.getComputerPlayer());
    Assert.assertEquals(player1, game2.getComputerPlayer());
  }

  @Test
  public void getShipNumber() {
    Assert.assertArrayEquals(new Integer[]{1,2,3,4}, game1.getShipNumber());
    Assert.assertArrayEquals(new Integer[4], game2.getShipNumber());
  }

  @Test
  public void setShipNumber() {
    game1.setShipNumber(0,"1");
    game2.setShipNumber(1, "1");
    Assert.assertEquals(new Integer(1), game1.shipNumber[0] );
    Assert.assertEquals(new Integer(1), game2.shipNumber[1] );
  }

  @Test
  public void increaseFleetSize() {
    game2.increaseFleetSize("1");
    Assert.assertEquals(new Integer(1), game2.getFleetSize());
  }

  @Test
  public void gameEnd() {
    game2.getHumanPlayer().increaseSunkShipNum();
    game2.increaseFleetSize("1");
    Assert.assertEquals(new Integer(-1), new Integer(game2.gameEnd()));
    game2.increaseFleetSize("1");
    game2.getComputerPlayer().increaseSunkShipNum();
    game2.getComputerPlayer().increaseSunkShipNum();
    Assert.assertEquals(new Integer(1), new Integer(game2.gameEnd()));
    game2.increaseFleetSize("1");
    Assert.assertEquals(new Integer(0), new Integer(game2.gameEnd()));

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