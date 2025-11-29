package problems.leetcode.linkedlist;

import java.math.BigInteger;

import types.leetcode.ListNode;

public class No2_AddTwoNumbers {
    /**
     * 1. 타입 변환 - 10^100까지 표현 가능해야함. -> BigInteger
     * 2. 전가산기
     */
    class Solution1 {
        private BigInteger toBigInteger(ListNode head) {
            ListNode p = head;
            StringBuilder sb = new StringBuilder();
            while (p != null) {
                sb.append(p.val);
                p = p.next;
            }

            return new BigInteger(sb.reverse().toString());
        }

        private ListNode toLinkedList(BigInteger n) {
            ListNode head = null;
            for (char c : n.toString().toCharArray()) {
                head = new ListNode(Character.getNumericValue(c), head);
            }
            return head;
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            BigInteger result = toBigInteger(l1).add(toBigInteger(l2));
            return toLinkedList(result);
        }
    }

    class Solution2 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode root = new ListNode(), p = root;
            int carry = 0;

            while (l1 != null || l2 != null || carry != 0) {
                int sum = carry;

                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }

                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }

                carry = sum / 10;
                sum %= 10;

                p.next = new ListNode(sum);
                p = p.next;
            }

            return root.next;
        }
    }
}
