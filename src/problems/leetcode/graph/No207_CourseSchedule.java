package problems.leetcode.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No207_CourseSchedule {
    class Solution1 {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Map<Integer, List<Integer>> adjMap = new HashMap<>();

            for (int[] pre : prerequisites) {
                adjMap.putIfAbsent(pre[0], new ArrayList<>());
                adjMap.get(pre[0]).add(pre[1]);
            }

            boolean[] path = new boolean[numCourses], visited = new boolean[numCourses];
            for (int node : adjMap.keySet()) {
                if (!backtrack(adjMap, node, path, visited)) {
                    return false;
                }
            }
            return true;
        }

        private boolean backtrack(Map<Integer, List<Integer>> adjMap, int node, boolean[] path, boolean[] visited) {
            if (path[node]) {
                return false;
            }

            if (visited[node]) {
                return true;
            }

            path[node] = true;
            for (Integer next : adjMap.getOrDefault(node, Collections.emptyList())) {
                if (!backtrack(adjMap, next, path, visited)) {
                    return false;
                }
            }
            path[node] = false;
            visited[node] = true;

            return true;
        }
    }
}
