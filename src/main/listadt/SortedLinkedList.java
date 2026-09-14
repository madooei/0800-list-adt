package listadt;

import java.util.Objects;

/**
 * A linked-node implementation of the SortedList ADT.
 *
 * @param <T> the element type; must be Comparable so elements can be ordered.
 */
public class SortedLinkedList<T extends Comparable<T>> implements SortedList<T> {

  private Node<T> head;   // front sentinel
  private Node<T> tail;   // back sentinel
  private int size;       // number of real nodes

  public SortedLinkedList() {
    head = new Node<>(null);
    tail = new Node<>(null);
    head.next = tail;
    tail.prev = head;
    size = 0;
  }

  @Override
  public void add(T value) {
    if (value == null) {
      throw new NullPointerException();
    }
    Node<T> current = head.next;
    while (current != tail && current.value.compareTo(value) <= 0) {
      current = current.next;
    }
    insertBetween(value, current.prev, current);
  }

  @Override
  public T get(int index) {
    return node(index).value;
  }

  @Override
  public int indexOf(T value) {
    Node<T> current = head.next;
    int index = 0;
    while (current != tail) {
      if (Objects.equals(current.value, value)) {
        return index;
      }
      current = current.next;
      index++;
    }
    return -1;
  }

  @Override
  public boolean contains(T value) {
    return indexOf(value) != -1;
  }

  @Override
  public boolean remove(T value) {
    Node<T> current = head.next;
    while (current != tail) {
      if (Objects.equals(current.value, value)) {
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return true;
      }
      current = current.next;
    }
    return false;
  }

  @Override
  public int size() {
    return size;
  }

  private Node<T> insertBetween(T value, Node<T> before, Node<T> after) {
    Node<T> node = new Node<>(value);
    node.prev = before;
    node.next = after;
    before.next = node;
    after.prev = node;
    size++;
    return node;
  }

  private Node<T> node(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    Node<T> current = head.next;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    return current;
  }

  private static class Node<T> {
    T value;
    Node<T> next;
    Node<T> prev;

    Node(T value) {
      this.value = value;
    }
  }
}
