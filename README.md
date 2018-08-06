# battleship-game
Battleship game for Console played between a single player and a computer.
** Game Rule:
* The game is played between two players, each has a 2-dimensional map (board), where fleet of ships is placed (this is a fleet map).
* None of the players can see the opponent’s fleet map.
* The objective of the game is to sink the entire fleet of the opponent, before the opponent sinks all your ships.
* Each player tries to hit ships of the opponent by guessing the position of one of the cells on the map.
* An opponent will reply if a ship was partially hit or not, or if was completely sunk.
* A player will maintain additional map, which records the correctness of guesses of opponent's fleet location (guesses' map)
* The fleet (per player) consists of 10 ships (1 Battleship, 2 Cruisers, 3 Submarines and 4 Destroyer).
* The ships can only be placed vertically or horizontally. Diagonal placement is not allowed.
* No part of a ship may hang off the edge of the board. Ships may not overlap each other. Ships may NOT be placed on another ship.
* Ships cannot occupy cells next to each other. In other words, ships cannot touch each other; there must be at least 1 cell that separates between two ships.
* Once the guessing begins, the players may not move the ships.
* If any of players guesses correctly, this player has an additional turn.
* As soon as all of one player's ships have been sunk, the game ends.
