package edu.neu.ccs.cs5004.assignment5.model.game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author linzisheng.
 * @Date 2018/2/28 23:44.
 */
public class StrategyTest {
  private AbstractStrategy strategy1;
  @Before
  public void setUp() throws Exception {
    strategy1 = new SmartStrategy();
  }

  @Test
  public void generateAttackPosn() {
    Position posn = strategy1.generateAttackPosn(new Map());
  }
}