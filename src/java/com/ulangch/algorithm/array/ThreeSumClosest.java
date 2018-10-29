package com.ulangch.algorithm.array;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 *
 * https://leetcode-cn.com/problems/3sum-closest/
 */
public class ThreeSumClosest {

    /**
     * 思想：设定一个中数，对于每一个中数，改变left和right指针，使sum最接近target
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0, sub = 0, abssub = 0, clost = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length - 1; i++) {
            int left = 0, right = nums.length -1;
            while (left < i && right > i) {
                sub = nums[left] + nums[i] + nums[right] - target;
                abssub = Math.abs(sub);
                if (clost > abssub) {
                    clost = abssub;
                    sum = nums[left] + nums[i] + nums[right];
                }
                if (sub > 0) { right--; }
                else if (sub < 0) { left++; }
                else { sum = target; return sum; }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(new ThreeSumClosest().threeSumClosest(nums, 1));
    }
}
