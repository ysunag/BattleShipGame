package edu.neu.ccs.cs5004.assignment5.model.cell;

import edu.neu.ccs.cs5004.assignment5.model.ship.BattleShip;
import edu.neu.ccs.cs5004.assignment5.model.ship.Ship;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShipObserverTest {
    private ShipObserver testEnemyShipCell;
    private ShipObserver sunkEnemyShipCell;
    private ShipObserver sameStateEnemyShipCell;

    @Before
    public void setUp() throws Exception {
        testEnemyShipCell = new EnemyShipCell(false, false, false);
        sunkEnemyShipCell = new EnemyShipCell(true, true, true);
        sameStateEnemyShipCell = new EnemyShipCell(false, false, false);
    }

    @Test
    public void update() {
        testEnemyShipCell.update(new BattleShip(4));
        sameStateEnemyShipCell.update(new BattleShip(0));
        Assert.assertEquals(sunkEnemyShipCell, testEnemyShipCell);
        Assert.assertEquals(sameStateEnemyShipCell, sameStateEnemyShipCell);
    }
}