package edu.neu.ccs.cs5004.assignment5.model.game;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.assignment5.model.cell.Cell;
import edu.neu.ccs.cs5004.assignment5.model.cell.EnemyShipCell;
import edu.neu.ccs.cs5004.assignment5.model.cell.OpenSeaCell;
import edu.neu.ccs.cs5004.assignment5.model.cell.SpecificShipCell;
import edu.neu.ccs.cs5004.assignment5.model.ship.BattleShip;
import edu.neu.ccs.cs5004.assignment5.model.ship.Destroyer;
import edu.neu.ccs.cs5004.assignment5.model.ship.ShipUpdate;
import edu.neu.ccs.cs5004.assignment5.model.ship.Submarine;



/**
 * @Author linzisheng.
 * @Date 2018/3/1 0:05.
 */
public class PlayerTest {
  private Player p1;
  private Player sameP1;
  private Player p2;
  private Player p3;
  private Player p4;
  private Player nullP;
  private Position posn;
  private Position posn2;
  private Cell cell;
  private Cell cell2;
  private MapI map;

  @Before
  public void setUp() throws Exception {
    p1 = new Player();
    sameP1 = new Player();
    nullP = null;
    p2 = new Player();
    posn = new Position(1, Column.C);
    posn2 = new Position(2, Column.C);
    p3 = new Player();
    cell = new SpecificShipCell(false, false, new ShipUpdate(new Destroyer(0)));
    p3.getFleetMap().replaceCell(cell, posn);
    p4 = new Player();
    cell2 = new SpecificShipCell(false, false, new ShipUpdate(new Submarine(0)));
    p4.getFleetMap().replaceCell(cell2, posn);
    p4.getFleetMap().replaceCell(cell2, posn2);
    map = new Map();
  }

  @Test
  public void getStrategy() {
    p1.setStrategy(Strategy.RANDOMSTRATEGY);
    Assert.assertEquals(new RandomStrategy(), p1.getStrategy());
  }

  @Test
  public void setStrategy() {
    p1.setStrategy(Strategy.RANDOMSTRATEGY);
    Assert.assertEquals(new RandomStrategy(), p1.getStrategy());
  }

  @Test
  public void getSunkShipNum() {
    Assert.assertEquals(new Integer(0), p1.getSunkShipNum());
  }

  @Test
  public void increaseSunkShipNum() {
    p1.increaseSunkShipNum();
    Assert.assertEquals(new Integer(1), p1.getSunkShipNum());
  }

  @Test
  public void getFleetMap() {
    Assert.assertEquals(new Map(), p1.getFleetMap());
  }

  @Test
  public void getBattleMap() {
    Assert.assertEquals(new Map(), p1.getBattleMap());
  }

  @Test
  public void attackCell() {
    Assert.assertEquals(null, p1.attackCell());
    p1.setStrategy(Strategy.RANDOMSTRATEGY);
    Position posn = p1.attackCell();
  }

  @Test
  public void attackOpponent() {
    p1.attackOpponent(posn, p2);
    map.replaceCell(new OpenSeaCell(true), posn);
    Assert.assertEquals(map, p1.getBattleMap());
    p1.attackOpponent(posn, p3);
    map.replaceCell(new EnemyShipCell(true, true, true), posn);
    Assert.assertEquals(map, p1.getBattleMap());
    p1.attackOpponent(posn, p4);
    map.replaceCell(new EnemyShipCell(true, false, false), posn);
    Assert.assertEquals(map, p1.getBattleMap());
  }

  @Test
  public void equals() {
    Assert.assertEquals(p1, p1);
    Assert.assertEquals(p1.equals(p2) && p2.equals(p3), p1.equals(p3));
    Assert.assertEquals(p1, sameP1);
    Assert.assertEquals(sameP1, p1);
    Assert.assertFalse(p1.equals(nullP));
    Assert.assertFalse(p1.equals(cell));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(p1.equals(sameP1),p1.hashCode() == sameP1.hashCode());
  }

  @Test
  public void setBattleMap() {
    map.replaceCell(new EnemyShipCell(true, false, false), posn);
    p1.setBattleMap(map);
    Assert.assertEquals(map, p1.getBattleMap());
  }

  @Test
  public void setFleetMap() {
    map.replaceCell(new EnemyShipCell(true, false, false), posn);
    p1.setFleetMap(map);
    Assert.assertEquals(map, p1.getFleetMap());
  }
}