package company;

public class Main {
    private static final String link = "files/employeers.txt";

    public static void main(String[] args) {
        Company company = new Company();
        //company.createEmplyeers();
        // System.out.println("Общая зарплата: " + company.getWage());
        // company.outputConsole();
//        company.saveFile(link);
//        company.sortMinMaxSalary();
        //company.sortMaxMinSalary();
        company.load(link);


    }
}