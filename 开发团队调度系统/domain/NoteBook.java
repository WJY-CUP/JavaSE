package 开发团队调度系统.domain;

/**
 * @Author: Wan Jiangyuan
 * @Description:
 * @Date: Created in 16:29 2020/7/17
 * @E-mail: 15611562852@163.com
 */

public class NoteBook implements Equipment {

    private String model;
    private double price;

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }


    @Override
    public String getDescription() {
        return model+price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
