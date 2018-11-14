package com.ulangch.algorithm.binarysearch;

public class BinarySearch {

    public int search(int[] nums, int target) {
        if (nums == null) return -1;
        int start = 0, end = nums.length - 1, mid, cmp;
        while (start < end) {
            mid = (start + end) / 2;
            cmp = nums[mid] - target;
            if (cmp < 0) start = mid + 1;
            else if (cmp > 0) end = mid - 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 5, 7, 9, 11};
        System.out.println(new BinarySearch().search(nums, 5));
    }
}
