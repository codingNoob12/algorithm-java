package problems.leetcode.tree;

import types.leetcode.TreeNode;

public class No543_DiameterOfBinaryTree {
    /**
     * DFS => 깊이 구하기
     * 만약 현재 노드 지난다면, 왼쪽 서브트리 깊이 + 오른쪽 서브트리 깊이 + 1
     * 안지난다면, 왼쪽이든 오른쪽에서 최대 길이가 있을 것. 이거 그대로 리턴
     * 
     * 헬퍼 함수가 필요함. 함수 하나로 깊이를 리턴해가면서 longest를 갱신해나갈 수 있지만, 최대값 리턴 불가
     */
    class Solution1 {
        private int longest = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return longest;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = dfs(root.left);
            int right = dfs(root.right);
            longest = Math.max(longest, left + right);
            return Math.max(left, right) + 1;
        }
    }
}
