package com.ulangch.algorithm.linkedlist;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 说明:
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode res = null;
        while (cur != null) {
            ListNode next = cur.next;
            if (pre == null) {
                res = next;
            }
            cur.next = pre;
            if (pre!= null && next != null) {
                pre.next = next;
            }
            pre = cur;
            cur = next;
        }
        return res;
    }

    private void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        SwapNodesInPairs soln = new SwapNodesInPairs();
        ListNode _1 = new ListNode(1);
        ListNode _2 = new ListNode(2);
        ListNode _3 = new ListNode(3);
        ListNode _4 = new ListNode(4);
        _1.next = _2;
        _2.next = _3;
        _3.next = _4;
        _4.next = null;
        ListNode head = soln.swapPairs(_1);
        soln.print(head);
    }
}
