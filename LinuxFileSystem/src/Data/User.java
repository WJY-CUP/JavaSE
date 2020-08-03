package Data;

import java.util.Date;

/**
 * @Author: Wan Jiangyuan
 * @Description:
 * @Date: Created in 16:15 2020/8/3
 * @E-mail: 15611562852@163.com
 */

public class User {

    private String name;
    private String password;
    private Date date = new Date();

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
