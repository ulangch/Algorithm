package com.ulangch.algorithm.linkedlist;

/** 给定一个链表，判断链表中是否有环。
 *
 * 进阶：
 * 你能否不使用额外空间解决此题？
 *
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 ******************************************************
 *
 * 方法1：
 * 使用 “快慢指针” 来解决这个问题
 * 快慢指针： 设置两个指针，fast和slow，fast每次走两步，slow每次走一步，
 * 如果链表是封闭的，则成为一个追击问题，fast总会追上slow的
 *
 * 方法2：
 * 使用Hash表，保存已经被遍历过的node，如果再次被遍历，则说明存在环形列表
 */

public class CycleLinkedList {

    /** 使用快慢指针来实现*/
    public boolean hasCycle(ListNode head) {
        ListNode fast;
        ListNode slow;
        if (head == null || head.next == null) {
            return false;
        }
        fast = head.next;
        slow = head;
        while (fast != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next;
            if (fast == null) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode _1 = new ListNode(1);
        ListNode _2 = new ListNode(2);
        ListNode _3 = new ListNode(3);
        ListNode _4 = new ListNode(4);
        ListNode _5 = new ListNode(5);
        head.next = _1;
        _1.next = _2;
        _2.next = _3;
        _3.next = _4;
        _4.next = _5;
        _5.next = null;
        CycleLinkedList solution = new CycleLinkedList();
        System.out.println(solution.hasCycle(head));
    }
}
