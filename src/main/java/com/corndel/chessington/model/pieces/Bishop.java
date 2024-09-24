package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;
import net.bytebuddy.implementation.bind.annotation.Super;

import java.util.List;

public class Bishop extends AbstractPiece implements Piece {

  public Bishop(PlayerColour colour) {
    super(PieceType.BISHOP, colour);
  }

  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    // TODO Implement this!
    return List.of();
  }
}
