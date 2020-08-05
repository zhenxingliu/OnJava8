package com.blueheart.onjava.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda -> 操作符
 * 左侧：参数列表
 * 右侧：所需要执行的功能 Lambda体
 *  语法1：无参，无返回值
 *      () -> System.out.println("hello");
 *  语法2:有一个参数，无返回值
 *      (x) -> System.out.println("hello");
 *  语法3:有多个参数，并且有多条语句，有返回值
 *
 *
 */
public class TestLambda2 {

    @Test
    public void test1(){
        int num = 0; // final
        Runnable r0 = new Runnable() {


            @Override
            public void run() {
                System.out.println("runnable" + num);
            }
        };

        r0.run();
        Runnable  r1 = () -> System.out.println("runnable" + num);
        r1.run();
    }

    @Test
    public void test2(){
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("aaaaaaaaaaa");
    }

    @Test
    public void test3(){
        Comparator<Integer> con = (x,y) -> {
            System.out.println("con");
            return Integer.compare(x,y);
        };
        con.compare(11,22);
    }

    @Test
    public void test4(){
        Comparator<Integer> con = (x,y) -> Integer.compare(x,y);
        con.compare(11,22);
    }

    @Test
    public void test5(){
        Comparator<Integer> con = Integer::compare;
        con.compare(11,22);
    }

}
