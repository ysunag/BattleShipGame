package edu.neu.ccs.cs5004.assignment5.model.ship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShipTest {
    private Ship testCruiser;
    private Ship testCruiser2;
    private Ship expectShip;
    @Before
    public void setUp() throws Exception {
        testCruiser = new Cruiser(0);
        expectShip = new Cruiser(1);
        testCruiser2 = new Cruiser(3);
    }

    @Test
    public void getSize() {
        Assert.assertEquals(new Integer(3), testCruiser.getSize());
    }

    @Test
    public void getNumberOfHitCells() {
        Assert.assertEquals(new Integer(0), testCruiser.getNumberOfHitCells());
    }

    @Test
    public void getShip() {
        Assert.assertEquals(new BattleShip(0), Ship.getShip(0));
        Assert.assertEquals(new Cruiser(0), Ship.getShip(1));
        Assert.assertEquals(new Submarine(0), Ship.getShip(2));
        Assert.assertEquals(new Destroyer(0), Ship.getShip(3));
    }

    @Test
    public void isSunk() {
        Assert.assertEquals(false, testCruiser.isSunk());
        Assert.assertEquals(true, testCruiser2.isSunk());
    }


    @Test
    public void increaseNumberOfHitCells() {
        testCruiser.increaseNumberOfHitCells();
        Assert.assertEquals(expectShip, testCruiser);
    }
}