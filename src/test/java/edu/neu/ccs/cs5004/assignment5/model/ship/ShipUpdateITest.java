package edu.neu.ccs.cs5004.assignment5.model.ship;

import edu.neu.ccs.cs5004.assignment5.model.cell.EnemyShipCell;
import edu.neu.ccs.cs5004.assignment5.model.cell.ShipObserver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShipUpdateITest {
    private ShipObserver testEnemyShipCell;
    private ShipUpdateI testShipUpdate;
    private ShipUpdateI expectedShipUpdate;
    @Before
    public void setUp() throws Exception {
        testEnemyShipCell = new EnemyShipCell(true, false, false);
        testShipUpdate = new ShipUpdate(new Cruiser(0));
        expectedShipUpdate = new ShipUpdate(new Cruiser(0));
        expectedShipUpdate.registerObserver(testEnemyShipCell);
    }

    @Test
    public void registerObserver() {
        testShipUpdate.registerObserver(testEnemyShipCell);
        Assert.assertEquals(expectedShipUpdate, testShipUpdate);
    }

    @Test
    public void removeObserver() {
        expectedShipUpdate.removeObserver(testEnemyShipCell);
        Assert.assertEquals(testShipUpdate, expectedShipUpdate);
    }

    @Test
    public void notifyObservers() {
        Ship sunkShip = new Cruiser(3);
        ShipUpdate sunkShipupdate = new ShipUpdate(sunkShip);
        sunkShipupdate.registerObserver(testEnemyShipCell);
        EnemyShipCell sunkCell = new EnemyShipCell(true, true,true);
        ShipUpdate resultShipUpdate = new ShipUpdate(sunkShip);
        resultShipUpdate.registerObserver(sunkCell);
        sunkShipupdate.notifyObservers();
        Assert.assertEquals(resultShipUpdate, sunkShipupdate);
    }
}