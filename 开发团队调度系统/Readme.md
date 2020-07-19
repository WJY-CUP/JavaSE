# 开发团队调度软件

## 1.目 标

模拟实现一个基于文本界面的《开发团队调度软件》

熟悉Java面向对象的高级特性，进一步掌握编程技巧和调试技巧

主要涉及以下知识点：

- 类的继承性和多态性
- 对象的值传递、接口
- static和final修饰符
- 特殊类的使用：包装类、抽象类、内部类
- 异常处理





## 2.需求说明

该软件实现以下功能：

- 软件启动时，根据给定的数据创建公司部分成员列表（数组）
- 根据菜单提示，基于现有的公司成员，组建一个开发团队以开发一个新的项目
- 组建过程包括将成员插入到团队中，或从团队中删除某成员，还可以列出团队中现有成员的列表
- 开发团队成员包括架构师、设计师和程序员



### 2.1 公司员工信息输出功能

~~~
1-公司员工列表  2-开发团队列表 3-添加团队成员  4-删除团队成员 5-退出   请选择(1-5)：1

ID		姓名	 年龄		工资		职位	状态	 奖金		股票		领用设备
1		马云	 22		3000.0	
2		马化腾	32		18000.0	架构师	FREE    15000.0	2000	联想T46000.0
3		李彦宏	23		7000.0	程序员	FREE					戴尔NEC17寸
4		刘强东	24		7300.0	程序员	FREE					戴尔三星 17寸
5		雷军	 28		10000.0	设计师	 FREE	5000.0			佳能 2900激光
6		任志强	22		6800.0	程序员	FREE					华硕三星 17寸
7		柳传志	29		10800.0	设计师	FREE	5200.0			华硕三星 17寸
8		杨元庆	30		19800.0	架构师	FREE	15000.0	2500	爱普生20K针式
9		史玉柱	26		9800.0	设计师	FREE	5500.0			惠普m65800.0
10		丁磊	 21		6600.0	程序员	 FREE					戴尔NEC 17寸
11		张朝阳	25		7100.0	程序员	FREE					华硕三星 17寸
12		杨致远	27		9600.0	设计师	FREE	4800.0			惠普m65800.0
~~~



### 2.2 团队列表信息输出功能

~~~
1-公司员工列表  2-开发团队列表 3-添加团队成员  4-删除团队成员 5-退出   请选择(1-5)：2

--------------------团队成员列表---------------------
TDI/ID  姓名    年龄      工资       职位      奖金        股票
 2/4    刘强东   24      7300.0    程序员
 3/2    马化腾   32      18000.0   架构师     15000.0  	2000
 4/6    任志强   22      6800.0    程序员
 5/12   杨致远   27      600.0     设计师     4800.0
-----------------------------------------------------
~~~



### 2.3 添加团队成员功能

#### 2.3.1 添加成功

将执行从列表中添加指定（通过ID）成员到开发团队的功能：

**添加成功界面：**

~~~
1-团队列表 2-添加团队成员 3-删除团队成员 4-退出  请选择(1-4)：2

---------------------添加成员---------------------

请输入要添加的员工ID：2

添加成功

按回车键继续...
~~~

添加成功后，按回车键将重新显示主界面。

开发团队人员组成要求：

- 最多一名架构师
- 最多两名设计师
- 最多三名程序员



#### 2.3.2 添加失败

**如果添加操作因某种原因失败，将显示类似以下信息（失败原因视具体原因而不同）：**

**添加失败界面**

~~~
1-公司员工列表  2-开发团队列表 3-添加团队成员  4-删除团队成员 5-退出   请选择(1-5)：3

---------------------添加成员---------------------

请输入要添加的员工ID：2

添加失败，原因：该员工已是某团队成员

按回车键继续...
~~~

 失败信息包含以下几种：

- 成员已满，无法添加
- 该成员不是开发人员，无法添加
- 该员工已在本开发团队中
- 该员工已是某团队成员
- 该员正在休假，无法添加
- 团队中至多只能有一名架构师
- 团队中至多只能有两名设计师
- 团队中至多只能有三名程序员



### 2.4 删除团队成员功能

将执行从开发团队中删除指定（通过TeamID）成员的功能：

**删除成功界面**

