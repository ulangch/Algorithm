package com.ulangch.algorithm.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

 candidates 中的数字可以无限制重复被选取。

 说明：
 所有数字（包括 target）都是正整数。
 解集不能包含重复的组合。

 示例 1:
 输入: candidates = [2,3,6,7], target = 7,
 所求解集为:
 [
   [7],
   [2,2,3]
 ]

 示例 2:
 输入: candidates = [2,3,5], target = 8,
 所求解集为:
 [
   [2,2,2,2],
   [2,3,3],
   [3,5]
 ]

 https://leetcode-cn.com/problems/combination-sum/
 */

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        backtrack(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }

    /** 回溯算法*/
    private boolean backtrack(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int target, int start) {
        if (target < 0) {
            return false;
        } else if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return false;
        } else {
            for (int i = start; i < candidates.length; i++) {
                tmp.add(candidates[i]);
                /** 深度优先搜索 */
                boolean flag = backtrack(res, tmp, candidates, target - candidates[i], i);
                tmp.remove(tmp.size() - 1);
                if (!flag) {
                    break;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CombinationSum soln = new CombinationSum();
        System.out.println(soln.combinationSum(new int[] {8, 7, 4, 3}, 11));
    }
}


/**

 回溯算法：

 1: int a[n];
 2: try(int i)
 3: {
 4:     if(i>n)
 5:        输出结果;
 6:      else
 7:     {
 8:        for(j = 下界; j <= 上界; j=j+1)  // 枚举i所有可能的路径
 9:        {
 10:            if(fun(j))                 // 满足限界函数和约束条件
 11:              {
 12:                 a[i] = j;
 13:               ...                         // 其他操作
 14:                 try(i+1);
 15:               回溯前的清理工作（如a[i]置空值等）;
 16:               }
 17:          }
 18:      }
 19: }
 */