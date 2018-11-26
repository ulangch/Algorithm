package com.ulangch.algorithm.array;

import com.ulangch.algorithm.Utils;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1018/
 */
public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || k < 1 || k > nums.length) return Integer.MIN_VALUE;
        int part = partition(nums, 0, nums.length - 1);
        while (part != k - 1) {
            if (part < k - 1) {
                part = partition(nums, part + 1, nums.length - 1);
            } else {
                part = partition(nums, 0, part - 1);
            }
        }

        return nums[k - 1];
    }

    private int partition(int[] nums, int start, int end) {
        int k = nums[start];
        while (start < end) {
            while (start < end && nums[end] <= k) {
                end--;
            }
            if (nums[end] >= k) {
                int tmp = nums[end];
                nums[end] = nums[start];
                nums[start] = tmp;
            }
            while (start < end && nums[start] >= k) {
                start++;
            }
            if (nums[start] <= k) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        KthLargestElementInArray soln = new KthLargestElementInArray();
        System.out.println(soln.findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
    }
}
