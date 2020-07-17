package 开发团队调度系统.domain;

import 开发团队调度系统.service.Status;

/**
 * @Author: Wan Jiangyuan
 * @Description:
 * @Date: Created in 16:14 2020/7/17
 * @E-mail: 15611562852@163.com
 */

public class Programmer extends Employee {

    private int memberId;
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer() {

    }

    public Programmer(int id, String name, int age, double salary, int memberId, Status status, Equipment equipment) {
        super(id, name, age, salary);
        this.memberId = memberId;
        this.status = status;
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
