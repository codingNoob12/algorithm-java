package problems.leetcode.shortestpath;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class No787_CheapestFlightsWithinKStops {
    class Solution1 {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

            for (int[] f : flights) {
                graph.putIfAbsent(f[0], new HashMap<>());
                graph.get(f[0]).put(f[1], f[2]);
            }

            // <도착지, 경로 비용, 이동 횟수>
            Queue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.get(1)));
            pq.add(Arrays.asList(src, 0, 0));
            int[] counts = new int[n];
            Arrays.fill(counts, Integer.MAX_VALUE);

            while (!pq.isEmpty()) {
                List<Integer> current = pq.poll();
                int u = current.get(0);
                int cost = current.get(1);
                int count = current.get(2);

                if (u == dst) {
                    return cost;
                }

                if (count > k || counts[u] <= count || !graph.containsKey(u)) {
                    continue;
                }
                counts[u] = count;

                for (Map.Entry<Integer, Integer> v : graph.get(u).entrySet()) {
                    pq.add(Arrays.asList(v.getKey(), cost + v.getValue(), count + 1));
                }
            }

            return -1;
        }
    }
}
