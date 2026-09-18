import java.util.Objects;

/**
 * A linked-node implementation of the SortedList ADT.
 *
 * @param <T> the element type; must be Comparable so elements can be ordered.
 */
public class SortedLinkedList<T extends Comparable<T>> implements SortedList<T> {

  private Node<T> head;  // front sentinel
  private Node<T> tail;  // back sentinel
  private int size;  // number of real nodes

  private static class Node<T> {
    T value;
    Node<T> next;
    Node<T> prev;

    Node(T value) {
      this.value = value;
    }
  }

  public SortedLinkedList() {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public int size() {
    return size;
  }

  private Node<T> insertBetween(T value, Node<T> before, Node<T> after) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public void add(T value) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public T get(int index) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public int indexOf(T value) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public boolean contains(T value) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  @Override
  public boolean remove(T value) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }
}
