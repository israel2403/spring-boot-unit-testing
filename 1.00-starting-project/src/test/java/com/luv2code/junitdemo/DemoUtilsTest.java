package com.luv2code.junitdemo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestMethodOrder(MethodOrderer.MethodName.class)
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
  void test_equals_and_not_equals() {
    System.out.println("Running test: testEqualsAndNotEquals");

    assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
    assertNotEquals(6, demoUtils.add(1, 9), "1+9 must not be 6");
  }

  @Test
  void test_null_and_not_null() {
    System.out.println("Running test: testNullAndNotNull");

    String str1 = null;
    String str2 = "Hello";

    assertNull(demoUtils.checkNull(str1), "Object should be null");
    assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
  }

  @Test
  void test_same_and_not_same() {
    String str = "luv2code";
    assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Objects should refere to the same object");
    assertNotSame(str, demoUtils.getAcademy(), "Objects should not refer to the same object");
  }

  @Test
  void test_true_false() {
    int gradeOne = 10;
    int gradeTwo = 5;
    assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "This should return true");
    assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "This should return false");
  }

  @Test
  void test_array_equals() {
    // Arrange
    String[] stringArray = { "A", "B", "C" };

    // Act
    String[] firstThreeLettersOfAlphabet = demoUtils.getFirstThreeLettersOfAlphabet();

    // Assert
    assertArrayEquals(stringArray, firstThreeLettersOfAlphabet, "Arrays should be equal");
  }

  @Test
  void test_iterable_equals() {
    // Arrange
    List<String> expected = List.of("luv", "2", "code");

    // Act
    List<String> actual = demoUtils.getAcademyInList();

    // Assert
    assertIterableEquals(expected, actual, "Lists should be equal");
  }

  @Test
  void test_lines_match() {
    // Arrange
    List<String> expected = List.of("luv", "2", "code");

    // Act
    List<String> actual = demoUtils.getAcademyInList();

    // Assert
    assertLinesMatch(expected, actual, "Lists should match");
  }

  @Test
  void test_throws_and_does_not_throw() {
    assertThrows(Exception.class, () -> {
      demoUtils.throwException(-1);
    }, "Should throw an exception");

    assertDoesNotThrow(() -> {
      demoUtils.throwException(1);
    }, "Should not throw an exception");
  }

  @Test
  void test_timeout() {
    assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
      demoUtils.checkTimeout();
    }, "Method should execute in 3 secs");
  }
}
