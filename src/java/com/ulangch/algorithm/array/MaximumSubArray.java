package com.ulangch.algorithm.array;

/**
 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

 示例:
 输入: [-2,1,-3,4,-1,2,1,-5,4],
 输出: 6
 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 进阶:

 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

 https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaximumSubArray {

    /** 暴力法 O(n2)*/
    public int maxSubArray1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    /**
     * 扫描法 O(n)
     *
     * 对于每次遍历的位置，如果前面的最大sum < 0; 则抛弃前面的sum，
     * 否则由于前面的sum有意义，则加上当前遍历的值。
     */
    public int maxSubArray2(int[] nums) {
        int max = nums[0];
        int preSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (preSum <= 0) {
                preSum = nums[i];
            } else {
                preSum += nums[i];
            }
            max = Math.max(preSum, max);
        }
        return max;
    }

    /** 动态规划O(n)
     动态转移方程： dp[i] = max(dp[i - 1] + nums[i], nums[i])
     */
    public int maxSubArray3(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubArray soln = new MaximumSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(soln.maxSubArray1(nums));
        System.out.println(soln.maxSubArray2(nums));
        System.out.println(soln.maxSubArray3(nums));
    }
}
