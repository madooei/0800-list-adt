# The List ADT

The chapter separates the `List` *contract* from the structures that implement it, using an interface to unify two otherwise unrelated classes. It then repeats the pattern with a second ADT, `SortedList`.

## Prerequisites

- JDK 17+

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  src/
    main/
      List.java             # the documented List<T> contract
      ArrayList.java        # array-backed List (the renamed DynamicArray)
      LinkedList.java       # node-backed List (from the linked list chapter)
      SortedList.java       # a second ADT: SortedList<T extends Comparable<T>>
      SortedLinkedList.java # sentinel-based linked implementation of SortedList
      Main.java             # one selectionSort over both lists; a SortedList demo
  scripts/
    run.sh                  # compile everything and run the demo
```

## How to compile and run

- `scripts/run.sh` — compiles all source into `out/` and runs `Main`.

There is no build tool and no test suite: testing is introduced later in the course. The script above is all you need.

## What's here

- `List<T>` — the documented contract for an ordered, indexed collection: `add`, `remove`, `get`, `set`, `contains`, `indexOf`, `size`.
- `ArrayList<T>` — an array-backed `List`.
- `LinkedList<T>` — a node-backed `List`, using a private doubly linked `Node`.
- `SortedList<T extends Comparable<T>>` — a second ADT that keeps its elements in ascending order on every insert, with no `set`.
- `SortedLinkedList<T extends Comparable<T>>` — a `SortedList` implementation using two sentinel nodes so insert and remove need no boundary cases.
- `Main` — a runnable demo: one `selectionSort`, written against `List`, sorts both an `ArrayList` and a `LinkedList`; a separate demo exercises `SortedLinkedList`.

A note on `ArrayList.get`: the documented `List` contract promises an `IndexOutOfBoundsException` for an invalid index, so `ArrayList.get` bounds-checks before reading. This is a small addition over the original `DynamicArray.get`, which let the backing array decide.
