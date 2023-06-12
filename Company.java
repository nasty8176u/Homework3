package company;

import company.employees.Employee8Hour;
import company.employees.EmployeeFree;
import company.employees.EmployeeMonth;
import company.employees.SuperEmployees;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Company {
    private List<SuperEmployees> list = new ArrayList<>();


    public double getWage() {
        double wage = 0;
        for (int i = 0; i < list.size(); i++) {
            wage += list.get(i).getSalary();
        }
        return wage;
    }

    // создаем сотрудников
    public void createEmplyeers() {
        list.add(new EmployeeMonth("Иван", "Иванов", 4000));
        list.add(new EmployeeMonth("Петр", "Петров", 3000));
        list.add(new Employee8Hour("Данил", "Данилов", 58));
        list.add(new Employee8Hour("Сергей", "Сергеев", 88));
        list.add(new EmployeeFree("Антон", "Антонов", 18, 5));
        list.add(new EmployeeFree("Геннадий", "Геннадиев", 23, 7));
    }

    // метод вывода в консоль
    public void outputConsole(List<SuperEmployees> employeesList) {
        String employeer = null;
        for (int i = 0; i < employeesList.size(); i++) {
            if (employeesList.get(i) instanceof EmployeeMonth) {
                employeer = "дневной";
            } else if (employeesList.get(i) instanceof EmployeeFree) {
                employeer = "фриланс";
            } else if (employeesList.get(i) instanceof Employee8Hour) {
                employeer = "почасовый";
            }
            System.out.println(i + 1 + " " + employeesList.get(i).getName() + " " + employeesList.get(i).getFamily() + " " + employeer + " " + employeesList.get(i).getSalary());
        }
    }

    // сортируем список от минимуму к максимум и выводим его
    public void sortMinMaxSalary(List<SuperEmployees> employeesList) {
        System.out.println();
        System.out.println("Сортировка от минимума к максимуму");
        employeesList.sort(new Comparator<SuperEmployees>() {
            @Override
            public int compare(SuperEmployees o1, SuperEmployees o2) {
                if (o1.getSalary() == o2.getSalary()) return 0;
                else if (o1.getSalary() > o2.getSalary()) return 1;
                else return -1;
            }
        });
        outputConsole(employeesList);
    }

    // сортируем список от максимума к минимуму и выводим его
    public void sortMaxMinSalary(List<SuperEmployees> employeesList) {
        System.out.println();
        System.out.println("Сортировка от максимуму к минимуму");
        employeesList.sort(new Comparator<SuperEmployees>() {
            @Override
            public int compare(SuperEmployees o1, SuperEmployees o2) {
                if (o1.getSalary() == o2.getSalary()) return 0;
                else if (o1.getSalary() < o2.getSalary()) return 1;
                else return -1;
            }
        });
        outputConsole(employeesList);
    }

    public void saveFile(String link) {
        try {
            FileWriter writer = new FileWriter(link, false);
            // пишем колличество обьектов
            writer.write("" + list.size() + "\n");
            for (SuperEmployees value : list) {
                writer.write(value.getClass().getSimpleName() + "\n");
                writer.write(value.getName() + "\n");
                writer.write(value.getFamily() + "\n");
                if (value.getClass().getSimpleName().equals("EmployeeMonth")) {
                    writer.write((((EmployeeMonth) value).getPriceMounts()) + "\n");
                }
                if (!value.getClass().getSimpleName().equals("EmployeeMonth")) {
                    writer.write((((Employee8Hour) value).getHourPrice()) + "\n");
                }
                if (value.getClass().getSimpleName().equals("EmployeeFree")) {
                    writer.write((((EmployeeFree) value).getHourDay()) + "\n");
                }
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<SuperEmployees> load(String link) {
        try {
            FileReader reader = new FileReader(link);
            BufferedReader br = new BufferedReader(reader);
            int arraySize = Integer.parseInt(br.readLine());
            List<SuperEmployees> superEmployees = new ArrayList<>();
            for (int i = 0; i < arraySize; i++) {
                String tempReader = br.readLine();
                if (tempReader.equals("EmployeeMonth")) {
                    superEmployees.add(new EmployeeMonth(br.readLine(), br.readLine(), Double.parseDouble(br.readLine())));
                }
                if (tempReader.equals("Employee8Hour")) {
                    superEmployees.add(new Employee8Hour(br.readLine(), br.readLine(), Double.parseDouble(br.readLine())));
                }
                if (tempReader.equals("EmployeeFree")) {
                    superEmployees.add(new EmployeeFree(br.readLine(), br.readLine(), Double.parseDouble(br.readLine()), Integer.parseInt(br.readLine())));
                }
            }
            outputConsole(superEmployees);
            return superEmployees;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
