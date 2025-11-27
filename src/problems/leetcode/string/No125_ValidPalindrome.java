package problems.leetcode.string;

public class No125_ValidPalindrome {
    class Solution1 {
        public boolean isPalindrome(String s) {
            String filtered = s.toLowerCase().replaceAll("[^a-z0-9]", "");
            String reversed = new StringBuilder(filtered).reverse().toString();
            return filtered.equals(reversed);
        }
    }

    class Solution2 {
        public boolean isPalindrome(String s) {
            int left = 0;
            int right = s.length() - 1;

            while (left < right) {
                while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                    left++;
                }

                while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                    right--;
                }

                if (left < right) {
                    char lc = Character.toLowerCase(s.charAt(left));
                    char rc = Character.toLowerCase(s.charAt(right));
                    if (lc != rc) {
                        return false;
                    }
                    left++;
                    right--;
                }
            }

            return true;
        }
    }
}
