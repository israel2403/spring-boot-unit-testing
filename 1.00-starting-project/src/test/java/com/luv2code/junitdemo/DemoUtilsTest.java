package com.luv2code.junitdemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DemoUtilsTest {

  @Test
  void testEqualsAndNotEquals() {
    DemoUtils demoUtils = new DemoUtils();

    assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
    assertNotEquals(6, demoUtils.add(1, 9), "1+9 must not be 6");
  }
}
