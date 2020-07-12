package 银行余额;

/**
 * @Author: Wan Jiangyuan
 * @Description:
 * @Date: Created in 16:09 2020/7/12
 * @E-mail: 15611562852@163.com
 */

class Account {
    private int id;
    protected double balance;
    private double annual;

    public Account(int id, double balance, double annual) {
        this.id = id;
        this.balance = balance;
        this.annual = annual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnual() {
        return annual;
    }

    public void setAnnual(double annual) {
        this.annual = annual;
    }

//    public double getMonthlyInterest() {
//
//    }
    public void withdraw (double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("balance: " + balance);
        } else {
            System.out.println("余额不足!");
        }
    }
    public void deposit (double amount) {
        balance += amount;
        System.out.println("balance: " + balance);
        System.out.println("-------存钱结束-------");
    }
}

class Check extends Account{

    double overdraft;

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }


    public Check(int id, double balance, double annual, double overdraft) {
        super(id, balance, annual);
        this.overdraft = overdraft;
    }

    public void withdraw (double amount) {
        balance = super.getBalance();
        if (balance >= amount) {
            balance -= amount;
            System.out.println("balance: " + balance);
        } else if (balance+overdraft >= amount){
            System.out.println("余额不足!");
            System.out.println("可透支余额: " + overdraft);
            balance = balance-amount;
            System.out.println("余额为: " + balance);
        } else {
            System.out.println("无透支额度");
        }
        System.out.println("-------取钱结束------");
    }

}

public class testAccount {
    public static void main(String[] args) {
//        Account a = new Account(1122,20000,0.045);
////        a.withdraw(30000);
////        a.deposit(2000);
        Check c = new Check(258,10000,0.045,5000);
        c.withdraw(12000);
        c.withdraw(20000);
        c.deposit(5000);

    }
}