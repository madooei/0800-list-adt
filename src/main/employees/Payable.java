package employees;

/**
 * A capability contract: anything Payable can report the amount it is owed.
 * Unrelated classes (an Employee and a Vendor) can both implement it.
 */
interface Payable {
  double amountDue();
}
