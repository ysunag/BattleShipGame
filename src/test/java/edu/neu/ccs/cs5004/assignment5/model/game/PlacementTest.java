package edu.neu.ccs.cs5004.assignment5.model.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment5.model.ship.BattleShip;

import static org.junit.Assert.*;

/**
 * @Author linzisheng.
 * @Date 2018/3/1 2:07.
 */
public class PlacementTest {
  private Placement p1;
  private Placement p2;
  private Placement p3;
  private Placement pNull;
  private MapI diffP;

  @Before
  public void setUp() throws Exception {
    p1 = new Placement();
    p2 = p1;
    p3 = new Placement();
    pNull = null;
    diffP = new Map();
  }

  @Test
  public void randomFleetPlace() {
    p1.randomFleetPlace(new Player(), new Integer[]{1,2,3,4});
  }

  @Test
  public void userPlaceShip() {
    MapI map = new Map();
    Position posn = new Position(1, Column.A);
    Assert.assertTrue(p1.userPlaceShip(map, new BattleShip(0), posn, "0"));
    Assert.assertFalse(p1.userPlaceShip(map, new BattleShip(0), posn, "0"));

  }

  @Test
  public void randomPlaceOneShip() {
    p1.randomPlaceOneShip(new Map(), new BattleShip(0));
  }

  @Test
  public void randomMapPosition() {
    Position posn = p1.randomMapPosition();
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(p1,p2);
    Assert.assertEquals(p1,p3);
    Assert.assertEquals(p3,p1);
    Assert.assertFalse(p1.equals(pNull));
    Assert.assertFalse(p1.equals(diffP));
  }

  @Test
  public void equals() {
    Assert.assertEquals(p1.equals(p3), p1.hashCode() == p3.hashCode());
  }
}