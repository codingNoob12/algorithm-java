package problems.leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
public class No706_DesignHashMap {
    class Solution1 {
        class MyHashMap {

            private final int[] hashtable = new int[1_000_001];
            private final boolean[] hasValue = new boolean[1_000_001];

            public MyHashMap() {

            }

            public void put(int key, int value) {
                hashtable[key] = value;
                hasValue[key] = true;
            }

            public int get(int key) {
                return hasValue[key] ? hashtable[key] : -1;
            }

            public void remove(int key) {
                hasValue[key] = false;
            }
        }
    }

    class Solution2 {
        class MyHashMap {

            static class Node {
                int key, val;
                Node next;

                Node(int key, int val) {
                    this.key = key;
                    this.val = val;
                }
            }

            private final double factor = 0.75;
            private final Node[] nodes = new Node[(int) (1000000 * factor)];

            public MyHashMap() {

            }

            public void put(int key, int value) {
                int hash = key % nodes.length;
                Node p = nodes[hash], prev = null;
                while (p != null && p.key != key) {
                    prev = p;
                    p = p.next;
                }

                if (prev == null) {
                    nodes[hash] = new Node(key, value);
                } else if (p == null) {
                    prev.next = new Node(key, value);
                } else {
                    p.val = value;
                }
            }

            public int get(int key) {
                Node p = nodes[key % nodes.length];

                while (p != null && p.key != key) {
                    p = p.next;
                }

                return p != null ? p.val : -1;
            }

            public void remove(int key) {
                int hash = key % nodes.length;
                Node p = nodes[hash], prev = null;
                while (p != null && p.key != key) {
                    prev = p;
                    p = p.next;
                }

                if (p != null) {
                    if (prev == null) {
                        nodes[hash] = null;
                    } else {
                        prev.next = p.next;
                    }
                }
            }
        }
    }
}
