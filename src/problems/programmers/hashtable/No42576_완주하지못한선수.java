package problems.programmers.hashtable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class No42576_완주하지못한선수 {
    class Solution1 {
        public String solution(String[] participant, String[] completion) {
            Map<String, Integer> counter = new HashMap<>();
            for (String p : participant) {
                counter.put(p, counter.getOrDefault(p, 0) + 1);
            }

            for (String c : completion) {
                counter.put(c, counter.get(c) - 1);
                if (counter.get(c) == 0) {
                    counter.remove(c);
                }
            }

            return counter.entrySet().iterator().next().getKey();
        }
    }

    class Solution2 {
        public String solution(String[] participant, String[] completion) {
            Map<String, Integer> counter = new HashMap<>();
            for (String p : participant) {
                counter.put(p, counter.getOrDefault(p, 0) + 1);
            }

            for (String c : completion) {
                counter.put(c, counter.get(c) - 1);
            }

            return Collections.max(counter.entrySet(), Map.Entry.comparingByValue()).getKey();
        }
    }
}
