package com.hussein;
import com.hussein.TreeIterator.MyNode;

import java.util.Stack;

/**
 * <p>Title: TreeIterator</p>
 * <p>Description: 二叉树非递归遍历</p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2021/6/25 4:06 PM
 */
public class TreeIterator {

    /**
     *                         10
     *              6                          15
     *       4            8            12              18
     *    1      5     7      9    11      13      16       19
     */
    public static void main(String[] args) {
        MyNode node  = buildNode();
        //前序遍历
        preOrder(node);
    }

    private static void preOrder(MyNode root) {
        if(root == null) {
            System.out.println("空树");
            return;
        }
        Stack<MyNode> s = new Stack<>();
        //根节点入栈
        s.push(root);
        while(!s.empty()) {
            //1.访问根节点
            MyNode p = s.pop();
            System.out.print(p.getData() + " ");
            //2.如果根节点存在右孩子，则将右孩子入栈
            if(p.getRight() != null) {
                s.push(p.getRight());
            }
            //3.如果根节点存在左孩子，则将左孩子入栈
            if(p.getLeft() != null) {
                s.push(p.getLeft());
            }
        }
        System.out.println();
    }

    private static MyNode buildNode() {
        MyNode root = new MyNode("10");
        MyNode left = buildLeftNode();
        root.setLeft(left);
        MyNode right = buildRightNode();
        root.setRight(right);
        return root;
    }

    private static MyNode buildRightNode() {
        MyNode root = new MyNode("15");
        MyNode left = new MyNode("12");
        left.setLeft(new MyNode("11"));
        left.setRight(new MyNode("13"));
        MyNode right = new MyNode("18");
        right.setLeft(new MyNode("16"));
        right.setRight(new MyNode("19"));
        root.setLeft(left);
        root.setRight(right);
        return root;
    }

    private static MyNode buildLeftNode() {
        MyNode root = new MyNode("6");
        MyNode left = new MyNode("4");
        left.setLeft(new MyNode("1"));
        left.setRight(new MyNode("5"));
        MyNode right = new MyNode("8");
        right.setLeft(new MyNode("7"));
        right.setRight(new MyNode("9"));
        root.setLeft(left);
        root.setRight(right);
        return root;
    }


    public static class MyNode{

        private String data;

        private MyNode left;

        private MyNode right;

        public MyNode(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public MyNode getLeft() {
            return left;
        }

        public void setLeft(MyNode left) {
            this.left = left;
        }

        public MyNode getRight() {
            return right;
        }

        public void setRight(MyNode right) {
            this.right = right;
        }
    }
}
