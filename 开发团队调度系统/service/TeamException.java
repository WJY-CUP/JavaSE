package 开发团队调度系统.service;

/**
 * @Author: Wan Jiangyuan
 * @Description:
 * @Date: Created in 16:45 2020/7/17
 * @E-mail: 15611562852@163.com
 */

public class TeamException extends Throwable {

    static final long serialVersionUID = -3387516993124229948L;

    public TeamException() {

    }

    public TeamException(String message) {
        super(message);
    }


}
