package edu.neu.ccs.cs5004.assignment5.model.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author linzisheng.
 * @Date 2018/2/28 23:50.
 */
public class RandomStrategyTest {

  private AbstractStrategy strategy1;
  private AbstractStrategy strategy2;
  private AbstractStrategy strategy3;
  private AbstractStrategy strategy4;
  @Before
  public void setUp() throws Exception {
    strategy1 = new RandomStrategy();
    strategy2 = strategy1;
    strategy3 = new RandomStrategy();
    strategy4 = new SmartStrategy();
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(strategy1.equals(strategy2), strategy1.hashCode() == strategy2.hashCode());
    Assert.assertEquals(strategy1.equals(strategy3), strategy1.hashCode() == strategy3.hashCode());
  }

  @Test
  public void equals() {
    Assert.assertEquals(strategy1,strategy2);
    Assert.assertEquals(strategy1,strategy3);
    Assert.assertEquals(strategy3,strategy1);
    Assert.assertEquals(strategy1.equals(strategy2) && strategy2.equals(strategy3), strategy1.equals(strategy3));
    Assert.assertFalse(strategy1.equals(null));
    Assert.assertFalse(strategy1.equals(strategy4));

  }

  @Test
  public void generateAttackPosn() {
    Position posn = strategy1.generateAttackPosn(new Map());
  }
}