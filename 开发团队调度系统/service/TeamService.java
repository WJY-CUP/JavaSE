package 开发团队调度系统.service;

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

    public TeamService() {

    }

    public Programmer[] getTeam() {
        return team;
    }

    public void addMember(Employee e) throws TeamException {
        if (total < MAX_MEMBER) {
            team[total] = (Programmer)e;
        } else if (total == MAX_MEMBER) {
            throw new TeamException("添加失败");
        }
    }

    public void removeMember(int memberId) throws TeamException {
        if (memberId >= total) {
            throw new TeamException("找不到指定memberId的员工，删除失败");
        }
        for (Programmer programmer : team) {
            if (programmer.getId() == memberId) {
                for (int i = memberId; i < total-1; i++) {
                    team[i] = team[i+1];
                    team[i].setId(i);
                }
                team[total-1] = null;
            }
        }
    }


}
