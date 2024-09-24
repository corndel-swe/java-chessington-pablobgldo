package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece implements Piece {


  public Pawn(PlayerColour colour) {
    super(PieceType.PAWN, colour);
  }

  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    var allowedMoves = new ArrayList<Move>();
    int direction = getColour().equals(PlayerColour.WHITE) ? -1 : 1;
    Coordinates destination = from.plus(direction, 0);

    if (from.getRow() > 0 && from.getRow() < 7 && board.get(destination) == null) {
      allowedMoves.add(new Move(from, destination));
      // Adds 2-step move if pawn hasn't moved yet
      Coordinates extra = destination.plus(direction, 0);
      if (board.get(extra) == null && (from.getRow() == 6 && getColour() == PlayerColour.WHITE) || (from.getRow() == 1 && getColour() == PlayerColour.BLACK)) {
        allowedMoves.add(new Move(from, extra));
      }
      // Calculate possible enemy attacks
      List<Coordinates> possible = List.of(from.plus(direction, 1), from.plus(direction, -1));
      List<Coordinates> enemies = possible.stream().filter(x -> board.get(x) != null && board.get(x).getColour() != getColour()).toList();
      if (!enemies.isEmpty()) {
        for (Coordinates coords : enemies) {
          allowedMoves.add(new Move(from, coords));
        }
      }
    }
    return allowedMoves;
  }
}