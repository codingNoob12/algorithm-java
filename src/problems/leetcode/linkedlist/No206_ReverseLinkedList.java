package problems.leetcode.linkedlist;

import types.leetcode.ListNode;

public class No206_ReverseLinkedList {
    /**
     * 1. 재귀
     * 2. 반복
     * 3. 스택 -> 재귀가 call stack을 이용한 방식인데 굳이 스택 자료구조를 쓸 필요가 있을까?
     */
    class Solution1 {
        private ListNode reverse(ListNode prev, ListNode node) {
            if (node == null) {
                return prev;
            }

            ListNode next = node.next;
            node.next = prev;
            return reverse(node, next);
        }

        public ListNode reverseList(ListNode head) {
            return reverse(null, head);
        }
    }

    class Solution2 {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;

            while (head != null) {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }

            return prev;
        }
    }
}
