package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Rook extends AbstractPiece implements Piece {

  public Rook(PlayerColour colour) {
    super(PieceType.ROOK, colour);
  }

  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    var allowedMoves = new ArrayList<Move>();
    for (int i=0; i<8; i++) {
      // 1st part of the loop gets all horizontal moves
      if (i != from.getCol()) {
        allowedMoves.add(new Move (from, new Coordinates(from.getRow(), i)));}
      // 2nd part of the loop gets all vertical moves
      if (i != from.getRow()) {
      allowedMoves.add(new Move (from, new Coordinates(i, from.getCol())));}}

    return allowedMoves;
  }
}
