package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece implements Piece {

  public Pawn(PlayerColour colour) {
    super(PieceType.PAWN, colour);
  }

  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    var allowedMoves = new ArrayList<Move>();
    int direction = getColour() == PlayerColour.WHITE ? -1 : 1;
    int startRow = getColour() == PlayerColour.WHITE ? 6 : 1;

    // 1 step
    Coordinates oneStep = from.plus(direction, 0);
    if (oneStep.getRow() >= 0 && oneStep.getRow() <= 7 &&
            board.get(oneStep) == null) {
      allowedMoves.add(new Move(from, oneStep));

      // 2 steps
      Coordinates twoSteps = from.plus(direction * 2, 0);
      if (from.getRow() == startRow && twoSteps.getRow() >= 0 &&
              twoSteps.getRow() <= 7 && board.get(twoSteps) == null) {
        allowedMoves.add(new Move(from, twoSteps));
      }
    }

    // Possible attack moves
    List<Coordinates> attacks = List.of(
            from.plus(direction, -1), //
            from.plus(direction, 1)
    );

    for (Coordinates attack : attacks) {
      if (attack.getRow() >= 0 && attack.getRow() <= 7 &&
              attack.getCol() >= 0 && attack.getCol() <= 7 &&
              board.get(attack) != null &&
              board.get(attack).getColour() != getColour()) {
        allowedMoves.add(new Move(from, attack));
      }
    }

    return allowedMoves;
  }
}
