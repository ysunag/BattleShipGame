package edu.neu.ccs.cs5004.assignment5.model.game;


public interface GameI {

  /**
   * Getter for human player.
   *
   * @return Value for human player
   */
  PlayerI getHumanPlayer();

  /**
   * Getter for computer player.
   *
   * @return Value for computer player
   */
  PlayerI getComputerPlayer();

  /**
   * Getter for property 'shipNumber'.
   *
   * @return Value for property 'shipNumber'
   */
  Integer[] getShipNumber();

  /**
   * Set the number of ships in the given index of the shipNumber
   * array by the number in the given string.
   *
   * @param index  the index of the shipNumber array to set
   * @param number the number to set
   */
  void setShipNumber(Integer index, String number);

  /**
   * Get the number of ship in the fleet.
   *
   * @return the number of ship in the fleet.
   */
  Integer getFleetSize();

  /**
   * Increases the fleet size by the number represented in the given string.
   *
   * @param num the number to increase the fleet size by
   */
  void increaseFleetSize(String num);


  /**
   * Check whether the game is over.
   *
   * @return 0 if the game continues, 1 if the human player wins, -1 if the computer player wins
   */
  int gameEnd();


}
