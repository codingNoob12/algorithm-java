package problems.leetcode.dequeandpriorityqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class No973_KClosestPointsToOrigin {
    class Solution1 {
        public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    (a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));

            for (int[] point : points) {
                pq.add(point);
            }

            List<int[]> result = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                result.add(pq.remove());
            }
            return result.toArray(new int[0][0]);
        }
    }
}
