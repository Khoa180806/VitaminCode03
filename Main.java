import Entity.*;
import Service.*;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeManagement employeeManagement = new EmployeeManagementImpl();
    
    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = getIntInput("Nhập lựa chọn của bạn: ");
            
            switch (choice) {
                case 1:
                    addDepartment();
                    break;
                case 2:
                    updateDepartment();
                    break;
                case 3:
                    addEmployee();
                    break;
                case 4:
                    updateEmployee();
                    break;
                case 5:
                    employeeManagement.showListDepartment();
                    break;
                case 6:
                    showEmployeeByDepartment();
                    break;
                case 7:
                    employeeManagement.showListEmployee();
                    break;
                case 8:
                    employeeManagement.showListViceManagerAndManager();
                    break;
                case 9:
                    calculateSalaryByDepartment();
                    break;
                case 0:
                    System.out.println("Tạm biệt!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn từ 0-9.");
            }
            
            System.out.println("\nNhấn Enter để tiếp tục...");
            scanner.nextLine();
        }
    }
    
    private static void showMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("         HỆ THỐNG QUẢN LÝ NHÂN VIÊN");
        System.out.println("=".repeat(50));
        System.out.println("1. Thêm phòng ban");
        System.out.println("2. Cập nhật thông tin phòng ban");
        System.out.println("3. Thêm nhân viên");
        System.out.println("4. Cập nhật thông tin nhân viên");
        System.out.println("5. Hiển thị danh sách phòng ban");
        System.out.println("6. Hiển thị danh sách nhân viên theo phòng ban");
        System.out.println("7. Hiển thị danh sách nhân viên toàn công ty");
        System.out.println("8. Hiển thị danh sách phó phòng, trưởng phòng");
        System.out.println("9. Tính tổng lương của từng phòng");
        System.out.println("0. Thoát");
        System.out.println("=".repeat(50));
    }
    
    private static void addDepartment() {
        System.out.println("\n--- THÊM PHÒNG BAN ---");
        System.out.print("Nhập mã phòng ban: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên phòng ban: ");
        String name = scanner.nextLine();
        System.out.print("Nhập địa chỉ phòng ban: ");
        String address = scanner.nextLine();
        
        Department department = new Department(id, name, address);
        List<Department> deptList = new ArrayList<>();
        deptList.add(department);
        employeeManagement.addDepartment(deptList);
        System.out.println("✓ Đã thêm phòng ban thành công!");
    }
    
    private static void updateDepartment() {
        System.out.println("\n--- CẬP NHẬT PHÒNG BAN ---");
        System.out.print("Nhập mã phòng ban cần cập nhật: ");
        String departmentId = scanner.nextLine();
        
        System.out.print("Nhập tên phòng ban mới: ");
        String newName = scanner.nextLine();
        System.out.print("Nhập địa chỉ phòng ban mới: ");
        String newAddress = scanner.nextLine();
        
        employeeManagement.updateDepartmentToId(departmentId, newName, newAddress);
    }
    
    private static void addEmployee() {
        System.out.println("\n--- THÊM NHÂN VIÊN ---");
        
        System.out.print("Nhập mã nhân viên: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên nhân viên: ");
        String name = scanner.nextLine();
        int age = getIntInput("Nhập tuổi: ");
        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        int baseSalary = getIntInput("Nhập lương cơ bản: ");
        System.out.print("Nhập chức vụ: ");
        String position = scanner.nextLine();
        System.out.print("Nhập mã phòng ban: ");
        String departmentId = scanner.nextLine();
        
        System.out.println("\nChọn loại nhân viên:");
        System.out.println("1. Nhân viên (Staff)");
        System.out.println("2. Phó phòng (Vice Manager)");
        System.out.println("3. Trưởng phòng (Manager)");
        int type = getIntInput("Lựa chọn: ");
        
        Employee employee = null;
        try {
            switch (type) {
                case 1:
                    employee = new Staff(id, name, age, address, baseSalary, position, departmentId);
                    break;
                case 2:
                    int viceAllowance = getIntInput("Nhập phụ cấp phó phòng: ");
                    employee = new ViceManager(viceAllowance, id, name, age, address, baseSalary, position, departmentId);
                    break;
                case 3:
                    int managerAllowance = getIntInput("Nhập phụ cấp trưởng phòng: ");
                    employee = new Manager(managerAllowance, id, name, age, address, baseSalary, position, departmentId);
                    break;
                default:
                    System.out.println("✗ Loại nhân viên không hợp lệ!");
                    return;
            }
            
            employeeManagement.addEmployee(employee);
            System.out.println("✓ Đã thêm nhân viên thành công!");
            
        } catch (Exception e) {
            System.out.println("✗ Lỗi khi thêm nhân viên: " + e.getMessage());
        }
    }
    
    private static void updateEmployee() {
        System.out.println("\n--- CẬP NHẬT THÔNG TIN NHÂN VIÊN ---");
        System.out.print("Nhập mã nhân viên cần cập nhật: ");
        String employeeId = scanner.nextLine();
        
        // Nhập thông tin mới
        System.out.println("\nNhập thông tin mới:");
        System.out.print("Nhập tên nhân viên: ");
        String name = scanner.nextLine();
        int age = getIntInput("Nhập tuổi: ");
        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        int baseSalary = getIntInput("Nhập lương cơ bản: ");
        System.out.print("Nhập chức vụ: ");
        String position = scanner.nextLine();
        System.out.print("Nhập mã phòng ban: ");
        String departmentId = scanner.nextLine();
        
        System.out.println("\nChọn loại nhân viên:");
        System.out.println("1. Nhân viên (Staff)");
        System.out.println("2. Phó phòng (Vice Manager)");
        System.out.println("3. Trưởng phòng (Manager)");
        int type = getIntInput("Lựa chọn: ");
        
        Employee updatedEmployee = null;
        try {
            switch (type) {
                case 1:
                    updatedEmployee = new Staff(employeeId, name, age, address, baseSalary, position, departmentId);
                    break;
                case 2:
                    int viceAllowance = getIntInput("Nhập phụ cấp phó phòng: ");
                    updatedEmployee = new ViceManager(viceAllowance, employeeId, name, age, address, baseSalary, position, departmentId);
                    break;
                case 3:
                    int managerAllowance = getIntInput("Nhập phụ cấp trưởng phòng: ");
                    updatedEmployee = new Manager(managerAllowance, employeeId, name, age, address, baseSalary, position, departmentId);
                    break;
                default:
                    System.out.println("✗ Loại nhân viên không hợp lệ!");
                    return;
            }
            
            // Cập nhật thông tin nhân viên
            employeeManagement.updateEmployeeToId(updatedEmployee, employeeId);
            
        } catch (Exception e) {
            System.out.println("✗ Lỗi khi cập nhật nhân viên: " + e.getMessage());
        }
    }
    
    private static void showEmployeeByDepartment() {
        System.out.println("\n--- DANH SÁCH NHÂN VIÊN THEO PHÒNG BAN ---");
        System.out.print("Nhập mã phòng ban: ");
        String departmentId = scanner.nextLine();
        System.out.println("Danh sách nhân viên của phòng ban " + departmentId + ":");
        System.out.println("-".repeat(40));
        employeeManagement.showListEmployeeByDepartment(departmentId);
    }
    
    private static void calculateSalaryByDepartment() {
        System.out.println("\n--- TÍNH TỔNG LƯƠNG THEO PHÒNG BAN ---");
        System.out.print("Nhập mã phòng ban: ");
        String departmentId = scanner.nextLine();
        System.out.println("\nKết quả tính toán:");
        System.out.println("-".repeat(40));
        employeeManagement.sumSalaryByDepartment(departmentId);
        System.out.println("-".repeat(40));
    }
    
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("✗ Vui lòng nhập một số nguyên hợp lệ!");
            }
        }
    }
}
