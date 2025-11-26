package problems.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class No937_ReorderDataInLogFiles {
    class Solution1 {
        public String[] reorderLogFiles(String[] logs) {
            // letter log와 digit log의 정렬 기준이 다르고, letter log 이후 digit log가 온다고 함
            // 따라서, 둘이 분리하여 정렬하고 병합하는 것이 합리적
            List<String> letterLogs = new ArrayList<>();
            List<String> digitLogs = new ArrayList<>();

            for (String log : logs) {
                if (Character.isAlphabetic(log.split(" ", 2)[1].charAt(0))) {
                    letterLogs.add(log);
                } else {
                    digitLogs.add(log);
                }
            }

            letterLogs.sort((l1, l2) -> {
                String[] split1 = l1.split(" ", 2);
                String[] split2 = l2.split(" ", 2);

                int compareTo = split1[1].compareTo(split2[1]);

                if (compareTo == 0) {
                    return split1[0].compareTo(split2[0]);
                }
                return compareTo;
            });

            letterLogs.addAll(digitLogs);

            return letterLogs.toArray(new String[0]);
        }
    }
}
