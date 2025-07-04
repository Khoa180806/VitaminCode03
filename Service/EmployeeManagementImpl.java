package Service;

import Entity.Department;
import Entity.Employee;
import Entity.ViceManager;
import Entity.Manager;
import java.util.*;

public class EmployeeManagementImpl implements EmployeeManagement {
    private List<Department> departments = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    @Override
    public void addDepartment(Department department) {
        departments.add(department);
    }

    @Override
    public void updateEmployeeToDepartment(Employee employee, String departmentId) {
        employee.setDepartmentId(departmentId);
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void updateEmployeeToId(Employee employee, String id) {
        employee.setId(id);
    }

    @Override
    public void showListDepartment() {
        for (Department department : departments) {
            department.showListEmployee();
        }
    }

    @Override
    public void showListEmployeeByDepartment(String departmentId) {
        for (Department department : departments) {
            if (department.getDepartmentId().equals(departmentId)) {
                department.showListEmployee();
            }
        }
    }

    @Override
    public void showListEmployee() {
        for (Department department : departments) {
            department.showListEmployee();
        }
    }

    @Override
    public void showListViceManagerAndManager() {
        for (Employee employee : employees) {
            if (employee instanceof ViceManager || employee instanceof Manager) {
                employee.showInfo();
            }
        }
    }

    @Override
    public void sumSalaryByDepartment(String departmentId) {
        for (Department department : departments) {
            if (department.getDepartmentId().equals(departmentId)) {
                department.sumSalary();
            }
        }
    }
}
