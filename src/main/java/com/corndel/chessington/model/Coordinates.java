package com.corndel.chessington.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public final class Coordinates {
  private final int row;
  private final int col;

  @JsonCreator
  public Coordinates(@JsonProperty("row_num") int row, @JsonProperty("column_num") int col) {
    this.row = row;
    this.col = col;
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Coordinates that = (Coordinates) o;
    return row == that.row && col == that.col;
  }

  @Override
  public int hashCode() {
    return Objects.hash(row, col);
  }

  @Override
  public String toString() {
    return String.format("row %d, column %d", row, col);
  }

  public Coordinates plus(int rowDiff, int colDiff) {
    return new Coordinates(row + rowDiff, col + colDiff);
  }
}
