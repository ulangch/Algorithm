package com.ulangch.algorithm.sort;

import com.ulangch.algorithm.Utils;

/**
 *
 * 希尔排序：
 *
 * 1. 设定一个k值，k值可以调整
 * 2. 每次以k值作为间隔进行简单插入排序
 * 3. k值逐渐变小，最后成为间隔为1的简单插入排序
 */
public class ShellSort {

    public void sort(int[] nums) {
        int k = 1, len = nums.length;
        while (k < len / 3) {
            k = k * 3 + 1;
        }
        while (k >= 1) {
            for (int i = k; i < len; i += k) {
                for (int j = i; j >= k && nums[j] < nums[j - k]; j -= k) {
                    int tmp = nums[j];
                    nums[j] = nums[j - k];
                    nums[j - k] = tmp;
                }
            }
            k = (int) Math.floor(((double) k) / 3);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 4, 3, 1, 2, 0};
        new ShellSort().sort(nums);
        Utils.print(nums);
    }
}
