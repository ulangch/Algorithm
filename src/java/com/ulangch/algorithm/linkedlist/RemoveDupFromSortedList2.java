package com.ulangch.algorithm.linkedlist;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * <p>
 * 示例 2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * <p>
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDupFromSortedList2 {

    /**
     * 解题思想：
     * 1. 定义两个指针pre和cur指向同一个node
     * 2. 如果当前node值与后面节点的值相同，则cur = cur.next
     * 3. 比较pre和node，相等则说明未重复
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode reslist = new ListNode(Integer.MIN_VALUE);
        ListNode res = reslist;
        ListNode pre = head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            // 将cur指针指向最后一个与pre重复的node
            while (cur.next != null && cur.next.val == pre.val) {
                cur = cur.next;
            }
            // 如果cur和pre指向同一个node，说明该node没有重复
            // 添加到新链表中
            if (pre == cur) {
                reslist.next = cur;
                reslist = cur;
            }
            pre = cur.next;
            cur = cur.next;
        }
        reslist.next = cur;
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
        ListNode _2 = new ListNode(1);
        ListNode _3 = new ListNode(2);
        _1.next = _2;
        _2.next = _3;
        RemoveDupFromSortedList2 soln = new RemoveDupFromSortedList2();
        soln.print(soln.deleteDuplicates(_1));
    }
}