~~~
1-公司员工列表  2-开发团队列表 3-添加团队成员  4-删除团队成员 5-退出   请选择(1-5)：4

---------------------删除成员---------------------
请输入要删除员工的TID：1
确认是否删除(Y/N)：y
删除成功
按回车键继续...
~~~

删除成功后，按回车键将重新显示主界面。





## 3.软件设计结构

### 3.1 软件模块

|     view      |       |        service        |       |    domain     |
| :-----------: | ----- | :-------------------: | ----- | :-----------: |
|               |       |   **→TeamService→**   |       |               |
|               | **↗** |                       | **↘** |               |
| **TeamView→** |       |   **TeamException**   |       | **→Employee** |
|               | **↘** |                       | **↗** |               |
|               |       | **→NameListService→** |       |               |

- view模块为主控模块，负责菜单的显示和处理用户操作
- service模块为实体对象（Employee及其子类如程序员等）的管理模块
- NameListService和TeamService类分别用各自的数组来管理公司员工和开发团队成员对象
- domain模块为Employee及其子类等JavaBean类所在的包



### 3.2 domain模块

**domain模块中包含了所有实体类**

|  **Employee**   |               |        |                   |             |
| :-------------: | ------------- | :----: | :---------------: | ----------- |
|      **↑**      |               |        |                   |             |
| **Programmer→** | **→包含属性** | **→**  | **<<interface>>** |             |
|      **↑**      |               |        |   **Equipment**   |             |
|  **Designer**   |               | **↙**  |         ↓         | **↘**       |
|      **↑**      |               | **PC** |   **NoteBook**    | **Printer** |
|  **Architect**  |               |        |                   |             |

程序员(Programmer)及其子类，均会领用某种电子设备(Equipment)。





## 4.步骤

### 4.1 实现domain包中的类

#### 4.1.1 创建项目基本组件

1.将项目提供的几个类复制到相应的包中 (view包中：TSUtility.java;  service包中：Data.java)

2.按照设计要求，在domain包中，创建Equipment接 口及其各实现子类代码

3.按照设计要求，在domain包中，创建Employee类及其各子类代码



#### 4.1.2 Equipment接口及其实现子类的设计

~~~java
package 开发团队调度系统.domain;

public interface Equipment {

    String getDescription();
}
~~~

~~~java
class PC implements Equipment

//机器的型号
- model: String
//显示器名称
- display: String
+ PC(model: String, display: String)
~~~

~~~java
class NoteBook implements Equipment
 
- model: String
- price: double
+ NoteBook(model: String, price: double)
~~~

~~~java
class Printer implements Equipment

- name: String
//机器的类型
- type: String
+ Printer(name: String, type: String)
~~~



#### 4.1.3 Employee类及其子类的设计

~~~java
class Employee

- id: int 
- name:String
- age: int
- salary: double 
+ Employee(id: int , name: String, age: int, salary: double) 
~~~

~~~java
class Programmer extends Employee

//成员加入开发团队后在团队中的ID
- memberId : int

/*
  - FREE-空闲
  - BUSY-已加入开发团队
  - VOCATION-正在休假
*/
- status: Status = FREE
//该成员领用的设备
- equipment: Equipment
    
+ Programmer(id: int , name: String, age: int, salary: double, equipment: Equipment) 
~~~

~~~java
class Designer extends Programmer 

- bonus : double
    
+ Designer(id: int , name: String,age: int, salary: double,
equipment: Equipment, bonus : double) 
~~~

~~~java
class Architect extends Designer 

- stock : int
    
+Architect (id: int , name: String, age: int, salary: double,equipment: Equipment,bonus : double, stock : int)
~~~



#### 4.1.4 Status类

**Status枚举类位于service包中，封装员工的状态。其代码如下：**

~~~java
package 开发团队调度系统.service;

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
~~~



### 4.2 实现service包中的类

#### 4.2.1 NameListService类的设计

**功能：负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法。**

~~~java
class NameListService

//保存公司所有员工对象
- employees: Employee[]
/*
  - 根据项目提供的Data类构建相应大小的employees数组
  - 再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
  - Data类位于service包中
*/
+ NameListService()

//获取当前所有员工。返回：包含所有员工对象的数组
+ getAllEmployees(): Employee[]
    
