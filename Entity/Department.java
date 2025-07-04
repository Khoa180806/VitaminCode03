package Entity;

import java.util.*;

public class Department {
    private String departmentId;
    private String departmentName;
    private String departmentAddress;
    private List<Employee> employees;

    public Department(String departmentId, String departmentName, String departmentAddress) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
        this.employees = new ArrayList<>();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void showListEmployee() {
        for (Employee employee : employees) {
            employee.showInfo();
        }
    }

    public void sumSalary() {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.calculateSalary();
        }
        System.out.println("Sum salary: " + sum);
    }
}
