package com.ulangch.algorithm.linkedlist;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * <p>
 * 例如，下面的两个链表：
 * A:      a1 → a2↘
 *                 c1 → c2 → c3
 *                ↗
 * B: b1 → b2 → b3
 * 在节点 c1 开始相交。
 * <p>
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionOfTwoList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lengthA = 0;
        int lengthB = 0;
        ListNode curA = headA, curB = headB;
        while (curA != null) {
            lengthA++;
            curA = curA.next;
        }
        while (curB != null) {
            lengthB++;
            curB = curB.next;
        }
        int step = lengthA - lengthB;
        if (step > 0) {
            while (headA != null && step > 0) {
                headA = headA.next;
                step--;
            }
        } else if (step < 0) {
            while (headB != null && step < 0) {
                headB = headB.next;
                step++;
            }
        }
        while (headA != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}


/**
 * 思想：先保证两条链表的长度一致，然后一遍循环找到相交节点
 */
