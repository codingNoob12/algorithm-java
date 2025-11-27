package problems.leetcode.string;

public class No5_LongestPalindromicSubstring {
    /**
     * 확장하면서 펠린드롬인지 확인하는 방식으로 구현
     * 시작점부터 펠린드롬이라면, 확장을 하여 최대 길이를 갱신하는 방식으로 구현함
     * 
     * 주의) expandPalindrome(s, i, i)와 expandPalindrome(s, i, i + 1)을 같이 호출해야함
     * - 길이가 짝수인 경우와 홀수인 경우 모두 고려하기 위함임
     */
    class Solution1 {
        private int start = 0;
        private int maxLen = 0;

        private void expandPalindrome(String s, int i, int j) {
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            }

            int length = j - i - 1;

            if (maxLen < length) {
                start = i + 1;
                maxLen = length;
            }
        }

        public String longestPalindrome(String s) {
            for (int i = 0; i < s.length(); i++) {
                expandPalindrome(s, i, i);
                expandPalindrome(s, i, i + 1);
            }

            return s.substring(start, start + maxLen);
        }
    }
}
