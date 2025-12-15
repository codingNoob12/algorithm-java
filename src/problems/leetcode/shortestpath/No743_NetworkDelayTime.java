package problems.leetcode.shortestpath;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class No743_NetworkDelayTime {
    class Solution1 {
        public int networkDelayTime(int[][] times, int n, int k) {
            Map<Integer, Map<Integer, Integer>> adjMap = new HashMap<>();

            for (int[] t : times) {
                adjMap.putIfAbsent(t[0], new HashMap<>());
                adjMap.get(t[0]).put(t[1], t[2]);
            }

            PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
            boolean[] visited = new boolean[n + 1];
            int[] dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[0] = -1;

            pq.add(Map.entry(k, 0));
            dist[k] = 0;

            while (!pq.isEmpty()) {
                Map.Entry<Integer, Integer> node = pq.poll();

                if (visited[node.getKey()]) {
                    continue;
                }

                visited[node.getKey()] = true;

                if (!adjMap.containsKey(node.getKey())) {
                    continue;
                }

                for (Map.Entry<Integer, Integer> next : adjMap.get(node.getKey()).entrySet()) {
                    if (dist[next.getKey()] > dist[node.getKey()] + next.getValue()) {
                        dist[next.getKey()] = dist[node.getKey()] + next.getValue();
                        pq.add(Map.entry(next.getKey(), dist[next.getKey()]));
                    }
                }
            }

            int maxTime = Arrays.stream(dist).max().getAsInt();
            return maxTime != Integer.MAX_VALUE ? maxTime : -1;
        }
    }
}
