package problems.leetcode.dequeandpriorityqueue;

import java.util.PriorityQueue;

import types.leetcode.ListNode;

public class No23_MergeKSortedLists {
    class Solution1 {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> {
                if (n1.val > n2.val) {
                    return 1;
                }
                if (n1.val == n2.val) {
                    return 0;
                }
                return -1;
            });

            for (ListNode p : lists) {
                while (p != null) {
                    pq.add(p);
                    p = p.next;
                }
            }

            ListNode root = new ListNode(), p = root;
            while (!pq.isEmpty()) {
                p.next = pq.remove();
                p = p.next;
            }
            p.next = null;

            return root.next;
        }
    }
}
