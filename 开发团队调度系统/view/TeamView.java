package 开发团队调度系统.view;

import 开发团队调度系统.domain.Employee;
import 开发团队调度系统.domain.Programmer;
import 开发团队调度系统.service.Data;
import 开发团队调度系统.service.NameListService;
import 开发团队调度系统.service.TeamException;
import 开发团队调度系统.service.TeamService;

/**
 * @Author: Wan Jiangyuan
 * @Description:
 * @Date: Created in 16:11 2020/7/17
 * @E-mail: 15611562852@163.com
 */

public class TeamView extends TeamException {

    NameListService nameListService = new NameListService();
    TeamService teamService = new TeamService();


    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }

    private void enterMainMenu() {
        boolean isLoop = true;
        do {
            isLoop = true;
            System.out.println("-------------------------------------开发团队调度软件--------------------------------------\n");
            System.out.println("1-公司员工列表  2-开发团队列表 3-添加团队成员  4-删除团队成员 5-退出   请选择(1-5)：");
            char s = TSUtility.readMenuSelection();
            switch (s) {
                case '1':
                    listAllEmployees();
                    break;
                case '2':
                    getTeam();
                    break;
                case '3':
                    addMember();
                    break;
                case '4':
                    deleteMember();
                    break;
                case '5':
                    isLoop = false;
                    break;
            }
        }while (isLoop);
    }

    private void listAllEmployees() {
        System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备\n");
        for (Employee employee : nameListService.getAllEmployees()) {
            System.out.println(employee.toString());
            System.out.println();
        }
    }

    private void getTeam() {
        System.out.println("--------------------团队成员列表---------------------\n");
        System.out.println("TDI/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票\n");
        Programmer[] p = teamService.getTeam();
        try {
            for (Programmer programmer : p) {
                System.out.println(programmer.toString());
            }
        } catch (Exception e) {
            System.out.println("团队暂无成员，请先加入成员");
        }
    }

    private void addMember() {
        System.out.println("请输入要添加的员工ID：");
        int id = TSUtility.readInt();
        try {
            Employee employee = nameListService.getEmployee(id);
            teamService.addMember(employee);
        } catch (TeamException e) {
            System.out.println("添加失败，原因： " + e.getMessage());
        }
        TSUtility.readReturn();
    }

    private void deleteMember() {

    }


}
