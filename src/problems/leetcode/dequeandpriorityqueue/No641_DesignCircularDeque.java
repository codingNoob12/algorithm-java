package problems.leetcode.dequeandpriorityqueue;

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
public class No641_DesignCircularDeque {
    class Solution1 {
        class MyCircularDeque {

            private final int[] data;
            private int front = 0, rear = 0;

            public MyCircularDeque(int k) {
                data = new int[k + 1];
            }

            public boolean insertFront(int value) {
                if (isFull()) {
                    return false;
                }

                data[front] = value;
                front = (front - 1 + data.length) % data.length;
                return true;
            }

            public boolean insertLast(int value) {
                if (isFull()) {
                    return false;
                }

                rear = (rear + 1) % data.length;
                data[rear] = value;
                return true;
            }

            public boolean deleteFront() {
                if (isEmpty()) {
                    return false;
                }

                front = (front + 1) % data.length;
                return true;
            }

            public boolean deleteLast() {
                if (isEmpty()) {
                    return false;
                }

                rear = (rear - 1 + data.length) % data.length;
                return true;
            }

            public int getFront() {
                return isEmpty() ? -1 : data[(front + 1) % data.length];
            }

            public int getRear() {
                return isEmpty() ? -1 : data[rear];
            }

            public boolean isEmpty() {
                return front == rear;
            }

            public boolean isFull() {
                return (rear + 1) % data.length == front;
            }
        }
    }

    class Solution2 {
        class MyCircularDeque {

            static class DoublyLinkedList {
                DoublyLinkedList left;
                DoublyLinkedList right;
                int val;

                public DoublyLinkedList(int val) {
                    this.val = val;
                }
            }

            private DoublyLinkedList head, tail;

            private final int MAX_SIZE;
            private int size = 0;

            public MyCircularDeque(int k) {
                head = new DoublyLinkedList(0);
                tail = new DoublyLinkedList(0);
                head.right = tail;
                tail.left = head;
                MAX_SIZE = k;
            }

            public boolean insertFront(int value) {
                if (isFull()) {
                    return false;
                }

                head.right.left = new DoublyLinkedList(value);
                head.right.left.right = head.right;
                head.right.left.left = head;
                head.right = head.right.left;
                size++;
                return true;
            }

            public boolean insertLast(int value) {
                if (isFull()) {
                    return false;
                }

                tail.left.right = new DoublyLinkedList(value);
                tail.left.right.left = tail.left;
                tail.left.right.right = tail;
                tail.left = tail.left.right;
                size++;
                return true;
            }

            public boolean deleteFront() {
                if (isEmpty()) {
                    return false;
                }

                head.right.right.left = head;
                head.right = head.right.right;
                size--;
                return true;
            }

            public boolean deleteLast() {
                if (isEmpty()) {
                    return false;
                }

                tail.left.left.right = tail;
                tail.left = tail.left.left;
                size--;
                return true;
            }

            public int getFront() {
                return isEmpty() ? -1 : head.right.val;
            }

            public int getRear() {
                return isEmpty() ? -1 : tail.left.val;
            }

            public boolean isEmpty() {
                return size == 0;
            }

            public boolean isFull() {
                return size == MAX_SIZE;
            }
        }
    }
}
