package com.ulangch.algorithm.linkedlist;

/**
 * 对链表进行插入排序。
 * <p>
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * <p>
 * 插入排序算法：
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * <p>
 * 示例 1：
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * <p>
 * 示例 2：
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * https://leetcode-cn.com/problems/insertion-sort-list/
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = new ListNode(Integer.MIN_VALUE);
        res.next = head;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val < pre.val) {
                ListNode tmppre = null;
                ListNode tmp = res;
                while (tmp != cur) {
                    if (tmp.val > cur.val) {
                        tmppre.next = cur;
                        cur.next = tmp;
                        pre.next = next;
                        break;
                    }
                    tmppre = tmp;
                    tmp = tmp.next;
                }
                cur = next;
            } else {
                pre = cur;
                cur = next;
            }
        }
        return res.next;
    }

    public ListNode insertionSortList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            ListNode pre = res;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
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
        ListNode _1 = new ListNode(4);
        ListNode _2 = new ListNode(2);
        ListNode _3 = new ListNode(1);
        ListNode _4 = new ListNode(3);
        _1.next = _2;
        _2.next = _3;
        _3.next = _4;
        InsertionSortList soln = new InsertionSortList();
        soln.print(soln.insertionSortList2(_1));
    }
}
