package xin.twodog.algorithm.offer;

import java.util.Stack;

public class ListProblem {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
//        c.next = d;
//        d.next = null;
        ReverseList reverseList = new ReverseList();
        reverseList.reverseList(a);
    }

    public static class ListNode {
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

    /**
     * head-> head.next-> head.next.next
     * flag = null;
     * while true
     * b = head.next;
     * head.next = flag;
     * flag = head;
     * head = b;
     */
    static class ReverseList {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode currentNextChangeTo = null;
            while (head != null) {
                ListNode currentNext = head.next; //保存当前节点的next
                head.next = currentNextChangeTo;  // 将当前节点的next 改变为 前面的节点
                if (currentNext == null) break; //最后一个节点就不移动了，跳出循环♻️
                currentNextChangeTo = head; //保存下一个前面的节点
                head = currentNext; // 移动到下一个head
            }
            return head;
        }
    }
}

