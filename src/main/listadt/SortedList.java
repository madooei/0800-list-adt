package listadt;

/**
 * A SortedList keeps its non-null elements in ascending order at all times. The
 * position of an element is determined by its value, not by the caller, so there
 * is no way to place a value at a chosen index — and so there is no set.
 *
 * @param <T> the element type; must be Comparable so elements can be ordered.
 */
public interface SortedList<T extends Comparable<T>> {

  /**
   * Insert a value into the position that keeps this list sorted.
   *
   * @param element the non-null value to insert.
   * @throws NullPointerException if element is null.
   */
  void add(T element);

  /**
   * Return the element at the given index, where index 0 is the smallest value.
   *
   * @param index a position from 0 to size() - 1.
   * @return the element at that position.
   * @throws IndexOutOfBoundsException if index < 0 or index >= size().
   */
  T get(int index);

  /**
   * Remove the first occurrence of a value.
   *
   * @param element the value to remove.
   * @return true if a value was removed, false if it was not found.
   */
  boolean remove(T element);

  /**
   * Report whether a value is present in this list.
   *
   * @param element the value to look for.
   * @return true if present, false otherwise.
   */
  boolean contains(T element);

  /**
   * Find the index of the first occurrence of a value.
   *
   * @param element the value to look for.
   * @return the index of the first occurrence, or -1 if not present.
   */
  int indexOf(T element);

  /**
   * Report how many elements are in this list.
   *
   * @return the number of elements; never negative.
   */
  int size();
}
