package employees;

public abstract class Employee implements Payable {
  public String name;
  public int id;

  public Employee(String name, int id) {
    this.name = name;
    this.id = id;
  }

  public abstract double monthlyPay();

  @Override
  public double amountDue() {
    return monthlyPay();
  }
}
