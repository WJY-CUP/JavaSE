package 开发团队调度系统.view;

import 开发团队调度系统.domain.Employee;
import 开发团队调度系统.service.Data;
import 开发团队调度系统.service.NameListService;
import 开发团队调度系统.service.TeamException;

/**
 * @Author: Wan Jiangyuan
 * @Description:
 * @Date: Created in 16:11 2020/7/17
 * @E-mail: 15611562852@163.com
 */

public class TeamView extends TeamException {

    public static void main(String[] args) {

        NameListService nameListService = new NameListService();
        Employee[] e = new Employee[Data.EMPLOYEES.length];


        char sel = 'a';
        do {
            System.out.println("-------------------------------------开发团队调度软件--------------------------------------\n");
            System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备\n");
            e = nameListService.getAllEmployees();
            for (Employee employee : e) {
                System.out.println(employee.getId() + '\t' + );
            }
        }while (sel == '4');

    }


}
