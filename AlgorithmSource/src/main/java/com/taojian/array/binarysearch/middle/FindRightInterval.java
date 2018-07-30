package com.taojian.array.binarysearch.middle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: taojian
 * @create: 2018-07-30 17:29
 * <p>
 * <p>
 * Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is
 * bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.
 * <p>
 * For any interval i, you need to store the minimum interval j's index, which means that the interval j has the
 * minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1
 * for the interval i. Finally, you need output the stored value of each interval as an array.
 * <p>
 * Note:
 * You may assume the interval's end point is always bigger than its start point.
 * You may assume none of these intervals have the same start point.
 * Example 1:
 * Input: [ [1,2] ]
 * <p>
 * Output: [-1]
 * <p>
 * Explanation: There is only one interval in the collection, so it outputs -1.
 * Example 2:
 * Input: [ [3,4], [2,3], [1,2] ]
 * <p>
 * Output: [-1, 0, 1]
 * <p>
 * Explanation: There is no satisfied "right" interval for [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point;
 * For [1,2], the interval [2,3] has minimum-"right" start point.
 * Example 3:
 * Input: [ [1,4], [2,3], [3,4] ]
 * <p>
 * Output: [-1, 2, -1]
 * <p>
 * Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point.
 * <p>
 * <p>
 * 给一组区间，对于每一个区间i，检查是否存在区间j，满足j的起点大于等于i的终点，我们称j在i的“右边"。
 * <p>
 * 对于任意区间i，你需要存储j的最小下标，这意味着区间j拥有最小的起点并且位于i的“右边”。如果j不存在，则存储为-1。将最终结果以数组形式返回。
 * <p>
 * 注意：
 * <p>
 * 你可以假设区间的终点总是比起点大
 * 你可以假设任意区间的起点都不相同
 **/
public class FindRightInterval {

    public class Interval {
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

    public int[] findRightInterval(Interval[] intervals) {
        int[] res = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            int minIndex = -1;
            for (int j = 0; j < intervals.length; j++) {
                if (i != j) {
                    if (intervals[j].start >= intervals[i].end && (minIndex == -1 || intervals[j].start
                            < intervals[minIndex].start)) {
                        minIndex = j;
                    }
                }
            }
            res[i] = minIndex;
        }
        return res;
    }

    public int[] findRightInterval1(Interval[] intervals) {

        // Store each Interval Start => original index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i].start, i);
        }

        int[] res = new int[intervals.length];

        // sort by Intervals by Start
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval A, Interval B) {
                return A.start - B.start;
            }
        });

        // For Each Interval, Binary Search for minimum interval whose left index is >= target
        for (int i = 0; i < intervals.length; i++) {
            int target = intervals[i].end;
            Interval inter = binarySearch(intervals, i, intervals.length - 1, target);
            if (inter == null) {
                res[map.get(intervals[i].start)] = -1;
            } else {
                res[map.get(intervals[i].start)] = map.get(inter.start);
            }
        }

        return res;
    }

    // Find minimum interval whose left index is >= to target
    public Interval binarySearch(Interval[] intervals, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (intervals[mid].start < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (intervals[left].start >= target) {
            return intervals[left];
        } else {
            return null;
        }
    }
}

