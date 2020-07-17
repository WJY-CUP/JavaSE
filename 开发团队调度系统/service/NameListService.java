package 开发团队调度系统.service;

import 开发团队调度系统.domain.Architect;
import 开发团队调度系统.domain.Designer;
import 开发团队调度系统.domain.Employee;
import 开发团队调度系统.domain.Programmer;

/**
 * @Author: Wan Jiangyuan
 * @Description:
 * @Date: Created in 16:11 2020/7/17
 * @E-mail: 15611562852@163.com
 */

public class NameListService extends TeamException{

    private Employee[] employees = new Employee[Data.EMPLOYEES.length];

    public NameListService() {
        super();
        for (int i = 0; i < employees.length; i++){
            switch (Data.EMPLOYEES[i][0]) {
                case "10":
                    employees[i].setId(Integer.parseInt(Data.EMPLOYEES[i][1]));
                    employees[i].setName(Data.EMPLOYEES[i][2]);
                    employees[i].setAge(Integer.parseInt(Data.EMPLOYEES[i][3]));
                    employees[i].setSalary(Double.parseDouble(Data.EMPLOYEES[i][4]));
                    break;

                case "11":
                    Programmer programmer = new Programmer();
                    programmer.setId(Integer.parseInt(Data.EMPLOYEES[i][1]));
                    programmer.setName(Data.EMPLOYEES[i][2]);
                    programmer.setAge(Integer.parseInt(Data.EMPLOYEES[i][3]));
                    programmer.setSalary(Double.parseDouble(Data.EMPLOYEES[i][4]));
                    employees[i] = programmer;
                    break;

                case "12":
                    Designer designer = new Designer();
                    designer.setId(Integer.parseInt(Data.EMPLOYEES[i][1]));
                    designer.setName(Data.EMPLOYEES[i][2]);
                    designer.setAge(Integer.parseInt(Data.EMPLOYEES[i][3]));
                    designer.setSalary(Double.parseDouble(Data.EMPLOYEES[i][4]));
                    designer.setBonus(Double.parseDouble(Data.EMPLOYEES[i][5]));
                    employees[i] = designer;
                    break;

                case "13":
                    Architect architect = new Architect();
                    architect.setId(Integer.parseInt(Data.EMPLOYEES[i][1]));
                    architect.setName(Data.EMPLOYEES[i][2]);
                    architect.setAge(Integer.parseInt(Data.EMPLOYEES[i][3]));
                    architect.setSalary(Double.parseDouble(Data.EMPLOYEES[i][4]));
                    architect.setBonus(Double.parseDouble(Data.EMPLOYEES[i][5]));
                    architect.setStock(Integer.parseInt(Data.EMPLOYEES[i][6]));
                    employees[i] = architect;
                    break;

            }
        }
    }

    public Employee[] getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException {
        if (id < 0) {
            throw new TeamException("ID负值");
        }
        for (Employee employee : employees) {
            if (id == employee.getId()) {
                return employee;
            }
        }
        return null;
    }


    public static void main(String[] args) {

    }
}
