package 开发团队调度系统.domain;

import sun.security.krb5.internal.crypto.Des;
import 开发团队调度系统.service.Status;

/**
 * @Author: Wan Jiangyuan
 * @Description:
 * @Date: Created in 16:14 2020/7/17
 * @E-mail: 15611562852@163.com
 */

public class Designer extends Programmer {

    private double bonus;

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return super.printInfo()  + "设计师" + "\t" +
                getStatus() + "\t" +
                getBonus() + "\t\t\t" +
                getEquipment().getDescription();
    }

    public String printList() {
        return super.getMemberId() + "/" + super.printInfo() +  "设计师" + "\t" + bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
