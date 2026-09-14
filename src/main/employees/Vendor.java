package employees;

public class Vendor implements Payable {
  public String company;
  public double invoiceTotal;

  public Vendor(String company, double invoiceTotal) {
    this.company = company;
    this.invoiceTotal = invoiceTotal;
  }

  @Override
  public double amountDue() {
    return invoiceTotal;
  }
}
