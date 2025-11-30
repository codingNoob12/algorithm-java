package problems.leetcode.linkedlist;

import types.leetcode.ListNode;

public class No92_ReverseLinkedListII {
    class Solution1 {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode root = new ListNode(0, head), before = root;
            for (int i = 0; i < left - 1; i++) {
                before = before.next;
            }

            ListNode tail = before.next, prev = tail, p = tail.next;
            for (int i = 0; i < right - left; i++) {
                ListNode next = p.next;
                p.next = prev;
                prev = p;
                p = next;
            }

            tail.next = p;
            before.next = prev;

            return root.next;
        }
    }
}
