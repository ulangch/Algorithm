package com.ulangch.algorithm.linkedlist;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 */
public class CycleLinkedList2 {

    /**
     * 解题目思路：
     * 1. 快慢指针确定是否有环
     * 2. 假设环开始的位置为A, 首节点到A的距离为a（未知）；快慢指针相遇的位置为B, A到B的距离为b
     * 3. 则： a+b为慢指针走的距离， 2*(a+b)为快指针走的距离
     * 4. 则： 慢指针从B点出发走 (a+b)的距离可以回到B，走 a 的距离可以到A
     * 5. 因此可以设定另一个指针 p 和 慢指针 s 同时从首节点和 B 出发，相遇的位置则为 A 的位置。
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode pSlow = head, pFast = head;
        // 检测是否有环
        boolean cycle = false;
        while (pFast != null) {
            pFast = pFast.next;
            if (pFast == null) {
                break;
            }
            pFast = pFast.next;
            pSlow = pSlow.next;
            if (pFast == pSlow) {
                cycle = true;
                break;
            }
        }
        if (!cycle) {
            return null;
        }
        // 查找 A 的位置
        ListNode pTrack = head;
        while (pTrack != pSlow) {
            pTrack = pTrack.next;
            pSlow = pSlow.next;
        }
        return pTrack;
    }

    public static void main(String[] args) {
        ListNode _1 = new ListNode(1);
        ListNode _2 = new ListNode(2);
        ListNode _3 = new ListNode(3);
        ListNode _4 = new ListNode(4);
        ListNode _5 = new ListNode(5);
        ListNode _6 = new ListNode(6);
        ListNode _7 = new ListNode(7);
        ListNode _8 = new ListNode(8);
        ListNode _9 = new ListNode(9);
        _1.next = _2;
        _2.next = _3;
        _3.next = _4;
        _4.next = _5;
        _5.next = _6;
        _6.next = _7;
        _7.next = _8;
        _8.next = _9;
        _9.next = _4;
        ListNode res = new CycleLinkedList2().detectCycle(_1);
        if (res != null) {
            System.out.println(res.val);
        }
    }
}
