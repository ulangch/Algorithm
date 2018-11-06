package com.ulangch.algorithm.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * <p>
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * <p>
 * https://leetcode-cn.com/problems/reorder-list/
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        if (list.size() <= 2) {
            return;
        }
        int j = list.size() - 1;
        ListNode l_left, left, r_left;
        ListNode l_right, right, r_right = null;
        for (int i = 1; i < list.size();) {
            if (i >= j) {
                break;
            }
            l_left = list.get(i - 1);
            left = l_left.next;
            r_left = left.next;
            l_right = list.get(j - 1);
            right = l_right.next;
            r_right = right.next;

            l_left.next = right;
            right.next = left;
            l_right.next = r_right;
            System.out.print("[" + i + ", " + j + "]: ");
            print(head);
            i++;
            j--;
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
        ListNode _1 = new ListNode(1);
        ListNode _2 = new ListNode(2);
        ListNode _3 = new ListNode(3);
        ListNode _4 = new ListNode(4);
        ListNode _5 = new ListNode(5);
        _1.next = _2;
        _2.next = _3;
        _3.next = _4;
        _4.next = _5;
        ReorderList soln = new ReorderList();
        soln.reorderList(_1);
    }
}
