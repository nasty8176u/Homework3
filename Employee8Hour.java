package company.employees;

public class Employee8Hour extends SuperEmployees {
    double hourPrice;

    public Employee8Hour(String name, String family, double hourPrice) {
        super(name, family);
        this.hourPrice = hourPrice;
    }

    @Override
    public double getSalary() {
        return 20.8 * 8 * hourPrice;
    }

    public double getHourPrice() {
        return hourPrice;
    }
}