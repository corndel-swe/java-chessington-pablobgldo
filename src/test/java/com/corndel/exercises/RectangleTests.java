package com.corndel.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangleTests {

    @Test
    public void RectangleAreaMethodWorks() {
        Rectangle rect = new Rectangle(2, 5);
        double result = rect.getArea();
        assertEquals(result, rect.getHeight()*rect.getWidth());
    }

    @Test
    public void RectanglePerimeterMethodWorks() {
        Rectangle rect = new Rectangle(2, 5);
        double result = rect.getPerimeter();
        assertEquals(result, 2*2+5*2);
    }
}
