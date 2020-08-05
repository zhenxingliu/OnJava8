package com.blueheart.onjava.lambda;

import com.blueheart.onjava.lamdba.Employee;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 方法引用
 *      对象：：实例方法名
 *      类：：静态方法名
 *      类：：实例方法名
 */
public class TestLambda4 {

    @Test
    public void test1(){
        Consumer<String> con = System.out::println;
        con.accept("abcd");
    }

    @Test
    public void test2(){
        Employee emp = new Employee("zah",11,22);
        Supplier<String> sup = () -> emp.getName();
        System.out.println(sup.get());

        Supplier<Integer> sup2 = emp::getAge;
        System.out.println(sup2.get());
    }



}
