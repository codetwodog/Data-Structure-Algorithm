package xin.twodog.DataStructureAndAlgorithm.offer;

import java.util.Stack;

public class ListProblem {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class PrintList {
        public int[] reversePrint(ListNode head) {
            Stack<Integer> integers = new Stack<>();
            int[] array = new int[]{};
            int j = 0;
            if (head == null) {
            } else {
                while (head.next != null) {
                    integers.push(head.val);
                    head = head.next;
                }
                integers.push(head.val);
                array = new int[integers.size()];
                while (!integers.isEmpty()) {
                    array[j++] = integers.pop();
                }
            }
            return array;
        }
    }
}

