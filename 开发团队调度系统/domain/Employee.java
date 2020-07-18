package 开发团队调度系统.domain;

/**
 * @Author: Wan Jiangyuan
 * @Description:
 * @Date: Created in 16:10 2020/7/17
 * @E-mail: 15611562852@163.com
 */

public class Employee {

    private int id;
    private String name;
    private int age;
    private double salary;


    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Employee() {

    }

    @Override
    public String toString() {
        return printInfo();
    }

    public String printInfo() {
        return id + "\t" + name + "\t" + age + "\t\t" +salary + "\t";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }




}
