package com.ulangch.algorithm.linkedlist;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 * <p>
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * <p>
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDupFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null) {
            ListNode tmp = next.next;
            if (cur.val == next.val) {
                cur.next = tmp;
                next = tmp;

            } else {
                cur = next;
                next = tmp;
            }
        }
        return head;
    }
}
