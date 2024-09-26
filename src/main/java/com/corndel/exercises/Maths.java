package com.corndel.exercises;

public class Maths {
    public static double PI = 3.14;
    public static double max(double a, double b) {
        return a >= b ? a : b;
    }

    public static double round(double i) {
        if (i%1 != 0) {
            int integer = (int) i;
            double decimal = i-integer;
            return decimal >= 0.5 ? integer + 1 : integer;
        }
        return i;
    }
}
