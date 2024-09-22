package com.corndel.exercises;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.*;
import org.junit.jupiter.api.Test;

// Hello! These tests use something fancy called "Reflection"
// If you are looking at these to help with Day 3 exercises
// Run away and look elsewhere, for here be dragons!

public class D2E1Tests {
  @Test
  public void PiExists() {
    try {
      var c = Class.forName("com.corndel.exercises.Maths");
      var f = c.getField("PI");
      assertThat(f).isNotNull();
    } catch (Throwable e) {
      fail(e);
    }
  }
  @Test
  public void PiIsStatic() {
    try {
      var c = Class.forName("com.corndel.exercises.Maths");
      var f = c.getField("PI");
      var m = f.getModifiers();
      assertThat(Modifier.isStatic(m)).isTrue();
    } catch (Throwable e) {
      fail(e);
    }
  }

  @Test
  public void PiIsCorrectValue() {
    try {
      var c = Class.forName("com.corndel.exercises.Maths");
      var f = c.getField("PI");

      assertThat(f.getDouble(c)).isEqualTo(3.14);
    } catch (Throwable e) {
      fail(e);
    }
  }

  @Test
  public void MaxExists() {
    try {
      var c = Class.forName("com.corndel.exercises.Maths");
      var m = c.getMethod("max", double.class, double.class);

      assertThat(m).isNotNull();
    } catch (Throwable e) {
      fail(e);
    }
  }

  @Test
  public void MaxIsStatic() {
    try {
      var c = Class.forName("com.corndel.exercises.Maths");
      var m = c.getMethod("max", double.class, double.class);
      var mod = m.getModifiers();

      assertThat(Modifier.isStatic(mod)).isTrue();
    } catch (Throwable e) {
      fail(e);
    }
  }

  @Test
  public void MaxReturnsFirstValueIfGreater() {
    try {
      var v1 = 1.5;
      var v2 = 0.7;
      var c = Class.forName("com.corndel.exercises.Maths");
      var m = c.getMethod("max", double.class, double.class);

      var result = m.invoke(c, v1, v2);

      assertThat(result).isEqualTo(v1);
    } catch (Throwable e) {
      fail(e);
    }
  }

  @Test
  public void MaxReturnsSecondValueIfGreater() {
    try {
      var v1 = 0.5;
      var v2 = 0.7;
      var c = Class.forName("com.corndel.exercises.Maths");
      var m = c.getMethod("max", double.class, double.class);

      var result = m.invoke(c, v1, v2);

      assertThat(result).isEqualTo(v2);
    } catch (Throwable e) {
      fail(e);
    }
  }
}
