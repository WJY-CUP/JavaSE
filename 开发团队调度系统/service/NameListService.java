package 开发团队调度系统.service;

import 开发团队调度系统.domain.*;

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
                    Employee employee = new Employee();
                    employee.setId(Integer.parseInt(Data.EMPLOYEES[i][1]));
                    employee.setName(Data.EMPLOYEES[i][2]);
                    employee.setAge(Integer.parseInt(Data.EMPLOYEES[i][3]));
                    employee.setSalary(Double.parseDouble(Data.EMPLOYEES[i][4]));
                    employees[i] = employee;
                    break;

                case "11":
                    Programmer programmer = new Programmer();
                    programmer.setId(Integer.parseInt(Data.EMPLOYEES[i][1]));
                    programmer.setName(Data.EMPLOYEES[i][2]);
                    programmer.setAge(Integer.parseInt(Data.EMPLOYEES[i][3]));
                    programmer.setSalary(Double.parseDouble(Data.EMPLOYEES[i][4]));
                    switch (Data.EQUIPMENTS[i][0]) {
                        case "21":
                            PC pc = new PC(Data.EQUIPMENTS[i][1],Data.EQUIPMENTS[i][2]);
                            programmer.setEquipment(pc);
                            break;
                        case "22":
                            NoteBook noteBook = new NoteBook(Data.EQUIPMENTS[i][1],Double.parseDouble(Data.EQUIPMENTS[i][2]));
                            programmer.setEquipment(noteBook);
                            break;
                        case "23":
                            Printer printer = new Printer(Data.EQUIPMENTS[i][1], Data.EQUIPMENTS[i][2]);
                            programmer.setEquipment(printer);
                    }

                    employees[i] = programmer;

                    break;

                case "12":
                    Designer designer = new Designer();
                    designer.setId(Integer.parseInt(Data.EMPLOYEES[i][1]));
                    designer.setName(Data.EMPLOYEES[i][2]);
                    designer.setAge(Integer.parseInt(Data.EMPLOYEES[i][3]));
                    designer.setSalary(Double.parseDouble(Data.EMPLOYEES[i][4]));

                    designer.setBonus(Double.parseDouble(Data.EMPLOYEES[i][5]));
                    switch (Data.EQUIPMENTS[i][0]) {
                        case "21":
                            PC pc = new PC(Data.EQUIPMENTS[i][1],Data.EQUIPMENTS[i][2]);
                            designer.setEquipment(pc);
                            break;
                        case "22":
                            NoteBook noteBook = new NoteBook(Data.EQUIPMENTS[i][1],Double.parseDouble(Data.EQUIPMENTS[i][2]));
                            designer.setEquipment(noteBook);
                            break;
                        case "23":
                            Printer printer = new Printer(Data.EQUIPMENTS[i][1], Data.EQUIPMENTS[i][2]);
                            designer.setEquipment(printer);
                    }
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
                    switch (Data.EQUIPMENTS[i][0]) {
                        case "21":
                            PC pc = new PC(Data.EQUIPMENTS[i][1],Data.EQUIPMENTS[i][2]);
                            architect.setEquipment(pc);
                            break;
                        case "22":
                            NoteBook noteBook = new NoteBook(Data.EQUIPMENTS[i][1],Double.parseDouble(Data.EQUIPMENTS[i][2]));
                            architect.setEquipment(noteBook);
                            break;
                        case "23":
                            Printer printer = new Printer(Data.EQUIPMENTS[i][1], Data.EQUIPMENTS[i][2]);
                            architect.setEquipment(printer);
                    }

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


//    public Equipment initializeEquipment(Programmer programmer, int i) {
//
//        switch (Data.EQUIPMENTS[i][0]) {
//            case "21":
//                Equipment equipment = new PC(Data.EQUIPMENTS[i][1],Data.EQUIPMENTS[i][2]);
//                break;
//
//            case "22":
//                Equipment equipment = new NoteBook(Data.EQUIPMENTS[i][1],Double.parseDouble(Data.EQUIPMENTS[i][2]));
//                programmer.setEquipment(noteBook);
//                break;
//
//            case "23":
//                Printer printer = new Printer(Data.EQUIPMENTS[i][1],Data.EQUIPMENTS[i][2]);
//                programmer.setEquipment(printer);
//                break;
//        }
//
//
//    }
}
