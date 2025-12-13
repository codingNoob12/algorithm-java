package problems.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No17_LetterCombinationsOfAPhoneNumber {
    class Solution1 {
        private static final Map<Character, List<Character>> map = new HashMap<>();

        static {
            map.put('2', List.of('a', 'b', 'c'));
            map.put('3', List.of('d', 'e', 'f'));
            map.put('4', List.of('g', 'h', 'i'));
            map.put('5', List.of('j', 'k', 'l'));
            map.put('6', List.of('m', 'n', 'o'));
            map.put('7', List.of('p', 'q', 'r', 's'));
            map.put('8', List.of('t', 'u', 'v'));
            map.put('9', List.of('w', 'x', 'y', 'z'));
        }

        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            combination(digits, new StringBuilder(), result);
            return result;
        }

        public void combination(String digits, StringBuilder path, List<String> result) {
            int depth = path.length();

            if (depth >= digits.length()) {
                result.add(path.toString());
                return;
            }

            for (char c : map.get(digits.charAt(depth))) {
                path.append(c);
                combination(digits, path, result);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
