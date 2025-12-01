package problems.leetcode.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class No316_RemoveDuplicateLetters {

    /**
     * 1. 스택
     * 2. 재귀
     */
    class Solution1 {
        public String removeDuplicateLetters(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            Map<Character, Boolean> contains = new HashMap<>();
            Map<Character, Integer> counter = new HashMap<>();

            for (char c : s.toCharArray()) {
                counter.put(c, counter.getOrDefault(c, 0) + 1);
            }

            for (char c : s.toCharArray()) {
                counter.put(c, counter.get(c) - 1);

                if (contains.getOrDefault(c, false)) {
                    continue;
                }

                while (!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0) {
                    contains.put(stack.pop(), false);
                }

                stack.push(c);
                contains.put(c, true);
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.reverse().toString();
        }
    }

    class Solution2 {
        public String removeDuplicateLetters(String s) {
            Set<Character> sortedSet = toSortedSet(s);

            for (char c : sortedSet) {
                String suffix = s.substring(s.indexOf(c));
                if (sortedSet.equals(toSortedSet(suffix))) {
                    return c + removeDuplicateLetters(suffix.replace(String.valueOf(c), ""));
                }
            }

            return "";
        }

        private Set<Character> toSortedSet(String s) {
            Set<Character> set = new TreeSet<>();

            for (char c : s.toCharArray()) {
                set.add(c);
            }

            return set;
        }
    }
}
