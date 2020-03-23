package charpter3;

import charpter3.MyLinkedList;;

/**
 * 3.2 Swap two adjacent elements by adjusting only the links (and not the data)
 * using: a. Singly linked lists. b. Doubly linked lists.
 */
public class E2 {
    /**
     * @apiNote 实现双链表
     * @param node
     */
    public static void swap(Node<Integer> node) {
        Node beforeNode, afterNode;
        beforeNode = node.prev;
        afterNode = node.next;

        node.next = afterNode.next;
        afterNode.next.prev = node;
        afterNode.next = node;
        node.prev = afterNode;
        beforeNode.next = afterNode;
        afterNode.prev = beforeNode;

    }
    /**
     * @apiNote 实现单链表
     * @param beforeNode
     * @param x
     */
    public static void swap(Node<Integer> beforeNode, int x) {
        Node node, afterNode;
        node = beforeNode.next;
        afterNode = node.next;

        beforeNode.next = afterNode;
        afterNode.next = node;
        node.next = null;
  
    }

}