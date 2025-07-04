package Entity;

public abstract class Employee {
    private String id;
    private String name;
    private int age;
    private String address;
    private int baseSalary;
    private String position;
    private String departmentId;

    public Employee(String id, String name, int age, String address, int baseSalary, String position, String departmentId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.baseSalary = baseSalary;
        this.position = position;
        this.departmentId = departmentId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public abstract double calculateSalary();

    public void showInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Position: " + position);
        System.out.println("Department ID: " + departmentId);
    }
}