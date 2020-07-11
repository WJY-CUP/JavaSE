package 账本;

import java.util.Scanner;

public class Utility {

    private static Scanner scanner = new Scanner(System.in);

    //此函数若返回值为int,则若输入字母会直接崩掉，故char类型更具容错性
    public static char readMenuSelection(){
        char c;
        for(;;){
            String str = readKeyboard(1);
            //String类就是一个字符数组
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4'){
                System.out.println("选择错误，请重新输入: ");
            }else break;
        }
        return c;
    }

    public static char readConfirmSelection(){
        char c;
        for(;;){
            String str = readKeyboard(1).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N'){
                break;
            }else {
                System.out.println("选择错误，请重新输入： ");
            }
        }
        return c;
    }

    public static int readNumber(){
        int n;
        for (;;){
            String str = readKeyboard(4);
            try{
                n = Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                System.out.println("数字输入错误，请重新输入： ");
            }
        }
        return n;
    }

    public static String readString(){
        return readKeyboard(8);
    }

    private static String readKeyboard(int limit){
        String line = "";
        /*
            hasNext（） 是检测 还有没有下一个输入
            next（）是指针移动到当前下标，并取出下一个输入
            nextLine（） 把指针移动到下一行 让然后取出当前这一行的输入
            hasNextLine（） 是检测下一行有没有输入
         */
        while (scanner.hasNext()){
            line = scanner.nextLine();
            if (line.length() < 1 || line.length() > limit){
                System.out.println("输出长度（不大于" + limit + "），请重新输入： ");
                continue;
            }
            break;
        }
        return line;
    }

}
