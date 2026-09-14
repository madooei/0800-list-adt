package employees;

public class SalariedEmployee extends Employee {
  public double annualSalary;

  public SalariedEmployee(String name, int id, double annualSalary) {
    super(name, id);
    this.annualSalary = annualSalary;
  }

  @Override
  public double monthlyPay() {
    return annualSalary / 12;
  }
}
