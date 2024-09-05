import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchTest {
  private int[] arrayOne;
  private int[] arrayTwo;
  private ArrayList<String> arrayThree;
  private String[] arrayFour;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    arrayOne = new int[]{10, 12, 14, 16, 18, 20};

    arrayTwo = new int[]{13, 17, 18, 19, 24, 27, 32, 54, 58};

    arrayThree = new ArrayList();
    arrayThree.add("always");
    arrayThree.add("can't");
    arrayThree.add("want");
    arrayThree.add("what");
    arrayThree.add("you");

    arrayFour = new String[]{"a", "and", "broken", "burned", "chain", "skin", "to", "waterfall"};
  }

  @org.junit.jupiter.api.AfterEach
  void tearDown() {
    arrayOne = null;
    arrayTwo = null;
    arrayThree = null;
    arrayFour = null;
  }

  @org.junit.jupiter.api.Test
  void linearSearch() {
    assertEquals(-1, Search.linearSearch(arrayOne, 11));
    assertEquals(-1, Search.linearSearch(arrayOne, 15));
    assertEquals(-1, Search.linearSearch(arrayOne, 19));
    assertEquals(-1, Search.linearSearch(arrayOne, 19));
    assertEquals(-1, Search.linearSearch(arrayOne, 21));

    assertEquals(0, Search.linearSearch(arrayOne, 10));
    assertEquals(1, Search.linearSearch(arrayOne, 12));
    assertEquals(2, Search.linearSearch(arrayOne, 14));
    assertEquals(3, Search.linearSearch(arrayOne, 16));
    assertEquals(4, Search.linearSearch(arrayOne, 18));
    assertEquals(5, Search.linearSearch(arrayOne, 20));
  }

  @org.junit.jupiter.api.Test
  void testLinearSearch() {
    assertEquals(-1, Search.linearSearch(arrayThree, "broken"));
    assertEquals(-1, Search.linearSearch(arrayThree, "Always"));
    assertEquals(-1, Search.linearSearch(arrayThree, "ALWAYS"));
    assertEquals(-1, Search.linearSearch(arrayThree, "zebra"));

    assertEquals(0, Search.linearSearch(arrayThree, "always"));
    assertEquals(1, Search.linearSearch(arrayThree, "can't"));
    assertEquals(2, Search.linearSearch(arrayThree, "want"));
    assertEquals(3, Search.linearSearch(arrayThree, "what"));
    assertEquals(4, Search.linearSearch(arrayThree, "you"));
  }

  @org.junit.jupiter.api.Test
  void binarySearch() {
    assertEquals(-1, Search.binarySearch(arrayTwo, 11));
    assertEquals(-1, Search.binarySearch(arrayTwo, 15));
    assertEquals(-1, Search.binarySearch(arrayTwo, 16));
    assertEquals(-1, Search.binarySearch(arrayTwo, 21));
    assertEquals(-1, Search.binarySearch(arrayTwo, 59));

    assertEquals(0, Search.binarySearch(arrayTwo, 13));
    assertEquals(1, Search.binarySearch(arrayTwo, 17));
    assertEquals(2, Search.binarySearch(arrayTwo, 18));
    assertEquals(3, Search.binarySearch(arrayTwo, 19));
    assertEquals(4, Search.binarySearch(arrayTwo, 24));
    assertEquals(5, Search.binarySearch(arrayTwo, 27));
    assertEquals(6, Search.binarySearch(arrayTwo, 32));
    assertEquals(7, Search.binarySearch(arrayTwo, 54));
    assertEquals(8, Search.binarySearch(arrayTwo, 58));
  }

  @org.junit.jupiter.api.Test
  void testBinarySearch() {
    assertEquals(-1, Search.binarySearch(arrayFour, "after"));
    assertEquals(-1, Search.binarySearch(arrayFour, "an"));
    assertEquals(-1, Search.binarySearch(arrayFour, "dan"));
    assertEquals(-1, Search.binarySearch(arrayFour, "chAIN"));
    assertEquals(-1, Search.binarySearch(arrayFour, "TO"));

    assertEquals(0, Search.binarySearch(arrayFour, "a"));
    assertEquals(1, Search.binarySearch(arrayFour, "and"));
    assertEquals(2, Search.binarySearch(arrayFour, "broken"));
    assertEquals(3, Search.binarySearch(arrayFour, "burned"));
    assertEquals(4, Search.binarySearch(arrayFour, "chain"));
    assertEquals(5, Search.binarySearch(arrayFour, "skin"));
    assertEquals(6, Search.binarySearch(arrayFour, "to"));
    assertEquals(7, Search.binarySearch(arrayFour, "waterfall"));
  }
}