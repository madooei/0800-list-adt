package employees;

/**
 * A runnable demo of the chapter's OOP arc: inheritance and overriding give each
 * employee its own monthlyPay; type substitution lets a mixed roster share one
 * array; dynamic dispatch runs the right monthlyPay in one loop; composition
 * gives a Manager a team; and the Payable interface spans unrelated types.
 */
public class Main {

  static void printBadge(Employee e) {
    System.out.println(e.name + " (#" + e.id + ")");
  }

  static void cutCheck(Payable p) {
    System.out.println("Pay $" + p.amountDue());
  }

  public static void main(String[] args) {
    // A mixed roster, treated uniformly as Employee (type substitution).
    Employee[] staff = new Employee[3];
    staff[0] = new SalariedEmployee("Ada", 1, 90000);
    staff[1] = new HourlyEmployee("Lin", 2, 30, 160);
    staff[2] = new ContractorEmployee("Sam", 3, 5000);

    // Run payroll with one loop; dynamic dispatch picks each monthlyPay.
    double total = 0;
    for (Employee e : staff) {
      printBadge(e);
      total += e.monthlyPay();
    }
    System.out.println("Total monthly pay: $" + total);
    System.out.println();

    // A Manager is-a Employee and has-a team of reports, which can nest.
    Manager cto = new Manager("Ada", 1, 200000);
    Manager lead = new Manager("Lin", 2, 150000);
    HourlyEmployee dev = new HourlyEmployee("Sam", 3, 50, 160);
    lead.addReport(dev);
    cto.addReport(lead);
    System.out.println(cto.name + " has " + cto.reports.size() + " direct report(s).");
    System.out.println();

    // Payable spans unrelated types: an Employee and a Vendor.
    cutCheck(new SalariedEmployee("Ada", 1, 90000));
    cutCheck(new Vendor("Acme Cloud", 4000));
  }
}
