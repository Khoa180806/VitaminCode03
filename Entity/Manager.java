package Entity;

public class Manager extends Employee {
    private int allowance = 5000000;
    public Manager(int allowance, String id, String name, int age, String address, int baseSalary, String position, String departmentId) {
        super(id, name, age, address, baseSalary, position, departmentId);
        this.allowance = allowance;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + allowance;
    }
}
