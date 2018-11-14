package com.ulangch.algorithm.sort;

import com.ulangch.algorithm.Utils;

/**
 * 快速排序
 * 快速排序的原理：选择一个关键值作为基准值。比基准值小的都在左边序列（一般是无序的），比基准值大的都在右边（一般是无序的）。一般选择序列的第一个元素。
 * <p>
 * 一次循环：从后往前比较，用基准值和最后一个值比较，如果比基准值小的交换位置，如果没有继续比较下一个，直到找到第一个比基准值小的值才交换。
 * 找到这个值之后，又从前往后开始比较，如果有比基准值大的，交换位置，如果没有继续比较下一个，直到找到第一个比基准值大的值才交换。
 * 直到从前往后的比较索引>从后往前比较的索引，结束第一次循环，此时，对于基准值来说，左右两边就是有序的了。
 * <p>
 * 接着分别比较左右两边的序列，重复上述的循环。
 *
 * https://www.cnblogs.com/hjy9420/p/5032309.html
 */
public class QuickSort {

    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int lo, int hi) {
        int start = lo, end = hi;
        int key = nums[start];
        while (start < end) {
            // 从后往前比较
            while (start < end && nums[end] >= key) {
                end--;
            }
            if (nums[end] < key) {
                int tmp = nums[end];
                nums[end] = key;
                nums[start] = tmp;
            }
            // 从前往后比较，key在end的位置
            while (start < end && nums[start] <= key) {
                start++;
            }
            if (nums[start] > key) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
            }
        }
        // 左边 < 关键值 < 右边
        // 递归使用同样的方式对左边和右边进行快排
        if (start > lo) sort(nums, lo, start - 1);
        if (hi > end) sort(nums, end + 1, hi);
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 4, 3, 1, 2, 0};
        new QuickSort().sort(nums);
        Utils.print(nums);
    }
}
