package com.ulangch.algorithm.linkedlist;


/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */

public class ReverseLinkedList2 {

    /**
     * 自己写的方法，比较复杂
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode boardLeft = null;
        ListNode boardRight = null;
        ListNode rotateLeft = null; // 旋转后的左侧值
        ListNode rotateRight = null; // 旋转后的右侧值
        ListNode res;
        int index = 1;
        if (m == n) {
            return head;
        }
        while (cur != null) {
            ListNode next = cur.next;
            if (index == m - 1) {
                boardLeft = cur;
                cur = next;
            } else if (index >= m && index <= n) {
                if (index == m) {
                    rotateRight = cur;
                } else if (index == n) {
                    rotateLeft = cur;
                    boardRight = next;
                }
                cur.next = pre;
                pre = cur;
                cur = next;
            } else {
                cur = next;
            }
            index++;
        }
        if (boardLeft != null) {
            boardLeft.next = rotateLeft;
            res = head;
        } else {
            res = rotateLeft;
        }
        if (rotateRight != null) {
            rotateRight.next = boardRight;
        }
        return res;
    }

    // TODO: 更易懂的方式：for循环到需要反转的点，在反转区间内迭代反转
    // @see https://www.cnblogs.com/ariel-dreamland/p/9159570.html

    public static void main(String[] args) {

    }
}
