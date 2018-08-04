package edu.neu.ccs.cs5004.assignment5.model.game;


import java.util.Arrays;
import java.util.Objects;

/**
 * Represents a battle ship game.
 */
public abstract class AbstractGame implements GameI {

  PlayerI humanPlayer;
  PlayerI computerPlayer;
  Integer[] shipNumber;
  Integer fleetSize;
  public static final Integer SHIPTYPENUMBER = 4;

  /**
   * Creates a new abstract game.
   */
  public AbstractGame() {
    humanPlayer = new Player();
    computerPlayer = new Player();
    computerPlayer.setStrategy(Strategy.RANDOMSTRATEGY);
    shipNumber = new Integer[4];
    fleetSize = 0;
  }


  @Override
  public PlayerI getHumanPlayer() {
    return humanPlayer;
  }

  @Override
  public PlayerI getComputerPlayer() {
    return computerPlayer;
  }

  @Override
  public Integer[] getShipNumber() {
    Integer[] newOne = this.shipNumber;
    return newOne;
  }

  @Override
  public void setShipNumber(Integer index, String number) {
    shipNumber[index] = Integer.parseInt(number);
  }

  @Override
  public void increaseFleetSize(String num) {
    this.fleetSize = this.fleetSize + Integer.parseInt(num);
  }

  @Override
  public Integer getFleetSize() {
    return this.fleetSize;
  }


  @Override
  public int gameEnd() {
    if (!humanPlayer.getSunkShipNum().equals(fleetSize)
            && !computerPlayer.getSunkShipNum().equals(fleetSize)) {
      return 0;
    } else if (humanPlayer.getSunkShipNum().equals(fleetSize)) {
      return -1;
    } else {
      return 1;
    }
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    AbstractGame that = (AbstractGame) other;
    return Objects.equals(humanPlayer, that.humanPlayer)
            && Objects.equals(computerPlayer, that.computerPlayer)
            && Arrays.equals(shipNumber, that.shipNumber)
            && Objects.equals(fleetSize, that.fleetSize);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(humanPlayer, computerPlayer, fleetSize);
    result = 31 * result + Arrays.hashCode(shipNumber);
    return result;
  }
}
