package company.employees;

public class EmployeeFree extends Employee8Hour {
    private int hourDay;

    public EmployeeFree(String name, String family, double hourPrice, int hourDay) {
        super(name, family, hourPrice);
        this.hourDay = hourDay;
    }

    @Override
    public double getSalary() {
        return 20.8 * hourPrice * hourDay;
    }

    public int getHourDay() {
        return hourDay;
    }
}