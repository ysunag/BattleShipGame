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
public class PlacementITest {

  private Placement p1;
  @Before
  public void setUp() throws Exception {
    p1 = new Placement();
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
}