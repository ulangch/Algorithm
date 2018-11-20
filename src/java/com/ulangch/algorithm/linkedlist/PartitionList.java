package com.ulangch.algorithm.linkedlist;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * https://leetcode-cn.com/problems/partition-list/
 */
public class PartitionList {

    /**
     * 记录上次交换插入的位置， 每次插入从该位置进行插入
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode lastInsert = new ListNode(-1);
        ListNode res = lastInsert;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val < x) {
                if (pre == null || pre.val < x) {
                    pre = cur;
                } else {
                    pre.next = next;
                }
                cur.next = lastInsert.next;
                lastInsert.next = cur;
                cur = next;
            } else {
                if (lastInsert.next == null) {
                    lastInsert.next = cur;
                }
                pre = cur;
                cur = next;
            }
        }
        return res.next;
    }

    private void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode _1 = new ListNode(1);
        ListNode _2 = new ListNode(2);
        ListNode _3 = new ListNode(3);
        _1.next = _2;
        _2.next = _3;
        PartitionList soln = new PartitionList();
        soln.print(soln.partition(_1, 4));
    }
}
