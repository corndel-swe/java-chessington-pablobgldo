package com.corndel.exercises;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class D2E2Tests {
  @Test
  public void SquareInheritsFromRectangle() {
    assertThat(Rectangle.class.isAssignableFrom(Square.class)).isTrue();
  }

  @Test
  public void testGetArea() {
    Square square = new Square(5);
    assertThat(square.getArea()).isEqualTo(25);
  }

  @Test
  public void testGetPerimeter() {
    Square square = new Square(4);
    assertThat(square.getPerimeter()).isEqualTo(16);
  }

  @Test
  public void testGetWidth() {
    Square square = new Square(3);
    assertThat(square.getWidth()).isEqualTo(3);
  }

  @Test
  public void testGetHeight() {
    Square square = new Square(4);
    assertThat(square.getHeight()).isEqualTo(4);
  }
}
