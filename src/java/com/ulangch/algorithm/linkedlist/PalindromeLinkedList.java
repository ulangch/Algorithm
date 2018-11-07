package com.ulangch.algorithm.linkedlist;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * <p>
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * <p>
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;  // 空集也是回文集
        if (head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode rightHalf = slow.next;
        ListNode rightPre = null;
        while (rightHalf != null) {
            ListNode next = rightHalf.next;
            rightHalf.next = rightPre;
            if (next == null) break;
            rightPre = rightHalf;
            rightHalf = next;
        }
        while (rightHalf != null) {
            if (head.val != rightHalf.val) return false;
            rightHalf = rightHalf.next;
            head = head.next;
        }
        return true;
    }

    private void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        PalindromeLinkedList soln = new PalindromeLinkedList();
        System.out.println(soln.isPalindrome(l1));
    }




    /**
     * 解题思路：
     * 将前半部分链表反转，并与后半部分链表比较
     */

    /**
     * 注明：
     * 可以使用栈来解决，空间复杂度O(n/2)，
     * 栈保存链表的前半部分（利用快慢指针来确定前半部分，快指针到达最后，慢指针的位置即为中间点），
     * 出栈与慢指针对比
     */
}
