package edu.neu.ccs.cs5004.assignment5.controller;

import edu.neu.ccs.cs5004.assignment5.model.game.DebugMode;
import edu.neu.ccs.cs5004.assignment5.model.game.GameMode;
import edu.neu.ccs.cs5004.assignment5.view.ConsolePrinter;
import edu.neu.ccs.cs5004.assignment5.view.DebugConsolePrinter;
import edu.neu.ccs.cs5004.assignment5.view.GameConsolePrinter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControllerTest {

  private Controller gameController;
  private Controller debugController;
  private Controller sameStateController;
  private Controller sameRefController;

  @Before
  public void setUp() throws Exception {
    gameController = new Controller(new GameMode(), false, new GameConsolePrinter());
    debugController = new Controller(new DebugMode(), true, new DebugConsolePrinter());
    sameStateController = new Controller(new GameMode(), false, new GameConsolePrinter());
    sameRefController = gameController;
  }


  @Test
  public void equals() {
    Controller nullController = null;
    Controller anotherController = new Controller(new GameMode(), false, new GameConsolePrinter());
    Assert.assertTrue(gameController.equals(sameRefController));
    Assert.assertTrue(gameController.equals(sameStateController));
    Assert.assertEquals(gameController.equals(sameStateController), sameStateController.equals(gameController));
    Assert.assertEquals(gameController.equals(sameStateController)
            && sameStateController.equals(anotherController), gameController.equals(anotherController));
    Assert.assertFalse(gameController.equals(debugController));
    Assert.assertFalse(gameController.equals(nullController));
    Assert.assertFalse(gameController.equals(new Integer(9)));

    Controller wrongController1 = new Controller(new GameMode(), true, new GameConsolePrinter());
    Controller wrongController2 = new Controller(new GameMode(), false, new DebugConsolePrinter());
    Assert.assertFalse(gameController.equals(wrongController1));
    Assert.assertFalse(gameController.equals(wrongController2));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(gameController.equals(sameStateController),
            gameController.hashCode() == sameStateController.hashCode());
    Assert.assertEquals(gameController.equals(sameRefController),
            gameController.hashCode() == sameRefController.hashCode());
    Assert.assertEquals(!gameController.equals(debugController),
            gameController.hashCode() != debugController.hashCode());
  }
}