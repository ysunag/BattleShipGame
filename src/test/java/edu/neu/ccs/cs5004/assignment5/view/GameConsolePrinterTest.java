package edu.neu.ccs.cs5004.assignment5.view;

import edu.neu.ccs.cs5004.assignment5.model.cell.*;
import edu.neu.ccs.cs5004.assignment5.model.game.*;
import edu.neu.ccs.cs5004.assignment5.model.ship.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameConsolePrinterTest {
    private MapI testMap;
    private MapI testMap2;
    private GameConsolePrinter testPrinter;
    private GameConsolePrinter sameRefPrinter;
    private GameConsolePrinter sameStatePrinter;
    private ConsolePrinter debugPrinter;
    private GameI game;

    private Ship battleShip;
    private Ship cruiser;
    private Ship destroyer;
    private Ship submarine;
    private Ship sunkBattleShip;
    private Ship sunkCruiser;
    private Ship sunkDestroyer;
    private Ship sunkSubmarine;
    private Cell enemyShipCell;
    private Cell hitEnemyCell;
    private Cell sunkEnemyCell;
    private Position position1;
    private Position position2;
    private Position position3;
    private Position position4;
    private Position position5;
    private Position position6;
    private Position position7;
    private Position position8;

    @Before
    public void setUp() throws Exception {
        testMap = new Map();
        testMap2 = new Map();

        battleShip = new BattleShip(0);
        cruiser = new Cruiser(0);
        submarine = new Submarine(0);
        destroyer = new Destroyer(0);
        sunkBattleShip = new BattleShip(4);
        sunkCruiser = new Cruiser(3);
        sunkSubmarine = new Submarine(2);
        sunkDestroyer = new Destroyer(1);


        position1 = new Position(1, Column.A);
        position2 = new Position(1,Column.J);
        position3 = new Position(3,Column.B);
        position4 = new Position(7,Column.G);
        position5 = new Position(10,Column.A);
        position6 = new Position(6,Column.H);
        position7 = new Position(5,Column.E);
        position8 = new Position(10,Column.J);


        testMap.placeOneShip(battleShip, position1, Direction.horizontal);
        testMap.placeOneShip(cruiser, position2, Direction.vertical);
        testMap.placeOneShip(submarine, position3, Direction.horizontal);
        testMap.placeOneShip(destroyer, position4, Direction.vertical);
        testMap.placeOneShip(sunkBattleShip, position5, Direction.horizontal);
        testMap.placeOneShip(sunkCruiser, position7, Direction.vertical);
        testMap.placeOneShip(sunkSubmarine, position6, Direction.horizontal);
        testMap.placeOneShip(sunkDestroyer,position8, Direction.vertical);
        testMap.replaceCell(new SpecificShipCell(true, false,
                new ShipUpdate(new BattleShip(1))), position1);
        testMap.replaceCell(new SpecificShipCell(true, false, new ShipUpdate(new Submarine(1))),
                position3);
        testMap.replaceCell(new OpenSeaCell(true), new Position(1, Column.F));
        testMap.replaceCell(new GapCell(true), new Position(10, Column.F));

        enemyShipCell = new EnemyShipCell(false, false, false);
        hitEnemyCell = new EnemyShipCell(true, false, false);
        sunkEnemyCell = new EnemyShipCell(true, true, true);

        testMap2.replaceCell(enemyShipCell, position5);
        testMap2.replaceCell(sunkEnemyCell, position2);
        testMap2.replaceCell(hitEnemyCell, position3);
        testMap2.replaceCell(new OpenSeaCell(true), new Position(1, Column.F));
        testPrinter = new GameConsolePrinter();
        sameStatePrinter = new GameConsolePrinter();
        sameRefPrinter = testPrinter;
        debugPrinter = new DebugConsolePrinter();
        game = new GameMode();
        game.getHumanPlayer().setFleetMap(testMap);
        game.getHumanPlayer().setBattleMap(testMap2);
        game.getComputerPlayer().setFleetMap(testMap);
        game.getComputerPlayer().setBattleMap(testMap2);
    }

    @Test
    public void display() {
        testPrinter.display(game);
    }

    @Test
    public void equals() {
        GameConsolePrinter nullPrinter = null;
        GameConsolePrinter anotherPrinter = new GameConsolePrinter();

        Assert.assertTrue(testPrinter.equals(testPrinter));
        Assert.assertTrue(testPrinter.equals(sameRefPrinter));
        Assert.assertTrue(testPrinter.equals(sameStatePrinter));
        Assert.assertTrue(testPrinter.equals(anotherPrinter));
        Assert.assertEquals(testPrinter.equals(sameStatePrinter), sameStatePrinter.equals(testPrinter));
        Assert.assertEquals(testPrinter.equals(sameStatePrinter)
                && sameStatePrinter.equals(anotherPrinter), testPrinter.equals(anotherPrinter));
        Assert.assertFalse(testPrinter.equals(nullPrinter));
        Assert.assertFalse(testPrinter.equals(new Integer(7)));
        Assert.assertFalse(testPrinter.equals(debugPrinter));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(testPrinter.equals(sameStatePrinter),
                testPrinter.hashCode() == sameStatePrinter.hashCode());
        Assert.assertEquals(testPrinter.equals(sameRefPrinter),
                testPrinter.hashCode() == sameRefPrinter.hashCode());
        Assert.assertEquals(!testPrinter.equals(debugPrinter),
                testPrinter.hashCode() != debugPrinter.hashCode());
    }
}