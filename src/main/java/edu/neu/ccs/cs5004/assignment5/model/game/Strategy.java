package edu.neu.ccs.cs5004.assignment5.model.game;

public interface Strategy {
  String RANDOMSTRATEGY = "1";
  String SMARTSTRATEGY = "2";

  Position generateAttackPosn(MapI map);
}
