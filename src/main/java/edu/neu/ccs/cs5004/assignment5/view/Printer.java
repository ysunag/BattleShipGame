package edu.neu.ccs.cs5004.assignment5.view;


import edu.neu.ccs.cs5004.assignment5.model.cell.EnemyShipCell;
import edu.neu.ccs.cs5004.assignment5.model.cell.SpecificShipCell;
import edu.neu.ccs.cs5004.assignment5.model.cell.WaterCell;
import edu.neu.ccs.cs5004.assignment5.model.game.GameI;
import edu.neu.ccs.cs5004.assignment5.model.game.MapI;

/**
 * Represents the printer used in the map to print out message or map.
 */
public interface Printer {

  /**
   * Asks user to select select which mode to play.
   */
  static void selectMode() {
    System.out.println("Please select which mode to play: press 1 to play debug mode, "
            +
            "press 2 to play game mode");
  }

  /**
   * Asks user to choose how to place the ship.
   */
  void selectPlacement();

  /**
   * Prints out the map.
   *
   * @param map the map to print
   */
  void show(MapI map);

  /**
   * Prints water cell.
   *
   * @param cell the cell to print
   */
  void show(WaterCell cell);

  /**
   * Prints Specific ship cell.
   *
   * @param cell the cell to print
   */
  void show(SpecificShipCell cell);

  /**
   * Prints enemy ship cell.
   *
   * @param cell the cell to print
   */
  void show(EnemyShipCell cell);

  /**
   * States the type of the ship needs to print.
   *
   * @param shipType the type of ship to print
   */
  void stateShipType(String shipType);

  /**
   * Asks which row to place ship.
   */
  void askUserForRow();

  /**
   * Asks to choose column.
   */
  void askUserForColumn();

  /**
   * Asks which direction to place the ship.
   */
  void askUserForDirection();

  /**
   * Asks how many Battle Ship the fleet should have.
   */
  void askForBattleShipNum();

  /**
   * Asks how many Cruiser the fleet should have.
   */
  void askForCruiserNum();

  /**
   * Asks how many Submarine the fleet should have.
   */
  void askForSubmarineNum();

  /**
   * Asks how many Destroyer the fleet should have.
   */
  void askForDestroyerNum();

  /**
   * Warns the user that the placement of ship failed and need to place again.
   */
  void placeWarning();


  /**
   * States the following is human player's fleet map.
   */
  void humanFleet();

  /**
   * States the following is computer player's fleet map.
   */
  void computerFleet();

  /**
   * States the following is human player's battle map.
   */
  void humanBattleFleet();

  /**
   * States the following is computer player's battle map.
   */
  void computerBattleFleet();

  /**
   * Asks the user to select attack strategy.
   */
  void askForStrategy();

  /**
   * Announces that the human player wins the game.
   */
  void humanWin();

  /**
   * Announces that the computer player wins the game.
   */
  void computerWin();

  /**
   * To display the maps in the game.
   *
   * @param game the game to display
   */
  void display(GameI game);

}
