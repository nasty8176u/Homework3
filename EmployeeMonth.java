package company.employees;

public class EmployeeMonth extends SuperEmployees{
    double priceMounts;

    public EmployeeMonth(String name, String family, double priceMounts) {
        super(name, family);
        this.priceMounts = priceMounts;
    }

    @Override
    public double getSalary() {
        return priceMounts;
    }

    public double getPriceMounts() {
        return priceMounts;
    }


}