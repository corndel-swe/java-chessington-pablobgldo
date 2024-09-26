package com.corndel.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathsTests {

    @Test
    public void PiShouldBe314() {
        assertEquals(Maths.PI, 3.14);
    }

    @Test
    public void MathsMaxShouldWork() {
        assertEquals(Maths.max(1, 5), 5);
    }

    @Test
    public void MathsRoundReturnsIntWhenGivenInt() {
        double result = Maths.round(2);
        assertEquals(result, 2);
    }

    @Test
    public void MathsRoundCanRoundDown() {
        double result = Maths.round(2.4);
        assertEquals(result, 2);
    }

    @Test
    public void MathsRoundCanRoundUp() {
        double result = Maths.round(2.7);
        assertEquals(result, 3);
    }
}