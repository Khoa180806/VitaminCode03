package Service;

import Entity.Department;
import Entity.Employee;
import java.util.*;

public interface EmployeeManagement {
    void addDepartment(List<Department> departments);
    void updateDepartmentToId(String departmentId, String newName, String newAddress);
    void addEmployee(Employee employee);
    void updateEmployeeToId(Employee employee, String id);
    void showListDepartment();
    void showListEmployeeByDepartment(String departmentId);
    void showListEmployee();
    void showListViceManagerAndManager();
    void sumSalaryByDepartment(String departmentId);
}
