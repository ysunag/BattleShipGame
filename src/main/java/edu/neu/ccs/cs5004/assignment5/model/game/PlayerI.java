package edu.neu.ccs.cs5004.assignment5.model.game;

public interface PlayerI {

  /**
   * Getter for property 'fleetMap'.
   *
   * @return Value for property 'fleetMap'.
   */
  MapI getFleetMap();

  /**
   * Getter for property 'battleMap'.
   *
   * @return Value for property 'battleMap'.
   */
  MapI getBattleMap();

  /**
   * Getter for property 'sunkShipNumber'.
   *
   * @return Value for property 'sunkShipNumber'.
   */
  Integer getSunkShipNum();

  /**
   * Increases the sunk ship number by 1.
   */
  void increaseSunkShipNum();

  /**
   * Sets the strategy according to the input string.
   *
   * @param strategy the string representing the strategy.
   */
  void setStrategy(String strategy);

  /**
   * Getter for property 'strategy'.
   *
   * @return Value for strategy.
   */
  Strategy getStrategy();

  /**
   * Generates the position to attack cell by the player's strategy.
   *
   * @return the position to attack the cell.
   */
  Position attackCell();

  /**
   * A player attacks the opponent's cell at the given position on the opponent's fleet map.
   *
   * @param posn  the position to attack.
   * @param enemy the player whose cell is to be attacked.
   */
  void attackOpponent(Position posn, PlayerI enemy);

  /**
   * Setter for property 'battleMap'.
   *
   * @param battleMap the value of battleMap to set.
   */
  void setBattleMap(MapI battleMap);

  /**
   * Setter for property 'fleetMap'.
   *
   * @param fleetMap the value of fleetMap to set.
   */
  void setFleetMap(MapI fleetMap);
}
