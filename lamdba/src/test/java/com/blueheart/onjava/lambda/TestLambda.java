package com.blueheart.onjava.lambda;

import com.blueheart.onjava.lamdba.Employee;
import com.blueheart.onjava.lamdba.FileterEmployeeBySalary;
import com.blueheart.onjava.lamdba.FilterEmployeeByAge;
import com.blueheart.onjava.lamdba.MyPredicate;
import org.junit.Test;

import java.util.*;

public class TestLambda {



    //原来的匿名内部类
    @Test
    public void test1(){
        Comparator<Integer> integerComparator = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        TreeSet<Integer> integers = new TreeSet<>(integerComparator);
    }

    //Lambda
    @Test
    public void test2(){
        Comparator<Integer> com = Integer::compare;
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    @Test
    public void test3(){
        List<Employee> employeeList = Arrays.asList(
                new Employee("张三",19,9999.9),
                new Employee("李四",18,3333),
                new Employee("王五",27,7777),
                new Employee("马六",40,4444.1),
                new Employee("赵七",45,5555.9)
        );

        List<Employee> list1 = filterEmployee1(employeeList);
        printlist(list1);

        List<Employee> list2 = filterEmployee2(employeeList, new FilterEmployeeByAge());
        printlist(list2);

        List<Employee> list3 = filterEmployee2(employeeList, new FileterEmployeeBySalary());
        printlist(list3);

        //匿名内部类
        List<Employee> employees = filterEmployee2(employeeList, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() < 5000;
            }
        });
        printlist(employees);



        //lambda
        System.out.println("============lambda==========");
        List<Employee> employees1 = filterEmployee2(employeeList, (e) -> e.getSalary() < 5000);
        employees1.forEach(System.out::println);

        //stream
        System.out.println("============stream==========");
        employeeList.stream().filter((e) ->e.getSalary()<5000).forEach(System.out::println);
        employeeList.stream().map(Employee::getName).forEach(System.out::println);


    }

    private void printlist(List<Employee> list) {
        System.out.println("=======================");
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    //传统方法实现我要过滤工资大于5000，年龄大于35岁的人员
    public List<Employee> filterEmployee1(List<Employee> employees){
        ArrayList<Employee> employeeArrayList = new ArrayList<Employee>();
        for (Employee employee : employees) {
            if(employee.getAge()>35 && employee.getSalary()>5000){
                employeeArrayList.add(employee);
            }
        }
        return employeeArrayList;
    }

    //策略模式
    public List<Employee> filterEmployee2(List<Employee> employees, MyPredicate<Employee> filter){
        List<Employee> employees1 = new ArrayList<>();
        for (Employee employee :
                employees) {
            if(filter.test(employee)){
                employees1.add(employee);
            }
        }
        return employees1;
    }











}
