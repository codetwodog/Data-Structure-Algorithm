package xin.twodog.algorithm.offer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;

public class ListProblem {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        ReverseList reverseList = new ReverseList();
        reverseList.reverseList(a);

        //random List
        Node node0 = new Node(3);
        Node node1 = new Node(3);
        Node node2 = new Node(3);
        node0.next = node1;
        node0.random = null;
        node1.next = node2;
        node1.random = node0;
        node2.next = null;
        node2.random = null;
        CopyRandomList copyRandomList = new CopyRandomList();
        Node node = copyRandomList.copyRandomList(node0);
        System.out.println();
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
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

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 引用关系的复制是本题的难点, 用hash code去记录关系
     */
    static class CopyRandomList {
        public Node copyRandomList(Node head) {

            if (head == null) return null;

            //记录引用关系和值
            Map<Integer, Integer> nodeMapHash2Index = new LinkedHashMap<>();
            Map<Integer, Integer> nodeMapIndex2Hash = new LinkedHashMap<>();
            Map<Integer, Integer> nodeMapIndex2Value = new LinkedHashMap<>();
            List<Node> nodesCopy = new ArrayList<>();
            int i = 0;
            int k = 0;
            int g = 0;
            while (head != null) {
                nodeMapHash2Index.put(head.hashCode(), k++);
                nodeMapIndex2Hash.put(g++, head.random == null ? null : head.random.hashCode());
                nodeMapIndex2Value.put(i++, head.val);
                head = head.next;
            }

            //复制出所有node
            for (int j = 0; j < nodeMapIndex2Hash.size(); j++) {
                Node node = new Node(nodeMapIndex2Value.get(j));
                nodesCopy.add(node);
            }

            //根据记录还原next和random
            int j = 0;
            for (j = 0; j < nodesCopy.size() - 1; j++) {
                nodesCopy.get(j).next = nodesCopy.get(j + 1);
                nodesCopy.get(j).random = nodeMapIndex2Hash.get(j) == null ? null : nodesCopy.get(nodeMapHash2Index.get(nodeMapIndex2Hash.get(j)));
            }
            nodesCopy.get(j).next = null;
            nodesCopy.get(j).random = nodeMapIndex2Hash.get(j) == null ? null : nodesCopy.get(nodeMapHash2Index.get(nodeMapIndex2Hash.get(j)));

            return nodesCopy.get(0);
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

