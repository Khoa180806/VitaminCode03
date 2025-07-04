package Service;

import Entity.Department;
import Entity.Employee;

public interface EmployeeManagement {
    void addDepartment(Department department);
    void updateEmployeeToDepartment(Employee employee, String departmentId);
    void addEmployee(Employee employee);
    void updateEmployeeToId(Employee employee, String id);
    void showListDepartment();
    void showListEmployeeByDepartment(String departmentId);
    void showListEmployee();
    void showListViceManagerAndManager();
    void sumSalaryByDepartment(String departmentId);
}
