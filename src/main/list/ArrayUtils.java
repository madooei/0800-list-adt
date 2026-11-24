package list;

/** A namespace of general-purpose algorithms over a List. */
public final class ArrayUtils {

  private ArrayUtils() {
    // This class is a namespace, not a blueprint — don't instantiate it.
  }

  // Assumes list is not null. Sorts in place by each element's natural order.
  public static <T extends Comparable<T>> void selectionSort(List<T> list) {
    for (int i = 0; i < list.size() - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < list.size(); j++) {
        if (list.get(j).compareTo(list.get(minIndex)) < 0) {
          minIndex = j;
        }
      }
      T temp = list.get(i);
      list.set(i, list.get(minIndex));
      list.set(minIndex, temp);
    }
  }
}
