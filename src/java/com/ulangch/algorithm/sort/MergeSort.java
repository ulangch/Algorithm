package com.ulangch.algorithm.sort;

import com.ulangch.algorithm.Utils;

/**
 * 归并排序:
 *
 * 第一, 分解: 把待排序的 n 个元素的序列分解成两个子序列, 每个子序列包括 n/2 个元素.
 * 第二, 治理: 对每个子序列分别调用归并排序MergeSort, 进行递归操作
 * 第三, 合并: 合并两个排好序的子序列,生成排序结果.
 */
public class MergeSort {

    public void sort(int[] nums) {
        int[] tmp = new int[nums.length];
        sort(nums, 0, nums.length - 1, tmp);
    }

    private void sort(int[] nums, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(nums, left, mid, tmp);
            sort(nums, mid + 1, right, tmp);
            merge(nums, left, mid, right, tmp);
        }
    }

    private void merge(int[] nums, int left, int mid, int right, int[] tmp) {
        int i = left, j = mid + 1;
        int t = 0; // tmp
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[t] = nums[i];
                i++;
            } else {
                tmp[t] = nums[j];
                j++;
            }
            t++;
        }
        while (i <= mid) {
            tmp[t] = nums[i];
            i++;
            t++;
        }
        while (j <= right) {
            tmp[t] = nums[j];
            j++;
            t++;
        }

        for (int k = 0; k < t; k++) {
            nums[left] = tmp[k];
            left++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 4, 3, 1, 2, 0};
        new MergeSort().sort(nums);
        Utils.print(nums);
    }
}
