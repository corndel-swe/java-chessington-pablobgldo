package com.corndel.exercises;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class D2E3Tests {
  // Rectangle tests
  @Test
  public void RectangleInheritsFromShape() {
    assertThat(Shape.class.isAssignableFrom(Rectangle.class)).isTrue();
  }

  @Test
  public void RectangleGetArea() {
    var square = new Square(5);
    assertThat(square.getArea()).isEqualTo(25);
  }

  @Test
  public void RectangleGetPerimeter() {
    var square = new Square(4);
    assertThat(square.getPerimeter()).isEqualTo(16);
  }

  // RightTriangle tests
  @Test
  public void RightTriangleInheritsFromShape() {
    assertThat(Shape.class.isAssignableFrom(RightTriangle.class)).isTrue();
  }

  @Test
  public void RightTriangleGetArea() {
    try {
      var rightTriangle = new RightTriangle(3.0, 4.0);
      var getArea = RightTriangle.class.getMethod("getArea");
      var area = (double) getArea.invoke(rightTriangle);

      assertThat(area).isEqualTo(6.0);
    } catch (Throwable e) {
      fail(e);
    }
  }

  @Test
  public void RightTriangleGetPerimeter() {
    try {
      var rightTriangle = new RightTriangle(3.0, 4.0);
      var getPerimeter = RightTriangle.class.getMethod("getPerimeter");
      var perimeter = (double) getPerimeter.invoke(rightTriangle);

      assertThat(perimeter).isEqualTo(12.0);
    } catch (Throwable e) {
      fail(e);
    }
  }

  // Circle tests
  @Test
  public void CircleInheritsFromShape() {
    assertThat(Shape.class.isAssignableFrom(Circle.class)).isTrue();
  }

  @Test
  public void CircleGetArea() {
    try {
      var circle = new Circle(2.0);
      var getArea = Circle.class.getMethod("getArea");
      var area = (double) getArea.invoke(circle);

      assertThat(area).isCloseTo(12.6, within(0.1));
    } catch (Throwable e) {
      fail(e);
    }
  }

  @Test
  public void CircleGetRadius() {
    try {
      var circle = new Circle(3.0);
      var getPerimeter = Circle.class.getMethod("getPerimeter");
      var perimeter = (double) getPerimeter.invoke(circle);

      assertThat(perimeter).isCloseTo(18.8, within(0.1));
    } catch (Throwable e) {
      fail(e);
    }
  }
}
