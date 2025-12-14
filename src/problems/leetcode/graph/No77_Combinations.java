package problems.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class No77_Combinations {
    class Solution1 {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> results = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            backtrack(1, n, k, path, results);
            return results;
        }

        private void backtrack(int start, int n, int k, List<Integer> path, List<List<Integer>> results) {
            if (path.size() == k) {
                results.add(new ArrayList<>(path));
                return;
            }

            for (int i = start; i <= n - k + path.size() + 1; i++) {
                path.add(i);
                backtrack(i + 1, n, k, path, results);
                path.remove(path.size() - 1);
            }
        }
    }
}
