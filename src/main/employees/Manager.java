package employees;

import listadt.List;
import listadt.LinkedList;

public class Manager extends SalariedEmployee {
  public List<Employee> reports;

  public Manager(String name, int id, double annualSalary) {
    super(name, id, annualSalary);
    this.reports = new LinkedList<>();
  }

  public void addReport(Employee e) {
    reports.add(e);
  }
}
