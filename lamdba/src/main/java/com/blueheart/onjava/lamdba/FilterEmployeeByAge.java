package com.blueheart.onjava.lamdba;


public class FilterEmployeeByAge implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getAge()>35;
    }
}
