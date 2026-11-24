package demo;

import list.SortedLinkedList;
import list.SortedList;

/** A demo of SortedLinkedList: values added in any order come out sorted. */
public final class SortedLinkedListDemo {

  private SortedLinkedListDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    SortedList<Integer> sorted = new SortedLinkedList<>();
    int[] values = {5, 2, 8, 1, 9, 3, 6};
    for (int value : values) {
      sorted.add(value);
    }

    // Expect 1, 2, 3, 5, 6, 8, 9.
    System.out.println("after adding 5, 2, 8, 1, 9, 3, 6: " + toText(sorted));

    // 8 is the sixth smallest value, so expect index 5.
    System.out.println("indexOf(8): " + sorted.indexOf(8));

    // Expect 1, 2, 3, 5, 6, 9.
    sorted.remove(8);
    System.out.println("after remove(8): " + toText(sorted));
  }

  // The elements of list in order, separated by commas.
  private static String toText(SortedList<Integer> list) {
    String text = "";
    for (int i = 0; i < list.size(); i++) {
      if (i > 0) {
        text += ", ";
      }
      text += list.get(i);
    }
    return text;
  }
}
