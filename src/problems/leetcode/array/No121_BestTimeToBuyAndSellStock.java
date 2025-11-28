package problems.leetcode.array;

public class No121_BestTimeToBuyAndSellStock {
    /**
     * 1. 브루트포스 -> O(N^2) (N <= 10^5) -> 시간 초과
     * 2. dp
     * 
     * i번째 날에 주식을 판다고 가정
     * 
     * i번째날 팔았을 때 최대 이익 profit[i]를 구하려면
     * i번째날 이전에 최소 가격을 저장하고 있어야함.
     * 
     * 문제에서 수익을 낼 수 없다면 수익이 0 이라고함
     * 이를 다르게 생각하면 i번째날 가격이 가장 싸다면 산날 바로 팔아서 수익이 0이라 볼 수 있음
     * 
     * 따라서, i번째 날에 최소 가격을 갱신하고 i번째날 이익과 이전까지의 최대 이익을 비교하여 갱신하면 풀림
     */
    class Solution1 {
        public int maxProfit(int[] prices) {
            int minPrice = prices[0];
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                minPrice = Math.min(minPrice, prices[i]);
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
            return maxProfit;
        }
    }
}
