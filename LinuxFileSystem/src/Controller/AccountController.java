package Controller;

import java.io.*;

/**
 * @Author: Wan Jiangyuan
 * @Description:
 * @Date: Created in 18:13 2020/8/3
 * @E-mail: 15611562852@163.com
 */

public class AccountController {


     /**
      * @Description: 检查本地存储用户名和密码的文件是否已存在，若不存在，则创建新文件
      * @Author: Wan Jiangyuan
      * @Date: 19:49 2020/8/3 
      * @Param:  需要检查的文件路径（存储本地用户名和密码的文件）
      * @Return: 文件已存在或（不存在但新建文件成功），则返回true；否则返回false
      */
    public static boolean FileExist(String path) {
        boolean isExit = false;
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
                //设置文件属性为隐藏
                // R ： 只读文件属性。A：存档文件属性。S：系统文件属性。H：隐藏文件属性
                String sets=" attrib +H  "+file.getAbsolutePath();
                System.out.println(sets);
                //执行文件设置命令
                Runtime.getRuntime().exec(sets);
            }
            isExit = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isExit;
    }

    
     /**
      * @Description: 向路径为path的文件中写入（追加方式）字符串info
      * @Author: Wan Jiangyuan
      * @Date: 20:03 2020/8/3
      * @Param: String info--需要向文件中写入（追加方式）的字符串
      * 	    String path--需要访问的文件路径
      * @Return: 若向文件写入字符串info成功，则返回true；否则返回flase
      */
    public static boolean StringWriteLine(String info, String path) {

        boolean isAdded = false;

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
            fileWriter.write("\n" + info);
            isAdded = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return isAdded;
    }


     /**
      * @Description: 校验登录操作的用户名userName和密码password是否匹配
      * @Author: Wan Jiangyuan
      * @Date: 21:46 2020/8/3
      * @Param: String userName--登录操作输入的用户名
      * 	    String password--登录操作输入的密码
      * 		String fileUrl--需要访问的文件路径（存储本地用户名和密码的文件）
      * @Return: 若输入的userName和password相匹配，则返回true；否则返回false
      */

     /*
     用户名和密码的检索碰撞----即逐行检索时某用户的密码和当前请求登录的用户的用户名相同所带来的错误匹配问题，
        可在注册存储时对用户名和密码分别加上不同的前缀
     本类中注册函数UserRegister()对用户名userName和密码password存储时分别加上了"un"和"pw"前缀
        以保证一个用户的用户名和另一个用户的密码永远不会发生碰撞。
      */
    public static boolean UserValidate(String userName, String password, String path) {

        String line = "";
        boolean isExist = false;

        try {
            //文件字节输入流
            FileInputStream fis = new FileInputStream(path);
            //转换流，将一个字节输入流转换为字符的输入流
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            //字符输入缓冲流
            BufferedReader br = new BufferedReader(isr);
            //若文件未读取完毕，则继续读取下一行
            while ((line = br.readLine()) != null) {
                //若当前行与用户名相匹配
                if (line.equals("un" + userName)) {
                    //看密码是否匹配
                    if (br.readLine().equals(String.valueOf(("pw" + password).hashCode()))) {
                        isExist = true;
                    }
                    //只要检索到用户名，不论密码是否匹配，都终止循环
                    break;
                }
            }
            //关闭对文件的访问
            br.close();
            isr.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return isExist;
    }

    
    
     /**
      * @Description: 以注册操作输入的用户名userName和密码password注册新用户（向存储本地用户名和密码的文件中写入新的用户名的和密码）
      * @Author: Wan Jiangyuan
      * @Date: 21:57 2020/8/3
      * @Param: String userName--注册操作输入的用户名
      *  		String password--注册操作输入的密码
      *  		String fileUrl--需要访问的文件路径（存储本地用户名和密码的文件）
      * @Return: 若新用户注册成功，则返回true；否则返回false
      */
    /*
    密码的明文存储问题----密码任何时候都不允许明文存储
    以避免用户信息被意外盗取时发生损失，采取Java自带的对象哈希值编码方式对密码进行存储和校验。
     */
    public static boolean UserRegister(String userName, String password, String path) {

        boolean isAdded = false;
        //检验用户名是否已存在
        if (StringWriteLine("un" + userName, path)) {
            return isAdded;
        } else {
            //若不存在，依次写入用户名和密码（分别加上前缀"un"和"pw"）
            StringWriteLine("un" + userName, path);
            StringWriteLine(String.valueOf(("pw" + password).hashCode()), path);
            isAdded = true;
        }

        return isAdded;


    }


}
