package edu.neu.ccs.cs5004.assignment5.model.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment5.model.ship.BattleShip;
import edu.neu.ccs.cs5004.assignment5.model.ship.Ship;
import javafx.geometry.Pos;

import static org.junit.Assert.*;

/**
 * @Author linzisheng.
 * @Date 2018/2/28 23:51.
 */
public class PositionTest {
  private Position posn1;
  private Position posn2;
  private Position posn3;
  private Position posn4;
  private Position nullPosn;
  private Ship battleShip;

  @Before
  public void setUp() throws Exception {
    posn1 = new Position("1","A");
    posn2 = posn1;
    posn3 = new Position("1","A");
    posn4 = new Position("2", "B");
    nullPosn = null;
    battleShip = new BattleShip(1);
  }

  @Test
  public void getRow() {
    Assert.assertEquals(new Integer(1) , posn1.getRow());
    Assert.assertEquals(new Integer(2) , posn4.getRow());
  }

  @Test
  public void getColumn() {
    Assert.assertEquals(Column.A , posn1.getColumn());
    Assert.assertEquals(Column.B , posn4.getColumn());
  }

  @Test
  public void equals() {
    Assert.assertEquals(posn1,posn2);
    Assert.assertEquals(posn1,posn3);
    Assert.assertEquals(posn3,posn1);
    Assert.assertEquals(posn1.equals(posn2) && posn2.equals(posn4), posn1.equals(posn4));
    Assert.assertFalse(posn1.equals(null));
    Assert.assertFalse(posn1.equals(battleShip));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(posn1.equals(posn3), posn1.hashCode() == posn3.hashCode());
    Assert.assertEquals(posn1.equals(posn2), posn1.hashCode() == posn2.hashCode());
  }

  @Test
  public void testToString() {
    Assert.assertEquals("Position{row=1, column=Column{col=0}}", posn1.toString());
    Assert.assertEquals("Position{row=2, column=Column{col=1}}", posn4.toString());
  }
}