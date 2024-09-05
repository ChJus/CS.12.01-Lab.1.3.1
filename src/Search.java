import java.util.ArrayList;

public class Search {
  public static int linearSearch(int[] array, int value) {
    // Loops through array of elements, returns index
    // if the value at the index matches the search value
    for (int i = 0; i < array.length; i++) {
      if (array[i] == value) return i;
    }

    // Otherwise return a negative index (which should throw an error
    // down the line if it is accessed).
    return -1;
  }

  public static int linearSearch(ArrayList<String> list, String string) {
    // Loops through array of elements, returns index
    // if the value at the index matches the search value.
    // Note the use of Object.equals().
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).equals(string)) return i;
    }

    // Return an illegal index value (could not find value in array)
    return -1;
  }

  public static int binarySearch(int[] array, int value) {
    // NOTE: assumes the array is sorted, unpredictable behavior when
    // duplicate values are present in the array.

    // Performs binary search to look for the value in an array
    // Start with two pointers indicating the possible range in the array
    // that the value may be in.
    int start = 0, end = array.length - 1;
    while (start <= end) {
      int split = (start + end) / 2;

      // We then check the value at the middle of this range
      // 1) Value is less than our search value — we limit our search to between [middle + 1, end]
      // 2) Value is greater than our search value — we limit our search to between [start, middle - 1]
      // 3) The value is at the middle index — return the middle index
      if (array[split] < value) start = split + 1;
      else if (array[split] > value) end = split - 1;
      else return split;
    }

    // Value not found in the array
    return -1;
  }

  // Performs binary search (see notes above) on a String array.
  public static int binarySearch(String[] array, String string) {
    int start = 0, end = array.length - 1;
    while (start <= end) {
      int split = (start + end) / 2;
      if (array[split].compareTo(string) < 0) start = split + 1;
      else if (array[split].compareTo(string) > 0) end = split - 1;
      else return split;
    }

    // Value not found in the array
    return -1;
  }
}
