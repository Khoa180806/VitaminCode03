package Entity;

public class ViceManager extends Employee {
    private int allowance = 3000000;
    public ViceManager(int allowance, String id, String name, int age, String address, int baseSalary, String position, String departmentId) {
        super(id, name, age, address, baseSalary, position, departmentId);
        this.allowance = allowance;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + allowance;
    }
}