/*获取指定ID的员工对象。
参数：指定员工的ID
返回：指定员工对象
异常：找不到指定的员工*/
+ getEmployee(int id) throws TeamException: Employee 
~~~



#### 4.2.2 TeamService类的设计

**功能：关于开发团队成员的管理：添加、删除等。**

~~~java
class TeamService
    
//用来为开发团队新增成员自动生成团队中的唯一ID
- counter: int sttaic = 1
//开发团队最大成员数
- MAX_MEMBER: final int = 5
//用来保存当前团队中的各成员对象 
- team: Programmer[] = new Programmer[MAX_MEMBER];
//记录团队成员的实际人数
- total: int = 0;

/*
  功能：返回当前团队的所有对象
  返回：包含所有成员对象的数组，数组大小与成员人数一致
*/
+ getTeam(): Programmer[]
    
/*
  功能：向团队中添加成员
  参数：待添加成员的对象
  异常：添加失败， TeamException中包含了失败原因
*/
+ addMember(e: Employee) throws TeamException: void 
    
    
/*
  功能：从团队中删除成员
  参数：待删除成员的memberId
  异常：找不到指定memberId的员工，
*/
+ removeMember(memberId: int) throws TeamException: void 
~~~



#### 4.2.3 TeamException类的设计

~~~java
public class TeamException extends Throwable {

    static final long serialVersionUID = -3387516993124229948L;

    public TeamException() {

    }
    public TeamException(String message) {
        super(message);
    }
}
~~~



### 4.3 实现view包中类

#### 4.3.1 TeamView类的设计

~~~java
class TeamView

- employees: Employee[]
+ NameListService()
- listSvc: NameListService = new NameListService()
- teamSvc: TeamService = new TeamService()

    
/*
  功能：获取当前所有员工。
  返回：包含所有员工对象的数组
*/
+ getAllEmployees(): Employee[]
    
/*
  功能：获取指定ID的员工对象。
  参数：指定员工的ID
  返回：指定员工对象
  异常：找不到指定的员工
*/
+ getEmployee(int id) throws TeamException: Employee 
    
//主界面显示及控制方法
+ enterMainMenu(): void 
//以表格形式列出公司所有成员
+ listAllEmployees(): void 
//显示团队成员列表
+ getTeam():void
//向开发团队添加成员
+ addMember(): void
//删除开发团队中的成员
+ deleteMember(): void 
+ main(args: String[]) : void 
~~~



#### 4.3.2 TSUtility工具类的设计

**功能：从键盘读取标准格式输入**

~~~java
package 开发团队调度系统.view;

import java.util.*;
/**
 * 
 * @Description 项目中提供了TSUtility.java类，可用来方便地实现键盘访问。
 * @author shkstart  Email:shkstart@126.com
 * @version 
 * @date 2019年2月12日上午12:02:58
 *
 */
public class TSUtility {
    private static Scanner scanner = new Scanner(System.in);
    /**
     * 
     * @Description 该方法读取键盘，如果用户键入’1’-’4’中的任意字符，则方法返回。返回值为用户键入字符。
     * @author shkstart
     * @date 2019年2月12日上午12:03:30
     * @return
     */
	public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' &&
                c != '3' && c != '4' && c != '5') {
                System.out.print("选择错误，请重新输入：");
            } else break;
        }
        return c;
    }
	/**
	 * 
	 * @Description 该方法提示并等待，直到用户按回车键后返回。
	 * @author shkstart
	 * @date 2019年2月12日上午12:03:50
	 */
    public static void readReturn() {
        System.out.print("按回车键继续...");
        readKeyBoard(100, true);
    }
    /**
     * 
     * @Description 该方法从键盘读取一个长度不超过2位的整数，并将其作为方法的返回值。
     * @author shkstart
     * @date 2019年2月12日上午12:04:04
     * @return
     */
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }
    /**
     * 
     * @Description 从键盘读取‘Y’或’N’，并将其作为方法的返回值。
     * @author shkstart
     * @date 2019年2月12日上午12:04:45
     * @return
     */
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("选择错误，请重新输入：");
            }
        }
        return c;
    }

    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }

        return line;
    }
}
~~~

