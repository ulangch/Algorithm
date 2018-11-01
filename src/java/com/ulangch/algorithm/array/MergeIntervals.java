package com.ulangch.algorithm.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间
 *
 * https://leetcode-cn.com/problems/merge-intervals/
 */
class Interval {
    int start;
    int end;
    Interval() {
        start = 0;
        end = 0;
    }
    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class MergeIntervals {

    /**
     * 1. 按 start 作升序排列
     * 2. 遍历数组，比较上次合并的区间和当前的区间
     * 3. 如果当前区间 start 大于上次合并区间的 end，说明无法延续上次的合并，否则进行合并
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval, Interval t1) {
                return interval.start - t1.start;
            }
        });
        if (intervals.size() <= 1) {
            return intervals;
        }
        Interval preMerge = intervals.get(0);
        Interval tmp;
        for (int i = 1; i < intervals.size(); i++) {
            tmp = intervals.get(i);
            if (tmp.start > preMerge.end) {
                res.add(preMerge);
                preMerge = tmp;
            } else {
                if (tmp.end > preMerge.end) {
                    preMerge.end = tmp.end;
                }
            }
        }
        res.add(preMerge);
        return res;
    }

    public static void main(String[] args) {
    }
}
