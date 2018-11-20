package com.ulangch.algorithm.sort;

import com.ulangch.algorithm.Utils;
import com.ulangch.algorithm.linkedlist.ListNode;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * <p>
 * 示例 2:
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * https://leetcode-cn.com/problems/sort-list/
 */
public class SortList {

    /**
     * 归并排序
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 将链表分为左右两部分
        pre.next = null;
        head = sortList(head);
        slow = sortList(slow);
        ListNode tmp = merge(head, slow);
        return tmp;
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode res = dummy;
        while (l != null && r != null) {
            if (l.val < r.val) {
                dummy.next = l;
                l = l.next;
            } else {
                dummy.next = r;
                r = r.next;
            }
            dummy = dummy.next;
        }
        while (l != null) {
            dummy.next = l;
            dummy = l;
            l = l.next;
        }
        while (r != null) {
            dummy.next = r;
            dummy = r;
            r = r.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode root = Utils.buildList(new int[]{-1, 5, 3, 4, 0});
        Utils.print(root);
        Utils.print(new SortList().sortList(root));
    }
}
