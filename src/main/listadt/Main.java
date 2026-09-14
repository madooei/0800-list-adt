package listadt;

/**
 * A runnable demo of the chapter's List ADT arc. One selectionSort, written
 * against the List interface, sorts both an ArrayList and a LinkedList. The
 * SortedList ADT keeps its order on every insert, with a SortedLinkedList behind
 * the contract.
 */
public class Main {

  // One sort, written against the List interface; works on any implementation.
  static <T extends Comparable<T>> void selectionSort(List<T> list) {
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

  static void printList(List<Integer> list) {
    for (int i = 0; i < list.size(); i++) {
      if (i < list.size() - 1) {
        System.out.print(list.get(i) + ", ");
      } else {
        System.out.print(list.get(i));
      }
    }
    System.out.println();
  }

  public static void main(String[] args) {
    // The same selectionSort sorts either implementation: program to the
    // interface, and the concrete type is chosen only at the new.
    List<Integer> a = new ArrayList<>();
    List<Integer> b = new LinkedList<>();
    int[] values = {5, 2, 8, 1, 9, 3};
    for (int v : values) {
      a.add(v);
      b.add(v);
    }

    selectionSort(a);   // sorts an ArrayList
    selectionSort(b);   // sorts a LinkedList — the same method
    System.out.print("ArrayList sorted:  ");
    printList(a);
    System.out.print("LinkedList sorted: ");
    printList(b);
    System.out.println();

    // The SortedList ADT keeps order on every insert.
    SortedList<Integer> s = new SortedLinkedList<>();
    int[] toInsert = {5, 2, 8, 1, 9, 3, 6};
    for (int v : toInsert) {
      s.add(v);
    }
    System.out.print("SortedLinkedList:  ");
    for (int i = 0; i < s.size(); i++) {
      if (i < s.size() - 1) {
        System.out.print(s.get(i) + ", ");
      } else {
        System.out.print(s.get(i));
      }
    }
    System.out.println();
    System.out.println("indexOf(8) = " + s.indexOf(8));
    s.remove(8);
    System.out.println("after remove(8), contains(8) = " + s.contains(8));
  }
}
