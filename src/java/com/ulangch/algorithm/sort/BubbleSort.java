package com.ulangch.algorithm.sort;

import com.ulangch.algorithm.Utils;

/**
 * 冒泡排序
 *
 * 1. 从index(0)开始, 将相邻的两个数比较，大于则交换，一直遍历到index(n-2), n为数组长度，则一遍下来找到最大数，且放在index(n-1)的位置
 * 2. 重复上面的步骤, 遍历到index(n-3), 则找到第二大数字，且放在index(n-2)的位置
 * ...
 */

public class BubbleSort {
    public void sort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int length = nums.length;
        for (int i = length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 3, 2, 7, 1};
        new BubbleSort().sort(nums);
        Utils.print(nums);
    }
}
