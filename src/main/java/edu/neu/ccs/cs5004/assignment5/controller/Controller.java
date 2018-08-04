package edu.neu.ccs.cs5004.assignment5.controller;

import edu.neu.ccs.cs5004.assignment5.model.game.AbstractGame;
import edu.neu.ccs.cs5004.assignment5.model.game.DebugMode;
import edu.neu.ccs.cs5004.assignment5.model.game.GameI;
import edu.neu.ccs.cs5004.assignment5.model.game.GameMode;
import edu.neu.ccs.cs5004.assignment5.model.game.Placement;
import edu.neu.ccs.cs5004.assignment5.model.game.PlacementI;
import edu.neu.ccs.cs5004.assignment5.model.game.Position;
import edu.neu.ccs.cs5004.assignment5.model.ship.Ship;
import edu.neu.ccs.cs5004.assignment5.view.DebugConsolePrinter;
import edu.neu.ccs.cs5004.assignment5.view.GameConsolePrinter;
import edu.neu.ccs.cs5004.assignment5.view.Printer;
import edu.neu.ccs.cs5004.assignment5.view.ReadConsole;

import java.util.Objects;

/**
 * Represents the controller controlling the BattleShip game.
 */
public class Controller {
  public GameI game;
  public Boolean isDebugMode;
  public Printer printer;
  public static final ReadConsole READER = new ReadConsole();


  /**
   * Creates a new controller with given game whether the game is played in debug mode.
   *
   * @param game        the game to play.
   * @param isDebugMode whether the game is played in debug mode.
   * @param printer     the printer used to print the map information.
   */
  public Controller(GameI game, Boolean isDebugMode, Printer printer) {
    this.game = game;
    this.isDebugMode = isDebugMode;
    this.printer = printer;
  }

  /**
   * Generates a controller to a game.
   *
   * @return a game mode controller depends on game or debug mode.
   */
  public static Controller generateGameController() {
    Printer.selectMode();
    String mode = READER.toRead(System.in);
    if (mode.equals("1")) {
      return new Controller(new DebugMode(), true, new DebugConsolePrinter());
    } else if (mode.equals("2")) {
      return new Controller(new GameMode(), false, new GameConsolePrinter());
    } else {
      return null;
    }
  }

  /**
   * Places the fleet on players' fleet maps.
   */
  public void placeShip() {
    PlacementI placer = new Placement();
    if (isDebugMode) {
      debugSetFleet();
    }
    printer.selectPlacement();
    String placement = READER.toRead(System.in);
    if (placement.equals("1")) {
      placer.randomFleetPlace(game.getHumanPlayer(), game.getShipNumber());
    } else if (placement.equals("2")) {
      selfPlaceShip();
    }
    placer.randomFleetPlace(game.getComputerPlayer(), game.getShipNumber());
    printer.display(this.game);
  }


  /**
   * Human player and computer player attack a cell on the map of each other's for once.
   */
  protected void playOneRoundGame() {
    printer.askForStrategy();
    String strategy = READER.toRead(System.in);
    this.game.getHumanPlayer().setStrategy(strategy);
    if (this.game.getHumanPlayer().getStrategy() == null) {
      printer.askUserForRow();
      String row = READER.toRead(System.in);
      printer.askUserForColumn();
      String col = READER.toRead(System.in);
      game.getHumanPlayer().attackOpponent(new Position(row, col), game.getComputerPlayer());
    } else {
      game.getHumanPlayer().attackOpponent(game.getHumanPlayer().attackCell(),
              game.getComputerPlayer());
    }
    game.getComputerPlayer().attackOpponent(game.getComputerPlayer().attackCell(),
            game.getHumanPlayer());
    printer.display(game);
  }

  /**
   * Human player and Computer player take turns to attack a cell until one of them win the game.
   */
  public void playGame() {
    while (game.gameEnd() == 0) {
      playOneRoundGame();
    }
    if (game.gameEnd() == -1) {
      printer.computerWin();
    }
    if (game.gameEnd() == 1) {
      printer.humanWin();
    }
  }


  /**
   * Human player places the ships in the fleet on the desired position on the map.
   */
  protected void selfPlaceShip() {
    PlacementI placer = new Placement();
    for (int i = 0; i < AbstractGame.SHIPTYPENUMBER; i++) {
      for (int j = 0; j < game.getShipNumber()[i]; j++) {
        Boolean placed = false;
        Ship newShip = Ship.getShip(i);
        while (!placed) {
          printer.stateShipType(newShip.getClass().getSimpleName());
          printer.askUserForRow();
          String row = READER.toRead(System.in);
          printer.askUserForColumn();
          String col = READER.toRead(System.in);
          printer.askUserForDirection();
          String dir = READER.toRead(System.in);
          placed = placer.userPlaceShip(game.getHumanPlayer().getFleetMap(), newShip,
                  new Position(row, col), dir);
          if (!placed) {
            printer.placeWarning();
          }
        }
        printer.humanFleet();
        printer.show(game.getHumanPlayer().getFleetMap());
      }
    }
  }

  /**
   * Sets the fleet configuration in debug mode.
   */
  protected void debugSetFleet() {
    String num;
    printer.askForBattleShipNum();
    num = READER.toRead(System.in);
    game.increaseFleetSize(num);
    game.setShipNumber(0, num);
    printer.askForCruiserNum();
    num = READER.toRead(System.in);
    game.increaseFleetSize(num);
    game.setShipNumber(1, num);
    printer.askForSubmarineNum();
    num = READER.toRead(System.in);
    game.increaseFleetSize(num);
    game.setShipNumber(2, num);
    printer.askForDestroyerNum();
    num = READER.toRead(System.in);
    game.increaseFleetSize(num);
    game.setShipNumber(3, num);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Controller that = (Controller) obj;
    return Objects.equals(game, that.game)
            &&
            Objects.equals(isDebugMode, that.isDebugMode)
            &&
            Objects.equals(printer, that.printer);
  }

  @Override
  public int hashCode() {

    return Objects.hash(game, isDebugMode, printer);
  }
}
