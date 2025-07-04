package Entity;

public class Staff extends Employee {
    public Staff(String id, String name, int age, String address, int baseSalary, String position, String departmentId) {
        super(id, name, age, address, baseSalary, position, departmentId);
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary();
    }
}
