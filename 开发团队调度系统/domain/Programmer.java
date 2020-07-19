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
        super();
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return super.printInfo() + "程序员" + "\t" + getStatus() + "\t\t\t\t\t" +
                getEquipment().getDescription();
    }

    public String printList() {
        return memberId + "/" + super.printInfo() + "程序员";
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
