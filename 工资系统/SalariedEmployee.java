package 工资系统;

/**
 * @Author: Wan Jiangyuan
 * @Description:
 * @Date: Created in 15:46 2020/7/16
 * @E-mail: 15611562852@163.com
 */

public class SalariedEmployee extends Employee{
    private double monthlySalary;

    public SalariedEmployee(String name, int number, MyDate birthday, double monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    @Override
    double earnings() {
        return monthlySalary;
    }


    @Override
    public String toString() {
        return "SalariedEmployee{ " +
                ", name=" + super.getName() +
                ", number=" + super.getNumber() +
                ", monthlySalary=" + monthlySalary +
                ", birthday=" + getBirthday().toDateString() +
                " }";
    }
}
