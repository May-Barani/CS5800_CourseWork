package inheritance;

public class CommissionEmployee extends Employee {

    Double commissionRate;
    Double grossSales;

    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, Double commissionRate, Double grossSales) {
        super(firstName, lastName, socialSecurityNumber);
        this.commissionRate = commissionRate;
        this.grossSales = grossSales;
    }

    public Double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public Double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(Double grossSales) {
        this.grossSales = grossSales;
    }

    @Override
    public String toString() {
        return "CommissionEmployee{" +
                " firstName='" + firstName +
                ", lastName='" + lastName + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", commissionRate=" + commissionRate + '%' + '\'' +
                ", grossSales= $" + grossSales + '\'' +
                '}';
    }
}