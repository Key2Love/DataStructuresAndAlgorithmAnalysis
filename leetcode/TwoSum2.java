/**
 * @program: algorithm
 * @description: 给你两个 非空 链表来代表两个非负整数。
 * 数字最高位位于链表开始位置。它们的每个节点只存储一位数字。
 * 将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * @author: Sunbuhui7
 * @create: 2020-04-14 11:30
 **/

import java.util.*;

/**
 * 小tips，涉及链表反转可以使用stack。
 */
public class TwoSum2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static int addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();
        while (l1 != null) {
            a.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            b.push(l2.val);
            l2 = l2.next;
        }
        int finnal = 0;
        int count = 0;
        int temp = 0;
        while (!a.isEmpty()) {
            temp = a.pop();
            finnal += temp * Math.pow(10, count);
            count++;
        }
        count = 0;
        while (!b.isEmpty()) {
            temp = b.pop();
            finnal += temp * Math.pow(10, count);
            count++;
        }
        return finnal;


    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();
        while (l1 != null) {
            a.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            b.push(l2.val);
            l2 = l2.next;
        }
        //进位数。
        int carry = 0;
        //定义了空头节点。
        ListNode head = null;
        //carry>0的意义在于如果最高位相加大于十，如果没有这一位判断那么错误。
        while (!a.isEmpty() || !b.isEmpty()||carry>0) {
            int sum = carry;
            //用于判断最高位相加的情况
            int stackA = a.isEmpty()?0:a.pop();
            int stackB = b.isEmpty()?0:b.pop();
            sum += stackA;
            sum += stackB;
            //例如18%10 = 8;余数
            //先初始化当前节点，让该节点指向头节点。
            //最后再头节点指定当前节点。
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode seven = new ListNode(7);
        ListNode two = new ListNode(2);
        ListNode four = new ListNode(4);
        ListNode three = new ListNode(3);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode one = new ListNode(1);
        seven.next = two;
        two.next = four;
        four.next = three;
        five.next = six;
        six.next = one;
        System.out.println(addTwoNumbers2(seven,five));


    }
}


