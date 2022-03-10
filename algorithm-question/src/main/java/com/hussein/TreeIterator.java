package com.hussein;

import java.util.Stack;

/**
 * <p>Title: TreeIterator</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2022/3/10 4:32 PM
 */
public class TreeIterator {

    /**
     *                A
     *           B         C
     *        D     E   F      G
     *
     * 前序: 根左右  A->B->D->E->C->F->G
     * 中序: 左根右  D->B->E->A->F->C->G
     * 后续: 左右根  D->E->B->F->G->C->A
     */
    public static void main(String[] args) {
        TreeNode head = buildTree();
        System.out.println("前序遍历：");
        preOrder0(head);
        System.out.println();
        preOrder1(head);
        System.out.println();
        System.out.println("中序遍历：");
        middleOrder0(head);
        System.out.println();
        middleOrder1(head);
        System.out.println();
        System.out.println("后序遍历：");
        afterOrder0(head);
    }

    private static void afterOrder0(TreeNode head) {
        if(head == null){
            return;
        }
        afterOrder0(head.left);
        afterOrder0(head.right);
        System.out.print(head.value);
    }

    private static void middleOrder1(TreeNode head) {
       Stack<TreeNode> stack = new Stack<>();
       TreeNode curNode = head;
       while(curNode != null || !stack.isEmpty()){
           while(curNode != null){
               stack.push(curNode);
               curNode = curNode.left;
           }
           if(!stack.isEmpty()){
               TreeNode treeNode = stack.pop();
               System.out.print(treeNode.value);
               curNode = treeNode.right;
           }
       }
    }

    private static void middleOrder0(TreeNode head) {
        if(head == null){
            return;
        }
        middleOrder0(head.left);
        System.out.print(head.value);
        middleOrder0(head.right);
    }

    private static void preOrder0(TreeNode head) {
        if(head == null){
            return;
        }
        System.out.print(head.value);
        preOrder0(head.left);
        preOrder0(head.right);
    }

    private static void preOrder1(TreeNode head) {
        if(head == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(head);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            if(treeNode != null){
                System.out.print(treeNode.value);
                stack.add(treeNode.right);
                stack.add(treeNode.left);
            }
        }
        System.out.println();
    }

    private static TreeNode buildTree() {
        TreeNode head = new TreeNode("A");
        head.left = new TreeNode("B");
        head.right = new TreeNode("C");
        head.left.left = new TreeNode("D");
        head.left.right = new TreeNode("E");
        head.right.left = new TreeNode("F");
        head.right.right = new TreeNode("G");
        return head;
    }


    public static class TreeNode {

        public String value;

        public TreeNode left;

        public TreeNode right;

        public TreeNode(String value) {
            this.value = value;
        }
    }
}
