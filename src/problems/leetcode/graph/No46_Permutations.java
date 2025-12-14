package problems.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class No46_Permutations {
    class Solution1 {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> results = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            boolean[] used = new boolean[21];
            permutation(nums, used, path, results);
            return results;
        }

        private void permutation(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> results) {
            if (path.size() >= nums.length) {
                results.add(new ArrayList<>(path));
                return;
            }

            for (int n : nums) {
                if (used[n + 10]) {
                    continue;
                }
                path.add(n);
                used[n + 10] = true;

                permutation(nums, used, path, results);

                path.remove(path.size() - 1);
                used[n + 10] = false;
            }
        }
    }
}
