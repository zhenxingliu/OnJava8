package com.blueheart.onjava.lamdba;

/**
 * @author liuzhenxing
 */
public interface MyPredicate<T> {

    /**
     * 一个函数式比较接口，执行对业务类型的的判断，根据判断返回true 或 false
     * @param t 业务类型
     * @return true或false
     */
    boolean test(T t);

}
