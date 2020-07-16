package 工资系统;

/**
 * @Author: Wan Jiangyuan
 * @Description:
 * @Date: Created in 15:46 2020/7/16
 * @E-mail: 15611562852@163.com
 */

public abstract class Employee {
    private String name;
    private int number;
    private MyDate birthday;

    public Employee(String name, int number, MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    abstract double earnings();

    @Override
    public abstract String toString();
}
