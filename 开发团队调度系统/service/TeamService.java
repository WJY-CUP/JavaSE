package 开发团队调度系统.service;

import sun.security.krb5.internal.crypto.Des;
import 开发团队调度系统.domain.Architect;
import 开发团队调度系统.domain.Designer;
import 开发团队调度系统.domain.Employee;
import 开发团队调度系统.domain.Programmer;

/**
 * @Author: Wan Jiangyuan
 * @Description:
 * @Date: Created in 16:11 2020/7/17
 * @E-mail: 15611562852@163.com
 */

public class TeamService {
    private static int counter = 1;
    final static int MAX_MEMBER = 5;
    Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;
    private int[] number = new int[]{0,0,0};

    public TeamService() {

    }

    public Programmer[] getTeam() {
        return team;
    }

    public void addMember(Employee e) throws TeamException {
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加");
        }
        if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }

        if (total > 0) {
            for (Programmer p : team) {
                if (p != null && p.getId() == e.getId()) {
                    throw new TeamException("该员工已在本开发团队中");
                }
            }
        }
        Programmer programmer = (Programmer)e;
        if (programmer.getStatus().equals(Status.VOCATION)) {
            throw new TeamException("该员正在休假，无法添加");
        } else if (programmer.getStatus().equals(Status.BUSY)) {
            throw new TeamException("该员工已是某团队成员");
        }

        if (programmer instanceof Architect) {
            if (number[2] == 1) {
                throw new TeamException("团队中至多只能有一名架构师");
            } else {
                number[2]++;
            }
        } else if (programmer instanceof Designer) {
            if (number[1] == 2) {
                throw new TeamException("团队中至多只能有两名设计师");
            } else {
                number[1]++;
            }
        } else {
            if (number[0] == 3) {
                throw new TeamException("团队中至多只能有三名程序员");
            } else {
                number[0]++;
            }
        }

        team[total++] = programmer;
        programmer.setMemberId(total);
        programmer.setStatus(Status.BUSY);
        System.out.println("添加成功");
    }

    public void removeMember(int memberId) throws TeamException {
        if (memberId > total) {
            throw new TeamException("找不到指定memberId的员工，删除失败");
        }

        if (team[memberId-1] instanceof Architect) {
            number[2]--;
        } else if (team[memberId-1] instanceof Designer) {
            number[1]--;
        } else {
            number[0]--;
        }
        team[memberId-1].setStatus(Status.FREE);

        if (total > 1){
            for (Programmer programmer : team) {
                if (programmer.getMemberId() == memberId) {
                    for (int i = memberId-1; i < total-1; i++) {
                        team[i] = team[i+1];
                        team[i].setMemberId(i+1);
                    }
                    break;
                }
            }
        }

        team[total-1] = null;
        total--;
        System.out.println("删除成功");

    }

}
