package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Pawn implements Piece {

  private final Piece.PieceType type;
  protected final PlayerColour colour;

  public Pawn(PlayerColour colour) {
    this.type = PieceType.PAWN;
    this.colour = colour;
  }

  @Override
  public Piece.PieceType getType() {
    return type;
  }

  @Override
  public PlayerColour getColour() {
    return colour;
  }

  @Override
  public String toString() {
    return colour.toString() + " " + type.toString();
  }

  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    var allowedMoves = new ArrayList<Move>();
    if (getColour().equals(PlayerColour.WHITE) && from.getRow() > 0) {
      var destination = from.plus(-1, 0);
      if (board.get(destination) == null) {
        allowedMoves.add(new Move(from, destination));
      }
        if (from.getRow() == 6) {
          var extra_destination = from.plus(-2, 0);
          if (board.get(extra_destination) == null) {
            allowedMoves.add(new Move(from, extra_destination));
          }
        }
// Attempt at doing the diagonal bit
//        if (board.get(from.plus(-1, -1)) != null) {
//          allowedMoves.add(new Move(from, from.plus(-1, -1)));
//        }
//      if (board.get(from.plus(-1, 1)) != null) {
//        allowedMoves.add(new Move(from, from.plus(-1, 1)));
//      }

    } else if (getColour().equals(PlayerColour.BLACK) && from.getRow() < 7){
        var destination = from.plus(1, 0);
      if (board.get(destination) == null) {
        allowedMoves.add(new Move(from, destination));
      }
        if (from.getRow() == 1) {
          var extra_destination = from.plus(2, 0);
          if (board.get(extra_destination) == null) {
            allowedMoves.add(new Move(from, extra_destination));
          }
        }
      }
    return allowedMoves;
  }
}
