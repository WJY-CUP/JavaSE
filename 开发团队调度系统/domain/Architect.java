package 开发团队调度系统.domain;

import 开发团队调度系统.service.Status;

/**
 * @Author: Wan Jiangyuan
 * @Description:
 * @Date: Created in 16:14 2020/7/17
 * @E-mail: 15611562852@163.com
 */

public class Architect extends Designer {


    private int stock;

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    @Override
    public String toString() {
        return super.printInfo() + "架构师" + "\t" +
                getStatus() + "\t" +
                getBonus() + "\t" +
                getStock() + "\t" +
                getEquipment().getDescription();
    }

    public String printList() {
        return super.getMemberId() + "/" + super.printInfo()  + "架构师" + "\t" + super.getBonus() +
                "\t" + stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
