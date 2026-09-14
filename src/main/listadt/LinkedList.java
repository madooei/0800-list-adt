package listadt;

import java.util.Objects;

/**
 * A node-backed implementation of the List ADT.
 *
 * @param <T> the type of element stored in this list.
 */
public class LinkedList<T> implements List<T> {

  private Node<T> head;
  private Node<T> tail;
  private int size;

  public LinkedList() {
    head = null;
    tail = null;
    size = 0;
  }

  @Override
  public void add(T value) {
    Node<T> newNode = new Node<>(value);
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.prev = tail;
      tail.next = newNode;
      tail = newNode;
    }
    size++;
  }

  @Override
  public T get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    return node(index).value;
  }

  @Override
  public void set(int index, T value) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    node(index).value = value;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean contains(T value) {
    return indexOf(value) != -1;
  }

  @Override
  public int indexOf(T value) {
    Node<T> current = head;
    int index = 0;
    while (current != null) {
      if (Objects.equals(current.value, value)) {
        return index;
      }
      current = current.next;
      index++;
    }
    return -1;
  }

  @Override
  public boolean remove(T value) {
    int index = indexOf(value);
    if (index == -1) {
      return false;
    }
    removeAt(index);
    return true;
  }

  // Pre: index is a valid index.
  private void removeAt(int index) {
    Node<T> target = node(index);

    if (target.prev == null) {
      head = target.next;
    } else {
      target.prev.next = target.next;
    }

    if (target.next == null) {
      tail = target.prev;
    } else {
      target.next.prev = target.prev;
    }

    size--;
  }

  private Node<T> node(int index) {
    if (index < size / 2) {
      Node<T> current = head;
      for (int i = 0; i < index; i++) {
        current = current.next;
      }
      return current;
    } else {
      Node<T> current = tail;
      for (int i = size - 1; i > index; i--) {
        current = current.prev;
      }
      return current;
    }
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
