package View;

import Utility.GetInput;

import java.io.File;

/**
 * @Author: Wan Jiangyuan
 * @Description:
 * @Date: Created in 17:22 2020/8/3
 * @E-mail: 15611562852@163.com
 */

public class MenuView {


    public static final String ROOT_DIR = "E:\\FMS\\User\\";

    public static void StartMenu() {

        String UserDir = "";

        boolean isExit = false;
        System.out.println("------------------------------------------");
        System.out.println("        欢迎使用Linux文件系统");

        while (!isExit) {




            System.out.print("请输入用户名：");
            UserDir = GetInput.getString();
            File userDir = new File(ROOT_DIR+UserDir);
            System.out.println(ROOT_DIR);
            if (!userDir.exists()) {
                userDir.mkdir();
            }
        }



    }

    public static void ControlMenu() {

    }

}
