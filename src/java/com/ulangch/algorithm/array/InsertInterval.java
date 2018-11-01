package com.ulangch.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1:
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * <p>
 * 示例 2:
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * <p>
 * https://leetcode-cn.com/problems/insert-interval/
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if (intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        Interval preMerged = null;
        Interval tmp;
        boolean newMerged = false;
        for (int i = 0; i < intervals.size(); i++) {
            tmp = intervals.get(i);
            if (newInterval.start < tmp.start) {
                // merge new interval
                newMerged = true;
                if (preMerged == null) {
                    preMerged = newInterval;
                } else {
                    preMerged = merge(res, preMerged, newInterval);
                }
            }
            if (preMerged == null) {
                preMerged = tmp;
            } else {
                preMerged = merge(res, preMerged, tmp);
            }
        }
        if (!newMerged) {
            if (preMerged == null) {
                preMerged = newInterval;
            } else {
                preMerged = merge(res, preMerged, newInterval);
            }
        }
        res.add(preMerged);
        return res;
    }

    private Interval merge(List<Interval> res, Interval preMerge, Interval cur) {
        if (cur.start > preMerge.end) {
            res.add(preMerge);
            preMerge = cur;
        } else {
            if (cur.end > preMerge.end) {
                preMerge.end = cur.end;
            }
        }
        return preMerge;
    }

    public static void main(String[] args) {

    }
}
