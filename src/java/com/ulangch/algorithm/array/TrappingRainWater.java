package com.ulangch.algorithm.array;

/**

 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

 @see TrappingRainWater.png

 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

 示例:

 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 输出: 6

 https://leetcode-cn.com/problems/trapping-rain-water/

 */

public class TrappingRainWater {

    /**
     双指针方法. (自写)
     */
    public int trap(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length - 2; i++) {
            if (height[i] <= height[i + 1]) {
                continue;
            }
            // 下一个高点，永远只考虑升序带来的收益
            // 降序的情况在下一次遍历i时会覆盖
            int peek = 0;
            for (int j = i+1; j < height.length; j++) {
                int cur = height[j];
                if (cur <= peek) {
                    continue;
                }
                sum += (Math.min(height[i], cur) - peek) * (j - i - 1);
                peek = cur;
                if (cur >= height[i]) {
                    break;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TrappingRainWater soln = new TrappingRainWater();
        System.out.println(soln.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
