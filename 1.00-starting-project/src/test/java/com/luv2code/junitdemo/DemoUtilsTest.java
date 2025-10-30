package com.luv2code.junitdemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DemoUtilsTest {

  DemoUtils demoUtils;

  @BeforeEach
  void setUpBeforeEach() {
    this.demoUtils = new DemoUtils();
    System.out.println("@BeforeEach executes before the execution of each test method.");
  }

  @AfterEach
  void tearDownAfterEach() {
    System.out.println("@AfterEach executes after the execution of each test method.");
    System.out.println();
  }

  @BeforeAll
  static void setupBeforeEachClass() {
    System.out.println("@BeforeAll executes before the execution of all test methods.");
    System.out.println();
  }

  @AfterAll
  static void tearDownAfterEachClass() {
    System.out.println("@AfterAll executes after the execution of all test");
    System.out.println();
  }

  @Test
  void testEqualsAndNotEquals() {
    System.out.println("Running test: testEqualsAndNotEquals");

    assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
    assertNotEquals(6, demoUtils.add(1, 9), "1+9 must not be 6");
  }

  @Test
  void testNullAndNotNull() {
    System.out.println("Running test: testNullAndNotNull");

    String str1 = null;
    String str2 = "Hello";

    assertNull(demoUtils.checkNull(str1), "Object should be null");
    assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
  }
}
