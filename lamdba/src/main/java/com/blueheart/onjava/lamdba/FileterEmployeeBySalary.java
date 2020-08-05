package com.blueheart.onjava.lamdba;

public class FileterEmployeeBySalary implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary()>5000;
    }
}
