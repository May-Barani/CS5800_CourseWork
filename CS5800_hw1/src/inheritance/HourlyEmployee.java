package inheritance;

public class HourlyEmployee extends Employee {
    Double wage;
    int numberOfHoursWorked;

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, Double wage, int numberOfHoursWorked) {
        super(firstName, lastName, socialSecurityNumber);
        this.wage = wage;
        this.numberOfHoursWorked = numberOfHoursWorked;
    }

    public Double getWage() {
        return wage;
    }

    public void setWage(Double wage) {
        this.wage = wage;
    }

    public int getNumberOfHoursWorked() {
        return numberOfHoursWorked;
    }

    public void setNumberOfHoursWorked(int numberOfHoursWorked) {
        this.numberOfHoursWorked = numberOfHoursWorked;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                " firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", wage= $" + wage +
                ", numberOfHoursWorked=" + numberOfHoursWorked +
                '}';
    }
}