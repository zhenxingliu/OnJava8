package com.blueheart.onjava.lambda;

import org.junit.Test;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Java8 内置的四大核心接口
 * Consumer<T>：消费接口
 *      void accept(T t);
 *
 * Supplier<T>: 供给型接口
 *      T get();
 *
 * Function<T,R>: 函数型接口
 *      R apply(T t);
 *
 * Predicate<T>: 断言型接口
 *      boolean test(T t);
 */
public class TestLambda3 {

    //Predicate

    //Function

    //Supplier
    public List<Integer> suppl(int num, Supplier<Integer> supplier){
        return null;
    }

    @Test
    public void test1(){
        happy(10000,(m) -> System.out.println("double "+m +" consumer"));
    }


    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }

}
