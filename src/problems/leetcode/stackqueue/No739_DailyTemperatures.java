package problems.leetcode.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class No739_DailyTemperatures {
    class Solution1 {
        public int[] dailyTemperatures(int[] temperatures) {
            Deque<Integer> indexStack = new ArrayDeque<>();
            int[] answer = new int[temperatures.length];

            for (int i = 0; i < temperatures.length; i++) {
                while (!indexStack.isEmpty() && temperatures[indexStack.peek()] < temperatures[i]) {
                    int idx = indexStack.pop();
                    answer[idx] = i - idx;
                }
                indexStack.push(i);
            }

            return answer;
        }
    }
}
