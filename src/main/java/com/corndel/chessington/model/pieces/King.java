package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class King extends AbstractPiece implements Piece {

  protected boolean moved = false;

  public King(PlayerColour colour) {
    super(PieceType.KING, colour);
  }


  @Override
  public List<Move> getAllowedMoves(Coordinates from, Board board) {
    var allowedMoves = new ArrayList<Move>();

    List<int[]> directions = List.of(
            new int[]{-1, 0},
            new int[]{1, 0},
            new int[]{0, -1},
            new int[]{0, 1},
            new int[]{-1, -1},
            new int[]{-1, 1},
            new int[]{1, -1},
            new int[]{1, 1}
    );

    for (int[] dir : directions) {
      int row = from.getRow();
      int col = from.getCol();
      int rowDiff = dir[0];
      int colDiff = dir[1];

      while (true) {
        row += rowDiff;
        col += colDiff;
        if (row < 0 || row > 7 || col < 0 || col > 7) {
          break;
        }

        Coordinates dest = new Coordinates(row, col);
        if (!dest.equals(from)) {
          if (board.get(dest) == null || !board.get(dest).getColour().equals(getColour())) {
            allowedMoves.add(new Move(from, dest));
            break;
          }
          if (board.get(dest) != null) {
            break;
          }
        }
      }
    }

    return allowedMoves;
  }
}