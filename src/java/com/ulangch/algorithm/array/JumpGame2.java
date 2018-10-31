package com.ulangch.algorithm.array;

/**
 给定一个非负整数数组，你最初位于数组的第一个位置。
 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 你的目标是使用最少的跳跃次数到达数组的最后一个位置。

 示例:
 输入: [2,3,1,1,4]
 输出: 2
 解释: 跳到最后一个位置的最小跳跃数是 2。
 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。

 说明:
 假设你总是可以到达数组的最后一个位置。

 https://leetcode-cn.com/problems/jump-game-ii/
 */
public class JumpGame2 {
    /**
     贪心算法：
     在当前位置可以跳的步数的范围内，选择下一跳可以跳的最远的那个步数，来决定当前跳多少步
     */
    public int jump(int[] nums) {
        int target = nums.length - 1;   // 目标位置
        int jumpCount = 0;              // 跳跃步数
        int left = 0, right = 0;        // 当前位置可跳的左右边界
        while (right < target) {
            int maxBound = right;
            for (int i = left; i <= right; i++) {
                maxBound = Math.max(nums[i] + i, maxBound);
            }
            left = right + 1;   // 下一跳左边界
            right = maxBound;   // 下一跳右边界
            jumpCount++;
        }
        return jumpCount;
    }

    public static void main(String[] args) {
        JumpGame2 soln = new JumpGame2();
        System.out.println(soln.jump(new int[]{2, 3, 1, 1, 4}));
    }
}
