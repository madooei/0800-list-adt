package employees;

public class ContractorEmployee extends Employee {
  public double projectFee;

  public ContractorEmployee(String name, int id, double projectFee) {
    super(name, id);
    this.projectFee = projectFee;
  }

  @Override
  public double monthlyPay() {
    return projectFee;
  }
}
