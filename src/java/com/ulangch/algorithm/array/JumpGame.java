package com.ulangch.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 给定一个非负整数数组，你最初位于数组的第一个位置。
 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 判断你是否能够到达最后一个位置。

 示例 1:

 输入: [2,3,1,1,4]
 输出: true
 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 示例 2:

 输入: [3,2,1,0,4]
 输出: false
 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置

 https://leetcode-cn.com/problems/jump-game/
 */
public class JumpGame {
    /**
     使用贪心算法，完美解答：
     遍历数组一直跳就好,用max记录当前可以跳到的最大的步数,然后中间的用num[i] + i 去贪心的更新最大步骤即可。
     遍历的时候有几种情况：
     1.遍历完恰好跳到最后,或者可以跳过,是目标解;
     2.遍历的过程中遍历到第i个元素,结果前面无论怎么跳都跳不到这个地方，这个时候再怎么跳也跳不出来了.直接返回false.
     */
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            //贪心求解可以到达的最远步数.
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }

    /**使用回溯方法，会超时*/
    public boolean canJumpBackTrace(int[] nums) {
        List<Integer> path = new ArrayList<>();
        path.add(0);
        int res = backtrack(nums, path, 0, 0, nums.length - 1);
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        return res == 0;
    }

    private int backtrack(int[] nums, List<Integer> path, int start, int step, int target) {
        if (start + step == target) {
            return 0;
        } else if (start + step > target) {
            return -1;
        } else {
            for (int i = 1; i <= nums[start + step]; i++) {
                path.add(path.get(path.size() - 1) + i);
                int flag = backtrack(nums, path, path.get(path.size() - 2), i, target);
                if (flag == 0) {
                    return 0;
                }
                path.remove(path.size() - 1);
                if (flag == -1) {
                    break;
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        JumpGame soln = new JumpGame();
        System.out.println(soln.canJump(new int[]{2,3,1,1,4}));
        System.out.println(soln.canJump(new int[]{3,2,1,0,4}));
    }
}
