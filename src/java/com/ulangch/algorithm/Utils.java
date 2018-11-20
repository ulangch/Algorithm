package com.ulangch.algorithm;

import com.ulangch.algorithm.linkedlist.ListNode;

public class Utils {

    public static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode buildList(int[] nums) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode res = dummy;
        for (int e : nums) {
            dummy.next = new ListNode(e);
            dummy = dummy.next;
        }
        return res.next;
    }
}
