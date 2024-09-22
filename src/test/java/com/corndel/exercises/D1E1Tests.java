package com.corndel.exercises;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.*;
import org.junit.jupiter.api.Test;

// Hello! These tests use something fancy called "Reflection"
// If you are looking at these to help with Day 3 exercises
// Run away and look elsewhere, for here be dragons!

public class D1E1Tests {
  @Test
  public void CounterIsAClass() {
    try {
      var counterClass = Class.forName("com.corndel.exercises.Counter");
      assertThat(counterClass).isNotNull();
    } catch (Throwable e) {
      fail(e);
    }
  }

  @Test
  public void CountIsAField() {
    try {
      var counterClass = Class.forName("com.corndel.exercises.Counter");
      var counterFields = counterClass.getDeclaredFields();

      assertThat(counterFields.length).isEqualTo(1);
    } catch (Throwable e) {
      fail(e);
    }
  }

  @Test
  public void CounterHasAZeroArgumentConstructor() {
    try {
      var counterClass = Class.forName("com.corndel.exercises.Counter");
      var counterConstructor = counterClass.getConstructor();
      assertThat(counterConstructor).isNotNull();
      assertThat(Modifier.isPublic(counterConstructor.getModifiers())).isTrue();
    } catch (Throwable e) {
      fail(e);
    }
  }

  @Test
  public void CountIsInitialisedToZero() {
    try {
      var counterClass = Class.forName("com.corndel.exercises.Counter");
      var counterConstructor = counterClass.getConstructor();
      var counterFields = counterClass.getDeclaredFields();

      var counter = counterConstructor.newInstance();
      counterFields[0].setAccessible(true);
      var initialCount = counterFields[0].getInt(counter);

      assertThat(initialCount).isEqualTo(0);
    } catch (Throwable e) {
      fail(e);
    }
  }
}
