package com.ulangch.algorithm.linkedlist;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * <p>
 * 说明：
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEnd {

    /**
     * 递归寻找node的rIndex(从右边开始计算的index)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int flag = recursive(null, head, n);
        if (flag == -1) {
            return head.next;
        } else {
            return head;
        }
    }

    private int recursive(ListNode pre, ListNode cur, int n) {
        if (cur == null) {
            return 0;
        }
        int index = recursive(cur, cur.next, n);
        if (index == n - 1) {
            if (pre != null) {
                pre.next = cur.next;
            } else {
                return -1;
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        ListNode _1 = new ListNode(1);
        ListNode _2 = new ListNode(2);
        ListNode _3 = new ListNode(3);
        ListNode _4 = new ListNode(4);
        ListNode _5 = new ListNode(5);
        ListNode _6 = new ListNode(6);
        ListNode _7 = new ListNode(7);
        _1.next = _2;
        _2.next = _3;
        _3.next = _4;
        _4.next = _5;
        _5.next = _6;
        _6.next = _7;
        _7.next = null;
        RemoveNthNodeFromEnd soln = new RemoveNthNodeFromEnd();
        ListNode res = soln.removeNthFromEnd(_1, 3);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
