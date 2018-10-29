package com.ulangch.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/** 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

 * 满足要求的三元组集合为：
 * [
 *  [-1, 0, 1],
 *  [-1, -1, 2]
 * ]
 *
 *
 * https://leetcode-cn.com/problems/3sum/
 */

public class ThreeSum {

    /**
     * 自己实现的算法, 会出现超时
     */
    public List<List<Integer>> threeSumSelf(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        int first = 0;
        int second;
        int third;
        int length = nums.length;
        Arrays.sort(nums);
        while (first < length - 2) {
            second = first + 1;
            while (second < length - 1) {
                third = second + 1;
                while (third < length) {
                    if (nums[first] + nums[second] + nums[third] == 0) {
                        boolean found = false;
                        for (int i =0; i < result.size(); i++) {
                            List<Integer> ele = result.get(i);
                            if (nums[first] == ele.get(0)
                                    && nums[second] == ele.get(1)
                                    && nums[third] == ele.get(2)) {
                                found = true;
                            }
                        }
                        if (!found) {
                            result.add(new ArrayList<>(Arrays.asList(
                                    nums[first], nums[second], nums[third])));
                        }
                    }
                    third++;
                }
                second++;
            }
            first++;
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();

        if (nums != null && nums.length > 2) {
            // 先对数组进行排序
            Arrays.sort(nums);
            // i表示如果取第i个数作为结果
            for (int i = 0; i < nums.length - 2; ) {
                // 第二个数可能的起始位置
                int j = i + 1;
                // 第三个数可能是结束位置
                int k = nums.length - 1;

                while (j < k) {
                    // 如果找到满足条件的解
                    if (nums[j] + nums[k] == -nums[i]) {
                        // 将结果加入到结果含集中
                        List<Integer> list = new ArrayList<>(3);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);

                        // 移动到下一个位置。找下一组解
                        k--;
                        j++;

                        // 从左向右找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        // 从右向左找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    }
                    // 和大于0
                    else if (nums[j] + nums[k] > -nums[i]) {
                        k--;
                        // 从右向左找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    }
                    // 和小于0
                    else {
                        j++;
                        // 从左向右找第一个与之前处理的数不同的数的下标
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                    }
                }

                // 指向下一个要处理的数
                i++;
                // 从左向右找第一个与之前处理的数不同的数的下标
                while (i < nums.length - 2 && nums[i] == nums[i - 1]) {
                    i++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] eles = {-1, 0, 1, 2, -1, -4};
        System.out.println(new ThreeSum().threeSum(eles));
    }
}
