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
    public void addDepartment(List<Department> departments) {
        this.departments.addAll(departments);
    }

    @Override
    public void updateDepartmentToId(String departmentId, String newName, String newAddress) {
        for (Department department : departments) {
            if (department.getDepartmentId().equals(departmentId)) {
                department.setDepartmentName(newName);
                department.setDepartmentAddress(newAddress);
                System.out.println("✓ Đã cập nhật thông tin phòng ban thành công!");
                return;
            }
        }
        System.out.println("✗ Không tìm thấy phòng ban với mã: " + departmentId);
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
        // Tự động thêm vào department tương ứng
        for (Department dept : departments) {
            if (dept.getDepartmentId().equals(employee.getDepartmentId())) {
                dept.addEmployee(employee);
                break;
            }
        }
    }

    @Override
    public void updateEmployeeToId(Employee employee, String id) {
        for (Employee emp : employees) {
            if (emp.getId().equals(id)) {  // Tìm theo mã ID truyền vào
                // Cập nhật TẤT CẢ thông tin từ employee object
                emp.setName(employee.getName());
                emp.setAge(employee.getAge());
                emp.setAddress(employee.getAddress());
                emp.setBaseSalary(employee.getBaseSalary());
                emp.setPosition(employee.getPosition());
                emp.setDepartmentId(employee.getDepartmentId());
                System.out.println("✓ Đã cập nhật thông tin nhân viên thành công!");
                return;
            }
        }
        System.out.println("✗ Không tìm thấy nhân viên với mã: " + id);
    }

    @Override
    public void showListDepartment() {
        if (departments.isEmpty()) {
            System.out.println("Chưa có phòng ban nào!");
            return;
        }
        for (Department department : departments) {
            department.showInfo();
            System.out.println("--------------------------------");
        }
    }

    @Override
    public void showListEmployeeByDepartment(String departmentId) {
        for (Department department : departments) {
            if (department.getDepartmentId().equals(departmentId)) {
                department.showListEmployee();
                return;
            }
        }
        System.out.println("Không tìm thấy phòng ban với mã: " + departmentId);
    }

    @Override
    public void showListEmployee() {
        if (employees.isEmpty()) {
            System.out.println("Chưa có nhân viên nào!");
            return;
        }
        for (Employee employee : employees) {
            employee.showInfo();
            System.out.println("--------------------------------");
        }
    }

    @Override
    public void showListViceManagerAndManager() {
        boolean found = false;
        for (Employee employee : employees) {
            if (employee instanceof ViceManager || employee instanceof Manager) {
                employee.showInfo();
                System.out.println("--------------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có phó phòng hoặc trưởng phòng nào!");
        }
    }

    @Override
    public void sumSalaryByDepartment(String departmentId) {
        for (Department department : departments) {
            if (department.getDepartmentId().equals(departmentId)) {
                department.sumSalary();
                return;
            }
        }
        System.out.println("Không tìm thấy phòng ban với mã: " + departmentId);
    }
}
