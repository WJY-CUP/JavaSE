package 客户信息管理;

import ObjectOriented.test_static;

import java.util.Scanner;

/**
 * @Author: Wan Jiangyuan
 * @Description: 工具类
 * @Date: Created in 13:03 2020/7/10
 * @E-mail: 15611562852@163.com
 */

public class CMUtility {
    private static Scanner scanner = new Scanner(System.in);


    public static char readMenuSelection(){
        char c;
        for (; ; ){
            String str = readKeyboard(1,false);
            c = str.charAt(0);
            if (c != '1' && c != '2' &&
                    c != '3' && c != '4' && c != '5') {
                System.out.print("选择错误，请重新输入：");
            } else break;
        }
        return c;
    }

    public static char readChar(){
        String str = readKeyboard(1,false);
        return str.charAt(0);
    }
    public static char readChar(char defaultValue){
        String str = readKeyboard(1,true);
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }


    //读取整形数字
    public static int readInt(){
        int n;
        for (;;){
            String str = readKeyboard(2,false);
            try {
                n = Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }
    public static int readInt(int defaultValue){
        int n;
        for (;;){
            String str = readKeyboard(2,false);
            if (str.equals("")){
                return defaultValue;
            }

            try {
                n = Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    //读取字符串
    public static String readString(int limit){
        return readKeyboard(limit, false);
    }
    public static String readString(int limit, String defaultValue){
        String str = readKeyboard(limit, true);
        return str.equals("")? defaultValue:str;
    }

    public static char readConfirmSelection(){
        char c;
        for (;;){
            String str = readKeyboard(1,false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N'){
                break;
            }else {
                System.out.print("选择错误，请重新输入：");
            }
        }
        return c;
    }

    private static String readKeyboard(int limit, boolean blankReturn){
        String line = "";
        while (scanner.hasNextLine()){
            line = scanner.nextLine();
            System.out.println();
            if (line.length() == 0){
                if (blankReturn) return line;
                else continue;
            }

            if (line.length() > limit){
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }

        return line;
    }


}
