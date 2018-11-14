package com.ulangch.algorithm.sort;

import com.ulangch.algorithm.Utils;

/**
 * 简单插入排序：
 *
 * 每个数与前面的数进行比较，找到合适的地方并插入(小于就交换位置)
 */
public class InsertSort {

    public void sort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 4, 3, 1, 2, 0};
        new InsertSort().sort(nums);
        Utils.print(nums);
    }
}
