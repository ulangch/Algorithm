package com.ulangch.algorithm.array;

/**

 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。

 示例 1:

 输入: [1,2,0]
 输出: 3
 示例 2:

 输入: [3,4,-1,1]
 输出: 2
 示例 3:

 输入: [7,8,9,11,12]
 输出: 1
 说明:

 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间

 https://leetcode-cn.com/problems/first-missing-positive/
 */

public class FirstMissingPositive {

    /**
     思想：
        1. 将nums[i]放置到nums[i] - 1的位置上
        2. 遍历数组，i位置的数如果不为i+1，则返回i+1
        3. 返回length+1
     */
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] > 0 && nums[i] < length && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return length + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive soln = new FirstMissingPositive();
        System.out.println(soln.firstMissingPositive(new int[]{1,2,0}));
        System.out.println(soln.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(soln.firstMissingPositive(new int[]{7,8,9,11,12}));
    }
}
