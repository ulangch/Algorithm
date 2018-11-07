package com.ulangch.algorithm.linkedlist;

/**
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 进阶:
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * 示例:
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 * <p>
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 */
public class AddTwoNumbers2 {

    /**
     * 1. 对齐两个链表
     * 2. 迭代相加对齐部分
     * 3. 进位
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int length1 = 0, length2 = 0;
        ListNode cur1 = l1, cur2 = l2;
        while (cur1 != null) {
            length1++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            length2++;
            cur2 = cur2.next;
        }
        int step = length1 - length2;
        cur1 = l1; cur2 = l2;
        ListNode first = null, left = null;
        if (step > 0) {
            while (step > 1) {
                cur1 = cur1.next;
                step--;
            }
            first = l1;
            left = cur1;
            cur1 = cur1.next;
        } else if (step < 0){
            while (step < -1) {
                cur2 = cur2.next;
                step++;
            }
            first = l2;
            left = cur2;
            cur2 = cur2.next;
        }
        while (cur1 != null) {
            ListNode tmp = new ListNode(cur1.val + cur2.val);
            if (left == null) {
                left = tmp;
                first = tmp;
            } else {
                left.next = tmp;
                left = tmp;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        ListNode res = mergeRecursive(first, 0);
        if (res.val < first.val) {
            ListNode merge = new ListNode(1);
            merge.next = res;
            return merge;
        }
        return res;
    }

    private ListNode mergeRecursive(ListNode cur, int ind) {
        if (cur.next == null) {
            if (cur.val >= 10) {
                return new ListNode(cur.val - 10);
            } else {
                return cur;
            }
        } else {
            ListNode next = cur.next;
            ListNode res = mergeRecursive(next, ind + 1);
            int val = cur.val;
            if (next.val != res.val) {
                res.next = next.next;
                cur.next = res;
                if (res.val < next.val) {
                    val++;
                }
            }
            ListNode tmp = new ListNode(-1);
            if (val >= 10) {
                tmp.val = val - 10;
                tmp.next = res;
                return tmp;
            } else if (val != cur.val) {
                tmp.val = val;
                tmp.next = res;
                return tmp;
            }
            return cur;
        }
    }

    private void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AddTwoNumbers2 soln = new AddTwoNumbers2();
        ListNode l1 = new ListNode(0);

        ListNode r1 = new ListNode(7);
        ListNode r2 = new ListNode(3);
        r1.next = r2;
        soln.print(soln.addTwoNumbers(l1, r1));
    }
}
