package com.corndel.exercises;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

// Hello! These tests use something fancy called "Reflection"
// If you are looking at these to help with Day 3 exercises
// Run away and look elsewhere, for here be dragons!

public class D1E2Tests {
  @Test
  public void increment() {
    try {
      var counterClass = Class.forName("com.corndel.exercises.Counter");
      var counterConstructor = counterClass.getConstructor();
      var counterFields = counterClass.getDeclaredFields();
      var incrementMethod = counterClass.getMethod("increment");
      var counter = counterConstructor.newInstance();
      counterFields[0].setAccessible(true);
      counterFields[0].setInt(counter, 0);

      incrementMethod.invoke(counter);

      assertThat(counterFields[0].getInt(counter)).isEqualTo(1);
    } catch (Throwable e) {
      fail(e);
    }
  }

  @Test
  public void reset() {
    try {
      var counterClass = Class.forName("com.corndel.exercises.Counter");
      var counterConstructor = counterClass.getConstructor();
      var counterFields = counterClass.getDeclaredFields();
      var resetMethod = counterClass.getMethod("reset");
      var counter = counterConstructor.newInstance();
      counterFields[0].setAccessible(true);
      counterFields[0].setInt(counter, 1);

      resetMethod.invoke(counter);

      assertThat(counterFields[0].getInt(counter)).isEqualTo(0);
    } catch (Throwable e) {
      fail(e);
    }
  }

  @Test
  public void getCount() {
    try {
      var expectedCount = 21;
      var counterClass = Class.forName("com.corndel.exercises.Counter");
      var counterConstructor = counterClass.getConstructor();
      var counterFields = counterClass.getDeclaredFields();
      var getCountMethod = counterClass.getMethod("getCount");
      var counter = counterConstructor.newInstance();
      counterFields[0].setAccessible(true);
      counterFields[0].setInt(counter, expectedCount);

      var count = getCountMethod.invoke(counter);

      assertThat(count).isEqualTo(expectedCount);
    } catch (Throwable e) {
      fail(e);
    }
  }
}
