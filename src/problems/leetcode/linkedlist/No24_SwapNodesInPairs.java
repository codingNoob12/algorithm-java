package problems.leetcode.linkedlist;

import types.leetcode.ListNode;

public class No24_SwapNodesInPairs {
    /**
     * 1. 노드 스왑
     * 2. 값만 스왑
     * 3. 재귀
     */
    class Solution1 {
        public ListNode swapPairs(ListNode head) {
            ListNode root = new ListNode(), p = root;
            root.next = head;

            while (p.next != null && p.next.next != null) {
                ListNode n = p.next, nn = p.next.next;

                p.next = nn;
                n.next = nn.next;
                nn.next = n;

                p = n;
            }

            return root.next;
        }
    }

    class Solution2 {
        public ListNode swapPairs(ListNode head) {
            ListNode p = head;
            while (p != null && p.next != null) {
                int temp = p.val;
                p.val = p.next.val;
                p.next.val = temp;

                p = p.next.next;
            }

            return head;
        }
    }

    class Solution3 {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode next = head.next;
            head.next = swapPairs(head.next.next);
            next.next = head;

            return next;
        }
    }
}
