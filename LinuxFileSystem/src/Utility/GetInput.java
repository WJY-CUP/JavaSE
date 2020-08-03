package Utility;

import java.util.Scanner;

/**
 * @Author: Wan Jiangyuan
 * @Description:
 * @Date: Created in 16:28 2020/8/3
 * @E-mail: 15611562852@163.com
 */

public class GetInput {

    private static Scanner scanner = new Scanner(System.in);


    public static String getString() {
        return getKeyboard(10);
    }

     /**
      * @Description: 返回指定长度内的键盘输入的字符串
      * @Author: Wan Jiangyuan
      * @Date: 17:12 2020/8/3
      * @Param:  输入长度限制
      * @Return: 符合条件的字符串
      */
    private static String getKeyboard(int limit) {
        String line = "";
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() < 1 || line.length() > limit) {
                System.out.println("输入长度（需小于" + limit + "），请重新输入");
                continue;
            }
            break;
        }
        return line;
    }






}
