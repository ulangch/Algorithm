package com.ulangch.algorithm.linkedlist;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedList {

    /**
     * 思想： 找到最小节点并记录和删除
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res, tmp;
        ListNode cur1 = l1, cur2 = l2;
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        if (cur1.val <= cur2.val) {
            res = cur1;
            tmp = cur1;
            cur1 = cur1.next;
        } else {
            res = cur2;
            tmp = cur2;
            cur2 = cur2.next;
        }
        while (true) {
            if (cur1 == null) {
                tmp.next = cur2;
                break;
            }
            if (cur2 == null) {
                tmp.next = cur1;
                break;
            }
            if (cur1.val <= cur2.val) {
                tmp.next = cur1;
                cur1 = cur1.next;
            } else {
                tmp.next = cur2;
                cur2 = cur2.next;
            }
            tmp = tmp.next;
        }
        return res;
    }

    public static void main(String[] args) {
        // 1->2->4, 1->3->4
        ListNode l_1 = new ListNode(1);
        ListNode l_2 = new ListNode(2);
        ListNode l_3 = new ListNode(4);
        l_1.next = l_2;
        l_2.next = l_3;

        ListNode r_1 = new ListNode(1);
        ListNode r_2 = new ListNode(3);
        ListNode r_3 = new ListNode(4);
        r_1.next = r_2;
        r_2.next = r_3;
        new MergeTwoSortedList().mergeTwoLists(l_1, r_1);


    }
}
