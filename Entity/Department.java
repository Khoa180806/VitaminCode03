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

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public List<Employee> getEmployees() {
        return employees;
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
        System.out.println("Tổng tiền lương: " + sum);
    }

    public void showInfo() {
        System.out.println("Department ID: " + departmentId);
        System.out.println("Department Name: " + departmentName);
        System.out.println("Department Address: " + departmentAddress);
    }   
}
