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



---

### 2.1 添加团队成员功能



#### 2.1.1 添加成功

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



#### 2.1.2 添加失败

**如果添加操作因某种原因失败，将显示类似以下信息（失败原因视具体原因而不同）：**

**添加失败界面**

~~~
1-团队列表 2-添加团队成员 3-删除团队成员 4-退出  请选择(1-4)：2

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



### 2.2 删除团队成员功能

将执行从开发团队中删除指定（通过TeamID）成员的功能：

**删除成功界面**

~~~
1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：3

---------------------删除成员---------------------
请输入要删除员工的TID：1
确认是否删除(Y/N)：y
删除成功
按回车键继续...
~~~

删除成功后，按回车键将重新显示主界面。



### 2.3 团队列表信息输出功能

当选择“团队列表”菜单时，将列出开发团队中的现有成员，例如：

~~~
1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：1

--------------------团队成员列表---------------------

TDI/ID  姓名    年龄      工资       职位      奖金        股票
 2/4     刘强东   24      7300.0    程序员
 3/2     马化腾   32      18000.0  架构师   15000.0  2000
 4/6     任志强   22      6800.0    程序员
 5/12   杨致远   27      600.0      设计师   4800.0
-----------------------------------------------------
~~~





## 3.软件设计结构

![img](https://github.com/WJY-CUP/JavaSE/blob/master/jpg/%E5%BC%80%E5%8F%91%E5%9B%A2%E9%98%9F%E8%B0%83%E5%BA%A6%E7%B3%BB%E7%BB%9F_9.jpg)

![img](https://github.com/WJY-CUP/JavaSE/blob/master/jpg/%E5%BC%80%E5%8F%91%E5%9B%A2%E9%98%9F%E8%B0%83%E5%BA%A6%E7%B3%BB%E7%BB%9F_10.jpg)

![img](https://github.com/WJY-CUP/JavaSE/blob/master/jpg/%E5%BC%80%E5%8F%91%E5%9B%A2%E9%98%9F%E8%B0%83%E5%BA%A6%E7%B3%BB%E7%BB%9F_11.jpg)

![img](https://github.com/WJY-CUP/JavaSE/blob/master/jpg/%E5%BC%80%E5%8F%91%E5%9B%A2%E9%98%9F%E8%B0%83%E5%BA%A6%E7%B3%BB%E7%BB%9F_12.jpg)

![img](https://github.com/WJY-CUP/JavaSE/blob/master/jpg/%E5%BC%80%E5%8F%91%E5%9B%A2%E9%98%9F%E8%B0%83%E5%BA%A6%E7%B3%BB%E7%BB%9F_13.jpg)

![img](https://github.com/WJY-CUP/JavaSE/blob/master/jpg/%E5%BC%80%E5%8F%91%E5%9B%A2%E9%98%9F%E8%B0%83%E5%BA%A6%E7%B3%BB%E7%BB%9F_14.jpg)

![img](https://github.com/WJY-CUP/JavaSE/blob/master/jpg/%E5%BC%80%E5%8F%91%E5%9B%A2%E9%98%9F%E8%B0%83%E5%BA%A6%E7%B3%BB%E7%BB%9F_15.jpg)

![img](https://github.com/WJY-CUP/JavaSE/blob/master/jpg/%E5%BC%80%E5%8F%91%E5%9B%A2%E9%98%9F%E8%B0%83%E5%BA%A6%E7%B3%BB%E7%BB%9F_16.jpg)

![img](https://github.com/WJY-CUP/JavaSE/blob/master/jpg/%E5%BC%80%E5%8F%91%E5%9B%A2%E9%98%9F%E8%B0%83%E5%BA%A6%E7%B3%BB%E7%BB%9F_17.jpg)

![img](https://github.com/WJY-CUP/JavaSE/blob/master/jpg/%E5%BC%80%E5%8F%91%E5%9B%A2%E9%98%9F%E8%B0%83%E5%BA%A6%E7%B3%BB%E7%BB%9F_18.jpg)

![img](https://github.com/WJY-CUP/JavaSE/blob/master/jpg/%E5%BC%80%E5%8F%91%E5%9B%A2%E9%98%9F%E8%B0%83%E5%BA%A6%E7%B3%BB%E7%BB%9F_19.jpg)

![img](https://github.com/WJY-CUP/JavaSE/blob/master/jpg/%E5%BC%80%E5%8F%91%E5%9B%A2%E9%98%9F%E8%B0%83%E5%BA%A6%E7%B3%BB%E7%BB%9F_20.jpg)

![img](https://github.com/WJY-CUP/JavaSE/blob/master/jpg/%E5%BC%80%E5%8F%91%E5%9B%A2%E9%98%9F%E8%B0%83%E5%BA%A6%E7%B3%BB%E7%BB%9F_21.jpg)

![img](https://github.com/WJY-CUP/JavaSE/blob/master/jpg/%E5%BC%80%E5%8F%91%E5%9B%A2%E9%98%9F%E8%B0%83%E5%BA%A6%E7%B3%BB%E7%BB%9F_22.jpg)

![img](https://github.com/WJY-CUP/JavaSE/blob/master/jpg/%E5%BC%80%E5%8F%91%E5%9B%A2%E9%98%9F%E8%B0%83%E5%BA%A6%E7%B3%BB%E7%BB%9F_23.jpg)