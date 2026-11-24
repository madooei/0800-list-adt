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
      list/
        List.java               # the documented List<T> contract
        ArrayList.java          # array-backed List (the renamed DynamicArray)
        LinkedList.java         # node-backed List (from the linked list chapter)
        ArrayUtils.java         # one selectionSort, written against List
        SortedList.java         # a second ADT: SortedList<T extends Comparable<T>>
        SortedLinkedList.java   # sentinel-based linked implementation of SortedList
      demo/
        SortedLinkedListDemo.java
  scripts/
    run.sh                      # compile everything and run one demo
```

## How to compile and run

- `scripts/run.sh demo.SortedLinkedListDemo` — compiles all source into `out/` and runs that one demo. Every class you implement has its own demo.

There is no build tool and no test suite: testing is introduced later in the course. The script above is all you need.

## Contents

- `list.List<T>` — the documented contract for an ordered, indexed collection: `add`, `remove`, `get`, `set`, `contains`, `indexOf`, `size`.
- `list.ArrayList<T>` — an array-backed `List`.
- `list.LinkedList<T>` — a node-backed `List`, using a private doubly linked `Node`.
- `list.SortedList<T extends Comparable<T>>` — a second ADT that keeps its elements in ascending order on every insert, with no `set`.
- `list.SortedLinkedList<T extends Comparable<T>>` — a `SortedList` implementation using two sentinel nodes so insert and remove need no boundary cases.
- `list.ArrayUtils` — `selectionSort`, written once against `List`, so it sorts an `ArrayList` and a `LinkedList` alike.
- `demo.SortedLinkedListDemo` — the demo of `SortedLinkedList`: values added in any order come out sorted.

A note on `ArrayList.get`: the documented `List` contract promises an `IndexOutOfBoundsException` for an invalid index, so `ArrayList.get` bounds-checks before reading. This is a small addition over the original `DynamicArray.get`, which let the backing array decide.
