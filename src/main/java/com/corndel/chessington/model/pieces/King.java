package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;
import java.util.List;

public class King extends AbstractPiece implements Piece {

  protected boolean moved = false;

  public King(PlayerColour colour) {
    super(PieceType.KING, colour);
  }


  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    // TODO Implement this!
    return List.of();
  }
}
