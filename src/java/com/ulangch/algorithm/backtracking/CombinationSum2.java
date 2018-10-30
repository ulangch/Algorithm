package com.ulangch.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 candidates 中的每个数字在每个组合中只能使用一次。

 说明：
 所有数字（包括目标数）都是正整数。
 解集不能包含重复的组合。

 示例 1:
 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 所求解集为:
 [
   [1, 7],
   [1, 2, 5],
   [2, 6],
   [1, 1, 6]
 ]

 示例 2:
 输入: candidates = [2,5,2,1,2], target = 5,
 所求解集为:
 [
   [1,2,2],
   [5]
 ]

 https://leetcode-cn.com/problems/combination-sum-ii/
 */

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private boolean backtrack(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int target, int start) {
        if (target == 0) {
            if (!duplicate(res, tmp)) {
                res.add(new ArrayList<>(tmp));
            }
            return false;
        } else if (target < 0) {
            return false;
        } else {
            for (int i = start; i < candidates.length; i++) {
                tmp.add(candidates[i]);
                boolean flag = backtrack(res, tmp, candidates, target - candidates[i], i + 1);
                tmp.remove(tmp.size() - 1);
                if (!flag) {
                    break;
                }
            }
        }
        return true;
    }

    private boolean duplicate(List<List<Integer>> lists, List<Integer> ele) {
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).size() != ele.size()) {
                continue;
            }
            boolean duplicate = true;
            for (int j = 0; j < ele.size(); j++) {
                if (lists.get(i).get(j) != ele.get(j)) {
                    duplicate = false;
                    break;
                }
            }
            if (duplicate) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CombinationSum2 soln = new CombinationSum2();
        System.out.println(soln.combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));
        System.out.println("######################");
        System.out.println(soln.combinationSum2(new int[] {2,5,2,1,2}, 5));
    }
}
