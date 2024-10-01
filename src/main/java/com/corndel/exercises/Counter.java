package com.corndel.exercises;

public class Counter {
    private int count;

    public Counter() {
        count = 0;
    }

    public Counter(int i) {
        count = i;
    }

    public void increment() {
        count++;
    }

    public void reset() {
        count = 0;
    }

    public int getCount() {
        return count;
    }



}