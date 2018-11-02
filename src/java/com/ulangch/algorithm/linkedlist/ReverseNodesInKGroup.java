package com.ulangch.algorithm.linkedlist;

/**
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * <p>
 * 示例 :
 * 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode rHead = reverseRecur(head, new ListNode[1], k, 0);
        if (rHead == null) {
            return head;
        }
        return rHead;
    }

    /**
     * @param cur       当前遍历的节点
     * @param nextBoard 下一组的开始节点
     * @param k
     * @param ind       当前遍历节点在组中的位置
     * @return          翻转后的头节点
     * <p>
     * 算法思想：
     * 深度优先遍历，从右侧第一组开始在组内进行反转，记录翻转后的头节点
     * 始终关注边界问题
     */
    public ListNode reverseRecur(ListNode cur, ListNode[] nextBoard, int k, int ind) {
        if (cur == null) {
            return null;
        }
        int nextInd;
        if (ind >= k - 1) {
            nextInd = 0;
        } else {
            nextInd = ind + 1;
        }
        ListNode rHead = reverseRecur(cur.next, nextBoard, k, nextInd);
        if (rHead == null) {
            if (ind == 0 || ind == k - 1) {
                rHead = cur;
            }
        } else {
            if (ind < k - 1) {
                cur.next.next = cur;
                cur.next = null;
            }
            if (ind == k - 1) {
                nextBoard[0] = rHead;
                rHead = cur;
            }
            if (ind == 0) {
                cur.next = nextBoard[0];
            }
        }
        return rHead;
    }

    private void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
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
        ReverseNodesInKGroup soln = new ReverseNodesInKGroup();
        soln.print(soln.reverseKGroup(_1, 2));
    }
}
