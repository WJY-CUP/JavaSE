package 工资系统;

/**
 * @Author: Wan Jiangyuan
 * @Description:
 * @Date: Created in 15:47 2020/7/16
 * @E-mail: 15611562852@163.com
 */

public class HourlyEmployee extends Employee{

    private double wage;
    private int hour;

    public HourlyEmployee(String name, int number, MyDate birthday, double wage, int hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    @Override
    double earnings() {
        return wage*hour;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "name=" + super.getName() +
                ", number=" + super.getNumber() +
                ", wage=" + wage +
                ", hour=" + hour +
                ", birthday=" + getBirthday().toDateString() +
                " }";
    }
}
