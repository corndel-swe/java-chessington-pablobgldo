package com.corndel.exercises;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

// Hello! These tests use something fancy called "Reflection"
// If you are looking at these to help with Day 3 exercises
// Run away and look elsewhere, for here be dragons!

public class D1E3Tests {
  @Test
  public void CountIsPrivate() {
    try {
      var counterClass = Class.forName("com.corndel.exercises.Counter");
      var counterFields = counterClass.getDeclaredFields();

      var isAccessible = counterFields[0].canAccess(counterClass.getConstructor().newInstance());

      assertThat(isAccessible).isFalse();
    } catch (Throwable e) {
      fail(e);
    }
  }
}
