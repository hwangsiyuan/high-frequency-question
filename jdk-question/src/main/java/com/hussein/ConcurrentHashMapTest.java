package com.hussein;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>Title: ConcurrentMapTest</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/10/11 5:08 PM
 */
public class ConcurrentHashMapTest {

    /**
     * put 1.7 使用reentrantLock  锁住segment 然后在segment对应的hashEntry中进行操作
     * put 1.8 使用 CAS与synchronized 若找不到对应的元素则 用CAS创建，
     * 否则在同步块中进行操作(先从原有的节点中找，找不到作为最后一个节点的next)，最后判断是否要转换为红黑树
     * 结构 1.7 使用 segment数组  1.8 使用 数组+链表(红黑树)
     * 扩容算法 1.7在segment中操作与hashMap类似 1.8 使用CAS 进行扩容 若扩容后小于6则红黑树转为链表
     */
    public static void main(String[] args) {
        Map<KeyObject, Integer> map = new ConcurrentHashMap<>(4);
        List<KeyObject> keyList = new ArrayList<>();
        HashMapTest.putValues(map, keyList);
        Integer v1 = map.get(keyList.get(5));
        Integer v2 = map.get(keyList.get(6));
        Integer v3 = map.get(keyList.get(7));
        System.out.println(v1 + v2 + v3);
    }


}
