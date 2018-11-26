package com.ulangch.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * <p>
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1019/
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int left = 0, right = 0;
            // 如果已经计算过，则忽略
            if (map.get(cur) != null) continue;
            // 计算左边
            if (map.get(cur - 1) != null) {
                left += map.get(cur - 1);
            }
            // 计算右边
            if (map.get(cur + 1) != null) {
                right += map.get(cur + 1);
            }

            // 计算并更新当前
            int length = left + 1 + right;
            map.put(cur, length);

            // 更新左端点
            if (left != 0) map.put(cur - left, length);
            // 更新右端点
            if (right != 0) map.put(cur + right, length);

            if (maxLength < length) maxLength = length;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence soln = new LongestConsecutiveSequence();
        System.out.println(soln.longestConsecutive(new int[] {1, 3, 5, 2, 4}));
    }
}
