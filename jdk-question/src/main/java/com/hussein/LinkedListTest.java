package com.hussein;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * <p>Title: LinkedListTest</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/10/12 11:28 AM
 */
public class LinkedListTest {

    /**
     * LinkedList 内部使用双向链表实现，每次添加元素均维护pre,next,first,last
     * remove 只需要增加删除对应的节点重新维护对应的pre,next,first,last
     * get 判断与size的一半的关系 若小于则first使用next去找，否则使用last的pre去找
     */
    public static void main(String[] args) {
        List<KeyObject> list = new LinkedList<>();
        IntStream.range(1, 100).forEach(i -> {
            list.add(new KeyObject(i));
        });
        KeyObject keyObject = list.get(6);
        boolean contains = list.contains(keyObject);
        System.out.println(contains);
    }
}
