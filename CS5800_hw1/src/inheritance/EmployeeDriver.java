package inheritance;

public class EmployeeDriver {

	public static void main(String[] args) {
        SalariedEmployee salariedEmployee1 = new SalariedEmployee("Joe","Jones","111-11-1111",2500.0);
        HourlyEmployee hourlyEmployee1 =  new HourlyEmployee("Stephanie","Smith","222-22-2222",25.0,32);
        HourlyEmployee hourlyEmployee2 =  new HourlyEmployee("Mary","Quinn","333-33-3333",19.0,47);
        CommissionEmployee commissionEmployee1 =  new CommissionEmployee("Nicole","Dior","444-44-4444",15.0,50000.0);
        SalariedEmployee salariedEmployee2 = new SalariedEmployee("Renwa","Chanel","555-55-5555",1700.0);
        BaseEmployee baseEmployee =  new BaseEmployee("Mike","Davenport","666-66-6666",95000.0);
        CommissionEmployee commissionEmployee2 =  new CommissionEmployee("Mahnaz","Vaziri","777-77-7777",22.0,40000.0);
        System.out.println("Printing object details using .toString() method");
        System.out.println(salariedEmployee1 +"\n"+ hourlyEmployee1+"\n"+hourlyEmployee2+"\n"+commissionEmployee1+"\n"+ salariedEmployee2+"\n"+ commissionEmployee2+"\n"+baseEmployee+"\n");

        System.out.println("Printing object details using accessors and mutators method");
        printSalariedEmployee(salariedEmployee1);
        printSalariedEmployee(salariedEmployee2);

        printHourlyEmployee(hourlyEmployee1);
        printHourlyEmployee(hourlyEmployee2);

        printCommissionEmployee(commissionEmployee1);
        printCommissionEmployee(commissionEmployee2);

        printBaseEmployee(baseEmployee);

}

    public static void printSalariedEmployee(SalariedEmployee salariedEmployee){
        System.out.println("--- Printing Salaried Employee ---");
        printEmployeeBasicInfo(salariedEmployee);
        System.out.println("Weekly Salary : " + salariedEmployee.getWeeklySalary());
    }

    public static void printEmployeeBasicInfo(Employee employee){
        System.out.println("First Name : " + employee.getFirstName());
        System.out.println("Last Name : " + employee.getLastName());
        System.out.println("Social Security Number : " + employee.getSocialSecurityNumber());
    }

    public static void printHourlyEmployee(HourlyEmployee hourlyEmployee){
        System.out.println("--- Printing Hourly Employee ---");
        printEmployeeBasicInfo(hourlyEmployee);
        System.out.println("Wage : " + hourlyEmployee.getWage());
        System.out.println("Number of Hours Worked : " + hourlyEmployee.getNumberOfHoursWorked());
    }

    public static void printCommissionEmployee(CommissionEmployee commissionEmployee){
        System.out.println("--- Printing Commission Employee ---");
        printEmployeeBasicInfo(commissionEmployee);
        System.out.println("Commission Rate : " + commissionEmployee.getCommissionRate());
        System.out.println("Gross Sales: " + commissionEmployee.getGrossSales());
    }

    public static void printBaseEmployee(BaseEmployee baseEmployee){
        System.out.println("--- Printing Base Employee ---");
        printEmployeeBasicInfo(baseEmployee);
        System.out.println("Weekly Salary : " + baseEmployee.getBaseSalary());
    }


	}

