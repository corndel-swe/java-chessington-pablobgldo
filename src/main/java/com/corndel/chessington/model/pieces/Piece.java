package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public interface Piece {
  enum PieceType {
    PAWN,
    KNIGHT,
    BISHOP,
    ROOK,
    QUEEN,
    KING
  }

  @JsonProperty("piece")
  PieceType getType();

  @JsonProperty("player")
  PlayerColour getColour();

  @JsonIgnore
  List<Move> getAllowedMoves(Coordinates from, Board board);
}
