package problems.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No49_GroupAnagrams {
    class Solution1 {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> groupMap = new HashMap<>();

            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String key = String.valueOf(chars);
                groupMap.putIfAbsent(key, new ArrayList<>());
                groupMap.get(key).add(str);
            }

            return new ArrayList<>(groupMap.values());
        }
    }
}
