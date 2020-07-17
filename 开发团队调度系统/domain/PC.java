package 开发团队调度系统.domain;

/**
 * @Author: Wan Jiangyuan
 * @Description:
 * @Date: Created in 16:29 2020/7/17
 * @E-mail: 15611562852@163.com
 */

public class PC implements Equipment {

    private String model;
    private String display;

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    @Override
    public String toString() {
        return "PC{" +
                "model='" + model + '\'' +
                ", display='" + display + '\'' +
                '}';
    }

    @Override
    public String getDescription() {
        return "PC{" +
                "model='" + model + '\'' +
                ", display='" + display + '\'' +
                '}';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}
