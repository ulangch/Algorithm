package com.ulangch.algorithm.linkedlist;

/**

 反转一个单链表。

 示例:

 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL
 进阶:
 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

 https://leetcode-cn.com/problems/reverse-linked-list/
 */

public class ReverseLinkedList {

    /** 迭代处理 */
    public ListNode reverseListItr(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = null, cur = head, pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                res = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return res;
    }

    public ListNode reverseListRecur(ListNode head) {
        if (head == null || head.next == null) { return head; }
        ListNode rHead = reverseListRecur(head.next);
        head.next.next = head;
        head.next = null;
        return rHead;
    }

    public static void main(String[] args) {
        ListNode _1 = new ListNode(1);
        ListNode _2 = new ListNode(2);
        ListNode _3 = new ListNode(3);
        ListNode _4 = new ListNode(4);
        ListNode _5 = new ListNode(5);
        ListNode _6 = new ListNode(6);
        _1.next = _2;
        _2.next = _3;
        _3.next = _4;
        _4.next = _5;
        _5.next = _6;
        _6.next = null;
        ListNode cur = _1;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = new ReverseLinkedList().reverseListRecur(_1);
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}
