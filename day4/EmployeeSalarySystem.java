package day4;

public class EmployeeSalarySystem {

    public int salary(int basicSalary, int bonus) {
        return basicSalary + bonus;
    }

    public int salary(int basicSalary, int bonus, int overtime) {
        return basicSalary + bonus + overtime;
    }

    public double salary(double basicSalary, double bonus) {
        return basicSalary + bonus;
    }

    public String salary(String employeeName, String department) {
        return "Employee: " + employeeName + 
               ", Department: " + department;
    }

    public static void main(String[] args) {

        EmployeeSalarySystem emp = new EmployeeSalarySystem();

        System.out.println("Total Salary: " + 
                emp.salary(25000, 5000));

        System.out.println("Total Salary with Overtime: " + 
                emp.salary(30000, 4000, 2000));

        System.out.println("Double Salary Calculation: " + 
                emp.salary(45000.50, 5500.75));

        System.out.println(emp.salary("Aditya", "IT"));
    }
}