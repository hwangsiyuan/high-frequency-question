package com.hussein;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * <p>Title: HashMapTest</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/10/11 11:49 AM
 */
public class HashMapTest {

    /**
     * 1、HashMap put 先计算位置为tab[hash&(cap-1)] 若没有元素则创建新的node，
     * 如果有则依次检查node及next.. 是否key,hash一致，一致更新值，否则增加新的node为next
     * 若node的数量超过树型的阀值则转换为红黑树结构，最后检查是否超过扩容的阈值-1，超过则进行扩容；
     * 2、HashMap get 先计算为值tab[hash&(cap-1)] 若不为空
     * 则检查node及next是否key,hash一致,若一致则返回对应的value，若为红黑树则查找到对应的节点，否则返回空;
     * 3、HashMap 扩容算法 容量及阀值均扩大2倍，原有的数据 按照 hash&[newCap-1]进行存放，如果该tab为树形结构则重新构造
     * <p>
     * 1.7与1.8的差异 1.7结构为 数组+链表 1.8 数组+链表+红黑树
     */
    public static void main(String[] args) {
        Map<KeyObject, Integer> map = new HashMap<>(4);
        List<KeyObject> keyList = new ArrayList<>();
        putValues(map, keyList);
        Integer v1 = map.get(keyList.get(5));
        Integer v2 = map.get(keyList.get(6));
        Integer v3 = map.get(keyList.get(7));
        System.out.println(v1 + v2 + v3);
    }

    static void putValues(Map<KeyObject, Integer> map, List<KeyObject> keyList) {
        IntStream.range(1, 100).forEach(i -> {
            KeyObject keyObject = new KeyObject(i);
            keyList.add(keyObject);
            map.put(keyObject, i);
        });
    }

}
