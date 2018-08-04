package edu.neu.ccs.cs5004.assignment5.view;


import edu.neu.ccs.cs5004.assignment5.model.cell.EnemyShipCell;
import edu.neu.ccs.cs5004.assignment5.model.cell.SpecificShipCell;
import edu.neu.ccs.cs5004.assignment5.model.cell.WaterCell;
import edu.neu.ccs.cs5004.assignment5.model.game.Column;
import edu.neu.ccs.cs5004.assignment5.model.game.Map;
import edu.neu.ccs.cs5004.assignment5.model.game.MapI;
import edu.neu.ccs.cs5004.assignment5.model.game.Position;

/**
 * Represents the console printer to print the message or map.
 */
public abstract class ConsolePrinter implements Printer {


  @Override
  public void selectPlacement() {
    System.out.println("Please choose how you would like to place the ship: press 1 for "
            +
            "random placement, press 2 for user placement.");
  }

  @Override
  public void stateShipType(String shipType) {
    System.out.println("You have a " + shipType + " to place.");
  }

  @Override
  public void askUserForRow() {
    System.out.println("Please choose row (ROW: 1-10)");
  }

  @Override
  public void askUserForColumn() {
    System.out.println("Please choose column (COLUMN: A-J)");
  }

  @Override
  public void askUserForDirection() {
    System.out.println("Please choose which direction to place "
            +
            "the ship(horizontal:0, Vertical: 1)");
  }

  @Override
  public void askForBattleShipNum() {
    System.out.println("Please type in how many Battle Ship do you want to have?");
  }

  @Override
  public void askForCruiserNum() {
    System.out.println("Please type in how many Cruiser do you want to have?");
  }

  @Override
  public void askForSubmarineNum() {
    System.out.println("Please type in how many Submarine do you want to have?");
  }

  @Override
  public void askForDestroyerNum() {
    System.out.println("Please type in how many Destroyer do you want to have?");
  }


  @Override
  public void placeWarning() {
    System.out.println("Cannot place the ship. Select another position and place again.");
  }

  @Override
  public void askForStrategy() {
    System.out.println("Please choose which strategy to use. Press 1 for Random Strategy. Press"
            +
            "2 for Smart Strategy. Press 3 for choose your own attack position.");
  }


  @Override
  public void humanFleet() {
    System.out.println("Here is your fleet map");
  }

  @Override
  public void computerFleet() {
    System.out.println("Here is the opponent's map");
  }

  @Override
  public void humanBattleFleet() {
    System.out.println("Here is your Battle map");
  }

  @Override
  public void computerBattleFleet() {
    System.out.println("Here is the opponent's Battle map");
  }

  @Override
  public void humanWin() {
    System.out.println("Game over, the winner is you!");
  }

  @Override
  public void computerWin() {
    System.out.println("Game over, the winner is your opponent!");
  }

  @Override
  public void show(MapI map) {
    System.out.println("**************************************");
    Position current;
    for (int i = 1; i < Map.ROWNUMBER + 1; i++) {
      for (Column column : Column.values()) {
        current = new Position(i, column);
        map.getCell(current).prettyPrint(this);
      }
      System.out.println("");
    }
    System.out.println("**************************************");
  }


  @Override
  public void show(WaterCell cell) {
    if (cell.getWasHit()) {
      System.out.print("M");
    } else {
      System.out.print(" ");
    }
  }

  @Override
  public void show(SpecificShipCell cell) {
    if (cell.getIsSunk()) {
      System.out.print("X");
    } else if (cell.getWasHit()) {
      System.out.print("*");
    } else {
      System.out.print("o");
    }
  }


  @Override
  public void show(EnemyShipCell cell) {
    if (cell.getBelongToSunkShip()) {
      System.out.print("X");
    } else if (cell.getWasHit()) {
      System.out.print("*");
    } else {
      System.out.print("o");
    }
  }


}
