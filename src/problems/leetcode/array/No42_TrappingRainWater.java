package problems.leetcode.array;

import java.util.ArrayDeque;
import java.util.Deque;

public class No42_TrappingRainWater {
    /**
     * 1. 투포인터
     * 2. 모노톤 스택
     */
    class Solution1 {
        public int trap(int[] height) {
            int leftMax = 0, rightMax = 0;
            int i = 0, j = height.length - 1;
            int waters = 0;

            while (i < j) {
                leftMax = Math.max(leftMax, height[i]);
                rightMax = Math.max(rightMax, height[j]);

                if (leftMax <= rightMax) {
                    waters += leftMax - height[i];
                    i++;
                } else {
                    waters += rightMax - height[j];
                    j--;
                }
            }

            return waters;
        }
    }

    /**
     * 내림차순으로 스택 사용. 스택에서 pop할 때, 갇혀있던 빗물 추가
     * 
     * 스택에 원소가 2개 이상일 때만 빗물을 추가해야함
     * 
     * 목표 수위는 Math.min(height[i], height[indexStack.second])가 되고,
     * 실제 직사각형의 높이는 min - heigh[top]
     * 
     * 너비는 i - indexStack.second - 1 가 됨
     * 
     * 풀이에서는 pop을 미리 했기 때문에 second는 peek으로 접근 가능
     */
    class Solution2 {
        public int trap(int[] height) {
            Deque<Integer> indexStack = new ArrayDeque<>();
            int waters = 0;

            for (int i = 0; i < height.length; i++) {
                while (!indexStack.isEmpty() && height[i] > height[indexStack.peek()]) {
                    int top = indexStack.pop();

                    if (indexStack.isEmpty()) {
                        continue;
                    }

                    int h = Math.min(height[i], height[indexStack.peek()]) - height[top];
                    int w = i - indexStack.peek() - 1;

                    waters += w * h;
                }

                indexStack.push(i);
            }

            return waters;
        }
    }
}
