package 开发团队调度系统.service;

/**
 * @Author: Wan Jiangyuan
 * @Description:
 * @Date: Created in 16:33 2020/7/17
 * @E-mail: 15611562852@163.com
 */

public class Status {
    private final String NAME;
    private Status(String name) {
        this.NAME = name;
    }
    public static final Status FREE = new Status("FREE");
    public static final Status VOCATION = new Status("VOCATION");
    public static final Status BUSY = new Status("BUSY");
    public String getNAME() {
        return NAME;
    }
    @Override
    public String toString() {
        return NAME;
    }


}
