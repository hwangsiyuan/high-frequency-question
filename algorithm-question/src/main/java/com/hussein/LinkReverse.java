package com.hussein;

/**
 * <p>Title: LinkReverse</p>
 * <p>Description:  </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2022/3/11 3:12 PM
 */
public class LinkReverse {

    public static void main(String[] args) {
        //A->B->C->D->E->F
        Node node = buildNode();
        Node reverseNode = reverseNode(node);
        while(reverseNode != null){
            System.out.print(reverseNode.value);
            reverseNode = reverseNode.next;
        }
        System.out.println();
    }

    private static Node reverseNode(Node head) {
        Node prev = null, current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private static Node buildNode() {
        Node head = new Node("A");
        head.next = new Node("B");
        head.next.next = new Node("C");
        head.next.next.next = new Node("D");
        head.next.next.next.next = new Node("E");
        head.next.next.next.next.next = new Node("F");
        return head;
    }

    public static class Node {

        String value;

        Node next;

        public Node(String value) {
            this.value = value;
        }
    }
}
