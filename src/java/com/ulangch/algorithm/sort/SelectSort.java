package com.ulangch.algorithm.sort;

import com.ulangch.algorithm.Utils;

/**
 * 选择排序
 *
 * 1.将每个数与index(0)进行比较，大于则交换，一次下来找到最小值且放在index(0)的位置
 * 2.将每个数与index(1)比较，一次遍历找到第二小值且放在index(1)的位置
 */
public class SelectSort {

    public void sort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 4, 3, 1, 2, 0};
        new SelectSort().sort(nums);
        Utils.print(nums);
    }
}
