package com.corndel.chessington.model;

public enum PlayerColour {
  WHITE,
  BLACK;

  public PlayerColour getOpposite() {
    return this == WHITE ? BLACK : WHITE;
  }
}
