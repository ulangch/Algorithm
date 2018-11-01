package com.ulangch.algorithm.linkedlist;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedList {

    /**
     * 每次找到最小的节点填充到新链表中，并在原来最小节点的位置放上该节点的下一节点
     *
     * 注明：可以用优先队列，或者直接放在一个列表中然后进行排序
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode tmp = null, res = null;
        while (true) {
            ListNode min = null;
            int minInd = -1;
            for (int i = 0; i < lists.length; i++) {
                ListNode cur = lists[i];
                if (cur == null) {
                    continue;
                }
                if (min == null || min.val > cur.val) {
                    min = cur;
                    minInd = i;
                }
            }
            if (min != null) {
                if (tmp == null) {
                    tmp = min;
                    res = tmp;
                } else {
                    tmp.next = min;
                    tmp = tmp.next;
                }
                lists[minInd] = min.next;
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
