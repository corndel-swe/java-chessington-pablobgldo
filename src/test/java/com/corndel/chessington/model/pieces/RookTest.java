package com.corndel.chessington.model.pieces;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

public class RookTest {

  private Board board;
  private Rook rook = new Rook(PlayerColour.WHITE);

@BeforeEach
  public void setup() {
    board = Board.empty();
  }

  @Test
  public void rookCanMoveHorizontally() {
    // Arrange
    Coordinates coords = new Coordinates(3, 4);
    board.placePiece(coords, rook);

    // Act
    List<Move> allowedMoves = rook.getAllowedMoves(coords, board);

    // Assert
    assertThat(allowedMoves)
        .contains(
            new Move(coords, new Coordinates(3, 0)),
            new Move(coords, new Coordinates(3, 1)),
            new Move(coords, new Coordinates(3, 2)),
            new Move(coords, new Coordinates(3, 3)),
            new Move(coords, new Coordinates(3, 5)),
            new Move(coords, new Coordinates(3, 6)),
            new Move(coords, new Coordinates(3, 7)));
  }

  @Test
  public void rookCannotMoveToOwnSquare() {
    // Arrange
    Coordinates coords = new Coordinates(3, 4);
    board.placePiece(coords, rook);

    // Act
    List<Move> allowedMoves = rook.getAllowedMoves(coords, board);

    // Assert
    assertThat(allowedMoves).doesNotContain(new Move(coords, coords));
  }

  @Test
  public void rookCanMoveVertically() {
    // Arrange
    Coordinates coords = new Coordinates(3, 4);
    board.placePiece(coords, rook);

    // Act
    List<Move> allowedMoves = rook.getAllowedMoves(coords, board);

    // Assert
    assertThat(allowedMoves)
        .contains(
            new Move(coords, new Coordinates(0, 4)),
            new Move(coords, new Coordinates(1, 4)),
            new Move(coords, new Coordinates(2, 4)),
            new Move(coords, new Coordinates(4, 4)),
            new Move(coords, new Coordinates(5, 4)),
            new Move(coords, new Coordinates(6, 4)),
            new Move(coords, new Coordinates(7, 4)));
  }

  @Disabled
  @Test
  public void rookCanCaptureOpposingPieceHorizontally() {
    // Arrange
    Coordinates coords = new Coordinates(3, 4);
    board.placePiece(coords, rook);

    Piece opponent = new Queen(PlayerColour.BLACK);
    Coordinates opponentCoords = new Coordinates(3, 2);
    board.placePiece(opponentCoords, opponent);

    // Act
    List<Move> allowedMoves = rook.getAllowedMoves(coords, board);

    // Assert
    assertThat(allowedMoves).contains(new Move(coords, opponentCoords));
  }

  @Disabled
  @Test
  public void rookCanCaptureOpposingPieceVertically() {
    // Arrange
    Coordinates coords = new Coordinates(3, 4);
    board.placePiece(coords, rook);

    Piece opponent = new Queen(PlayerColour.BLACK);
    Coordinates opponentCoords = new Coordinates(5, 4);
    board.placePiece(opponentCoords, opponent);

    // Act
    List<Move> allowedMoves = rook.getAllowedMoves(coords, board);

    // Assert
    assertThat(allowedMoves).contains(new Move(coords, opponentCoords));
  }

  @Disabled
  @Test
  public void rookIsBlockedByFriendlyPieceHorizontally() {
    // Arrange
    Coordinates coords = new Coordinates(3, 4);
    board.placePiece(coords, rook);

    Piece friendlyPiece = new Queen(PlayerColour.WHITE);
    Coordinates friendlyCoords = new Coordinates(3, 2);
    board.placePiece(friendlyCoords, friendlyPiece);

    // Act
    List<Move> allowedMoves = rook.getAllowedMoves(coords, board);

    // Assert
    assertThat(allowedMoves)
        .doesNotContain(
            new Move(coords, friendlyCoords),
            new Move(coords, new Coordinates(3, 1)),
            new Move(coords, new Coordinates(3, 0)));
  }

  @Disabled
  @Test
  public void rookIsBlockedByFriendlyPieceVertically() {
    // Arrange
    Coordinates coords = new Coordinates(3, 4);
    board.placePiece(coords, rook);

    Piece friendlyPiece = new Queen(PlayerColour.WHITE);
    Coordinates friendlyCoords = new Coordinates(5, 4);
    board.placePiece(friendlyCoords, friendlyPiece);

    // Act
    List<Move> allowedMoves = rook.getAllowedMoves(coords, board);

    // Assert
    assertThat(allowedMoves)
        .doesNotContain(
            new Move(coords, friendlyCoords),
            new Move(coords, new Coordinates(6, 4)),
            new Move(coords, new Coordinates(7, 4)));
  }

  @Disabled
  @Test
  public void rookCannotPassThroughOpposingPieceHorizontally() {
    // Arrange
    Coordinates coords = new Coordinates(3, 4);
    board.placePiece(coords, rook);

    Piece opponent = new Queen(PlayerColour.BLACK);
    Coordinates opponentCoords = new Coordinates(3, 2);
    board.placePiece(opponentCoords, opponent);

    // Act
    List<Move> allowedMoves = rook.getAllowedMoves(coords, board);

    // Assert
    assertThat(allowedMoves)
        .doesNotContain(
            new Move(coords, new Coordinates(3, 1)), new Move(coords, new Coordinates(3, 0)));
  }

  @Disabled
  @Test
  public void rookCannotPassThroughOpposingPieceVertically() {
    // Arrange
    Coordinates coords = new Coordinates(3, 4);
    board.placePiece(coords, rook);

    Piece opponent = new Queen(PlayerColour.BLACK);
    Coordinates opponentCoords = new Coordinates(5, 4);
    board.placePiece(opponentCoords, opponent);

    // Act
    List<Move> allowedMoves = rook.getAllowedMoves(coords, board);

    // Assert
    assertThat(allowedMoves)
        .doesNotContain(
            new Move(coords, new Coordinates(6, 4)), new Move(coords, new Coordinates(7, 4)));
  }
}
