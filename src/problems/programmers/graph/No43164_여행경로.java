package problems.programmers.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class No43164_여행경로 {
    class Solution1 {
        public String[] solution(String[][] tickets) {
            Map<String, PriorityQueue<String>> adjMap = new HashMap<>();

            for (String[] ticket : tickets) {
                adjMap.putIfAbsent(ticket[0], new PriorityQueue<>());
                adjMap.get(ticket[0]).add(ticket[1]);
            }

            List<String> path = new LinkedList<>();
            dfs(adjMap, path, "ICN");

            return path.toArray(new String[0]);
        }

        private void dfs(Map<String, PriorityQueue<String>> adjMap, List<String> path, String from) {
            while (adjMap.containsKey(from) && !adjMap.get(from).isEmpty()) {
                dfs(adjMap, path, adjMap.get(from).poll());
            }

            path.add(0, from);
        }
    }
}
