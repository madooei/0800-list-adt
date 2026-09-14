package employees;

public class HourlyEmployee extends Employee {
  public double hourlyRate;
  public int hoursWorked;

  public HourlyEmployee(String name, int id, double hourlyRate, int hoursWorked) {
    super(name, id);
    this.hourlyRate = hourlyRate;
    this.hoursWorked = hoursWorked;
  }

  @Override
  public double monthlyPay() {
    return hourlyRate * hoursWorked;
  }
}
