package inheritance;

public class BaseEmployee extends Employee{
    Double baseSalary;

    public BaseEmployee(String firstName, String lastName, String socialSecurityNumber, Double baseSalary) {
        super(firstName, lastName, socialSecurityNumber);
        this.baseSalary = baseSalary;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return "BaseEmployee{" +
                " firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", baseSalary= $" + baseSalary + '\'' +
                '}';
    }
}