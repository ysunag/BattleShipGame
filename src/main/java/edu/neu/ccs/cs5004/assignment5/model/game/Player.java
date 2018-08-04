package edu.neu.ccs.cs5004.assignment5.model.game;

import edu.neu.ccs.cs5004.assignment5.model.cell.Attackable;
import edu.neu.ccs.cs5004.assignment5.model.cell.Cell;
import edu.neu.ccs.cs5004.assignment5.model.cell.EnemyShipCell;
import edu.neu.ccs.cs5004.assignment5.model.cell.Hit;
import edu.neu.ccs.cs5004.assignment5.model.cell.OpenSeaCell;
import edu.neu.ccs.cs5004.assignment5.model.cell.Sunk;

import java.util.Objects;

/**
 * Represents a player on the battle ship game.
 */


public class Player implements PlayerI {
  private MapI fleetMap;
  private MapI battleMap;
  private Integer sunkShipNum;
  private Strategy strategy;

  /**
   * Creates a new player.
   */
  public Player() {
    fleetMap = new Map();
    battleMap = new Map();
    sunkShipNum = 0;
  }


  public Strategy getStrategy() {
    return strategy;
  }

  @Override
  public void setStrategy(String strategy) {
    if (strategy.equals(Strategy.RANDOMSTRATEGY)) {
      this.strategy = new RandomStrategy();
    } else if (strategy.equals(Strategy.SMARTSTRATEGY)) {
      this.strategy = new SmartStrategy();
    } else {
      this.strategy = null;
    }
  }

  @Override
  public Integer getSunkShipNum() {
    return sunkShipNum;
  }

  @Override
  public void increaseSunkShipNum() {
    this.sunkShipNum++;
  }

  @Override
  public MapI getFleetMap() {
    return fleetMap;
  }

  @Override
  public MapI getBattleMap() {
    return battleMap;
  }

  /**
   * Generate a new position for attack.
   *
   * @return generate a position if it is smart or random strategy, else null.
   */
  public Position attackCell() {
    if (this.strategy == null) {
      return null;
    } else {
      return this.strategy.generateAttackPosn(this.battleMap);
    }
  }


  @Override
  public void attackOpponent(Position posn, PlayerI enemy) {
    Cell attackedCell = enemy.getFleetMap().getCell(posn);
    attackedCell.attackCell();
    Attackable attackRes = attackedCell.attackResult();

    if (attackRes.equals(new Sunk())) {
      enemy.increaseSunkShipNum();
      battleMap.replaceCell(new EnemyShipCell(true, true, true), posn);
      attackedCell.getShipUpdate().notifyObservers();
    } else if (attackRes.equals(new Hit())) {
      EnemyShipCell newCell = new EnemyShipCell(true, false, false);
      battleMap.replaceCell(newCell, posn);
      attackedCell.getShipUpdate().registerObserver(newCell);
    } else {
      battleMap.replaceCell(new OpenSeaCell(true), posn);
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Player player = (Player) obj;
    return Objects.equals(fleetMap, player.fleetMap)
            &&
            Objects.equals(battleMap, player.battleMap)
            &&
            Objects.equals(sunkShipNum, player.sunkShipNum)
            &&
            Objects.equals(strategy, player.strategy);
  }

  @Override
  public int hashCode() {

    return Objects.hash(fleetMap, battleMap, sunkShipNum, strategy);
  }

  @Override
  public void setBattleMap(MapI battleMap) {
    this.battleMap = battleMap;
  }

  @Override
  public void setFleetMap(MapI fleetMap) {

    this.fleetMap = fleetMap;
  }
}


