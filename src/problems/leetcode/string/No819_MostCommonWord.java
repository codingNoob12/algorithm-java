package problems.leetcode.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No819_MostCommonWord {
    class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");
            Map<String, Integer> countMap = new HashMap<>();
            Set<String> banSet = new HashSet<>(Arrays.asList(banned));

            for (String word : words) {
                if (!banSet.contains(word)) {
                    countMap.put(word, countMap.getOrDefault(word, 0) + 1);
                }
            }

            return Collections.max(countMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        }
    }
}
