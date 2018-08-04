package edu.neu.ccs.cs5004.assignment5.model.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author linzisheng.
 * @Date 2018/3/1 2:45.
 */
public class DirectionTest {


  @Test
  public void find() {
    Assert.assertEquals(Direction.horizontal, Direction.find(0));
    Assert.assertEquals(Direction.vertical, Direction.find(1));
  }

  @Test
  public void testToString() {
    Assert.assertEquals("Direction{dir=1}", Direction.vertical.toString());
    Assert.assertEquals("Direction{dir=0}", Direction.horizontal.toString());
  }
}