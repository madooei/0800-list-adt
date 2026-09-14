# The List ADT

The chapter separates the `List` *contract* from the structures that implement it, using the Java tools for that separation — inheritance, overriding, interfaces, type substitution, and polymorphism.

## Prerequisites

- JDK 17+

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  src/
    main/
      employees/            # the OOP motivation: inheritance through to interfaces
        Payable.java        # an interface: a capability shared by unrelated types
        Employee.java       # abstract base; abstract monthlyPay, implements Payable
        SalariedEmployee.java
        HourlyEmployee.java
        ContractorEmployee.java
        Manager.java        # is-a SalariedEmployee, has-a List<Employee> of reports
        Vendor.java         # implements Payable but is not an Employee
        Main.java           # payroll roster, dynamic dispatch, cutCheck demo
      listadt/              # the List ADT and its implementations
        List.java           # the documented List<T> contract
        ArrayList.java      # array-backed List (the renamed DynamicArray)
        LinkedList.java     # node-backed List (from the linked list chapter)
        SortedList.java     # a second ADT: SortedList<T extends Comparable<T>>
        SortedLinkedList.java  # sentinel-based linked implementation of SortedList
        Main.java           # one selectionSort over both lists; a SortedList demo
  scripts/
    run.sh                  # compile everything and run the List ADT demo
    run-employees.sh        # compile everything and run the employees (OOP) demo
```

## How to compile and run

- `scripts/run.sh` — compiles all source into `out/` and runs `listadt.Main`.
- `scripts/run-employees.sh` — compiles all source and runs `employees.Main`.

There is no build tool and no test suite: testing is introduced later in the course. The scripts above are all you need.

## What's here

- `employees.Main` — a runnable demo of the chapter's OOP arc: inheritance and overriding give each employee its own `monthlyPay`, type substitution lets a mixed roster share one array, dynamic dispatch runs the right `monthlyPay` in one loop, composition gives a `Manager` a team, and the `Payable` interface spans unrelated types.
- `listadt.List<T>` — the documented contract for an ordered, indexed collection: `add`, `remove`, `get`, `set`, `contains`, `indexOf`, `size`.
- `listadt.ArrayList<T>` — an array-backed `List`.
- `listadt.LinkedList<T>` — a node-backed `List`, using a private doubly linked `Node`.
- `listadt.SortedList<T extends Comparable<T>>` — a second ADT that keeps its elements in ascending order on every insert, with no `set`.
- `listadt.SortedLinkedList<T extends Comparable<T>>` — a `SortedList` implementation using two sentinel nodes so insert and remove need no boundary cases.
- `listadt.Main` — a runnable demo: one `selectionSort`, written against `List`, sorts both an `ArrayList` and a `LinkedList`; a separate demo exercises `SortedLinkedList`.

A note on `ArrayList.get`: the documented `List` contract promises an `IndexOutOfBoundsException` for an invalid index, so `ArrayList.get` bounds-checks before reading — a small addition over the original `DynamicArray.get`, which let the backing array decide.
