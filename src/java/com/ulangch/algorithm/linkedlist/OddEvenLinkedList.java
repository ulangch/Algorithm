package com.ulangch.algorithm.linkedlist;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * <p>
 * 示例 2:
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * <p>
 * 说明:
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 * <p>
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 */
public class OddEvenLinkedList {

    /**
     * 将奇数节点插入到上次插入的位置
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;
        ListNode lastInsertOdd = head;
        ListNode preEven = head.next;
        ListNode curOdd = preEven.next;
        while (preEven != null && curOdd != null) {
            ListNode next = curOdd.next;
            curOdd.next = lastInsertOdd.next;
            lastInsertOdd.next = curOdd;
            lastInsertOdd = curOdd;

            preEven.next = next;
            preEven = next;
            if (next == null) {
                break;
            }
            curOdd = next.next;
        }
        return head;
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
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        OddEvenLinkedList soln = new OddEvenLinkedList();
        soln.print(soln.oddEvenList(l1));
    }
}
