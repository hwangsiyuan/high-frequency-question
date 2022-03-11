package com.hussein;

import java.util.*;

/**
 * <p>Title: NodeInterator</p>
 * <p>Description:</p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2021/9/27 3:00 PM
 */
public class NodeInterator {

    public static void main(String[] args) {
        /**
         *                      10
         *         7                            15
         *     3       9                 13            17
         *
         */
        Node node = initNode();
        System.out.println("前序遍历: ");
        //前序遍历1
        List<Integer> p1List = preOrderIterator1(node);
        System.out.println(p1List);
        //前序遍历2
        List<Integer> p2List = preOrderIterator2(node);
        System.out.println(p2List);
        //前序遍历3
        List<Integer> p3List = preOrderIterator3(node);
        System.out.println(p3List);
        System.out.println();
        System.out.println("中序遍历: ");
        //中序遍历1
        List<Integer> m1List = midOrderIterator1(node);
        System.out.println(m1List);
        //中序遍历2
        List<Integer> m2List = midOrderIterator2(node);
        System.out.println(m2List);
        System.out.println();
        System.out.println("后序遍历: ");
        //后续遍历1
        List<Integer> a1List = afterOrderIterator1(node);
        System.out.println(a1List);
        //后续遍历2
        List<Integer> a2List = afterOrderIterator2(node);
        System.out.println(a2List);
        System.out.println();
        //层遍历
        List<List<Integer>> levelList = levelIterator(node);
        System.out.println(levelList);
        System.out.println();
    }

    private static List<Integer> preOrderIterator3(Node node) {
        List<Integer> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        Stack<Node> stack = new Stack();
        stack.push(node);
        while (stack.size() != 0) {
            Node root = stack.pop();
            if (root != null) {
                res.add(root.val);
                stack.add(root.right);
                stack.push(root.left);
            }
        }
        return res;
    }

    private static List<List<Integer>> levelIterator(Node node) {
        List<List<Integer>> levelList = new ArrayList();
        if (node == null) {
            return levelList;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> rowValue = new ArrayList<>();
            while (n > 0) {
                Node curnode = q.poll();
                rowValue.add(curnode.val);
                if (curnode.left != null) {
                    q.offer(curnode.left);
                }
                if (curnode.right != null) {
                    q.offer(curnode.right);
                }
                n--;
            }
            levelList.add(rowValue);
        }
        return levelList;
    }

    private static List<Integer> afterOrderIterator2(Node node) {
        List<Integer> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        Node curNode = node;
        while (curNode != null || !stack1.isEmpty()) {
            while (curNode != null) {
                stack1.push(curNode);
                stack2.push(curNode);
                curNode = curNode.right;
            }
            if (!stack1.isEmpty()) {
                curNode = stack1.pop();
                curNode = curNode.left;
            }
        }
        while (!stack2.isEmpty()) {
            curNode = stack2.pop();
            res.add(curNode.val);
        }
        return res;
    }

    private static List<Integer> afterOrderIterator1(Node node) {
        List<Integer> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        List<Integer> leftVals = afterOrderIterator1(node.left);
        res.addAll(leftVals);
        List<Integer> rightVals = afterOrderIterator1(node.right);
        res.addAll(rightVals);
        res.add(node.val);
        return res;
    }

    private static List<Integer> midOrderIterator2(Node node) {
        List<Integer> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        Node curNode = node;
        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            if (!stack.isEmpty()) {
                curNode = stack.pop();
                res.add(curNode.val);
                curNode = curNode.right;
            }
        }
        return res;
    }

    private static List<Integer> midOrderIterator1(Node node) {
        List<Integer> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        List<Integer> leftVals = midOrderIterator1(node.left);
        res.addAll(leftVals);
        res.add(node.val);
        List<Integer> rightVals = midOrderIterator1(node.right);
        res.addAll(rightVals);
        return res;
    }

    private static List<Integer> preOrderIterator2(Node node) {
        List<Integer> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node curNode = stack.pop();
            res.add(curNode.val);
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
        }
        return res;
    }

    private static List<Integer> preOrderIterator1(Node node) {
        List<Integer> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        res.add(node.val);
        List<Integer> leftVals = preOrderIterator1(node.left);
        res.addAll(leftVals);
        List<Integer> rightVals = preOrderIterator1(node.right);
        res.addAll(rightVals);
        return res;
    }

    private static Node initNode() {
        Node root = new Node(10);
        Node left = root.left = new Node(7);
        left.left = new Node(3);
        left.right = new Node(9);
        Node right = root.right = new Node(15);
        right.left = new Node(13);
        right.right = new Node(17);
        return root;
    }

    public static class Node {

        int val;

        Node left;

        Node right;

        public Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }
}
