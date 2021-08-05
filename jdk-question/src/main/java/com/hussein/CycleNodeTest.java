package com.hussein;

/**
 * <p>Title: CycleNodeTest</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2021/8/3 7:35 PM
 */
public class CycleNodeTest {

    public static void main(String[] args) {
        Cnode first = new Cnode(1);
        Cnode second = new Cnode(2);
        Cnode third = new Cnode(3);
        Cnode fourth = new Cnode(4);
        Cnode fifth = new Cnode(5);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = first;
        boolean isCycle = isCycle(first);
        System.out.println(isCycle);
    }

    private static boolean isCycle(Cnode first) {
        if (first == null || first.next == null) {
            return false;
        }
        Cnode slow = first;
        Cnode fast = first;
        while (fast != null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return  true;
            }
        }
        return false;
    }


    private static class Cnode {

        public int val;

        public Cnode next;

        public Cnode(int val) {
            this.val = val;
        }
    }

}

