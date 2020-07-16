package 工资系统;

import ObjectOriented.test_static;

import java.util.Scanner;

/**
 * @Author: Wan Jiangyuan
 * @Description:
 * @Date: Created in 15:47 2020/7/16
 * @E-mail: 15611562852@163.com
 */

public class PayrollSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入本月月份：");
        int month = scanner.nextInt();
        Employee[] e = new Employee[2];
        e[0] = new SalariedEmployee("马森", 1002,new MyDate(1992, 2, 28),10000);
        e[1] = new HourlyEmployee("潘雨生", 2001, new MyDate(1991, 1, 6),60,240);


        for (Employee employee : e) {
            if (month == employee.getBirthday().getMonth()) {
                System.out.println(employee);
                double newSalary = employee.earnings() + 100;
                System.out.println("过生日员工的新工资为: " + newSalary);
            }

        }


    }
}
