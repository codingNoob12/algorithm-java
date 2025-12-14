package problems.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class No78_Subsets {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> results = new ArrayList<>();

            backtrack(nums, 0, new ArrayList<>(), results);
            return results;
        }

        private void backtrack(int[] nums, int start, List<Integer> subset, List<List<Integer>> results) {
            results.add(new ArrayList<>(subset));

            for (int i = start; i < nums.length; i++) {
                subset.add(nums[i]);
                backtrack(nums, i + 1, subset, results);
                subset.remove(subset.size() - 1);
            }
        }
    }
}
