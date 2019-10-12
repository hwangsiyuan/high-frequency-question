package com.hussein;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * <p>Title: ArrayListTest</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/10/12 10:17 AM
 */
public class ArrayListTest {

    /**
     * ArrayList 内部用数组实现，每次扩容为原来的1.5倍 使用Arrays.copyOf存放到新的数组中
     * get 判断是否超过数组的index范围，不超过直接取数组的对应index数据
     * contains 迭代数组依次判断equals找到相等的就返回true
     */
    public static void main(String[] args) {
        List<KeyObject> list = new ArrayList<>(6);
        IntStream.range(1, 100).forEach(i -> {
            list.add(new KeyObject(i));
        });
        KeyObject keyObject = list.get(5);
        boolean contains = list.contains(keyObject);
        System.out.println(contains);
    }
}
